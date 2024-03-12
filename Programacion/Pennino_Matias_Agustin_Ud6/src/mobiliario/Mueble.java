/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 *
 * @author maniana
 */
public abstract class Mueble {
    
    public static final double MIN_PRECIO = 10.0;
    public static final double MAX_PRECIO = 10000.0;
    
    private static int listaId = 1;
    
    private int id;
    private double precio;
    private String descripcion;
    
    public Mueble(double precio, String desc) throws IllegalArgumentException{
        if (precio > Mueble.MAX_PRECIO || precio < Mueble.MIN_PRECIO) {
            throw new IllegalArgumentException("PRECIO FUERA DE RANGO");
        }
        
        this.descripcion = desc;
        this.id = Mueble.listaId++;
        this.precio = precio;
    }
    
    public int getId(){
        return this.id;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public String getDesc(){
        return this.descripcion;
    }
            
    @Override
    public String toString(){
        return String.format("tipo: %-10s identificador: %-2d precio: %6.2f "
                + "descripcion %-15s", this.getClass().getSimpleName(), 
                this.id, this.precio, this.descripcion);
    }
}
