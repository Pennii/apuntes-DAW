package actividadu3m;
import java.util.Scanner;

public class ExamenU1E1 {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int num1, num2;
        
        // Variables de salida


        // Variables auxiliares
        int trip, dec, cuad, mit, dobprod, sum;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa el primer numero");
        num1 = teclado.nextInt();
        System.out.println("Ingresa el segundo numero");
        num2 = teclado.nextInt();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        trip = 3 * num1;
        dec = num2 / 10;
        dobprod = num1 * num2 * 2;
        cuad = (int) Math.pow(dobprod, 2);
        sum = num1 + num2;
        mit = ((int) Math.pow(sum, 2)) / 2;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("el triple del primero es: "+trip);
        System.out.println("la decima del segundo es: "+dec);
        System.out.println("el cuadrado del doble del producto de ambos numeros es: "+cuad);
        System.out.println("la mitad del cuadrado de la suma de ambos numeros es: "+mit);
        
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}