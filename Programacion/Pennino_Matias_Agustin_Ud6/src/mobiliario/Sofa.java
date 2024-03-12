/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 *
 * @author maniana
 */
public class Sofa extends Asiento{
    
    private String composicion;
    
    public Sofa(double precio, String desc, int plazas, String tapiceria, String color, String composicion) throws IllegalArgumentException {
        super(precio, desc, plazas, tapiceria, color);
        
        this.composicion = composicion;
    }
    
    public String getComp(){
        return this.composicion;
    }
    
    @Override
    public String toString(){
        return String.format("%s composicion: %-10s", super.toString(), 
                this.composicion);
    }
    
}
