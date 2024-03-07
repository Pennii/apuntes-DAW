/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almacen;

/**
 *
 * @author matii
 */
public abstract class Producto {
    
    private static int ids = 1; 
    
    private final int id;
    private final double cantLitros;
    protected double precio;
    private String marca;
    
    public Producto(double cant, double precio, String marca){
        this.id = ids++;
        this.cantLitros = cant;
        this.precio = precio;
        this.marca = marca;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String toString(){
        return String.format("id: %d, cantidad de litros: %.2f, precio: %.2f"
                + ", marca: %s", this.id, this.cantLitros, this.precio,
                this.marca);
    }
}
