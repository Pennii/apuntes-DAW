/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @author maniana
 */
public final class LibroFisico extends Libro {
    
    public static final int MIN_PAGINAS = 20;
    public static final int MAX_PAGINAS = 5000;
    
    private final int PAGINAS;
    
    public LibroFisico(double precio, String descripcion, String titulo, 
            String autor, int publicacion, int paginas) throws IllegalArgumentException {
        super(precio, descripcion, titulo, autor, publicacion);
        if (paginas < MIN_PAGINAS || paginas > MAX_PAGINAS) {
            throw new IllegalArgumentException("Numero de paginas fuera de rango");
        }
        
        this.PAGINAS = paginas;
    }
    
    public int getPaginas(){
        return this.PAGINAS;
    }
    
    public String toString(){
        return String.format("%s Numero de paginas: %d",super.toString(),
                this.getPaginas());
    }
}
