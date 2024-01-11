package programacionunidad2;

import java.util.Scanner;

public class ScornNatacion {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int MIN = 0, MAX = 50, MAX_INT = 3;
        // Variables de entrada
        int largos;

        // Variables de salida
        String estilo;
        // Variables auxiliares
        boolean largosvalidos;
        int inv = 1;
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa la cantidad de largos:");
        largos = teclado.nextInt();
        largosvalidos = largos >= MIN && largos <= MAX;

        while (!largosvalidos && inv < MAX_INT) {
            System.out.println("El numero de largos debe ser entre 0 y 50, por favor ingreselo nuevamente");
            largos = teclado.nextInt();
            largosvalidos = largos >= MIN && largos <= MAX;
            inv++;
        }

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        if (largosvalidos) {
            System.out.print("{");
            for (int i = 1; i <= largos; i++) {
                estilo = i % 4 == 1 ? "crol" : i % 4 == 2 ? "espalda" : i % 4 == 3 ? "brazada" : "espalda";
                System.out.print(estilo + " ");
            }
            System.out.println("}");
        } else {
            System.out.println("Intentos maximo alcanzados, fin del programa");
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
