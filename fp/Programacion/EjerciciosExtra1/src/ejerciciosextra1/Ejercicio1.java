/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosextra1;

/**
 *
 * @author maniana
 */
public class Ejercicio1 {
        enum Palos {ESPADA, BASTO, ORO, COPA};
    public static void main(String[] args) {
       for(int i=0;i<=3;i++){
           System.out.println("El palo " + (i+1) + " es: " + Palos.values()[i]);
       }
    }

}
