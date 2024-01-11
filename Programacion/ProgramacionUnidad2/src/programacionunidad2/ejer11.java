package programacionunidad2;

import java.util.Scanner;

public class ejer11 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num;

        // Variables de salida
        int cifras = 0;
        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        do {
            System.out.println("Ingresa tu número (debe ser positivo):");

            num = teclado.nextInt();
        } while (num < 0);
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        while (num != 0) {
            cifras++;
            num /= 10;
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("tiene " + cifras + " cifras");

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
