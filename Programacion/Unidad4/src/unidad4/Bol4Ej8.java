/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Bol4Ej8 {

    public static void main(String[] args) {
        int nums[] = new int[10], pos, aux;
        boolean posValida;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Por el momento tenemos la siguiente lista:");
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = i + 1;
            System.out.printf("numero %-2d: %d\n", i + 1, nums[i]);
        }
        System.out.println("Aun podemos ingresar un numero, por favor ingresa"
                + " su posicion del 1 al 10 y que numero quieres ingresar");

        do {
            pos = teclado.nextInt();
            pos--;
            posValida = pos < nums.length && pos >= 0;
            if (!posValida) {
                System.out.println("Posicion invalida, intenta otra vez");
            }
        } while (!posValida);
        System.out.println("Ya puedes elegir tu numero");

        for (int i = nums.length - 1; i > pos; i--) {
            aux = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = aux;
        }
        nums[pos] = teclado.nextInt();

        System.out.printf("La nueva lista de numeros es:\n%s\n", Arrays.toString(nums));

    }

}
