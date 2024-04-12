/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea07;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author maniana
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        final int MES_MIN = 1, MES_MAX = 12, ANIO = 2024, DIA = 1;

        Map<LocalDate, Mascota> regalos = new TreeMap<>();
        /* en el bucle ira cambiando el mes para todo el año, por cada mes que 
        pase se creara una nueva clave en el mapa
         */
        for (int i = MES_MIN; i <= MES_MAX; i++) {
            Mascota nuevaMascota;
            /*mientras el valor de "nuevaMascota" se encuentre en el mapa, el bucle
            se repetira para introducir un valor distinto
             */
            do {
                nuevaMascota = Utilidades.mascotaAleatoria();
            } while (regalos.containsValue(nuevaMascota));
            regalos.put(LocalDate.of(ANIO, i, DIA), nuevaMascota);
        }

        for (LocalDate fecha : regalos.keySet()) {
            System.out.printf("A LA FECHA: %S SE LE REGALO A: %S\n", fecha.toString(),
                    regalos.get(fecha).toString());
        }
    }
}
