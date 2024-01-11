package unidad4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio2 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int RANGO_MIN = 10, RANGO_MAX = 20;
        final Pattern ESPECIALES = Pattern.compile(".*[\\\\!|#$%&()=?*+-_{}\\[\\]:;,.<>@].*");
        final Pattern DIGITOS = Pattern.compile(".*\\d.*");
        final Pattern MAYUS = Pattern.compile(".*[A-Z].*");
        final Pattern MINUS = Pattern.compile(".*[a-z].*");
//        lo de abajo tiene que cancelar valores no especiales
        final Pattern OTROS = Pattern.compile(".*(^[\\\\!|#$%&()=?*+-_{}\\[\\]:;,.<>@A-Za-z\\d]).*");
        

        // Variables de entrada
        String[] listaPasswords = {
            "Hh0011Aa\"99",
            "/HhOoLlAa22/",
            "1234567890",
            "++LuisAntonio==2223++",
            "<Aa1!>",
            "3st0_3s_un@_pru3b@",
            "Est0_3s_0tr@_Pru3b@_+",
            "{[(P@$$w*rd)]}",
            "SuperPaSSw0rd",
            "BARRATAI:4",
            "C0LuOuP04",
            "{[(P@SSW0RD)]}",
            "[1234567890Aa^]",
            "[1234567890Aa,]", "LuisAntonio=23", "RoyoRoyo42$", "1234567Aa-", "Est0_Es_1_Pru3b@",
            "Ju@n3nriqu301!", "BarTaLleGi.4", "<C0LuOuP0#4>", "{[(P@$$w0rd)]}", "\\UnoDosTres45\\"
        };
        // Variables de salida
        boolean[] salida=new boolean[listaPasswords.length];
        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println(" ");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        for (int i = 0; i < salida.length; i++) {
            Matcher minus = MINUS.matcher(listaPasswords[i]);
            Matcher mayus = MAYUS.matcher(listaPasswords[i]);
            Matcher digitos = DIGITOS.matcher(listaPasswords[i]);
            Matcher otros = OTROS.matcher(listaPasswords[i]);
            Matcher especial = ESPECIALES.matcher(listaPasswords[i]);
            salida[i] = listaPasswords[i].length()>=RANGO_MIN && 
                    listaPasswords[i].length()<=RANGO_MAX &&
                    especial.matches() && minus.matches()
                    && mayus.matches() && !otros.matches();
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        for (int i = 0; i < salida.length; i++) {
            System.out.printf("%-23s -> %s\n",listaPasswords[i],salida[i]?"es valida":"no es valida");
        }
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
