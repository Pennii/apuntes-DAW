/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almacen;

/**
 *
 * @author matii
 */
public class Azucarada extends Producto{
    
    private double porcentaje;
    private boolean promocion;
    
    public Azucarada(double cant, double precio, String marca, double porc, boolean promo) {
        super(cant, precio, marca);
        this.promocion = promo;
        this.porcentaje = porc;
        if (promo) {
            this.precio *= 0.8;
        }
    }
    
    public String toString(){
        return String.format("%s, promocion: %s, porcentaje de azucar: %.2f", 
                super.toString(), this.promocion?"si":"no", this.porcentaje);
    }
}
