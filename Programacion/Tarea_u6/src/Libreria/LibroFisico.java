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

    /**
     * tamaño minimo de paginas
     */
    public static final int MIN_PAGINAS = 20;
    
    /**
     * tamaño maximo de paginas
     */
    public static final int MAX_PAGINAS = 5000;

    private final int paginas;

    /**
     * constructor que agrega 1 parametro al heredado
     * @param precio
     * @param descripcion
     * @param titulo
     * @param autor
     * @param publicacion
     * @param paginas
     * @throws IllegalArgumentException 
     */
    public LibroFisico(double precio, String descripcion, String titulo,
            String autor, int publicacion, int paginas) throws IllegalArgumentException {
        super(precio, descripcion, titulo, autor, publicacion);
        if (paginas < MIN_PAGINAS || paginas > MAX_PAGINAS) {
            throw new IllegalArgumentException("Numero de paginas fuera de rango");
        }

        this.paginas = paginas;
    }

    /**
     * devuelve el numero de paginas
     * @return numero de paginas
     */
    public int getPaginas() {
        return this.paginas;
    }

    /**
     * 
     * @return todos los atributos del producto en String
     */
    public String toString() {
        return String.format("%s Numero de paginas: %d", super.toString(),
                this.getPaginas());
    }
}
