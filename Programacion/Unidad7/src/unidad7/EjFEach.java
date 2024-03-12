/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad7;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author maniana
 */
public class EjFEach {

    public static void main(String[] args) {

        String nombres[] = {"german", "lalo", "julio", "roman"};

        for (String nom : nombres) {
            if (nom.equals("roman") || nom.equals("julio")) {
                System.out.println(nom);
            }
        }

        Iterator it = Arrays.asList(nombres).iterator();
        String ultimo = "";

        System.out.println(it.next());
        while (it.hasNext()) {
            ultimo = (String) it.next();
        }
        
        System.out.println(ultimo);
    }
}
