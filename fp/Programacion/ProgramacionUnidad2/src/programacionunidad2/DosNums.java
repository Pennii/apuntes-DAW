package programacionunidad2;

import java.util.Scanner;

public class DosNums {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num1, num2;

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
            System.out.println("Ingresa el primer numero");
            num1 = teclado.nextInt();
            System.out.println("Ingresa el segundo numero");
            num2 = teclado.nextInt();
            valido = num2 <= num1;
            if (!valido) {
                System.out.println("El primer numero debe ser mayor al segundo");
            }
        } while (!valido);

        System.out.println("La lista de numeros es:");
        for (int i = num2; i <= num1; i++) {
            System.out.println(i);
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
