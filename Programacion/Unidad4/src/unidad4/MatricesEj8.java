/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class MatricesEj8 {
    public static void main(String[] args) {
        final String VOCALES = "[aeiou]";
        String[] entrada = new String[5];
        int cant = 0;
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < entrada.length; i++) {
            entrada[i] = teclado.nextLine();
            if (entrada[i].matches(VOCALES)) {
                cant++;
            }
        }
        System.out.printf("Hay %d vocales\n",cant);
    }
   
}
