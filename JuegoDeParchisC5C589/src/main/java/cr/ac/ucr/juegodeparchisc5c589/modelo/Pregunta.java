/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.juegodeparchisc5c589.modelo;

/**
 *
 * @author Thinkpad P52
 */
public class Pregunta 
{
    private String enunciado;
    private int respuesta;
    
    public void pregunta ()
    {
        
    }

    public Pregunta(String enunciado, int respuesta) 
    {
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }

    public String getEnunciado() 
    {
        return enunciado;
    }

    public int isRespuesta() 
    {
        return respuesta;
    }

    public void setEnunciado(String enunciado) 
    {
        this.enunciado = enunciado;
    }

    public void setRespuesta(int respuesta) 
    {
        this.respuesta = respuesta;
    }
    
    
}
