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
public class Ejercicio4 {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        float l, h;
        
        // Variables de salida
        float vol, pis;
        

        // Variables auxiliares
        float b;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Introduce el lado L: ");
        l = teclado.nextFloat();
        System.out.println("Introduce la altura: ");
        h = teclado.nextFloat();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        b = l*l;
        vol = 1/3f*b*h;
        pis = vol/2500;
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("el volumen es " + vol);
        System.out.println("equivale a "+pis+" piscinas");
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}
