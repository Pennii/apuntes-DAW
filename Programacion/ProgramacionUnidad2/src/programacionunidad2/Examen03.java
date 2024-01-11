package programacionunidad2;
import java.util.Scanner;

public class Examen03 {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int numFilas;
        
        
        // Variables de salida
        String resultado = "";

        // Variables auxiliares
        int contador;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa el numero de filas");
        numFilas = teclado.nextInt();
        

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int i = 1; i <= numFilas; i++){
            for (int j = 0; j < numFilas-i; j++) {
                resultado+=" ";
            }
            for (int j = numFilas-i; j < numFilas; j++) {
                resultado+="*";
            }
            System.out.println(resultado);
            resultado = "";
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