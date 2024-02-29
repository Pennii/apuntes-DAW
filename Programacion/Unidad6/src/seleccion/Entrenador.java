/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seleccion;

/**
 *
 * @author maniana
 */
public class Entrenador extends Seleccion{
    
    public Entrenador(int id, String nombre, String apellido, int edad){
        super(id, nombre, apellido, edad);
    }
    
    public void entrenar(){
        System.out.println("DIRIGE");
    }
    
    public void partido(){
        System.out.println("DIRIGE PARTIDO");
    }
    
    public void planificaEntrenamiento(){
        System.out.println("PLANIFICA");
    }
    
}
