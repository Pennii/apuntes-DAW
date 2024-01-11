/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Ejercicio6Matriz2 {

    public static void main(String[] args) {
        int[][] matriz;
        int orden;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa el orden de la matriz");
        orden = teclado.nextInt();

        matriz = new int[orden][orden];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == j || matriz.length - 1 - i == j) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf("%d ", matriz[i][j]);
            }
            System.out.println("");
        }
    }

}
