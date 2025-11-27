/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.controlador;

import cr.ac.ucr.juegodeparchisc5c589.modelo.HiloCronometro;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUICronometro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Thinkpad P52
 */
public class ControlCronometro implements ActionListener {

    private HiloCronometro hilo;
    private GUICronometro gui;

    public ControlCronometro() {
        this.gui=new GUICronometro();
        this.hilo=new HiloCronometro(gui);
        this.gui.escuchar(this);
        this.hilo.start();
        this.gui.setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
}