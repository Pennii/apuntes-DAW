package actividadu3m;
import java.util.Scanner;

public class ExamenU1E2 {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int num;
        
        // Variables de salida
        String cero, neg, ent, mult;

        // Variables auxiliares


        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa tu numero");
        num = teclado.nextInt();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        cero = num != 0 ? "es distinto":"es igual";
        neg = num < 0 ? "es negativo":"es positivo";
        ent = num >= 0 && num <=10 ? "esta entre ambos numeros":"no lo esta";
        mult = num % 3 == 0 && num < 20 ?"lo es":"no lo es";
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("el numero es igual a 0? "+cero);
        System.out.println("el numero es negativo? "+neg);
        System.out.println("el numero esta entre 0 y 10 incluidos? "+ent);
        System.out.println("el numero es multiplo de 3 y menor a 20? "+mult);
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}