/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.modelo;


import java.awt.Component;
import java.awt.Graphics;

/**
 *
 * @author Thinkpad P52
 */

public class AreaJuego {
    
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private BancoPregunta bancoPregunta;
    
    public AreaJuego(String colorJugador1, String nombreJugador1,  String nombreJugador2) {
        tablero = new Tablero();
        crearJugadores(colorJugador1, nombreJugador1, nombreJugador2);
        tablero.crearCasas(jugador1.getColor(), jugador2.getColor());
        bancoPregunta = new BancoPregunta();
    }
    public int getIndexFichaCasa(int x, int y, int turnoActual){
        String colorTurno = (turnoActual == 1) ? jugador1.getColor() : jugador2.getColor();
        return tablero.getIndexFichaCasa(x, y, colorTurno);
    }
   
    public int getIndexFichaEnTablero(int x, int y, int turnoActual){
        String colorTurno = (turnoActual == 1) ? jugador1.getColor() : jugador2.getColor();
        return tablero.getIndexFichaEnTablero(x, y, colorTurno);
    }
    
    public boolean sacarFicha(int indexFichaCasa, int turnoActual){
        String colorTurno = (turnoActual == 1) ? jugador1.getColor() : jugador2.getColor();
        return tablero.intentarSacarFicha(indexFichaCasa, colorTurno);
    }
    
    public int moverFicha(int indiceActual, int pasos, int turnoActual){
         String colorTurno = (turnoActual == 1) ? jugador1.getColor() : jugador2.getColor();
         return tablero.moverFicha(indiceActual, pasos, colorTurno);
    }
    
    public boolean isCeldaNormal(int indice){
        return tablero.isCeldaNormal(indice);
    }
    
    public Pregunta getPreguntaAleatroia(){
        return bancoPregunta.getPreguntaAleatoria();
    }
    
    public void aplicarResultadoPregunta(boolean acierto, int turnoActual){
        Jugador j = (turnoActual == 1) ? jugador1 : jugador2;
        if(acierto){
            j.sumarPuntos();
        } else  {
            j.restarPunto();
        }
    }
    
    public boolean verificarGanador(int turnoActual) {
        Jugador j = (turnoActual == 1) ? jugador1 : jugador2; 
        if (j.getPuntos() >= 10) { 
            return true;
        }
        return false;
    }

    public void crearJugadores(String colorJugador1, String nombreJugador1,  String nombreJugador2){
        jugador1 = new Jugador(nombreJugador1, colorJugador1);
        
        String colorJ2 = "Rojo"; // Default
        switch(colorJugador1){
            case "Amarillo": colorJ2 = "Rojo"; break;
            case "Azul":     colorJ2 = "Verde"; break;
            case "Rojo":     colorJ2 = "Amarillo"; break;
            case "Verde":    colorJ2 = "Azul"; break;
        }
        jugador2 = new Jugador(nombreJugador2, colorJ2);
    }
    
    public Jugador getJugador1() { return jugador1; }
    public Jugador getJugador2() { return jugador2; }
    
    public void dibujar(Component component, Graphics g){
        tablero.dibujar(component, g);
    }
}