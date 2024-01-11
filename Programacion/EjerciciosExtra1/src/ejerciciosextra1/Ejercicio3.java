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
public class Ejercicio3 {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        double metro;
        
        // Variables de salida
        double d, c, m, pi, pu, y;

        // Variables auxiliares


        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Introduzca la longitud en metros ");
        metro = teclado.nextDouble();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        d = metro*10;
        c = metro*100;
        m = metro*1000;
        
        pu = c/2.54;
        pi = pu/12;
        y = pi/3;
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println (d+" decimetros");
        System.out.println (c+" centimetros");
        System.out.println (m+" milimetros");
        System.out.println (pu+" pulgadas");
        System.out.println (pi+" pies");
        System.out.println (y + " yardas");
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}
