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
public class Bol6Ej9 {


    static int[] getDivisores(int cant){
        int div[] = new int[cant], cont = 0, divisores[],pos = 0;
        boolean primo, positivo;
        for (int i = 1; i < cant; i++) {
           primo = true;
            if (cant%i==0) {
                for (int j = 2; j < i && primo; j++) {
                    if (i%j==0) {
                        primo = false;
                    }
                }
                if (primo) {
                    div[i] = i;
                }
            }
        }
        for (int i = 0; i < div.length; i++) {
            if (div[i] != 0) {
                cont++;
            }
        }
        divisores = new int[cont];
        for (int i = 0; i < cont; i++) {
            positivo = false;
            for (int j = pos; j < div.length && !positivo; j++) {
                if (i == 0 && div[j]!=0) {
                    divisores[i] = div[j];
                    positivo = true;
                    pos = j;
                }else if(div[j]!=0 && div[j]!=divisores[i-1]){
                    divisores[i] = div[j];
                    positivo = true;
                    pos = j;
                }
            }
        }
        return divisores;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num;
        System.out.println("Ingresa un numero entero");
        num = teclado.nextInt();
        System.out.print("Los divisores de este numero son:\n"+Arrays.toString(getDivisores(num)));
    }
}
