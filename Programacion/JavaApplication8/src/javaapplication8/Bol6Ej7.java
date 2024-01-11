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
public class Bol6Ej7 {

    static void calcular(char c, double r, double h){
        double resultado;
        switch (c){
            case 'a' ->{
                resultado = 2*Math.PI*r*h+2*Math.PI*r*r;
                System.out.printf("El area de este cilindro es: %.2f",resultado);
            }
            case 'v' ->{
                resultado = Math.PI*r*r*h;
                System.out.printf("El volumen del cilindro es: %.2f",resultado);
            }
        }
    }
    public static void main(String[] args) {
        char opcion;
        double radio, altura;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Ingresa lo que quieras calcular v (volumen)"
                + " a (area)");
        opcion = teclado.nextLine().charAt(0);
        } while (!Character.isAlphabetic(opcion));
        
        System.out.println("Ingresa el radio del cilindro");
        radio = teclado.nextDouble();
        System.out.println("Ingresa la altura");
        altura = teclado.nextDouble();
        calcular(opcion, radio, altura);
    }
}
