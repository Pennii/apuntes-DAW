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
public class Ejercicio3Strings {
    public static void main(String[] args) {
//        String primeraCadena, segundaCadena="";
        String cadena;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingresa la cadena de caracteres para revertir");
        
//        primeraCadena = teclado.nextLine();
        cadena = teclado.nextLine();
        
//        for (int i = primeraCadena.length()-1; i >= 0; i--) {
//            segundaCadena+=primeraCadena.charAt(i);
//        }
//        System.out.println(segundaCadena);
        String reves = new StringBuilder(cadena).reverse().toString();
        System.out.println(reves);
    }
}
