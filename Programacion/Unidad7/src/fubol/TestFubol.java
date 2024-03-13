/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fubol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author maniana
 */
public class TestFubol {
    public static void main(String[] args) {
        Set<Fubolista> futbolistas = new TreeSet<>(Comparator.comparing(Fubolista :: getApodo));
        Fubolista jugador1 = new Fubolista("ricardo", 10);
        Fubolista jugador2 = new Fubolista("julian", 7);
        Fubolista jugador3 = new Fubolista("mateo", 22);
        Fubolista jugador4 = new Fubolista("barco", 15);
               
        futbolistas.add(jugador1);
        futbolistas.add(jugador2);
        futbolistas.add(jugador3);
        futbolistas.add(jugador4);
        
        System.out.println(futbolistas);
    }
}
