/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

/**
 *
 * @author matii
 */
public class Bol5Ej1 {

    public static void main(String[] args) {
        int matriz[][] = new int[5][5];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = i + j;
            }
        }
        
        for (int salida[] : matriz) {
            for (int j = 0; j < salida.length; j++) {
                System.out.printf("%-2d",salida[j]);
            }
            System.out.println("");
        }
    }

}
