/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package profesores;

/**
 *
 * @author maniana
 */
public class Test {

    public static void main(String[] args) {
        ProfesorEmerito prof1 = new ProfesorEmerito(19, "jose");
        
        System.out.println(prof1.getSueldoBase());
      
        System.out.printf("El nombre del profesor es: %s\n",prof1.getNombre());
    }
}
