/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.controlador;


import cr.ac.ucr.juegodeparchisc5c589.vista.GUICredito;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIHistoria;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIInstrucciones;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIJuego;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIJugador;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Thinkpad P52
 */
public class ControladorPrincipal implements ActionListener {

    private GUIPrincipal guiPrincipal;
    private GUICredito guiCredito;
    private GUIInstrucciones guiInstrucciones;
    private GUIHistoria guiHistoria;
    private ControladorJuego controladorJuego;
    private GUIJugador guiJugador;
    private GUIJuego guiJuego;

    public ControladorPrincipal() {
        guiPrincipal = new GUIPrincipal(this);
        guiPrincipal.setVisible(true);
        guiCredito = new GUICredito(this);
        guiInstrucciones = new GUIInstrucciones(this);
        guiHistoria = new GUIHistoria(this);
        guiJugador = new GUIJugador(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Jugar":
                guiPrincipal.setVisible(false);
                guiJugador.setVisible(true);
                
                break;
                
                
            case "Continuar":
                guiJugador.setVisible(false);
                String colorJugador1 = guiJugador.getCbColor();
                String nombreJugador1 = guiJugador.getTxtJugador1();
                String nombreJugador2 = guiJugador.getTxtJugador2();
                
                System.out.println("Color seleccionado: " + colorJugador1);
                System.out.println("Nombre Jugador 1: " + nombreJugador1);
                System.out.println("Nombre Jugador 2: " + nombreJugador2);
                controladorJuego = new ControladorJuego(guiPrincipal, colorJugador1, nombreJugador1, nombreJugador2);
                break;
                

            case "Instrucciones":
                guiPrincipal.setVisible(false);
                guiInstrucciones.setVisible(true);
                break;

            case "atrasInstrucciones":
                guiInstrucciones.setVisible(false);
                guiPrincipal.setVisible(true);
                break;

            case "Creditos":
                guiPrincipal.setVisible(false);
                guiCredito.setVisible(true);
                break;

            case "atrasCreditos":
                guiCredito.setVisible(false);
                guiPrincipal.setVisible(true);
                break;

            case "Historia":
                guiPrincipal.setVisible(false);
                guiHistoria.setVisible(true);
                break;

            case "atrasHistoria":
                guiHistoria.setVisible(false);
                guiPrincipal.setVisible(true);
                break;

            case "Salir":
                System.exit(0);
                break;

        }
    }

}