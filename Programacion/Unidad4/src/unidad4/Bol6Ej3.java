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
public class Bol6Ej3 {

    static int mostrarTabla(int t[][]) {
        int maximo = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (t[i][j] > maximo) {
                    maximo = t[i][j];
                }
            }
        }
        return maximo;
    }

    public static void main(String[] args) {
        int[][] tabla = new int[2][2];
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa la tabla 2 x 2:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                tabla[i][j] = teclado.nextInt();
            }
        }
        System.out.println("El numero maximo es: " + mostrarTabla(tabla));
    }
}
