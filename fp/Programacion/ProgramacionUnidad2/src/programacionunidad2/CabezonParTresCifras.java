package programacionunidad2;

import java.util.Scanner;

 public class CabezonParTresCifras {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int num;
        
        // Variables de salida


        // Variables auxiliares


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
            System.out.println("Ingresa un numero par, positivo y de 3 cifras");
            num = teclado.nextInt();
        }while (num<=0 || num<100 || num%2!=0);

        
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