/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package churrero;

/**
 *
 * @author maniana
 */
public class NoPerecedero extends Producto {

    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void setTipo(){
        this.tipo = tipo;
    }
    
    public String toString(){
        return String.format("%s, tipo: %s", super.toString(),this.tipo);
    }
    
}
