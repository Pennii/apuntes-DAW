package programacionunidad2;

import java.util.Scanner;

public class Hora {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int hora, minuto, segundo;

        // Variables de salida
        String valido;

        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa la hora, minuto y segundo deseado");
        hora = teclado.nextInt();
        minuto = teclado.nextInt();
        segundo = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        valido = ((hora >= 0 && hora <= 23) & (minuto >= 0 && minuto <= 59) & (segundo >= 0 & segundo <= 59)) ? "valido" : "no valido";

        if (valido == "valido") {
            segundo = ++segundo;
            if (segundo > 59) {
                segundo = 0;
                minuto = ++minuto;
                if (minuto > 59) {
                    hora = ++hora;
                    minuto = 0;
                    if (hora > 23) {
                        hora = 0;
                    }
                }
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("la hora es: " + valido);
        System.out.println((valido=="valido"?"la siguiente hora es: " + hora + ":" + minuto + ":" + segundo:"no se puede decir una hora siguiente"));

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
