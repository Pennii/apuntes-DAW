package programacionunidad2;

import java.util.Scanner;

public class Examen01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int RANGO_MIN = 0, RANGO_MAX = 50, INTENTO_MAX = 3;

        // Variables de entrada
        int largos;

        // Variables de salida
        String estilos = "{ ";

        // Variables auxiliares
        boolean valido;
        int intentos = 1;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa la cantidad de largos realizados (tienes 3 intentos):");
        do {
            largos = teclado.nextInt();
            if (largos >= RANGO_MIN && largos <= RANGO_MAX) {
                valido = true;
            } else {
                valido = false;
                System.out.println("El rango de largos es de 0 a 50");
                intentos++;
            }
        } while (!valido && intentos <= INTENTO_MAX);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        if (valido) {
            for (int i = 1; i <= largos; i++) {
                switch (i % 4) {
                    case 1 -> estilos += "crol, ";
                    case 2, 0 -> estilos += "espalda, ";
                    default -> estilos += "brazada, ";
                }
            }
            estilos = estilos.substring(0, estilos.length()-2);
            estilos += " }";
            System.out.println(estilos);
        } else {
            System.out.println("Numero de intentos maximos alcanzado");
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------       
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
