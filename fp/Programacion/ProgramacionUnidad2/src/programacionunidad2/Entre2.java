package programacionunidad2;

import java.util.Scanner;

public class Entre2 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int a, b;

        // Variables de salida
        int p = 0;

        // Variables auxiliares
        boolean primo = true;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa dos numeros: ");
        a = teclado.nextInt();
        b = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        if (a < b) {
            //Inicio un ciclo for para ver los numeros entre a y b
            for (int i = (a + 1); i < b; i++) {
                //La variable booleana tiene que empezar como true por cada numero
                primo = true;
                for (int j = 2; j < i; j++) {
                    //En este ciclo j es igual a 2, ya que si fuese 1 siempre daria == 0, si algun numero menor a i 
                    //lo divide ya no es primo
                    if (i % j == 0) {
                        primo = false;
                    }
                }
                if (primo) {
                    p++;
                }
            }

        }
        if (b < a) {
            for (int i = (a - 1); i > b; i--) {
                primo = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        primo = false;

                    }
                }

                if (primo) {
                    p++;
                }
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("Hay " + p + " numeros primos entre estos dos");

        System.out.println();
        System.out.println("Fin del programa.");

    }
}
