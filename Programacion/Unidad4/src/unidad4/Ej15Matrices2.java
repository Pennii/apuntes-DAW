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
public class Ej15Matrices2 {

    public static void main(String[] args) {
        int array1[] = {1, 8, 3, 1, 3, 7, 5, 2, 4, 6};
        int array2[] = {3, 4, 5, 6, 2, 5, 1, 7, 5, 5};
        int array3[];
        int suma = 0;

        if (array1.length == array2.length) {

            array3 = new int[array1.length];

            for (int i = 0; i < array3.length; i++) {
                array3[0] += array1[i];
                array3[array3.length - 1] += array2[i];
            }
            for (int i = 1; i < array3.length - 1; i++) {
                if (array1[i] >= array2[i]) {
                    array3[i] = array1[i];
                } else {
                    array3[i] = array2[i];
                }
            }

            for (int i = 0; i < array3.length; i++) {
                suma += array3[i];
            }

            System.out.printf("Array1: %s\n", Arrays.toString(array1));
            System.out.printf("Array2: %s\n", Arrays.toString(array2));
            System.out.println("resultado:");
            System.out.printf("Array3: %s\n", Arrays.toString(array3));
            System.out.printf("Suma de los elementos del array 3: %d\n", suma);
        }
    }
}
