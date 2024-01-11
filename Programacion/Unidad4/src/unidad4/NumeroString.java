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
public class NumeroString {
    public static void main(String[] args) {
        String texto;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingresa un numero real: ");
        texto = teclado.nextLine();
        try {
            double objetoInt = Double.valueOf(texto);
            System.out.printf("Numero obtenido %.2f\n",objetoInt);
        } catch (Exception e) {
        }
    }
}
