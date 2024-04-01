/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author maniana
 */
public class Vaciado {

    private List<Integer> lista;

    public Vaciado() {
        lista = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            lista.add((int) (Math.random() * 5 + 1));
        }
    }

    public void vaciar() {
        int prim = lista.get(0);
        System.out.println("EL PRIMER ELEMENTO ES: " + prim);
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next().equals(prim)) {
                it.remove();
            }
        }
        System.out.println("NUEVA LISTA: ");
        for (int num : lista) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        Vaciado vaciar1 = new Vaciado();

        for (int num : vaciar1.lista) {
            System.out.print(num + " ");
        }
        do {
            vaciar1.vaciar();
        } while (vaciar1.lista.size()!= 0);
    }
}
