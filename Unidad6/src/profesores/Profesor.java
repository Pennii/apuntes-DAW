/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package profesores;

/**
 *
 * @author maniana
 */
public class Profesor {
    private String nombre;
    private int edad;
    protected int aniosConsolidado;
    
    public Profesor(){
        this.aniosConsolidado = 1;
    }
}

class ProfesorEmerito extends Profesor{
    private int aniosEmerito;
    
    public double getSueldoBase(){
        double sueldo;
        sueldo = 925 + super.aniosConsolidado * 33.25 + 47.80 * this.aniosEmerito;
        return sueldo;
    }
}
