/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author maniana
 */
public class Gato extends Animal{
    
    private final String pelo;
    
    public Gato(String pelo){
        this.pelo = pelo;
    }
    
    /**
     * se llama al metodo de Animal y se agrega su ruido
     */
    public void hacerRuido(){
        super.hacerRuido();
        System.out.println("miau");
    }
    
    /**
     * devuelve el color del animal
     * @return pelo
     */
    public String getPelo(){
        return this.pelo;
    }
    
}
