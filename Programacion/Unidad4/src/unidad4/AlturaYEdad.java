/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class AlturaYEdad {
    public static void main(String[] args) {
        int alturaEdad[][] = new int[5][2];
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < alturaEdad.length; i++) {    
                System.out.println("Ingresa la altura");
                alturaEdad[i][0] = teclado.nextInt();
                System.out.println("Ingresa la edad");
                alturaEdad[i][1] = teclado.nextInt();
        }
        
        System.out.println(Arrays.deepToString(alturaEdad));
    }
}
