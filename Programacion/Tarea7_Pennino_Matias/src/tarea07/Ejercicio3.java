/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maniana
 */
public class Ejercicio3 {
    
    public static void main(String[] args) {
        List<Mascota> lista1 = new ArrayList<>();
        List<Mascota> lista2 = new ArrayList<>();
        Map<String, List<Integer>> coincidentes = new HashMap<>();
        final int TAM = 20;
        
        /* de la misma forma que en el ejercicio 2 se introducen valores a las listas,
        verificando que sean diferentes a los ya introducidos
        */
        for (int i = 0; i < TAM; i++) {
            Mascota aux;
            
            do {
                aux = Utilidades.mascotaAleatoria();
            } while (lista1.contains(aux));
            
            lista1.add(aux);
            
            do {
                aux = Utilidades.mascotaAleatoria();
            } while (lista2.contains(aux));
            
            lista2.add(aux);
        }
        
        for (int i = 0; i < TAM; i++) {
            String nombre1, nombre2;
            nombre1 = lista1.get(i).getNombre();
            nombre2 = lista2.get(i).getNombre();
            /* se comparan los nombres de las 2 listas en la misma posicion, si
            son iguales y no se encuentran en el mapa como clave se les agrega
            */
            if ((!coincidentes.containsKey(nombre1) || !coincidentes.containsKey(nombre2)) && nombre1.equals(nombre2)) {
                coincidentes.put(nombre1, new LinkedList<>());
            }
            /* una vez agregados, cada vez que esos nombres se encuentren en la 
            misma posicion la lista del mapa se actualiza
            */
            if (nombre1.equals(nombre2)) {
                coincidentes.get(nombre1).add(i);
            }
        }
        
        System.out.println("Primera lista:");
        System.out.println(lista1.toString());
        
        System.out.println("Segunda lista:");
        System.out.println(lista2.toString());
        
        System.out.println(coincidentes);
    }
}
