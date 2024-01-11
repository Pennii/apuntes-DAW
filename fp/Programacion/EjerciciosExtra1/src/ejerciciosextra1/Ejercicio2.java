/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosextra1;

import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class Ejercicio2 {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        float a, b;
        
        // Variables de salida
        float da, mb, cs, dcs;

        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Introduce el primer número: ");
        a = teclado.nextFloat();
        System.out.println("Introduce el segundo número: ");
        b = teclado.nextFloat();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        da = a * 2f;
        mb = b/2;
        cs = (a+b)*(a+b);
        dcs = (a*a + b*b)/10;

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("El doble del primer número es:" + da);
        System.out.println("La mitad del segundo número es:" + mb);
        System.out.println("El cuadrado de la suma de ambos números es:" + cs);
        System.out.println("La decima parte de la suma de los cuadrados de "
                + "ambos números es " + dcs);
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}
