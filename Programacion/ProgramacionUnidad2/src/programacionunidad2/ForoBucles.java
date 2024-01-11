package programacionunidad2;

import java.util.Scanner;

public class ForoBucles {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int filas, columnas;
        // Variables de salida
        // Variables auxiliares
        int nums = 1;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa el numero de filas");
        filas = teclado.nextInt();
        System.out.println("Ingresa el numero de columnas");
        columnas = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
//        Escrito a mano
//        System.out.println("1: 1 2 3 4 5 ");
//        System.out.println("2: 1 2 3 4 5 ");
//        System.out.println("3: 1 2 3 4 5 ");
//        System.out.println("4: 1 2 3 4 5 ");
//        System.out.println("5: 1 2 3 4 5 ");
//        ciclo for
        for (int i = 1; i <= filas; i++) {
            System.out.print(i + ": ");
            for (int j = 1; j <= columnas; j++) {
                System.out.print(nums + " ");
                nums++;
            }
            System.out.println();

        }
//        ciclo while
//        while(i<=5){
//            System.out.println(i+": 1 2 3 4 5");
//            i++;
//        }
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
