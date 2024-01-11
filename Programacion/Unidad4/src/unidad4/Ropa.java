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
 * @author maniana
 */
public class Ropa {

    public static void main(String[] args) {
        String codigo = "([MHB])([0-9]{5})([EA])([0-9]{2})";
        Pattern patron = Pattern.compile(codigo);
        String[] productos = {"H12345E15", "M00000E00", "A12345E15", "H12345E11",
            "B00011A02", "B00011A11", "h12345E15", "B1111A04", "B111111A06"};

        String tipoCliente = "", id, origen = "", control;
        int suma;
        boolean iguales = false;

        System.out.println("IDENTIFICACION POR CODIGO");
        System.out.println("--------------------------");

        System.out.printf("Se analizaran los siguientes productos:\n%s\n",
                Arrays.toString(productos));

        for (String entrada : productos) {
            suma = 0;
            Matcher valido = patron.matcher(entrada);
            if (valido.matches()) {
                switch (valido.group(1)) {
                    case "M": {
                        tipoCliente = "Mujer";
                        break;
                    }
                    case "H": {
                        tipoCliente = "Hombre";
                        break;
                    }
                    default: {
                        tipoCliente = "Bebe";
                    }
                }

                switch (valido.group(3)) {
                    case "E": {
                        origen = "Europa";
                        break;
                    }
                    default: {
                        origen = "Asia";
                    }
                }
                id = valido.group(2);

                for (int i = 0; i < id.length(); i++) {

                    suma += id.charAt(i) - '0';
                }
                control = Integer.toString(suma);
                iguales = suma == Integer.parseInt(valido.group(4));
                if (iguales) {
                    System.out.printf("%-9s: Prenda de %s. Fabricacion: %s\n",
                            entrada, tipoCliente, origen);
                } else {
                    System.out.printf("%-9s: Patron invalido\n", entrada);
                }

            } else {
                System.out.printf("%-9s: La entrada no es valida\n", entrada);
            }
        }

    }

}
