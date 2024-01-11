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
public class Palindromo {

    public static void main(String[] args) {
        System.out.println("FRASES PALINDROMAS");
        Scanner teclado = new Scanner(System.in);
        String reves = "";
        String frase = "";

        boolean valida = false;
        do {
            System.out.println("Ingresa una frase");
            frase = teclado.nextLine();
            frase = frase.toLowerCase();
            frase = frase.replaceAll(" ", "");
            for (int i = 0; i < frase.length() && !valida; i++) {
                valida = frase.charAt(i) >= 'a' && frase.charAt(i) <= 'z';
            }
        } while (!valida);
        for (int i = frase.length() - 1; i >= 0; i--) {
            reves += frase.charAt(i);
        }

        if (reves.equals(frase)) {
            System.out.println("La frase es palindroma");
        }
    }
}
