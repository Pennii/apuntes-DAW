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
public class Ejercicio2Matriz2 {

    public static void main(String[] args) {
        int[][] matriz;
        int largo, altura;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa el largo y la altura de la matriz");
        System.out.print("Largo: ");
        largo = teclado.nextInt();
        System.out.println("");
        System.out.print("Altura: ");
        altura = teclado.nextInt();

        matriz = new int[largo][altura];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if ((i+1) % 2 == 0) {
                    matriz[i][j] += 2;
                }
                if ((j+1) % 2 == 0) {
                    matriz[i][j] += 4;
                }
                
            }
        }
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%d ",matriz[i][j]);
            }
            System.out.println("");
        }
    }

}
