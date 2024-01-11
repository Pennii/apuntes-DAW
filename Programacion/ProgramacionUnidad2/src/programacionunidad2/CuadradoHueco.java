package programacionunidad2;

import java.util.Scanner;

 public class CuadradoHueco {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int base, altura;
        
        // Variables de salida


        // Variables auxiliares
        String espacios="";

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa la base de la figura ");
        base = teclado.nextInt();
        System.out.println("Ingresa la altura de la figura ");
        altura = teclado.nextInt();
        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        for(int k = 1; k <= (base - 2); k++){
            espacios+=" ";
        }
        for(int i = 1; i<= altura; i++){
            if(i==1||i==altura){
                for(int j = 1; j<= base; j++){
                    System.out.print("*");
                }
                System.out.println();
            }else {
                System.out.println("*"+espacios+"*");
            }
        }
        
        
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