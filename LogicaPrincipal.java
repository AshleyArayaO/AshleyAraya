/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.modelo;

/**
 *
 * @author Thinkpad P52
 */
public class LogicaPrincipal {
    private int valorDado;
    // 0: Rojo, 1: Azul, 2: Amarillo, 3: Verde
    private int turnoActual; 
    private final int NUM_JUGADORES = 4;
    private int[] fichasRojas = {-1, -1, -1, -1};
    private int[] fichasAzules = {-1, -1, -1, -1};
    public LogicaPrincipal() {
        this.turnoActual = 0; 
    }
    public int lanzarDado() {
        this.valorDado = (int) (Math.random() * 6) + 1;
        return this.valorDado;
    }
    public void cambiarTurno() {
        this.turnoActual = (this.turnoActual + 1) % NUM_JUGADORES;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

}

