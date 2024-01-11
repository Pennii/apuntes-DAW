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
public class MatricesEj4 {
    public static void main(String[] args) {
        int[] numeros = new int[4];
        int sietes = 0;
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = teclado.nextInt();
            for (int j = 0; numeros[i]>0; j++) {
                if (numeros[i]%10==7) {
                    sietes++;
                }
                numeros[i]/=10;
            }
        }
        System.out.println(sietes);
    }
}
