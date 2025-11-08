/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.modelo;

import cr.ac.ucr.juegodeparchisc5c589.modelo.Posicion;
import cr.ac.ucr.juegodeparchisc5c589.modelo.Celda;

/**
 *
 * @author Thinkpad P52
 */
public class CeldaEspecial extends Celda {
    protected String tipo;
    
    public CeldaEspecial(Posicion posicion, String tipo) {
        super(posicion);
        this.tipo= tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
