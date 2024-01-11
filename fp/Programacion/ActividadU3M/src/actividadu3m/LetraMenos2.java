package actividadu3m;

import java.util.Scanner;

public class LetraMenos2 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        char letra;

        // Variables de salida
        char menor1=0, menor2=0, mayor1=0, mayor2=0;

        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("ingrese su letra ");
        letra = teclado.next().charAt(0);

        //----------------------------------------------
        //                 Procesamiento Y salida de datos
        //----------------------------------------------
        if ((letra >= 'c' && letra <= 'z') || (letra >= 'C' && letra <= 'Z')) {
            menor1 = (char) (letra - 1);
            menor2 = (char) (letra - 2);
            System.out.println("la letra anteriror es " +(menor1 = (char) (letra - 1)));
            System.out.println("la segunda letra anteriror es " +(menor2 = (char) (letra - 2)));
        } else {
            switch (letra) {
                case 'a', 'A' -> {
                    System.out.println("esta letra no tiene dos letras anteriores");
                }
                case 'b', 'B' -> {
                    System.out.println("la letra anteriror es" +(menor1 = (char) (letra - 1)));
                    System.out.println("esta letra solo tiene una letra anterior");
                }
                default -> {
                }

            }
        }
        if((letra>='a'&& letra<='x')||(letra>='A' && letra<='X')){
            mayor1 = (char) (letra+1);
            mayor2 = (char) (letra+2);
            System.out.println("la siguiente letra es "+ mayor1);
            System.out.println("la segunda siguiente letra es "+ mayor2);
        }else switch(letra){
            case 'y', 'Y' -> {
                mayor1 = (char) (letra+1);
                System.out.println("esta letra solo tiene una letra posterior: " + mayor1);
            }
            case 'z', 'Z' -> System.out.println("Esta letra no tiene letras posteriores");
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
