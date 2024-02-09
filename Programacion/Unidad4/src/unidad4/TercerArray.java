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
public class TercerArray {

    public static void main(String[] args) {
        int array1[] = {1, 8, 3, 1, 3, 7, 5, 2, 4, 6};
        int array2[] = {3, 4, 5, 6, 2, 5, 1, 7, 5, 5};
        int array3[];
        int aux;
        int suma = 0;

        if (array1.length == array2.length) {
            array3 = new int[array1.length * 2];

            System.out.printf("Array 1: %s\n", Arrays.toString(array1));
            System.out.printf("Array 2: %s\n", Arrays.toString(array2));

            //primera mitad
            for (int i = 0; i < array1.length; i++) {
                aux = 0;
                if (i % 2 != 0) {
                    for (int j = 0; j <= i; j++) {
                        aux += array1[j];
                    }
                    array3[i] = aux;
                } else {
                    for (int j = 0; j <= i; j++) {
                        aux += array2[j];
                    }
                    array3[i] = aux;
                }

            }
            //segunda mitad
            for (int i = array1.length; i < array3.length; i++) {
                if (i % 2 != 0) {
                    array3[i] = array3[i - 2] * 2;
                } else {
                    array3[i] = array3[i - 2] + array3[i - 4];
                }
            }

            //suma impares
            for (int i = 0; i < array3.length; i++) {
                if (array3[i] % 2 != 0) {
                    suma += array3[i];
                }
            }

            System.out.printf("Array 3: %s\n", Arrays.toString(array3));
            System.out.printf("La suma de todos los numeros impares es: %d\n",
                    suma);
        } else {
            System.out.println("LONGITUD DE ARRAYS INVALIDA, AMBAS DEBEN SER IGUALES");
        }
    }

}
