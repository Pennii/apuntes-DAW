package programacionunidad2;

import java.util.Scanner;

public class Primos {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num;

        // Variables de salida
        int c = 0;

        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
       do{ System.out.println("Ingresa tu numero ");
        num = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                c++;
            }
        }
        if (c == 2) {
            System.out.println("Este numero es primo");
        } else {
            System.out.println("Este numero no es primo");
        }
       }while (num>0);

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
