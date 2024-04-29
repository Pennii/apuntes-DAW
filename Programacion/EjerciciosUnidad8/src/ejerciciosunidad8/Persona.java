/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosunidad8;

import java.io.Serializable;

/**
 *
 * @author matii
 */
public class Persona implements Serializable{
    private String nombre = "julian";
    private int conteo;
    private static int cont = 0;
    
    public Persona(){
        conteo = ++cont;
    }
    
    public String toString(){
        return nombre + " " + conteo;
    }
}
