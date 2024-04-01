/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act_practicar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author maniana
 */
public class Act2 {

    public static void main(String[] args) {
        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();
        Set<String> lista3 = new HashSet<>();
        List<Integer> lista4 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista1.add(Utilidades.colorAleatorio());
            lista2.add(Utilidades.colorAleatorio());
        }

        for (int i = 0; i < 10; i++) {
            if (lista1.get(i).equals(lista2.get(i))) {
                lista3.add(lista1.get(i));
                lista4.add(i);
                lista1.set(i, "---");
                lista2.set(i, "---");
            }
        }

        System.out.println(lista1);
        System.out.println(lista2);
        System.out.println(lista3);
        System.out.println(lista4);
    }
}
