/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 *
 * @author maniana
 */
public class Mesa extends Mueble{
    
    /**
     * cantidad minima de espacio para comensales
     */
    public static final int COMEN_MIN = 4;
    /**
     * cantidad maxima de espacio para comensales
     */
    public static final int COMEN_MAX = 16;
    
    private String forma;
    private int comensales;
    
    /**
     * constructor de 4 parametros. Utiliza el constructor de la clase Mueble para
     * los primeros 2 parametros y luego inicializa los 2 siguientes
     * @param precio precio del mueble
     * @param desc descripcion
     * @param forma forma de la mesa
     * @param comensales espacio para comensales
     * @throws IllegalArgumentException 
     */
    public Mesa(double precio, String desc, String forma, int comensales) throws IllegalArgumentException {
        super(precio, desc);
        
        if (comensales > Mesa.COMEN_MAX || comensales < Mesa.COMEN_MIN) {
            throw new IllegalArgumentException("CANTIDAD DE COMENSALES FUERA DE RANGO");
        }
        
        this.comensales = comensales;
        this.forma = forma;
    }
    
    /**
     * devuelve el espacio para comensales
     * @return numero de comensales
     */
    public int getComensales(){
        return this.comensales;
    }
    
    /**
     * devuelve la forma de la mesa
     * @return forma de la mesa
     */
    public String getForma(){
        return this.forma;
    }
    
    /**
     * devuelve la representacion de la mesa en forma de lista
     * @return caracteristicas de la mesa 
     */
    @Override
    public String toString(){
        return String.format("%s comensales: %-2d forma: %s", super.toString(),
                this.comensales, this.forma);
    }
    
}
