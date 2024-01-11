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
public class EjerciciosExtra2 {
      public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
       
        
        // Variables de entrada
        
         int a = 34, b = 21;
        int c = a++ + ++b;
        int d = --a + --b + c--;
        int e = a + +b + +c + d--;
        int f = -a + b-- + -c - d++;
        int suma = a + b + c + d + e + f;
        
        // Variables de salida


        // Variables auxiliares


        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println(" ");

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(suma);
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}
