/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Ejercicio4Strings {

    public static void main(String[] args) {
        String cadena1, cadena2;

        String salida = "";

        boolean alcanza1 = false, alcanza2 = false;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa dos cadenas de texto");
        cadena1 = teclado.nextLine();
        for (int i = 0; i < cadena1.length(); i++) {
            System.out.print("-");
        }
        System.out.println("");
        cadena2 = teclado.nextLine();

        for (int i = 0; !alcanza1 || !alcanza2; i++) {
            alcanza1 = i == cadena1.length();
            alcanza2 = i == cadena2.length();
            if (!alcanza1) {
                salida += cadena1.charAt(i);
            }
            if (!alcanza2) {
                salida += cadena2.charAt(i);
            }

        }

        System.out.println(salida);
    }
}
