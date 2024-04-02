/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maniana
 */
public class Colores {

    public static void main(String[] args) {
        String[] arrayColores = {"Negro", "Blanco", "Rojo", "Verde", "Azul", "Amarillo"};
        Map<String, Integer> mapa = new HashMap();
        int num;
        int frecuencia[] = new int[arrayColores.length];

        for (String arrayColore : arrayColores) {
            mapa.put(arrayColore, 0);
        }

        List<String> nombres = new LinkedList();

        for (int i = 0; i < 10; i++) {
            num = (int) (Math.random() * arrayColores.length);
            nombres.add(arrayColores[num]);
            mapa.put(arrayColores[num], mapa.get(arrayColores[num]) + 1);
        }

        for (String nom : nombres) {
            System.out.print(nom + " ");
        }
        System.out.println("");

        System.out.println(mapa.toString());
    }
}
