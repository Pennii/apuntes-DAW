/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

/**
 *
 * @author matii
 */
public class Bol5Ej9 {

    public static void main(String[] args) {
        int cubo[][][] = new int[9][9][9];
        
        for (int i = 0; i < cubo.length; i++) {
            System.out.printf("capa %d\n",i+1);
            for (int j = 0; j < cubo[i].length; j++) {
                for (int k = 0; k < cubo[i][j].length; k++) {
                    if (i == 0 || i == cubo.length - 1 || j == 0 || j == cubo[i].length-1
                            || k == 0 || k == cubo[i][j].length-1) {
                        cubo[i][j][k] = 1;
                    }
                    System.out.printf("%-2d",cubo[i][j][k]);
                }
                System.out.println("");
            }
            System.out.println("------------------");
        }
    }
}
