package Libreria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maniana
 */
public abstract class Producto {
    
    private static int controlador = 1;
    private static final double MIN_PRECIO = 0.01;
    private static final double MAX_PRECIO = 10000.00;
    
    private  final int IDENTIFICADOR;
    protected double precio;
    private  String descripcion;
    
    public Producto(double precio, String descripcion) throws IllegalArgumentException{
        if (precio < MIN_PRECIO || precio > MAX_PRECIO) {
            throw new IllegalArgumentException(String.format("El precio no esta en el"
                    + " rango permitido: %.2f",precio));
        }
        
        this.precio = precio;
        this.descripcion = descripcion;
        this.IDENTIFICADOR = Producto.controlador++;
    }
    
    public int getId(){
        return this.IDENTIFICADOR;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public String toString(){
        return String.format("Tipo: %-11s id: %-3d precio: %-4.2f descripcion: %s\n",
                this.getClass().getSimpleName(), this.getId(), this.precio,
                this.getPrecio());
    }
}
