package programacionunidad2;

import java.util.Scanner;

public class BuclesAnidados01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int fila;

        // Variables de salida
        int conteo = 1;

        // Variables auxiliares
        

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa hasta que fila quieres llegar: ");
        fila = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int i = 1; i <= fila ; i++) {
            System.out.print("fila " + (i) + ": ");
            for (int j = 0; j < i; j++) {
                System.out.print((conteo++)+" ");
            }
            System.out.println("");
        }

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
