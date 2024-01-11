/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividadu3m;

import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class Asignacion {
    
    public static void main(String[] args){
        
              //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int x, y;
        
        // Variables de salida


        // Variables auxiliares
        int a;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa el primer numero: ");
        x = teclado.nextInt();
        System.out.println("Ingresa el segundo numero: ");
        y = teclado.nextInt();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        a = x;
        x = y;
        y = a;

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("el primer numero ahora es " + x + " y el segundo es " + y);
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }
}
