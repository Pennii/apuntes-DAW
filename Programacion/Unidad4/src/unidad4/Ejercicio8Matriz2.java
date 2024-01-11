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
public class Ejercicio8Matriz2 {

    public static void main(String[] args) {
        final int LARGO = 3, ALTO = 3;
        int matriz[][] = new int[LARGO][ALTO], max = 0, min = 0,
                posMax[] = new int[2], posMin[] = new int[2];
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce los numeros a la matriz");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = teclado.nextInt();
                if (matriz[i][j] >= max) {
                    max = matriz[i][j];
                    posMax[0] = i;
                    posMax[1] = j;
                }
                if (min == 0) {
                    min = matriz[i][j];
                    posMin[0] = i;
                    posMin[1] = j;
                } else if (matriz[i][j] < min) {
                    min = matriz[i][j];
                    posMin[0] = i;
                    posMin[1] = j;
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%d ", matriz[i][j]);
            }
            System.out.println("");
        }
        System.out.printf("El numero maximo es: %d\nEl minimo es: %d\n",max,min);
        if (posMax[0] == posMin[0] ) {
            System.out.printf("Los numeros coinciden en fila: %d\n",posMax[0]+1);
        }else if (posMax[1] == posMin[1]) {
            System.out.printf("Los numeros coinciden en columna: %d\n",posMin[1]+1);
        }else{
            System.out.println("Los numeros no coinciden en fila o columna");
        }
    }
}
