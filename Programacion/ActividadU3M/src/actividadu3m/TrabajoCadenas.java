
package miprimerprograma;

import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class TrabajoCadenas {
    public static void main(String[] args){
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        String cadena = "hola mundo";
        String cadena2 = new String("hola mundo");
        String iguales;
        char primerletra = cadena.charAt(0);
        int longit = cadena.length();
        
        // Variables de salida


        // Variables auxiliares


        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println(primerletra);
        iguales = cadena.equals(cadena2)?"si":"no";
        System.out.println("son iguales? "+ iguales);
        System.out.println("son iguales? "+ (cadena.equals(cadena2)?"si":"no"));
        //su posicion en la memoria es distinta, entonces el == no los igualara
        //es por eso que se utiliza equals
        boolean si = cadena == cadena2;
        System.out.println(si);
        String patata = cadena.substring(7);
        
        System.out.println(patata);

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");  
    }
}
