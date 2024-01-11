package programacionunidad2;

import java.util.Scanner;

public class Ejer12 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num1, num2;

        // Variables de salida
        int numIgual = 0, numDiv;

        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa el primer numero positivo:");
        num1 = teclado.nextInt();
        System.out.println("Ingresa el segundo numero del 0 al 9:");
        num2 = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        numDiv = num1;
        while (numDiv != 0) {
            if (numDiv % 10 == num2) {
                numIgual++;
            }
            numDiv /= 10;
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("El mismo numero aparece " + numIgual + " veces en el numero "+num1);

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
