/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author maniana
 */
public abstract class Animal {
    
    /**
     * Este metodo nos permite ver que ruido hace cada animal, pero dependera de 
     * los animales que creemos despues.
     */
    public void hacerRuido(){
        System.out.printf("El %s hace: ",this.getClass().getSimpleName());
    }
    
}
