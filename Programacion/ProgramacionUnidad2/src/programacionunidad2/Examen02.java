package programacionunidad2;

import java.util.Scanner;

public class Examen02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int RANGO_MIN = 2, RANGO_MAX = 10;

        // Variables de entrada
        int filas;

        // Variables de salida
        String cuadrado = "+----+\n";
        int filler = 1;

        // Variables auxiliares
        boolean valido;
        int relleno;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa el numero de filas:");

        do {
            filas = teclado.nextInt();
            if (filas >= RANGO_MIN && RANGO_MAX >= filas) {
                valido = true;
            } else {
                valido = false;
                System.out.println("El rango minimo es " + RANGO_MIN + " y el maximo " + RANGO_MAX);
            }
        } while (!valido);
        System.out.println("¿Tendra relleno? usa un 0 para contestar que este vacio "
                + "y cualquier otro numero para indicar que si tendra");
        relleno = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        if (relleno == 0) {
            for (int i = 1; i < filas; i++) {
                cuadrado += "|    |\n";
            }
            cuadrado += "+----+";
        } else {
            for (int i = 2; i < filas; i++) {
                cuadrado += "|";
                for (int j = 1; j <= 4; j++) {
                    cuadrado += filler;
                }
                filler++;
                cuadrado += "|\n";
            }
            cuadrado += "+----+";
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println(cuadrado);

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
