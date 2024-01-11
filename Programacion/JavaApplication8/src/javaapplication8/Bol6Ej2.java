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
public class Bol6Ej2 {

    public static void main(String[] args) {
        int num1, num2, num3;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresar dos numeros:");
        num1 = teclado.nextInt();
        num2 = teclado.nextInt();
        num3 = teclado.nextInt();
        mostrarMaximo(num1, num2, num3);
    }

    static void mostrarMaximo(int a, int b, int c) {
        if (a > b && a >= c) {
            System.out.println("El primer numero es mayor");
        }
        if (b > a && b >= c) {
            System.out.println("El segundo numero es mayor");
        }
        if (c > a && c >= b) {
            System.out.println("El tercer numero es mayor");
        }
        if (a == b && b == c) {
            System.out.println("Los numeros son iguales");
        }
    }
}
