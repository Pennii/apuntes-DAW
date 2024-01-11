/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Bol6Ej1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num;
        
        System.out.println("Ingresa un numero:");
        num = teclado.nextInt();
        Mostrar(num);
    }
    
    static void Mostrar(int n){
        for (int i = 0; i < n; i++) {
            System.out.println("Comando ejecutado");
        }
    }
}
