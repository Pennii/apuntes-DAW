/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ss;

/**
 *
 * @author matii
 */
public class ej1 {
    public static void main(String[] args) {
        int[][] mat1 = new int[2][3], mat2 = new int[2][3], resultado = new int[2][3];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                mat1[i][j] = (int)(Math.random() * 50) + 1;
                mat2[i][j] = (int)(Math.random() * 50) + 1;
                resultado[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        
        System.out.println("Matriz 1:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat1[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("Matriz 2:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat2[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("Matriz resultado:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(resultado[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
