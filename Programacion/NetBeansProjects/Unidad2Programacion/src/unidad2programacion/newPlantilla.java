package unidad2programacion;
import java.util.Scanner;

public class newPlantilla {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int cant;
        
        // Variables de salida
        String ast="";

        // Variables auxiliares


        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa la cantidad de la base de la piramide ");
        cant = teclado.nextInt();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int j = 1 ; j<=cant ; j++){
            ast = ast+"*";
        }
        
        for(int i = cant; i >0 ; i--){
            System.out.println(ast.lastIndexOf(ast, i));
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