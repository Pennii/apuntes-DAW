/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author maniana
 */
public class Romanos2 {

    public static void main(String[] args) {
        //----------------------------------------------
//          Declaración de variables 
//----------------------------------------------
// Constantes
// Variables de entrada
String texto;

// Variables de salida
String listaNumerosRomanos = "";
String listaNumeros = "";

// Variables auxiliares
String patronRomano = "(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";
Pattern patron = Pattern.compile(patronRomano);
Matcher acoplamiento;

// Clase Scanner para petición de datos de entrada
Scanner teclado = new Scanner(System.in);

//----------------------------------------------
//                Entrada de datos 
//----------------------------------------------
System.out.println("PROGRAMA PARA EXPLORAR TEXTOS CON NÚMEROS ROMANOS");
System.out.println("-------------------------------------------------");
System.out.println("Introduzca texto que puede contener números romanos (entre I y MMMCMXCIX): ");
texto = teclado.nextLine();

//----------------------------------------------
//                 Procesamiento 
//----------------------------------------------
acoplamiento = patron.matcher(texto);

while (acoplamiento.find() ) {
    if (acoplamiento.group(0).length()>0) {
        // Hemos encontrado un número romano y no es la cadena vacía. Procedemos a "descifrarlo"
        int numero= 0;

        // Decodificamos millares
        String millares = acoplamiento.group(1);
        numero += millares.length() * 1000;

        // Decodificamos centenas
        String centenas = acoplamiento.group(2);
        // Casos "CD" y "CM"
        if (centenas.length() == 2 && centenas.charAt(0) == 'C' && centenas.charAt(1) != 'C') {
            switch (centenas.charAt(1)) {
                case 'D': // "CD"
                    numero += 400;
                    break;
                case 'M': // "CM"
                    numero += 900;
                    break;
            }
        } else {  // Resto de casos: C, CC, CCC, D, DC, DCC,DCCC
            for (int i=0 ; i < centenas.length(); i++) {
                switch (centenas.charAt(i)) {
                    case 'C':
                        numero += 100;
                        break;
                    case 'D':
                        numero += 500;
                        break;
                }
            }
        }

        // Decodificamos decenas
        String decenas = acoplamiento.group(3);
        // Casos "XL" y "XC"
        if (decenas.length() == 2 && decenas.charAt(0) == 'X' && decenas.charAt(1) != 'X') {
            switch (decenas.charAt(1)) {
                case 'L': // "XL"
                    numero += 40;
                    break;
                case 'C': // "XC"
                    numero += 90;
                    break;
            }
        } else {  // Resto de casos: X, XX, XXX, L, LX, LXX, LXXX
            for (int i=0 ; i < decenas.length(); i++) {
                switch (decenas.charAt(i)) {
                    case 'X':
                        numero += 10;
                        break;
                    case 'L':
                        numero += 50;
                        break;
                }
            }
        }

        // Decodificamos unidades
        String unidades = acoplamiento.group(4);
        // Casos "IV" y "IX"
        if (unidades.length() == 2 && unidades.charAt(0) == 'I' && unidades.charAt(1) != 'I') {
            switch (unidades.charAt(1)) {
                case 'V': // "IV"
                    numero += 4;
                    break;
                case 'X': // "IX"
                    numero += 9;
                    break;
            }
        } else {  // Resto de casos: I, II, III, V, VI, VII, VIII
            for (int i=0 ; i < unidades.length(); i++) {
                switch (unidades.charAt(i)) {
                    case 'I':
                        numero += 1;
                        break;
                    case 'V':
                        numero += 5;
                        break;
                }
            }
        }

        if (listaNumeros.length()>0) { // Si no es el primer número, añadimos una coma                
            listaNumerosRomanos += ", ";
            listaNumeros += ", ";
        }

        // Añadimos el número encontrado y convertido a sus respetivas listas
        listaNumerosRomanos += acoplamiento.group(0);
        listaNumeros += numero;
    }
}

//----------------------------------------------
//              Salida de resultados 
//----------------------------------------------
System.out.println();
System.out.println("RESULTADO");
System.out.println("---------");
if (listaNumeros.length()>0) {
    System.out.printf ("La lista de números romanos encontrados es: \n%s\n", 
            listaNumerosRomanos);
    System.out.printf ("La lista de números decodificados es: \n%s\n", 
            listaNumeros);
} else {
    System.out.printf ("No se han encontrado números romanos en el texto.");
}
        
    }
}
