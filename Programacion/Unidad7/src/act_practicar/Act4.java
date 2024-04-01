/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act_practicar;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maniana
 */
public class Act4 {

    public static void main(String[] args) {
        List<String> lista1 = new LinkedList<>();
        List<String> lista2 = new LinkedList<>();
        Map<String, List<Integer>> mapa = new HashMap<>();

        for (int i = 0; i < 15; i++) {
            lista1.add(Utilidades.colorAleatorio());
            lista2.add(Utilidades.colorAleatorio());
        }

        System.out.println(lista1);
        System.out.println(lista2);

        for (int i = 0; i < 15; i++) {
            if (lista1.get(i).equals(lista2.get(i))) {
                if (!mapa.containsKey(lista1.get(i))) {
                    mapa.put(lista1.get(i), new LinkedList<>());
                }
                mapa.get(lista1.get(i)).add(i);
            }
        }

        for (String color : mapa.keySet()) {
            System.out.printf("color: %s, coincidencias: %s\n", color, mapa.get(color).toString());
        }
    }
}
