package programacionunidad2;

import java.util.Scanner;

public class PrimoPosPrev {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num;

        // Variables de salida
        int signum, prevnum;

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
        //Primo posterior
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
        System.out.println("el siguiente numero primo es " + signum);

        //primo previo
        if (num > 2) {
            primo = false;
            prevnum = num;
            while (primo == false) {
                c = 0;
                prevnum--;
                for (int i = 1; i <= prevnum; i++) {
                    if (prevnum % i == 0) {
                        c++;
                    }
                }
                if (c == 2) {
                    primo = true;
                }
            }
            System.out.println("el anterior numero primo es " + prevnum);
        } else {
            System.out.println("Este numero no tiene primo previo");

        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
