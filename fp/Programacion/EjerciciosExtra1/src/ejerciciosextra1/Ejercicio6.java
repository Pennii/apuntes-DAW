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
public class Ejercicio6 {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int largos;
        float pi;
        
        // Variables de salida
        float mc, me, lt, mb;

        // Variables auxiliares
        

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Introduce la cantidad de largos");
        largos = teclado.nextInt();
        System.out.println("Introduce la cantidad de metros de la piscina");
        pi = teclado.nextFloat();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        mc = (largos/4 + (largos%4>0?1:0)) * pi;
        mb = (largos/4 + (largos%4==3?1:0)) * pi;
        me = largos/2 * pi;
        lt = (mc + me)/1000;
          
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("Recorrio " + mc + " metros en estilo crol");
        System.out.println("Recorrio " + mb + " metros en estilo brazo");
        System.out.println("Recorrio " + me + " metros en estilo espalda");
        System.out.println("Recorrio " + lt + " kilometros en total");
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}
