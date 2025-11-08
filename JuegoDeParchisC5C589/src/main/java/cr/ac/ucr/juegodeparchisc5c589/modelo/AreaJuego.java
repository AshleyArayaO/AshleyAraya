/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.modelo;

import cr.ac.ucr.juegodeparchisc5c589.modelo.Jugador;
import cr.ac.ucr.juegodeparchisc5c589.modelo.Tablero;
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
    
    public AreaJuego(){
        tablero = new Tablero();
        tablero.crearCasas("Azul");
    }
    
    public void dibujar(Component componente, Graphics g){
        tablero.dibujar(componente, g);
    }
}
