package programacionunidad2;

import java.util.Scanner;

 public class Nombre5Caract {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        String nom;
        
        // Variables de salida


        // Variables auxiliares
        int caract;
        boolean valido;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        do{
            System.out.println("Ingresa un nombre de entre 5 a 10 caracteres");
            nom = teclado.nextLine();
            caract = nom.length();
            valido = caract>=5 && caract<=10;
        }while (!valido);

        
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