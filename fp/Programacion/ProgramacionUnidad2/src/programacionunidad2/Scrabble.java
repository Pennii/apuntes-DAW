package programacionunidad2;

import java.util.Scanner;

public class Scrabble {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final byte LARGO_MIN = 5, MIN_MULTI = 1, MAX_MULTI = 3, SUM_VOC = 1, SUM_MINUS = 2,
                SUM_MAYUS = 5, REST = 1;

        // Variables de entrada
        String palabra;
        byte multi;

        // Variables de salida
        int multiplicacion;

        // Variables auxiliares
        char car;
        int suma = 0, mayusinv = 0;
        boolean mayuscula = false;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PROGRAMA DE OBTENCIÓN DE VALORES, SUMA Y MULTIPLO (SCRABBLE) ");
        System.out.println("----------------------");
        do {
            System.out.println("Ingresa la palabra de al menos 5 caracteres (solo el primer caracter puede ser mayuscula)");
            palabra = teclado.nextLine();
            for (int i = 0; i<palabra.length(); i++){
                car = palabra.charAt(i);
                mayuscula = Character.isUpperCase(car);
                if(mayuscula && i >= 1){
                    mayusinv++;
                }
            }
        } while (palabra.length() < LARGO_MIN && mayusinv>0);

        do {
            System.out.println("Introduce un numero multiplicador entre el " + MIN_MULTI+ " y el "+MAX_MULTI);
            multi = teclado.nextByte();
        } while (multi<MIN_MULTI || multi>MAX_MULTI);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int i = 0; i < palabra.length(); i++) {
            car = palabra.charAt(i);
            switch (car) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> {
                    suma += SUM_VOC;
                    break;
                }
                case 'x', 'y', 'z' -> {
                    suma += SUM_MINUS;
                    break;
                }
                case 'X' -> {
                    suma += SUM_MAYUS;
                    break;
                }
                default -> {
                    suma -= REST;
                }
            }
        }

        System.out.println("\nLa suma total es: " + suma);

        multiplicacion = suma * multi;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("La multiplicación de la suma y del multiplicador es: " + multiplicacion);

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
