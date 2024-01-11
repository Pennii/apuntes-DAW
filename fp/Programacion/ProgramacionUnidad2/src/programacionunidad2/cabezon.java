package programacionunidad2;

import java.util.Scanner;

public class cabezon {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num;

        // Variables de salida
        // Variables auxiliares
        boolean valido;
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        do {
            System.out.println("Ingresa tu numero:");
            num = teclado.nextInt();
            valido = num % 2 == 0 && num>0;
        } while (!valido);

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
