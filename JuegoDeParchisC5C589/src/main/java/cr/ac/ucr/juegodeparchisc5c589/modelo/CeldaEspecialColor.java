/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.modelo;

import cr.ac.ucr.juegodeparchisc5c589.modelo.Posicion;
import cr.ac.ucr.juegodeparchisc5c589.modelo.CeldaEspecial;

/**
 *
 * @author Thinkpad P52
 */
public class CeldaEspecialColor extends CeldaEspecial{
    private String color;
    
    public CeldaEspecialColor(Posicion posicion,String tipo, String color) {
        super(posicion,tipo);
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
