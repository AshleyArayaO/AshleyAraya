/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.controlador;

import cr.ac.ucr.juegodeparchisc5c589.modelo.AreaJuego;
import cr.ac.ucr.juegodeparchisc5c589.modelo.Dado;
import cr.ac.ucr.juegodeparchisc5c589.modelo.Pregunta;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIGameOver;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIJuego;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIPrincipal;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIWin;
import cr.ac.ucr.juegodeparchisc5c589.vista.PanelControl;
import cr.ac.ucr.juegodeparchisc5c589.vista.PanelJuego;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Thinkpad P52
 */
public class ControladorJuego implements ActionListener, MouseListener {

    private GUIJuego guiJuego;
    private PanelJuego panelJuego;
    private PanelControl panelControl;
    private GUIPrincipal guiPrincipal;
    private AreaJuego areaJuego;
    private Dado dado;
    private GUIGameOver guiGameOver;
    private GUIWin guiWin;
    // Agregamos referencia al cronometro si quieres controlarlo desde aqui
    // private ControlCronometro controlCronometro; 

    private int resultadoDado = 0;
    private boolean turnoTerminado = true;
    
    // 1: Jugador 1, 2: Jugador 2
    private int turnoActual = 1; 

    public ControladorJuego(GUIPrincipal guiPrincipal, String colorJugador1, String nombreJugador1, String nombreJugador2) {
        this.guiPrincipal = guiPrincipal;
        guiJuego = new GUIJuego(this);
        guiGameOver = new GUIGameOver();
        guiWin = new GUIWin();
        panelJuego = guiJuego.getPanelJuego();
        
        // Inicializamos el area de juego
        areaJuego = new AreaJuego(colorJugador1, nombreJugador1, nombreJugador2);
        
        panelControl = guiJuego.getPanelControl();
        panelControl.setJlNombreJugador1(nombreJugador1);
        panelControl.setJlNombreJugador2(nombreJugador2);
        
        dado = new Dado();
        guiJuego.setVisible(true);
        
        actualizarMensajeTurno();
    }

    public void dibujar(Component c, Graphics g) {
        areaJuego.dibujar(c, g);
    }
    
    private void actualizarMensajeTurno() {
        String nombre = (turnoActual == 1) ? areaJuego.getJugador1().getNombre() : areaJuego.getJugador2().getNombre();
        System.out.println(">>> Turno de: " + nombre);
        // Podrias poner esto en un Label del panelControl si existe
    }

    private void hacerPregunta() {
        Pregunta pregunta = areaJuego.getPreguntaAleatroia();
        if (pregunta == null) {
            System.out.println("Error: No hay preguntas en el banco.");
            return;
        }

        int respuestaCorrecta = pregunta.isRespuesta();
        String enunciado = pregunta.getEnunciado();

        int respuestaUsuarioInt = JOptionPane.showConfirmDialog(guiJuego, enunciado, "Pregunta", JOptionPane.YES_NO_OPTION);

        boolean acierto = (respuestaUsuarioInt == respuestaCorrecta);

        if (acierto) {
            JOptionPane.showMessageDialog(guiJuego, "¡Respuesta correcta! +1 punto.");
            areaJuego.aplicarResultadoPregunta(true, turnoActual);
        } else {
            JOptionPane.showMessageDialog(guiJuego, "¡Respuesta incorrecta! -1 punto.");
            areaJuego.aplicarResultadoPregunta(false, turnoActual);
        }
    }

    private void finalizarTurno() {
        System.out.println("Turno finalizado para Jugador " + turnoActual);
        
        // Verificar si alguien ganó (Condición simple por puntos o meta)
        if (areaJuego.verificarGanador(turnoActual)) {
            guiJuego.setVisible(false);
            guiWin.setVisible(true);
            return;
        }

        // Cambio de turno
        turnoActual = (turnoActual == 1) ? 2 : 1;
        turnoTerminado = true;
        resultadoDado = 0;
        
        // Resetear botón dado visualmente
        panelControl.getBtnDado().setIcon(null);
        panelControl.getBtnDado().setText("Lanzar (" + ((turnoActual==1) ? "J1" : "J2") + ")");
        
        actualizarMensajeTurno();
        panelJuego.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Dado":
                if (turnoTerminado) {
                    resultadoDado = dado.lanzar();
                    System.out.println("Resultado de dado:" + resultadoDado);
                    String rutaImagen = "/img/dado" + resultadoDado + ".1.png";
                    
                    try {
                        ImageIcon iconoDado = new ImageIcon(getClass().getResource(rutaImagen));
                        panelControl.getBtnDado().setIcon(iconoDado);
                    } catch (Exception ex) {
                        System.err.println("No se encontró la imagen del dado: " + rutaImagen);
                    }
                    
                    panelControl.getBtnDado().setText("");
                    panelJuego.repaint();

                    turnoTerminado = false; // Habilitamos el clic en el tablero

                    if (resultadoDado == 5) {
                        System.out.println("¡Saca un 5! Puedes sacar ficha o mover.");
                    } else {
                        System.out.println("Mueve " + resultadoDado + " casillas.");
                    }
                } else {
                    JOptionPane.showMessageDialog(guiJuego, "Ya lanzaste el dado. Debes mover una ficha.");
                }
                break;

            case "AtrasPanelControl":
                guiJuego.dispose();
                guiPrincipal.setVisible(true);
                break;

            case "Menu": // Boton en GameOver
            case "MenuWin": // Boton en Win
                guiPrincipal.setVisible(true);
                guiGameOver.setVisible(false);
                guiWin.setVisible(false);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (turnoTerminado) {
            System.out.println("Espera, debes lanzar el dado primero.");
            return;
        }

        // 1. Intentar sacar ficha de casa (Solo si sacó 5)
        if (resultadoDado == 5) {
            int indexFichaCasa = areaJuego.getIndexFichaCasa(e.getX(), e.getY(), turnoActual);
            if (indexFichaCasa != -1) {
                System.out.println("Sacando ficha de casa jugador " + turnoActual);
                boolean exito = areaJuego.sacarFicha(indexFichaCasa, turnoActual);
                if(exito) {
                    panelJuego.repaint();
                    finalizarTurno();
                    return;
                } else {
                     JOptionPane.showMessageDialog(guiJuego, "La salida está bloqueada.");
                     return;
                }
            }
        }

        // 2. Mover ficha en el tablero
        int indiceCelda = areaJuego.getIndexFichaEnTablero(e.getX(), e.getY(), turnoActual);
        
        if (indiceCelda != -1) {
            System.out.println("Intentando mover ficha de celda " + indiceCelda);
            
            // Lógica de movimiento y colisión en AreaJuego
            int resultadoMovimiento = areaJuego.moverFicha(indiceCelda, resultadoDado, turnoActual);
            
            // Códigos de retorno: -1 (Error/Bloqueado), >=0 (Nueva posición)
            if (resultadoMovimiento != -1) {
                panelJuego.repaint();
                
                // Verificar casilla especial o normal
                if (areaJuego.isCeldaNormal(resultadoMovimiento)) {
                    System.out.println("Casilla normal, mostrando pregunta!");
                    hacerPregunta();
                } else {
                    System.out.println("Casilla especial, turno seguro.");
                }
                
                finalizarTurno();
                return;
            } else {
                 JOptionPane.showMessageDialog(guiJuego, "Movimiento no válido (Bloqueo o excede meta).");
            }
        } else {
            System.out.println("Clic no válido. Selecciona una ficha de tu color.");
        }
    }

    // Métodos vacíos obligatorios de MouseListener
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
