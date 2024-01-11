/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author maniana
 */
public class Romanos {

    public static void main(String[] args) {
        Pattern numeros = Pattern.compile("(M{0,3})(D?C{0,3}M?D?)(L?X{0,3}C?L?)(V?I{0,3}V?X?)");
        String texto, lista = "", listaNum = "";
        Scanner teclado = new Scanner(System.in);
        texto = teclado.nextLine();
        Matcher igual = numeros.matcher(texto);

        while (igual.find()) {
            int total, miles = 0, cienes = 0, decenas = 0, unidades = 0;
            if (igual.group(1).length() > 0 || igual.group(2).length() > 0
                    || igual.group(3).length() > 0 || igual.group(4).length() > 0) {
                lista += igual.group(0)+"-";

                for (int j = 1; j <= igual.group(1).length(); j++) {
                    miles += 1000;
                }

                for (int j = 1; j <= igual.group(2).length(); j++) {
                    cienes += 100;
                }
                if (igual.group(2).contains("M")) {
                    cienes += 700;
                }
                if (igual.group(2).matches("D[C]{0,3}")) {
                    cienes += 400;
                }
                if (igual.group(2).matches("CD")) {
                    cienes += 200;
                }

                for (int j = 1; j <= igual.group(3).length(); j++) {
                    decenas += 10;
                }
                if (igual.group(3).contains("C")) {
                    decenas += 70;
                }
                if (igual.group(3).matches("L[X]{0,3}")) {
                    decenas += 40;
                }
                if (igual.group(3).matches("XL")) {
                    decenas += 20;
                }

                for (int j = 1; j <= igual.group(4).length(); j++) {
                    unidades += 1;
                }
                if (igual.group(4).contains("X")) {
                    unidades += 7;
                }
                if (igual.group(4).matches("V[I]{0,3}")) {
                    unidades += 4;
                }
                if (igual.group(4).matches("IV")) {
                    unidades += 2;
                }
                total = miles + decenas + unidades + cienes;
               texto = texto.replace(igual.group(0), Integer.toString(total));
                listaNum += Integer.toString(total)+"-";

            }
        }
        System.out.println(texto);
        lista = lista.substring(0, lista.length()-1);
        listaNum = listaNum.substring(0, listaNum.length()-1);
        System.out.printf("La lista de numeros es: %s\nLos numersos son %s\n", lista, listaNum);
    }
}
