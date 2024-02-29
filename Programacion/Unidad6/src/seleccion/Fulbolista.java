/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seleccion;

/**
 *
 * @author maniana
 */
public class Fulbolista extends Seleccion{
    
    private int dorsal;
    private String demarcacion;
    
    public Fulbolista(int id, String nombre, String apellido, int edad, int dorsal, String demarcacion) {
        super(id, nombre, apellido, edad);
        this.demarcacion = demarcacion;
        this.dorsal = dorsal;
    }
    
    public void entrevista(){
        System.out.println("ENTREVISTADO");
    }
    
    public void entrenar(){
        System.out.println("ENTRENANDO");
    }
    
    public void partido(){
        System.out.println("JUGANDO");
    }
   
}
