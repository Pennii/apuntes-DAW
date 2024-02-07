/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @author maniana
 */
public final class Ebook extends LibroDigital {

    private String codificacion;

    /**
     * constructor que agrega 1 parametro al agregado
     *
     * @param precio precio del producto
     * @param descripcion descripcion del producto
     * @param titulo titulo del libro
     * @param autor autor del libro
     * @param publicacion año de publicacion
     * @param tam tamaño del archivo
     * @param cod codificacion
     * @throws IllegalArgumentException
     */
    public Ebook(double precio, String descripcion, String titulo,
            String autor, int publicacion, int tam,
            String cod) throws IllegalArgumentException {
        super(precio, descripcion, titulo, autor, publicacion, tam);

        this.codificacion = cod;
    }

    /**
     * devuelve la codificacion
     *
     * @return codificacion del ebook
     */
    public String getCodificacion() {
        return this.codificacion;
    }

    /**
     * accion de descargar un archivo. emula la descarga del archivo, aumentando
     * el numero de veces descargado y el precio del mismo, hasta que llegue al
     * maximo
     *
     * @return cantidad de veces descargado
     */
    public int descargar() {
        if (this.precio < Producto.MAX_PRECIO) {
            this.precio += 0.01;
        }
        return super.descargar();
    }

    /**
     * 
     * @return todos los atributos del producto en String
     */
    public String toString() {
        return String.format("%s Codificacion: %s", super.toString(),
                this.getCodificacion());
    }
}
