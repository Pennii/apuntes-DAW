package programacionunidad2;

import java.util.Scanner;

public class Fecha {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int dia, mes, anio;

        // Variables de salida
        boolean dv = false, mv = true, av = true;
        // Variables auxiliares
        int diasvalidos = 0;
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa la fecha: ");
        dia = teclado.nextInt();
        mes = teclado.nextInt();
        anio = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        if (anio > 0) {
            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                System.out.println("año bisiesto");
                switch (mes) {
                    case 1, 3, 5, 7, 8, 10, 12 -> {
                        diasvalidos = 31;
                        break;
                    }
                    case 4, 6, 9, 11 -> {
                        diasvalidos = 30;
                        break;
                    }
                    case 2 -> {
                        diasvalidos = 29;
                        break;
                    }
                    default -> {
                        mv = false;
                    }
                }
            } else {
                switch (mes) {
                    case 1, 3, 5, 7, 8, 10, 12 -> {
                        diasvalidos = 31;
                        break;
                    }
                    case 4, 6, 9, 11 -> {
                        diasvalidos = 30;
                        break;
                    }
                    case 2 -> {
                        diasvalidos = 28;
                        break;
                    }
                    default -> {
                        mv = false;
                    }
                }
            }
            if (dia > 0 && dia <= diasvalidos) {
                dv = true;
            }

        } else {
            av = false;
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        if (dv && mv && av) {
            System.out.println("fecha valida");
        } else {
            System.out.println("fecha invalida");
        }

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
