/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 *
 * @author maniana
 */
public abstract class Asiento extends Mueble{
    
    public static final int PLAZAS_MIN = 1;
    public static final int PLAZAS_MAX = 9;
    
    private int numPlazas;
    private String tapiceria;
    private String color;
    
    public Asiento(double precio, String desc, int plazas, String tapiceria, String color) throws IllegalArgumentException {
        super(precio, desc);
        if (plazas < PLAZAS_MIN || plazas > PLAZAS_MAX) {
            throw new IllegalArgumentException("NUMERO DE PLAZAS FUERA DE RANGO");
        }
        
        this.numPlazas = plazas;
        this.color = color;
        this.tapiceria = tapiceria;
    }
    
    public int getPlazas(){
        return this.numPlazas;
    }
    
    public String getTapiceria(){
        return this.tapiceria;
    }
    
    public String getColor(){
        return this.color;
    }
    
    @Override
    public String toString(){
        return String.format("%s numero de plazas: %-2d tapiceria: %-10s "
                + "color: %-10s", super.toString(), this.numPlazas, this.tapiceria,
                this.color);
    }
    
}
