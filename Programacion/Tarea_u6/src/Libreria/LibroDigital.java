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
    
    public static final int MAX_SIZE = 65535;
    public static final int MIN_SIZE = 20;
    
    protected  int size;
    private int vecesDescargado;
    
    public LibroDigital(double precio, String descripcion, String titulo, 
            String autor, int publicacion, int tam) throws IllegalArgumentException {
        super(precio, descripcion, titulo, autor, publicacion);
        if (tam < MIN_SIZE || tam > MAX_SIZE) {
            throw new IllegalArgumentException("Tamaño de archivo invalido");
        }
        
        this.size = tam;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public int getNumDescargas(){
        return this.vecesDescargado;
    }
    
    public int descargar(){
        this.vecesDescargado++;
        return this.vecesDescargado;
    }
    
    public String toString(){
        return String.format("%s Tamaño: %dKB, numDescargas: %d",
                super.toString(), this.getSize(),
                this.getNumDescargas());
    }
    
    
    
}
