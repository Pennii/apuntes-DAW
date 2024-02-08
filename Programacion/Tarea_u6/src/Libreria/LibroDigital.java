/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @author maniana
 */
public abstract class LibroDigital extends Libro implements Descargable {

    /**
     * tamaño maximo del archivo: {@value MAX_SIZE}
     */
    public static final int MAX_SIZE = 65535;

    /**
     * tamaño minimo del archivo: {@value MIN_SIZE}
     */
    public static final int MIN_SIZE = 20;

    /**
     * tamaño del archivo
     */
    protected int size;
    private int vecesDescargado;

    /**
     * constructor que agrega 1 parametro al heredado
     *
     * @param precio precio del producto
     * @param descripcion descripcion del porducto
     * @param titulo titulo del libro
     * @param autor autor del libro
     * @param publicacion año de publicacion del libro
     * @param tam tamaño del archivo
     * @throws IllegalArgumentException si el tamaño del archivo es invalido
     */
    public LibroDigital(double precio, String descripcion, String titulo,
            String autor, int publicacion, int tam) throws IllegalArgumentException {
        super(precio, descripcion, titulo, autor, publicacion);
        if (tam < MIN_SIZE || tam > MAX_SIZE) {
            throw new IllegalArgumentException("Tamaño de archivo invalido");
        }

        this.size = tam;
    }

    /**
     * devuelve el tamaño del archivo
     *
     * @return tamaño del archivo en KB
     */
    public int getSize() {
        return this.size;
    }

    /**
     * devuelve la cantidad de veces que fue descargado un archivo
     *
     * @return numero de veces descargado
     */
    public int getNumDescargas() {
        return this.vecesDescargado;
    }

    /**
     * accion de descargar un archivo. emula la descarga, y aumenta el numero de
     * veces descargado, devolviendo este numero
     *
     * @return numero de veces descargado
     */
    public int descargar() {
        this.vecesDescargado++;
        return this.vecesDescargado;
    }

    /**
     *
     * @return todos los atributos del producto en String
     */
    public String toString() {
        return String.format("%s Tamaño: %dKB, numDescargas: %d",
                super.toString(), this.getSize(),
                this.getNumDescargas());
    }

}
