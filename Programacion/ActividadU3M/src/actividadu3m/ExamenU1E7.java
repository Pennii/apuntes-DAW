package actividadu3m;

import java.util.Scanner;

public class ExamenU1E7 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        String cadena;

        // Variables de salida
        String entre, empieza, simb, fin;

        // Variables auxiliares
        int charF, charI, charN;
        boolean tiene;
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Introduce una cadena");
        cadena = teclado.nextLine();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        tiene = cadena.length()>=3;
        charN = cadena.length()-1;
        charI = cadena.length()-2;
        charF = cadena.length()-3;
        entre = cadena.length() >= 5 && cadena.length() <= 10 ? "Esta entre 5 y "
                + "10 caracteres de largo" : "no esta entre 5 y 10 de largo";
        empieza = cadena.charAt(0) >= 'A' && cadena.charAt(0) <= 'Z'
                || cadena.charAt(0)>='a' && cadena.charAt(0)<='z'? 
                "Empieza por letra" : "no empieza por letra";
        simb = cadena.charAt(charN)=='.'||cadena.charAt(charN)==','
                ||cadena.charAt(charN)==';'?"Termina en simbolo":
                "no termina en simbolo";
        fin = tiene?cadena.charAt(charF)=='f' && cadena.charAt(charI)=='i'
                && cadena.charAt(charN)=='n'?"Termina en fin":"no termina"
                + " en fin":"no tiene 3 caracteres";

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println(entre);
        System.out.println(empieza);
        System.out.println(simb);
        System.out.println(fin);

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
