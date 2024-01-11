/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

import java.util.Arrays;

/**
 *
 * @author matii
 */
public class Bol4Ej5 {

    public static void main(String[] args) {
        int tabla1[] = {1, 3, 5, 7, 9}, tabla2[] = {2, 4, 6, 8, 10}, mezcla[] = new int[tabla1.length + tabla2.length];

        System.out.println("Tenemos dos tablas:");
        System.out.printf("La tabla 1: %s\n", Arrays.toString(tabla1));
        System.out.printf("La tabla 2: %s\n", Arrays.toString(tabla2));

        System.out.println("Ambas tablas mezcladas serian:");
        for (int i = 0, j = 0, k = 0; i < mezcla.length; i++) {
            if (j < tabla1.length && k < tabla2.length) {
                if (i % 2 == 0) {
                    mezcla[i] = tabla1[j++];
                } else {
                    mezcla[i] = tabla2[k++];
                }
            } else if (j >= tabla1.length) {
                mezcla[i] = tabla2[k++];
            } else{
                mezcla[i] = tabla1[j++];
            }
        }
        
        System.out.printf("Tabla mezclada uno por uno:\n%s\n",Arrays.toString(mezcla));
    }
}
