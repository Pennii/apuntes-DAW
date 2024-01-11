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
public class Ejercicio2Strings {
    public static void main(String[] args) {
        final String LETRA = "TRWAGMYFPDXBNJZSQVHLCKE";
        int dni;
        
        char letra;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingresa tu numero de dni, sin la letra");
        dni = teclado.nextInt();
        
        letra = LETRA.charAt(dni%23);
        
        System.out.printf("La letra final del dni es la siguiente: %s\n",letra);
    }
}
