/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

/**
 *
 * @author matii
 */
public class Bol5Ej8 {

    public static void main(String[] args) {
        int matriz[][] = new int[8][6];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == 0 || i == matriz.length - 1 || j == 0 || j == matriz[i].length - 1) {
                    matriz[i][j] = 1;
                }
                System.out.printf("%-3d", matriz[i][j]);
            }
            System.out.println("");
        }
    }
}
