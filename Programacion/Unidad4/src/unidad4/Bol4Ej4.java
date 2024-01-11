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
public class Bol4Ej4 {

    public static void main(String[] args) {
        int nums[] = new int[10], salida[] = new int[nums.length];
        Scanner teclado = new Scanner(System.in);
       

        for (int i = 0; i < nums.length; i++) {
            nums[i] = teclado.nextInt();
        }

        System.out.println("Lista de numeros:");
        System.out.println(Arrays.toString(nums));
        for (int i = 0, j = 0, k = nums.length-1; i < nums.length; i++) {
            if (i % 2 == 0) {
                salida[i] = nums[j++];
            }else{
                salida[i] = nums[k--];
            }
        }
        
        System.out.println(Arrays.toString(salida));
    }
}
