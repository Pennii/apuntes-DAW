/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inmutable;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class Trabajoexcep {

    public static void main(String[] args) {
         Scanner teclado = new Scanner(System.in);
        int numero;
        boolean leido;
        do {            
        System.out.println("Ingresa un numero");
        try {
            numero = teclado.nextInt();
            leido = true;
        } catch (InputMismatchException ex) {
            System.err.println("Error de caracter");
            teclado.nextLine();
            leido = false;
        }
        } while (!leido);

    }

}
