/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class MezclaCadenas {

    public static void main(String[] args) {
        String cadena1, cadena2;
        char cad1[], cad2[];
        int contador = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("ingresa la primera cadena");
        cadena1 = teclado.nextLine();
        System.out.println("Ingresa la segunda");
        cadena2 = teclado.nextLine();
        
        cad1 = new char[cadena1.length()];
        cad2 = new char[cadena2.length()];
        StringBuilder mezcla = new StringBuilder();
        
        cad1 = cadena1.toCharArray();
        cad2 = cadena2.toCharArray();
        
        do {
            if (contador < cadena1.length()) {
                mezcla.append(cad1[contador]);
            }
            if (contador < cadena2.length()) {
                mezcla.append(cad2[contador]);
            }
            contador++;
        } while (contador < cadena1.length() || contador < cadena2.length());
        System.out.println(mezcla);
    }
}
