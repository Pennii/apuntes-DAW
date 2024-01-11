/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividadu3m;

/**
 *
 * @author maniana
 */
import java.util.Scanner;

public class CelsiusAFarenheit {
    public static void main(String[] args){
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes

        // Variables de entrada
        double c;
        char t;
        
        // Variables de salida

        double resultado;
        // Variables auxiliares


        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("ingresa 'C' para celsius o 'F' para farenheit");
        t = teclado.nextLine().charAt(0);
        System.out.println("ingresa el valor");
        c = teclado.nextDouble();
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        if(t == 'c'|| t == 'C'){
            resultado = c * 9/5 + 32;

        }else{
            resultado = (c - 32) * 5/9;
        }
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("el valor transformado es: " + resultado);
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");  
    }
}
