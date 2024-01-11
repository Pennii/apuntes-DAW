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
public class MatricesEj14 {
    public static void main(String[] args) {
        int[][] matriz = new int[5][2];
        Scanner teclado = new Scanner(System.in);
        
        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                matriz1[j] = teclado.nextInt();
            }
        }
        
        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                if ((j+1)%2!=0) {
                    System.out.printf("%d ", matriz1[j]);
                }
            }
            System.out.println("");
        }
    }
}
