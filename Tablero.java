/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.modelo;


import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */

public class Tablero {

    private Celda[] tablero;
    private Casa casaJugador1;
    private Casa casaJugador2;
    private String colorJ1;
    private String colorJ2;

    public Tablero() {
        tablero = new Celda[68];
        iniciar();
    }
    public void iniciar() {
        int x = 351;
        int y = 589;

        // 0-3: Celdas normales subiendo
        for (int indice = 0; indice < 4; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            y -= 30;
        }
        
        // 4: Salida Amarillo
        tablero[4] = new CeldaEspecialColor(new Posicion(x, y), "salida Amarillo", "Amarillo");
        y -= 30;
        
        // 5-7: Celdas normales
        for (int indice = 5; indice < 8; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            y -= 30;
        }
        
        // Cambio de dirección
        x = 383;
        y = 349;
        
        // 8-10: Derecha
        for (int indice = 8; indice < 11; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            x += 30;
        }
        
        // 11: Zona Segura
        tablero[11] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        x += 30;
        
        // 12-15
        for (int indice = 12; indice < 16; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            x += 30;
        }
        
        // 16: Zona Segura
        x = 592;
        y = 289;
        tablero[16] = new CeldaEspecial(new Posicion(x, y), "zona segura");

        x = 590;
        y = 245;
        
        // 17-20
        for (int indice = 17; indice < 21; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            x -= 30;
        }
        
        // 21: Salida Azul
        tablero[21] = new CeldaEspecialColor(new Posicion(x, y), "salida Azul", "Azul");
        x -= 30;
        
        // 22-24
        for (int indice = 22; indice < 25; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            x -= 30;
        }
        
        x = 351;
        y = 213;
        
        // 25-27
        for (int indice = 25; indice < 28; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            y -= 30;
        }
        
        // 28: Zona Segura
        tablero[28] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        y -= 30;
        
        // 29-32
        for (int indice = 29; indice < 33; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            y -= 30;
        }

        x = 295;
        y = 3;
        
        // 33: Zona Segura
        tablero[33] = new CeldaEspecial(new Posicion(x, y), "zona segura");

        x = 253;
        y = 3;
        
        // 34-37
        for (int indice = 34; indice < 38; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            y += 30;
        }
        
        // 38: Salida Rojo
        tablero[38] = new CeldaEspecialColor(new Posicion(x, y), "salida Rojo", "Rojo");
        y += 30;
        
        // 39-41
        for (int indice = 39; indice < 42; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            y += 30;
        }

        x = 209;
        y = 245;
        
        // 42-43
        for (int indice = 42; indice < 44; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            x -= 30;
        }
        
        // 44: Zona Segura
        tablero[44] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        x -= 30;

        // 45-49
        for (int indice = 45; indice < 50; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            x -= 30;
        }

        x = 1;
        y = 289;
        
        // 50: Zona Segura
        tablero[50] = new CeldaEspecial(new Posicion(x, y), "zona segura");

        x = 1;
        y = 347;
        
        // 51-54
        for (int indice = 51; indice < 55; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            x += 30;
        }
        
        // 55: Salida Verde
        tablero[55] = new CeldaEspecialColor(new Posicion(x, y), "salida Verde", "Verde");
        x += 30;
        
        // 56-58
        for (int indice = 56; indice < 59; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            x += 30;
        }

        x = 245;
        y = 380;
        
        // 59-61
        for (int indice = 59; indice < 62; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            y += 30;
        }
        
        // 62: Zona Segura
        tablero[62] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        y += 30;
        
        // 63-66
        for (int indice = 63; indice < 67; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            y += 30;
        }

        x = 297;
        y = 592;
        
        // 67: Zona Segura (Última)
        tablero[67] = new CeldaEspecial(new Posicion(x, y), "zona segura");
    }
    public void crearCasas(String color1, String color2) {
        this.colorJ1 = color1;
        this.colorJ2 = color2;
        
        casaJugador1 = new Casa(color1);
        configurarFichasCasa(casaJugador1, color1);

        casaJugador2 = new Casa(color2);
        configurarFichasCasa(casaJugador2, color2);
    }
    
    private void configurarFichasCasa(Casa casa, String color) {
        String colorIngles = "black";
        if(color.equals("Amarillo")) colorIngles = "yellow";
        else if(color.equals("Rojo")) colorIngles = "red";
        else if(color.equals("Azul")) colorIngles = "blue";
        else if(color.equals("Verde")) colorIngles = "green";
        String pathImg = "./src/main/resources/img/piece" + colorIngles + ".png";
        
        // Coordenadas fijas de las casas (Ajustadas a tu código original)
        int x=0, y=0;
        if(color.equals("Amarillo")) { x = 455; y = 462; }
        else if(color.equals("Rojo")) { x = 40; y = 54; }
        else if(color.equals("Azul")) { x = 455; y = 54; }
        else if(color.equals("Verde")) { x = 40; y = 462; }
        casa.setFicha(0, new Ficha(new Posicion(x, y), new ImageIcon(pathImg), color));
        casa.setFicha(1, new Ficha(new Posicion(x + 85, y), new ImageIcon(pathImg), color));
        casa.setFicha(2, new Ficha(new Posicion(x, y + 64), new ImageIcon(pathImg), color));
        casa.setFicha(3, new Ficha(new Posicion(x + 85, y + 64), new ImageIcon(pathImg), color));
    }

    public int moverFicha(int indiceActual, int pasos, String colorJugador) {
        int nuevoIndice = (indiceActual + pasos) % 68;
        
        Celda celdaDestino = tablero[nuevoIndice];
        Ficha fichaEnDestino = celdaDestino.getFicha();
        
        if (fichaEnDestino != null) {
            if (fichaEnDestino.getColor().equals(colorJugador)) {
                return -1;
            } else {
                if (celdaDestino instanceof CeldaEspecial) {
                    return -1;
                } else {
                    devolverFichaACasa(fichaEnDestino);
                }
            }
        }
        
        Ficha fichaAMover = tablero[indiceActual].getFicha();
        tablero[indiceActual].setFicha(null);
        tablero[nuevoIndice].setFicha(fichaAMover);
        fichaAMover.setPosicion(tablero[nuevoIndice].getPosicion());
        
        return nuevoIndice;
    }
    
    private void devolverFichaACasa(Ficha ficha) {
        Casa casaDestino = (ficha.getColor().equals(colorJ1)) ? casaJugador1 : casaJugador2;
        int x=0, y=0;
        String c = ficha.getColor();
        if(c.equals("Amarillo")) { x = 455; y = 462; }
        else if(c.equals("Rojo")) { x = 40; y = 54; }
        else if(c.equals("Azul")) { x = 455; y = 54; }
        else if(c.equals("Verde")) { x = 40; y = 462; }
        ficha.setPosicion(new Posicion(x, y));
        for(int i=0; i<4; i++){
            if(casaDestino.getFicha(i) == null){
                casaDestino.setFicha(i, ficha);
                break;
            }
        }
    }

    public boolean intentarSacarFicha(int indexFichaCasa, String colorJugador) {
        Casa casaActual = (colorJugador.equals(colorJ1)) ? casaJugador1 : casaJugador2;
        Ficha ficha = casaActual.getFicha(indexFichaCasa);
        
        if (ficha == null) return false;

        int indiceSalida = -1;
        switch (colorJugador) {
            case "Amarillo": indiceSalida = 4; break;
            case "Azul": indiceSalida = 21; break;
            case "Rojo": indiceSalida = 38; break;
            case "Verde": indiceSalida = 55; break;
        }

        if (indiceSalida != -1) {
             if(tablero[indiceSalida].getFicha() == null || !tablero[indiceSalida].getFicha().getColor().equals(colorJugador)){
                 if(tablero[indiceSalida].getFicha() != null) {
                     devolverFichaACasa(tablero[indiceSalida].getFicha());
                 }
                 tablero[indiceSalida].setFicha(ficha);
                 ficha.setPosicion(tablero[indiceSalida].getPosicion());
                 casaActual.setFicha(indexFichaCasa, null);
                 return true;
             }
        }
        return false;
    }

    public int getIndexFichaCasa(int x, int y, String color) {
        Casa c = (color.equals(colorJ1)) ? casaJugador1 : casaJugador2;
        if(c == null) return -1;
        for (int i = 0; i < 4; i++) {
            if (c.getFicha(i) != null && c.getFicha(i).isContains(x, y)) return i;
        }
        return -1;
    }

    public int getIndexFichaEnTablero(int x, int y, String color) {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] != null && tablero[i].getFicha() != null) {
                if (tablero[i].getFicha().getColor().equals(color)) {
                    if (tablero[i].getFicha().isContains(x, y)) return i;
                }
            }
        }
        return -1;
    }
    
    public boolean isCeldaNormal(int indice){
         if (indice < 0 || indice >= tablero.length || tablero[indice] == null) return false;
        return !(tablero[indice] instanceof CeldaEspecial);
    }

    public void dibujar(Component component, Graphics g) {
        if(casaJugador1 != null) casaJugador1.dibujar(component, g);
        if(casaJugador2 != null) casaJugador2.dibujar(component, g);

        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] != null && tablero[i].getFicha() != null) {
                tablero[i].getFicha().dibujar(component, g);
            }
        }
    }
}

   