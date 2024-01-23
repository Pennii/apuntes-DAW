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
public class Numeracion {

    public static void main(String[] args) {
        StringBuilder resultados = new StringBuilder();
        Scanner teclado = new Scanner(System.in);
        Pattern patron = Pattern.compile("0x[0-9a-z]+|0b[0-1]+|[a-z]{2,6}|[0-9]+");
        Matcher valido;
        String entrada, auxiliar;
        int aux, erroneos = 0;

        do {
            System.out.println("Introduce un numero:");
            entrada = teclado.nextLine().toLowerCase();
            valido = patron.matcher(entrada);
            if (valido.find() && !entrada.equals("fin") && !entrada.equals("end")) {
                if (valido.group(0).length() > 1) {
                    switch (valido.group(0).charAt(1)) {
                        case 'x':
                            auxiliar = entrada.substring(2);
                            aux = Integer.parseInt(auxiliar,16);
                            resultados.append(String.format("HEX a DEC(%s -> %d)\n", entrada, aux));
                            break;
                        case 'b':
                            auxiliar = entrada.substring(2);
                            aux = Integer.parseInt(auxiliar,2);
                            resultados.append(String.format("BIN a DEC(%s -> %d)\n", entrada, aux));
                            break;
                        default:
                            if (Character.isDigit(valido.group(0).charAt(1))) {
                                aux = Integer.parseInt(entrada);
                                resultados.append(String.format("DEC a DEC(%s -> %d)\n", entrada, aux));
                            } else {
                                switch (valido.group(0)) {
                                    case "ua":
                                        aux = 1;
                                        resultados.append(String.format("EGP a DEC(%s -> %d)\n", entrada, aux));
                                        break;
                                    case "senua":
                                        aux = 2;
                                        resultados.append(String.format("EGP a DEC(%s -> %d)\n", entrada, aux));
                                        break;
                                    case "jemet":
                                        aux = 3;
                                        resultados.append(String.format("EGP a DEC(%s -> %d)\n", entrada, aux));
                                        break;
                                    default:
                                        erroneos++;
                                }
                            }
                    }
                } else{
                    aux = Integer.decode(entrada);
                    resultados.append(String.format("DEC a DEC(%s -> %d)\n", entrada, aux));
                }
            }else{
                 erroneos++;
            }
        } while (!entrada.equals("fin") && !entrada.equals("end"));
        if (erroneos - 1 > 0) {
            resultados.append(String.format("Cantidad de numeros erroneos: %d\n", erroneos));
        }
        System.out.println(resultados);
    }
}
