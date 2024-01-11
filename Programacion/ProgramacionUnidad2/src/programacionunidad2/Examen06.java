/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionunidad2;

import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Examen06 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num1, num2;
        System.out.println("Ingresa un numero:");
        num1 = teclado.nextInt();
        System.out.println("Ingresa otro: ");
        num2 = teclado.nextInt();
        System.out.println("Los numeros pares entre ellos son:");
        if (num1 > num2) {
            for (int i = num2; i <= num1; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } else if (num2 > num1) {
            for (int i = num1; i <= num2; i++) {
                if (i % 2 == 0){
                    System.out.println(i);
                }
            }
        }else{
            System.out.println("Los numeros son iguales");
        }
    }

}
