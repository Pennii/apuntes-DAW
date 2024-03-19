/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea;

/**
 *
 * @author maniana
 */
public class Compra {
    
    private final String nombre;
    private final double precio;
    private final int cantidad;

    public Compra(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public double getImporte(){
        return this.cantidad * this.precio;
    }
    
    
    @Override
    public String toString(){
        return String.format("nombre: %s precio: %.2f cantidad: %d", this.nombre,
                this.precio, this.cantidad);
    }
}
