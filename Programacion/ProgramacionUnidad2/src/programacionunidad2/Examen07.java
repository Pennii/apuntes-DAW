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
public class Examen07 {
    public static void main(String[] args) {
        int num, cant = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Ingresa un numero, si quieres finalizar "
                    + "el proceso ingresa un 0");
            num = teclado.nextInt();
            if (num % 10 == 2) {
                cant++;
            }
        } while (num!=0);
        System.out.println("La cantidad de numeros que finalizan con un 2 es: "+cant);
    }
}
