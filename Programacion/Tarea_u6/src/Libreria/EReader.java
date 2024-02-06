/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @author matii
 */
public final class EReader extends Producto {
    
    private final String FABRICANTE;
    
    
    /**
     * constructor de un parametro.
     *  implementa el constructor padre agregando fabricante.
     * @param precio
     * @param descripcion
     * @param fabricante
     * @throws IllegalArgumentException 
     */
    public EReader(double precio, String descripcion, String fabricante)
            throws IllegalArgumentException {
        super(precio, descripcion);
        
        this.FABRICANTE = fabricante;
    }
    
    public String getFabaricante(){
        return this.FABRICANTE;
    }
    
    public String toString(){
        return String.format("%s fabricante: %s", super.toString(), 
                this.getFabaricante());
    }
    
}
