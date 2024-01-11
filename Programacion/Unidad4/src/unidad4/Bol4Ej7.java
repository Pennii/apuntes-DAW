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
public class Bol4Ej7 {

    public static void main(String[] args) {
        int nums[] = {1,3,4};
        boolean asc = false, desc = false;

        System.out.printf("Tenemos esta lista de numeros:\n%s\n", Arrays.toString(nums));

        for (int i = 0; i < nums.length - 1 && (!asc || !desc); i++) {
            if (!asc) {
                asc = nums[i] < nums[i + 1];
            }
            if (!desc) {
                desc = nums[i + 1] < nums[i];
            }
        }
        if (!desc && asc) {
            System.out.println("Esta en orden ascendente");
        }else if (desc && !asc) {
            System.out.println("Esta en orden descendente");
        }else {
            System.out.println("La lista no esta ordenada");
        }
    }
}
