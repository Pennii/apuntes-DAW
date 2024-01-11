package programacionunidad2;

import java.util.Scanner;

public class PosNegs {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num = 0;

        // Variables de salida
        // Variables auxiliares
        int p = 0, t = 0, c = 0;

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
        while (num >= 0) {
            c = 0;
            System.out.println("Ingresa tu numero ");
            num = teclado.nextInt();
            if (num >= 0) {
                for (int i = 1; i <= num; i++) {
                    if (num % i == 0) {
                        c++;
                    }
                    
                }
                if (c == 2) {
                        p++;
                    }
                t++;
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("Se ingresaron " + p + " numeros primos, y " + t
                + " numeros en total");

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
