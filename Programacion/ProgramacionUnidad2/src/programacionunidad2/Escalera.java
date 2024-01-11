package programacionunidad2;

import java.util.Scanner;

public class Escalera {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int MIN_FILAS = 1, MAX_FILAS = 10;

        // Variables de entrada
        int filas;

        // Variables de salida
        int escalon = 1;
        // Variables auxiliares
        boolean filasv;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa la cantidad de filas de la escalera");
        filas = teclado.nextInt();
        filasv = filas >= MIN_FILAS && filas <= MAX_FILAS;

        while (!filasv) {
            System.out.println("\nel numero de filas es invalido, tiene que ser entre 1 y 10");
            filas = teclado.nextInt();
            filasv = filas >= MIN_FILAS && filas <= MAX_FILAS;
        }
        
        for (int i = 1; i <= filas; i++){
         System.out.print("fila numero "+i+": ");
            for(int j = 1; j <= i; j++){
                System.out.print(escalon + " ");
                escalon++;
            }
            System.out.println();
        }
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
