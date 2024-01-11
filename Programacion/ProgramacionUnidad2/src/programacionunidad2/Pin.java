package programacionunidad2;

import java.util.Scanner;

public class Pin {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int PIN = 2024;

        // Variables de entrada
        int num;

        // Variables de salida
        // Variables auxiliares
        int intento;
        boolean valido = false;

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
//        do {
//            System.out.println("Ingresa el pin:");
//            num = teclado.nextInt();
//            valido = num == PIN;
//            intento--;
//            if (num != PIN) {
//                System.out.println("PIN inconrrecto, " + intento + " intentos restantes");
//            }
//        } while (!valido && intento >= 1);
//
//        if (valido) {
//            System.out.println("pin correcto");
//        } else {
//            System.out.println("Intentos maximos alcanzados, programa bloqueado");
//        }
           
        for( intento = 2; intento >= 0 && !valido; intento--){
            
                System.out.println("ingresa el pin:");
                num = teclado.nextInt();
                valido = num == PIN;
                
                if (!valido){
                    System.out.println("PIN incorrecto, "+intento+" intentos restantes");
                }
            }
        
        if(valido){
            System.out.println("PIN correcto ingresando al sistema");
        }else {
            System.out.println("intentos maximos alcanzados programa bloqueado");
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
