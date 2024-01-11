package actividadu3m;

import java.util.Scanner;

public class ExamenU3E6 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final float DEP1 = 40, DEP2 = 20;

        // Variables de entrada
        float por;

        // Variables de salida
        float depFinal1, depFinal2;

        // Variables auxiliares
        float depTras;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("El deposito 1 tiene: " + DEP1 + " litros y el 2: " + DEP2);
        System.out.println("¿Que porcentaje del primero quieres llevar al segundo?");
        por = teclado.nextFloat();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        depTras = por * DEP1 / 100;
        System.out.println("Se trasladaran " + depTras + " litros");
        depFinal1 = DEP1 - depTras;
        depFinal2 = DEP2 + depTras;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("El primer deposito tendra: " + depFinal1 + " litros");
        System.out.println("El segundo deposito tendra: " + depFinal2 + " litros");

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
