/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almacen;

/**
 *
 * @author matii
 */
public class AguaMineral extends Producto{
    
    private String origen;
    
    public AguaMineral(double cant, double precio, String marca, String origen) {
        super(cant, precio, marca);
        this.origen = origen;
    }
    
    public String toString(){
        return String.format("%s, origen: %s", super.toString(), this.origen);
    }
}
