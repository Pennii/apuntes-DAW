/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class Ejercicio1Matriz2 {

    public static void main(String[] args) {
        final int FILAS = 5, COLUMNAS = 2;
        int[][] numeros = new int[FILAS][COLUMNAS];
        int media = 0, max = 0, min = 0, distancia;

        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = teclado.nextInt();
                media += numeros[i][j];
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                if (i == 0) {
                    max = numeros[i][j];
                    min = numeros[i][j];
                } else {
                    if (numeros[i][j] >= max) {
                        max = numeros[i][j];
                    }
                    if (numeros[i][j] <= min) {
                        min = numeros[i][j];
                    }
                }
            }
        }
        distancia = max - min;
        media = media / (numeros.length * numeros[0].length);

        System.out.printf("La media de los numeros es: %d\nEl numero mayor"
                + " es %d y el menor %d, la distancia entre ellos es %d",
                media, max, min, distancia);
        System.out.println(Arrays.deepToString(numeros));
    }
}
