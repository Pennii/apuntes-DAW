/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author matii
 */
public class Farmacia {

    public static void main(String[] args) {
        String pedidos[] = {"00102:715242 GELOCATIL:650:6",
            "00102:712786 ASPIRINA:20:4",
            "línea errónea",
            "0xa",
            "53756:844035 FRENADOL:500:10"};
        int cont = 0, inicio;
        Matcher valido;
        Pattern patron = Pattern.compile("([0-9]{5}):([0-9]{6}) "
                + "([A-Za-z]{1,15}):([0-9]{1,3}):([0-9]{1,4})");

        for (int i = 0; i < pedidos.length; i++) {
            valido = patron.matcher(pedidos[i]);
            if (valido.matches()) {
                cont++;
            }
        }

        StringBuilder resultado[] = new StringBuilder[cont];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = new StringBuilder("Código de farmacia: XXX Producto: YYY ZZZ de VVV gramos. Unidades pedidas: WWW");
        }

        cont = 0;
        for (int i = 0; i < pedidos.length; i++) {
            valido = patron.matcher(pedidos[i]);
            if (valido.matches()) {
                inicio = resultado[cont].indexOf("X");
                resultado[cont].replace(inicio, inicio + 3, valido.group(1));
                inicio = resultado[cont].indexOf("Y");
                resultado[cont].replace(inicio, inicio + 3, valido.group(2));
                inicio = resultado[cont].indexOf("Z");
                resultado[cont].replace(inicio, inicio + 3, valido.group(3));
                inicio = resultado[cont].indexOf("V");
                resultado[cont].replace(inicio, inicio + 3, valido.group(4));
                inicio = resultado[cont].indexOf("W");
                resultado[cont].replace(inicio, inicio + 3, valido.group(5));
                System.out.println(resultado[cont++]);
            }
        }
    }
}
