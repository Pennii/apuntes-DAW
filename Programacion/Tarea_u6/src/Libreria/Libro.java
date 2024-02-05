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

    public static final int MIN_YEAR = 1500;
    public static final int MAX_YEAR = LocalDate.now().getYear();

    private final String TITULO;
    private final String AUTOR;
    private final int ANIO_PUBLICACION;

    public Libro(double precio, String descripcion, String titulo, String autor,
             int publicacion) throws IllegalArgumentException {
        super(precio, descripcion);
        if (publicacion < MIN_YEAR || publicacion > MAX_YEAR) {
            throw new IllegalArgumentException("AÑO FUERA DE RANGO");
        }

        this.TITULO = titulo;
        this.AUTOR = autor;
        this.ANIO_PUBLICACION = publicacion;
    }
    
    public String getTitulo(){
     return this.TITULO;   
    }
    
    public String getAutor(){
        return this.AUTOR;
    }
    
    public int getAnioPublicacion(){
        return this.ANIO_PUBLICACION;
    }
    
    public String toString(){
        return String.format("%s Titulo: %s Autor: %s Año: %d", 
                super.toString(), this.getTitulo(), this.getAutor(),
                this.getAnioPublicacion());
    }
    
}
