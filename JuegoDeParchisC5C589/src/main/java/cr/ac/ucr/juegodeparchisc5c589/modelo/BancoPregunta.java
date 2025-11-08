/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.modelo;

import cr.ac.ucr.juegodeparchisc5c589.modelo.Pregunta;
import java.util.ArrayList;

/**
 *
 * @author Thinkpad P52
 */
public class BancoPregunta 
{
    private ArrayList <Pregunta> listaPreguntas;
    
    public BancoPregunta ()
    {
        listaPreguntas = new ArrayList<Pregunta>();
    }
    
    public void crearPreguntas ()
    {
        agregar(new Pregunta ("¿Bruselas es la Capital de Bélgica?",0));
        agregar(new Pregunta ("¿El tomate es una fruta?",0));
        agregar(new Pregunta ("¿Se puede acceder a los atributos privados de una clase desde fuera de esta?",1));
        agregar(new Pregunta ("En programación: ¿Una referencia es lo mismo que una Instancia?",1));
        agregar(new Pregunta ("¿Napoleón Bonaparte decubrió la fisión nuclear?",1));
        
    }
    
    public void agregar (Pregunta pregunta)
    {
        listaPreguntas.add(pregunta);
    }
    
    public Pregunta getPregunta (int posicion)
    {
        return listaPreguntas.get(posicion);
    }
    
    public int getElementos ()
    {
        return listaPreguntas.size();
    }
    
    
}//Fin de BancoPregunta
