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
public class Examen09 {

    public static void main(String[] args) {
        int num, cant = 0;
        Scanner teclado = new Scanner(System.in);
        num = teclado.nextInt();
        if (num == 0) {
            cant++;
        } else {
            while (num != 0) {
                num /= 10;
                cant++;
            }
        }

        System.out.println("El numero tiene " + cant + " unidades");
    }
}
