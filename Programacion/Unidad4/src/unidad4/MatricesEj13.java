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
public class MatricesEj13 {
    public static void main(String[] args) {
        int[][] matriz = new int[5][2];
        
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=teclado.nextInt();
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if ((i+1)%2==0) {
                    System.out.printf("%-2d ",matriz[i][j]);
                }
                
            }
            System.out.println("");
        }
    }
}
