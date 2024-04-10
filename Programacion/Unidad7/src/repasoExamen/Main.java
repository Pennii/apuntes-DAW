/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoExamen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author maniana
 */
public class Main {

    public static void main(String[] args) {
        // SE CREAN LAS 10 PERSONAS Y SE AGREGAN A LA LISTA
        Persona persona1 = new Persona("Julian", "M", LocalDate.of(1990, 4, 1));
        Persona persona2 = new Persona("Damian", "M", LocalDate.of(1999, 9, 12));
        Persona persona3 = new Persona("Eduardo", "M", LocalDate.of(1990, 7, 20));
        Persona persona4 = new Persona("Julieta", "F", LocalDate.of(2005, 12, 30));
        Persona persona5 = new Persona("Clara", "F", LocalDate.of(2005, 11, 10));
        Persona persona6 = new Persona("Mario", "M", LocalDate.of(1999, 10, 10));
        Persona persona7 = new Persona("German", "M", LocalDate.of(2002, 3, 15));
        Persona persona8 = new Persona("Camila", "F", LocalDate.of(2003, 1, 21));
        Persona persona9 = new Persona("Manuela", "F", LocalDate.of(2002, 4, 1));
        Persona persona10 = new Persona("Manuel", "M", LocalDate.of(1990, 4, 9));

        List<Persona> listaPersonas = new ArrayList<>();

        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);
        listaPersonas.add(persona6);
        listaPersonas.add(persona7);
        listaPersonas.add(persona8);
        listaPersonas.add(persona9);
        listaPersonas.add(persona10);

        // RECORREMOS LA LISTA DE LA MANERA EN LA QUE SE AGREGARON
        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }
        System.out.println("---------------");
        // ORDENAMOS LA LISTA POR NOMBRE Y LA MOSTRAMOS
        Collections.sort(listaPersonas, new PersonaOrdenNom());
        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }
        System.out.println("---------------");
        // ORDENAMOS LA LISTA POR FECHA DESDE LA MAS RECIENTE A LA MAS ANTIGUA
        Collections.sort(listaPersonas, new PersonaOrdenCrono());
        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }

        System.out.println("-----------");

        // CREAMOS EL CONJUNTO Y LE AGREGAMOS LAS PERSONAS DE LA LISTA
        TreeSet<Persona> conjuntoPersonas = new TreeSet<>(new PersonaOrdenCrono());

       conjuntoPersonas.addAll(listaPersonas);

        // MOSTRAMOS LA PERSONA MAS JOVEN Y MAS VIEJA
        System.out.println("La persona mas joven es: " + conjuntoPersonas.first());
        System.out.println("La persona mas vieja es: " + conjuntoPersonas.last());
        System.out.println("------------------");

        // CREAMOS UN MAPA, CREAMOS UNA KEY POR CADA VALOR DE SEXO QUE HAYA EN 
        // LAS PERSONAS Y LAS AGREGAMOS EN UNA LISTA
        Map<String, List<Persona>> mapaSexo = new HashMap<>();

        for (Persona persona : conjuntoPersonas) {
            if (!mapaSexo.containsKey(persona.getSexo())) {
                mapaSexo.put(persona.getSexo(), new LinkedList<>());
            }
            mapaSexo.get(persona.getSexo()).add(persona);
        }

        //MOSTRAMOS EL CONTENIDO DEL MAPA
        for (String sexo : mapaSexo.keySet()) {
            System.out.println("Personas con sexo " + sexo + ":");
            for (Persona persona : mapaSexo.get(sexo)) {
                System.out.println(persona);
            }
        }
        System.out.println("-----------");

        //CREAMOS UN MAPA, LAS KEYS SERAN LOS AÑOS DE NACIMIENTO Y LOS VALORES
        //LAS PERSONAS
        Map<Integer, List<Persona>> mapaYear = new TreeMap<>();

        //REORDENAMOS LA LISTA DE PERSONAS SOLO PARA VERIFICAR QUE ESTO SE HAGA BIEN
        Collections.sort(listaPersonas, new PersonaOrdenNom());

        for (Persona persona : listaPersonas) {
            if (!mapaYear.containsKey(persona.getNacimiento().getYear())) {
                mapaYear.put(persona.getNacimiento().getYear(), new LinkedList<>());
            }
            mapaYear.get(persona.getNacimiento().getYear()).add(persona);
        }
        
        //MOSTRAMOS EL CONTENIDO ORDENADO POR AÑO
        for (Map.Entry<Integer, List<Persona>> entrada : mapaYear.entrySet()) {
            System.out.println("Personas con año " + entrada.getKey() + ":");
            for (Persona persona : mapaYear.get(entrada.getKey())) {
                System.out.println(persona);
            }
        }
    }
}
