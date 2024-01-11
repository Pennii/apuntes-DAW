/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

import java.util.Arrays;

/**
 *
 * @author matii
 */
public class Bol5Ej4 {

    public static void main(String[] args) {
        int matriz[][] = new int[3][3], salida[][] = new int[3][3], cont = 0;

        System.out.println("Tenemos la siguiente matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                 matriz[i][j] = cont++;
                System.out.printf("%-2d", matriz[i][j]);
            }
            System.out.println("");
        }
        System.out.println("Vamos a transponerla");
        
        for (int i = 0; i < salida.length; i++) {
            for (int j = 0; j < salida[i].length; j++) {
                salida[i][j] = matriz[j][i];
                System.out.printf("%-2d",salida[i][j]);
            }
            System.out.println("");
        }
    }
}
