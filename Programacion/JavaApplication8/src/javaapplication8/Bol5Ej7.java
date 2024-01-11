/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

/**
 *
 * @author matii
 */
public class Bol5Ej7 {
    public static void main(String[] args) {
        int matriz1[][] = new int[5][9],matriz2[][] = new int[9][5], cont = 0;
        
        System.out.println("Tenemos la siguiente tabla:");
        for (int i[] : matriz1) {
            for (int j = 0; j < i.length; j++) {
                i[j] = cont++;
                System.out.printf("%-3d",i[j]);
            }
            System.out.println("");
        }
        System.out.println("Vamos a transponerla:");
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                matriz2[i][j] = matriz1[j][i];
                System.out.printf("%-3d",matriz2[i][j]);
            }
            System.out.println("");
        }
    }
}
