/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Arrays;

/**
 *
 * @author maniana
 */
public class Array2 {
    public static void main(String[] args) {
        final int LONGITUD = 10;
        int numeros[] = new int[LONGITUD];
        int numeros2[] = new int[LONGITUD];
        
        
        for (int i = 0; i < numeros.length;) {
            numeros[i] = (++i);
        }
        
        System.out.printf("La lista de numero es: %s\n",Arrays.toString(numeros));
        
        for (int i = 0; i < numeros2.length; i++) {
            numeros2[i] = (i*2);
        }
        
        System.out.printf("La lista de numero es: %s\n",Arrays.toString(numeros2));
    }
}
