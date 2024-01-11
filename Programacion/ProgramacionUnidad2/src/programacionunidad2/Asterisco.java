package programacionunidad2;

import java.util.Scanner;

public class Asterisco {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        char car = 0;

        // Variables de salida
        int letr = 0, mayus = 0, minus = 0, alfa = 0, nums = 0, cars = 0;

        // Variables auxiliares
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
        while (car != '*') {
            System.out.println("Ingresa un caracter: ");
            car = teclado.next().charAt(0);
            switch ((car >= 65 && car <= 90) ? 1 : (car >= 97 && car <= 122) ? 2 : (Character.isDigit(car)) ? 3 : (car != '*') ? 4 : 5) {
                case 1 -> {
                    mayus++;
                    letr++;
                    cars++;
                    alfa++;
                    break;
                }
                case 2 -> {
                    letr++;
                    minus++;
                    cars++;
                    alfa++;
                    break;
                }
                case 3 -> {
                    nums++;
                    cars++;
                    alfa++;
                    break;
                }
                case 4 -> {
                    cars++;
                    break;
                }
                default -> {
                    break;
                }
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("Caracteres: "+cars);
        System.out.println("Mayusculas: "+mayus);
        System.out.println("Minusculas: "+minus);
        System.out.println("Letras: "+letr);
        System.out.println("Numeros: "+nums);
        System.out.println("Alfanumericos: "+alfa);
        
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
