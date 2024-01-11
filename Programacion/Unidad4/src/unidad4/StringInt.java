/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

/**
 *
 * @author maniana
 */
public class StringInt {
    public static void main(String[] args) {
        String elem1 = "35";
        int elem1Int = Integer.valueOf(elem1);
        String elem3 = Integer.toBinaryString(elem1Int);
        int elem2= 5;
        System.out.printf("La suma es: %s\n",elem1Int+elem2);
        System.out.printf("El numeo hexa es: %s\n",elem3);
    }
   
}
