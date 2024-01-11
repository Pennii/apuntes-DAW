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
public class MatricesEj12 {

    public static void main(String[] args) {
        int[][] matriz;
        int num;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa un numero para la matriz");
        num = teclado.nextInt();

        matriz = new int[num][num];
        for (int i = 0; i < num; i++) {

            for (int j = 0; j < num; j++) {
                if ((i + 1) % 2 != 0) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%d ", matriz[i][j]);
            }
            System.out.println("");
        }
    }
}
