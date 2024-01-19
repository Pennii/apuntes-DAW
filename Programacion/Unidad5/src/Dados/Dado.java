/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dados;

/**
 *
 * @author pennii
 */
public class Dado {
    //Atributos de objeto
    private final int CARAS;
    private int lanzamientos;
    
    public Dado(int c){
        this.CARAS = c;
    }
    
    public Dado(){
        this.CARAS = 20;
    }
}
