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
public class Examen08 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int NOTAS = 10;
        double nota, notaMax = 0, notaMin = 0, suma = 0;
        for (int i = 1; i <= NOTAS; i++) {
            System.out.println("Ingresa la calificacion " + i + ":");
            nota = teclado.nextDouble();
            if (suma == 0) {
                notaMax = nota;
                notaMin = nota;
            } else {
                if (nota >= notaMax) {
                    notaMax = nota;
                }
                if (nota <= notaMin) {
                    notaMin = nota;
                }
            }

            suma += nota;
        }
        System.out.println("La nota maxima es: " + notaMax);
        System.out.println("La nota minima es: " + notaMin);
        System.out.println("La media de notas es: " + (suma / NOTAS));
    }
}
