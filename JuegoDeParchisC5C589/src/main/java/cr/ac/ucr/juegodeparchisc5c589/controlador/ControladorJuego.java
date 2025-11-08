/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.controlador;

import cr.ac.ucr.juegodeparchisc5c589.modelo.AreaJuego;
import cr.ac.ucr.juegodeparchisc5c589.modelo.Ficha;
import cr.ac.ucr.juegodeparchisc5c589.modelo.Posicion;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIJuego;
import cr.ac.ucr.juegodeparchisc5c589.vista.GUIPrincipal;
import cr.ac.ucr.juegodeparchisc5c589.vista.PanelControl;
import cr.ac.ucr.juegodeparchisc5c589.vista.PanelJuego;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Thinkpad P52
 */
public class ControladorJuego implements ActionListener,MouseListener {
    private GUIJuego guiJuego;
    private PanelJuego panelJuego;
    private PanelControl panelControl;
    private GUIPrincipal guiPrincipal;
    private Ficha ficha;
    private AreaJuego areaJuego;
    
    public ControladorJuego(GUIPrincipal guiPrincipal){
        this.guiPrincipal=guiPrincipal;
        guiJuego=new GUIJuego(this);
        panelJuego=guiJuego.getPanelJuego();
        panelControl=guiJuego.getPanelControl();
        guiJuego.setVisible(true);
        areaJuego= new AreaJuego();
        ficha=new Ficha(new Posicion(100,100),new  ImageIcon("./src/main/resources/img/pieceblue.png"),"Amarillo");
    }//453,468
    public void dibujar (Component c, Graphics g){
        ficha.dibujar(c, g);
        areaJuego.dibujar(c, g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Dado":
                System.out.println("Presiono el dado");
            break;
            case "Atras":
                guiJuego.dispose();
                guiPrincipal.setVisible(true);
            break;    
        }
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x "+e.getX()+" Y "+e.getY());
        ficha.getPosicion().setX(e.getX());
        ficha.getPosicion().setY(e.getY());
        panelJuego.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}

