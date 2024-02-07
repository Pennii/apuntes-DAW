/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

import java.time.LocalDate;

/**
 *
 * @author maniana
 */
public abstract class Libro extends Producto {

    /**
     * año minimo de publicacion
     */
    public static final int MIN_YEAR = 1500;
    /**
     * año maximo de publicacion. sera el actual
     */
    public static final int MAX_YEAR = LocalDate.now().getYear();

    private final String titulo;
    private final String autor;
    private final int anio_publicacion;

    /**
     * constructor heredado de producto. es el mismo, pero se agregan 3
     * parametros
     *
     * @param precio precio del producto
     * @param descripcion descripcion del porducto
     * @param titulo titulo del libro
     * @param autor autor del libro
     * @param publicacion año de publicacion
     * @throws IllegalArgumentException
     */
    public Libro(double precio, String descripcion, String titulo, String autor,
            int publicacion) throws IllegalArgumentException {
        super(precio, descripcion);
        if (publicacion < MIN_YEAR || publicacion > MAX_YEAR) {
            throw new IllegalArgumentException("AÑO FUERA DE RANGO");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.anio_publicacion = publicacion;
    }

    /**
     * devuelve el titulo
     *
     * @return titulo del libro
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * devuelve el autor
     *
     * @return autor del libro
     */
    public String getAutor() {
        return this.autor;
    }

    /**
     * devuelve el año de publicacion
     *
     * @return año de publicacion del libro
     */
    public int getAnioPublicacion() {
        return this.anio_publicacion;
    }

    /**
     *
     * @return todos los atributos del producto en String
     */
    public String toString() {
        return String.format("%s Titulo: %s Autor: %s Año: %d",
                super.toString(), this.getTitulo(), this.getAutor(),
                this.getAnioPublicacion());
    }

}
