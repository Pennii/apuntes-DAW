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

    private final String fabricante;

    /**
     * constructor de un parametro. implementa el constructor padre agregando
     * fabricante.
     *
     * @param precio precio del producto
     * @param descripcion descripcion del producto
     * @param fabricante fabricante del producto
     * @throws IllegalArgumentException dependera totalmente del padre
     */
    public EReader(double precio, String descripcion, String fabricante)
            throws IllegalArgumentException {
        super(precio, descripcion);

        this.fabricante = fabricante;
    }

    /**
     * devuelve el fabricante del ereader
     *
     * @return fabricante
     */
    public String getFabaricante() {
        return this.fabricante;
    }

    /**
     *
     * @return todos los atributos del producto en String
     */
    public String toString() {
        return String.format("%s fabricante: %s", super.toString(),
                this.getFabaricante());
    }

}
