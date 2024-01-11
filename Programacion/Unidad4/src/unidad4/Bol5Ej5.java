/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

/**
 *
 * @author matii
 */
public class Bol5Ej5 {
    public static void main(String[] args) {
        int matriz[][] = new int[7][7];
        
        System.out.println("La diagonal de la matriz sera 1, el resto de elementos "
                + "0:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    matriz[i][j] = 1;
                }else{
                    matriz[i][j] = 0;
                }
                System.out.printf("%-2d",matriz[i][j]);
            }
            System.out.println("");
        }
    }
    
}
