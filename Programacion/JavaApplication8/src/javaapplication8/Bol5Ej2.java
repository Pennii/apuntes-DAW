/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Bol5Ej2 {
    public static void main(String[] args) {
        int matriz[][] = new int[4][4];
        boolean valido = true;
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = teclado.nextInt();
            }
        }
        System.out.println("La matriz es la siguiente:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%-2d",matriz[i][j]);
            }
            System.out.println("");
        }
        
        for (int i = 0; i < matriz.length && valido; i++) {
            for (int j = 0; j < matriz[i].length && valido; j++) {
                valido = matriz[i][j] == matriz[j][i];
            }
        }
        
        if (valido) {
            System.out.println("La matriz es simetrica");
        }else{
            System.out.println("La matriz no es simetrica");
        }
    }
   
}
