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
public class Bol4Ej6 {

    public static void main(String[] args) {
        int tabla1[] = {1, 2, 3, 7, 8, 9, 13, 14, 15, 19, 20, 21},
                tabla2[] = {4, 5, 6, 10, 11, 12, 16, 17, 18, 22, 23, 24}, 
                salida[] = new int[tabla1.length+tabla2.length];
        boolean lado = true;
        
        
        System.out.println("Tenemos dos tablas:");
        System.out.printf("Tabla 1: %s\n", Arrays.toString(tabla1));
        System.out.printf("Tabla 2: %s\n", Arrays.toString(tabla2));
        System.out.println("Vamos a mezclarlos de tres en tres:");
        
        
        for (int i = 0, j = 0, k = 0; i < salida.length ; i++) {
            if (j < tabla1.length && k < tabla2.length) {
                if (lado) {
                    salida[i] = tabla1[j++];
                    if (j % 3 == 0) {
                        lado = false;
                    }
                }else {
                    salida[i] = tabla2[k++];
                    if (k % 3 == 0) {
                        lado = true;
                    }
                }
            }else if (j >= tabla1.length) {
                salida[i] = tabla2[k++];
            }else if (k >= tabla2.length) {
                salida[i] = tabla1[j++];
            }
        }
        System.out.printf("Las tablas mezcladas son:\n%s\n",Arrays.toString(salida));
    }
}
