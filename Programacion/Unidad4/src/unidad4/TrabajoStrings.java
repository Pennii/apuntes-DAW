/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unidad4;

import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class TrabajoStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena;
        String cadAux;
        boolean valido;
        Scanner teclado = new Scanner(System.in);
        do {
            cadena = teclado.nextLine();
            cadAux = cadena.toLowerCase().replaceAll(" ", "");
            valido = true;
            for (int i = 0; i < cadAux.length() && valido; i++) {
                valido = cadAux.charAt(i) >= 'a' && cadAux.charAt(i) <= 'z';
            }
        } while (!valido);
        cadena = "";
        for (int i = cadAux.length() - 1; i >= 0; i--) {
            cadena += cadAux.charAt(i);
        }
        valido = cadena.equals(cadAux);
        System.out.printf("La frase %s palindromo\n",valido?"es":"no es");

    }

}
