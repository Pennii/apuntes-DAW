package programacionunidad2;

import java.util.Scanner;

 public class EjerNueve {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int num1, num2;
        
        // Variables de salida


        // Variables auxiliares
        boolean valido1, valido2;

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
        do {
            System.out.println("Ingresa el primer numero");
            num1 = teclado.nextInt();
            System.out.println("Ingresa el segundo numero");
            num2 = teclado.nextInt();
            valido1 = num2 < num1;
            valido2 = num1 < num2;
            if (!valido1 && !valido2) {
                System.out.println("Un numero debe ser mayor a otro");
            }
        } while (!valido1 && !valido2);

        if (valido1) {
            System.out.println("Los numeros entre estos dos son:");
            for (int i = num1 - 1; i > num2; i--) {
                System.out.println(i);
            }
            if (num2 == num1-1){
                System.out.println("Son numeros sucesivos, no tienen enteros entre ellos");
            }
        } else {
            System.out.println("Los numeros entre estos dos son:");
            for (int i = num2 - 1; i > num1; i--) {
                System.out.println(i);
            }
            if (num1 == num2-1){
                System.out.println("Son numeros sucesivos, no tienen enteros entre ellos");
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