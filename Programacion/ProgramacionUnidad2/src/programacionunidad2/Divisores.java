package programacionunidad2;

import java.util.Scanner;

 public class Divisores {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int num;
        
        // Variables de salida


        // Variables auxiliares
        int c=0;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa tu numero ");
        num=teclado.nextInt();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for(int i=1;i<=num;i++){
            if(num%i==0){
                c++;
            }
        }

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("Este numero tiene " + c + " divisores");
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}