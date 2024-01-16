/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Arrays;

/**
 *
 * @author maniana
 */
public class Primitiva {

    public static void main(String[] args) {
        String lista[] = {"¡Hola Mundo!",
            "primitiva050609123237",
            "La teoría de Filomeno dice…",
            "primitiva121111223344",
            "En un lugar de la Mancha, de cuyo nombre no quiero acordarme…",
            "primitiva123456789012",
            "estoEsunacosa",
            "AbuelitoDimeTu",
            "primitiva010211334549"};
        String sorteo[][] = new String[lista.length][6];
        String patron = "primitiva[0-9]{12}";
        int contador, validas = 0, fila =0, repetidos[] = new int[6];
        boolean rango;

        for (String[] sorteo1 : sorteo) {
            for (int j = 0; j < sorteo1.length; j++) {
                sorteo1[j] = "";
            }
        }
        for (int i = 0; i < lista.length; i++) {
            contador = 0;
            if (lista[i].matches(patron)) {
                System.out.printf("cadena reconocida: %s\n", lista[i]);
                for (int j = lista[i].length()-12; j < lista[i].length() ; j += 2) {
                    sorteo[fila][contador] += lista[i].charAt(j);
                    sorteo[fila][contador] += lista[i].charAt(j+1);
                    contador++;
                }
                fila++;
                validas++;
            }
        }
        System.out.printf("Se han encontrado %d listas validas\n",validas);
        validas = 0;
        for (int i = 0; i < validas; i++) {
            rango = true;
            Arrays.fill(repetidos, 0);
            for (int j = 0; j < sorteo[i].length && rango; j++) {
                rango = Integer.valueOf(sorteo[i][j])<=49 && Integer.valueOf(sorteo[i][j]) >= 1;
                for (int k = 0; k < repetidos.length && rango; k++) {
                    rango = repetidos[k] != Integer.valueOf(sorteo[i][j]);
                }
                repetidos[j] = Integer.valueOf(sorteo[i][j]);
            }
            if (rango) {
                 System.out.println(Arrays.toString(sorteo[i]));
            }
           
        }
    }
}
