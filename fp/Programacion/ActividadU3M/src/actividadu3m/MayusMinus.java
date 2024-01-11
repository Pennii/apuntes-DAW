package actividadu3m;
import java.util.Scanner;

public class MayusMinus {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        char letra;
        
        // Variables de salida


        // Variables auxiliares


        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa tu letra: ");
        letra = teclado.next().charAt(0);

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        if(letra>=97&&letra<=122){
            System.out.println("el equivalente a tu letra en mayuscula es: "+(letra=(char)(letra-32)));
            int valor = letra;
            System.out.println("su valor numerico es: "+valor);
        }else if(letra>=65&&letra<=90){
               System.out.println("el equivalente a tu letra en minuscula es: "+(letra=(char)(letra+32)));
            int valor = letra;
            System.out.println("su valor numerico es: "+valor);
        }else{
            System.out.println("Este valor no es ninguna letra");
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