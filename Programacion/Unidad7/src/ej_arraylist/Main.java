/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej_arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author maniana
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> listaNum = new ArrayList<>();

        listaNum.add(22);
        listaNum.add(77);
        listaNum.add(11);

        System.out.println("Primer elemento: " + listaNum.get(0));
        System.out.println("Segundo elemento: " + listaNum.get(1));
        System.out.println("Tercer elemento: " + listaNum.get(2));
        
        System.out.println("REEMPLAZO EL TERCER NUMERO");
        listaNum.set(2, 33);
        System.out.println("Tercer elemento: " + listaNum.get(2));
        
        for (int i = 0; i < listaNum.size(); i++) {
            System.out.println(listaNum.get(i));
        }
        System.out.println("\nfor normal");
        for (int i = listaNum.size()-1; i >= 0; i--) {
            System.out.println(listaNum.get(i));
        }
        System.out.println("\nfor each");
        for (Integer integer : listaNum) {
            System.out.println(integer);
        }
        
        System.out.println("\nfor each lamba");
        listaNum.forEach((elem) -> System.out.println(elem));
        
        System.out.println("\niterador");
        Iterator it = listaNum.iterator();
        while (it.hasNext()) {            
            System.out.println(it.next());
        }
        
        System.out.println("\niterador reversa");
        ListIterator<Integer> listaIt = listaNum.listIterator(listaNum.size());
        while(listaIt.hasPrevious()){
            System.out.println(listaIt.previous());
        }
    }
}
