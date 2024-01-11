package actividadu3m;
import java.util.Scanner;

public class AlfaNum {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        char alfa;
        
        // Variables de salida


        // Variables auxiliares


        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa tu caracter: ");
        alfa = teclado.next().charAt(0);

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        if(Character.isLetterOrDigit(alfa)){
            System.out.println("el caracter es alfanumerico");
        }else{
            System.out.println("el caracter no es alfanumerico");
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