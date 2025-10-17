/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.controlador;

import cr.ac.ucr.juegodeparchisc5c589.vista.GUICredito;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIHistoria;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIInstrucciones;
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

    public ControladorPrincipal() {
        guiPrincipal= new GUIPrincipal(this);
        guiPrincipal.setVisible(true);
        guiCredito= new GUICredito(this);
        guiInstrucciones= new GUIInstrucciones(this);
        guiHistoria=new GUIHistoria(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Jugar":
                break;
            case "Instrucciones":
                guiPrincipal.setVisible(false);
                guiInstrucciones.setVisible(true);
                break;
            case "AtrasInstrucciones":
                guiInstrucciones.setVisible(false);
                guiPrincipal.setVisible(true);
                break;
            case "Historia":
                guiPrincipal.setVisible(false);
                guiHistoria.setVisible(true);
                break;
            case "AtrasHistoria":
                guiHistoria.setVisible(false);
                guiPrincipal.setVisible(true);
                break;
            case "Creditos":
                guiPrincipal.setVisible(false);
                guiCredito.setVisible(true);
                break;
            case "AtrasCreditos":
                guiCredito.setVisible(false);
                guiPrincipal.setVisible(true);
                break;
            case "Salir":
                System.exit(0);
                break;
        }
    }   
}
