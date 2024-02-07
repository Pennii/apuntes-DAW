package Libreria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author maniana
 */
public abstract class Producto {

    private static int controlador = 1;
    /**
     * precio minimo de un producto: {@value MIN_PRECIO}
     */
    public static final double MIN_PRECIO = 0.01;
    /**
     * precio maximo de un producto: {@value MAX_PRECIO}
     */
    public static final double MAX_PRECIO = 10000.00;

    private final int identificador;
    protected double precio;
    private final String descripcion;

    /**
     * constructor de 2 parametros. sera el constructor que se utilizara en esta
     * clase y sus hijas
     *
     * @param precio
     * @param descripcion
     * @throws IllegalArgumentException
     */
    public Producto(double precio, String descripcion) throws IllegalArgumentException {
        if (precio < MIN_PRECIO || precio > MAX_PRECIO) {
            throw new IllegalArgumentException(String.format("El precio no esta en el"
                    + " rango permitido: %.2f", precio));
        }

        this.precio = precio;
        this.descripcion = descripcion;
        this.identificador = Producto.controlador++;
    }

    /**
     * devuelve el identificador
     *
     * @return identificador del producto
     */
    public int getId() {
        return this.identificador;
    }

    /**
     * devuelve el precio
     *
     * @return precio del producto
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * devuelve la descripcion
     *
     * @return descripcion del producto
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     *
     * @return todos los atributos del producto en String
     */
    public String toString() {
        return String.format("Tipo: %-11s id: %-3d precio: %-4.2f descripcion: %s\n",
                this.getClass().getSimpleName(), this.getId(), this.getPrecio(),
                this.getPrecio());
    }
}
