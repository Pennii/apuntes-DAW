/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author maniana
 */
public class Pez extends Animal{
    
    private final String escamas;
    
    public Pez(String escamas){
        this.escamas = escamas;
    }
    
    /**
     * se llama al metodo de Animal y se agrega el ruido
     */
    public void hacerRuido(){
        System.out.println("glub glub");
    }
    
    /**
     * devuelve el color del animal
     * @return escamas
     */
    public String getEscamas(){
        return this.escamas;
    }
    
}
