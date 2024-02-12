/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Arrays;

/**
 *
 * @author maniana
 */
public class Ej14Matrices2 {

    public static void main(String[] args) {
        int array1[] = {1, 8, 3, 1, 3, 7, 5, 2, 4, 6};
        int array2[] = {3, 4, 5, 6, 2, 5, 1, 7, 5, 5};
        int array3[];
        int max, min;

        if (array1.length == array2.length) {
            array3 = new int[array1.length];

            max = array1[0];
            min = array1[0];

            for (int i = 0; i < array1.length; i++) {
                if (array1[i] >= array2[i] && array1[i] >= max) {
                    max = array1[i];
                } else if (array2[i] >= max) {
                    max = array2[i];
                } else if (array1[i] <= array2[i] && array1[i] <= min) {
                    min = array1[i];
                } else if (array2[i] <= min) {
                    min = array2[i];
                }
            }

            array3[0] = min;
            array3[array3.length - 1] = max;

            max = array1[0];
            for (int i = 1; i < array3.length - 1; i++) {
                array3[i] = array1[i] + array2[i];
                if (array3[i] >= max) {
                    max = array3[i];
                }
            }

            System.out.printf("Array 1: %s\n", Arrays.toString(array1));
            System.out.printf("Array 2: %s\n", Arrays.toString(array2));
            System.out.println("resultado:");
            System.out.printf("Array 3: %s\n", Arrays.toString(array3));
            System.out.printf("el numero maximo del array 3 es: %d\n", max);
        } else {
            System.out.println("LOS ARRAYS NO TIENEN LA LONGITUD CORRECTA");
        }
    }
}
