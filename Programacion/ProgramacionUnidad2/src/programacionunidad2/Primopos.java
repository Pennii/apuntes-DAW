package programacionunidad2;

import java.util.Scanner;

public class Primopos {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num;

        // Variables de salida
        int signum;

        // Variables auxiliares
        boolean primo = false;
        int c;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa tu numero: ");
        num = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        signum = num;

        while (primo == false) {
            c = 0;
            signum++;
            for (int i = 1; i <= signum; i++) {
                if (signum % i == 0) {
                    c++;
                }
            }
            if (c == 2) {
                primo = true;
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("el siguiente numero primo es " + signum);

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
