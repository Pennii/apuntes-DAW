package unidad4;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final String REEMPLAZAR_A = "4";
        final String REEMPLAZAR_a = "@";
        final String REEMPLAZAR_B = "8";
        final String REEMPLAZAR_C = "((";
        final String REEMPLAZAR_D = "))";
        final String REEMPLAZAR_E = "3";
        final String REEMPLAZAR_e = "?";
        final String REEMPLAZAR_G = "6";
        final String REEMPLAZAR_H = "#";
        final String REEMPLAZAR_I = "|";
        final String REEMPLAZAR_i = "1";
        final String REEMPLAZAR_l = "!";
        final String REEMPLAZAR_O = "0";
        final String REEMPLAZAR_o = "*";
        final String REEMPLAZAR_P = "9";
        final String REEMPLAZAR_S = "$$";
        final String REEMPLAZAR_s = "2";
        final String REEMPLAZAR_T = "7";
        final String REEMPLAZAR_t = "+";
        final String REEMPLAZAR_V = "\\/";
        final String REEMPLAZAR_Y = "&";

        // Variables de entrada
        String[] contras = {"Paella", "Vampiro", "CASANDRA", "DOdo", "GABOSVE",
            "HIPOlito", "AEGYPTOS", "ISISisis"};

        // Variables de salida
        // Variables auxiliares
        String[] ofuscada = new String[contras.length];
        char caracter;
        String cadena;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("OFUSCACION DE CONTRASEÑAS");
        System.out.println("----------------------");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int i = 0; i < contras.length; i++) {
            cadena = "";
            for (int j = 0; j < contras[i].length(); j++) {
                caracter = contras[i].charAt(j);

                switch (caracter) {
                    case 'A': {
                        cadena += REEMPLAZAR_A;
                        break;
                    }
                    case 'a': {
                        cadena += REEMPLAZAR_a;
                        break;
                    }
                    case 'B': {
                        cadena += REEMPLAZAR_B;
                        break;
                    }
                    case 'C': {
                        cadena += REEMPLAZAR_C;
                        break;
                    }
                    case 'D': {
                        cadena += REEMPLAZAR_D;
                        break;
                    }
                    case 'E': {
                        cadena += REEMPLAZAR_E;
                        break;
                    }
                    case 'e': {
                        cadena += REEMPLAZAR_e;
                        break;
                    }
                    case 'G': {
                        cadena += REEMPLAZAR_G;
                        break;
                    }
                    case 'H': {
                        cadena += REEMPLAZAR_H;
                        break;
                    }
                    case 'I': {
                        cadena += REEMPLAZAR_I;
                        break;
                    }
                    case 'i': {
                        cadena += REEMPLAZAR_i;
                        break;
                    }
                    case 'l': {
                        cadena += REEMPLAZAR_l;
                        break;
                    }
                    case 'O': {
                        cadena += REEMPLAZAR_O;
                        break;
                    }
                    case 'o': {
                        cadena += REEMPLAZAR_o;
                        break;
                    }
                    case 'P': {
                        cadena += REEMPLAZAR_P;
                        break;
                    }
                    case 'S': {
                        cadena += REEMPLAZAR_S;
                        break;
                    }
                    case 's': {
                        cadena += REEMPLAZAR_s;
                        break;
                    }
                    case 'T': {
                        cadena += REEMPLAZAR_T;
                        break;
                    }
                    case 't': {
                        cadena += REEMPLAZAR_t;
                        break;
                    }
                    case 'V': {
                        cadena += REEMPLAZAR_V;
                        break;
                    }
                    case 'Y': {
                        cadena += REEMPLAZAR_Y;
                        break;
                    }
                    default:
                        cadena += caracter;
                }
            }
            ofuscada[i] = cadena;
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        for (int i = 0; i < contras.length; i++) {
            System.out.printf("\tLa contraseña %d es: %-9s  -> %s\n", (i + 1),
                    contras[i], ofuscada[i]);
        }

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
