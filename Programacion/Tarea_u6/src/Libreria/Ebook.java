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

    public Ebook(double precio, String descripcion, String titulo,
            String autor, int publicacion, int tam,
            String cod) throws IllegalArgumentException {
        super(precio, descripcion, titulo, autor, publicacion, tam);
        
        this.codificacion = cod;
    }
    
    public String getCodificacion(){
        return this.codificacion;
    }
    
    public int descargar(){
        if (this.precio < Producto.MAX_PRECIO ) {
            this.precio+=0.01;
        }   
        return super.descargar();   
    }

    public String toString(){
        return String.format("%s Codificacion: %s",super.toString(),
                this.getCodificacion());
    }
}
