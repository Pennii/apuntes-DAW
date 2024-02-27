/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seleccion;

/**
 *
 * @author maniana
 */
public abstract class Seleccion {
    
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    
    public Seleccion(int id, String nombre, String apellido, int edad){
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }
    
    public void viajar(){
        System.out.println("VIAJANDO");
    }
    
    public void concentrarse(){
        System.out.println("CONCENTRARSE");
    }
    
    public void partido(){
        System.out.println("ASISTO AL PARTIDO");
    }
    
    public abstract void entrenar();
}
