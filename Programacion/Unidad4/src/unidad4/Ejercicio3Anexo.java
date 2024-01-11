/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class Ejercicio3Anexo {

    public static void main(String[] args) {
        System.out.println("CALCULO DE PUNTUACIONES");
        System.out.println("-----------------------");

        final char GANA = 'X', PIERDE = 'O';

        String patron = "[XO](-[XO])*";
        String[] mano = {"a", "a-b", "X-A", "O-O-B", "X--X", "O-X-", "-X-X",
            "O-X-O-X-O", "o", "O-o", "X", "o-x-o", "x", "x-x", "O-x-X", "X-X-X",
            "x-X-X-x"};
        int[] puntos = new int[mano.length];
        boolean valido;
        int invalidas = 0, validas;

        System.out.println(Arrays.toString(mano));

        for (int i = 0; i < mano.length; i++) {
            valido = true;
            mano[i] = mano[i].toUpperCase();
            if (mano[i].matches(patron)) {
                mano[i] = mano[i].replaceAll("-", "").trim();
                for (int j = 0; j < mano[i].length() && valido; j++) {
                    if (mano[i].charAt(j) == GANA) {
                        puntos[i]++;
                    }
                }
            } else {
                puntos[i] = -1;
                valido = false;
                invalidas++;
            }
        }
        validas = mano.length - invalidas;
        System.out.println("");
        System.out.println("");
        System.out.println("Analisis de puntuaciones:");
        System.out.println("-------------------------");

        int fila = 0;
        for (int puntuacion : puntos) {
            System.out.printf("Puntuacion %d: %2d\n", ++fila, puntuacion);
        }
        System.out.printf("Puntuaciones validas: %d\nPuntuaciones invalidas"
                + ": %d\n", validas, invalidas);

    }
}
