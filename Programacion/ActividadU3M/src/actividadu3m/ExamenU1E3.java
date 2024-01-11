package actividadu3m;
import java.util.Scanner;

public class ExamenU1E3 {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        float cant;
        
        // Variables de salida
        float mit, cuart;

        // Variables auxiliares


        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa de cuanto combustible se dispone:");
        cant = teclado.nextFloat();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        mit = cant / 2;
        cuart = mit / 4;
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("En la primera etapa se consumiran "+mit+" litros y quedaran "+mit);
        System.out.println("En la segunda se consumiran "+cuart+" y quedaran "+(mit-cuart));
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}