/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maniana
 */
public class AsigTurnos {

    public static void main(String[] args) {
        String[] personas = {"Juan", "Luisa", "Clara", "Rogelio", "Francisco"};
        Map<LocalDate, LinkedList<String>> turnosPorFecha = new HashMap();
        Map<String, LinkedList> turnosPorPersona = new HashMap();
        int cont = 0;

        for (int i = 0; i < 7; i++) {
            turnosPorFecha.put(LocalDate.of(2021, 3, i + 1), new LinkedList<String>());
        }
        for (int i = 0; i < 7; i++) {
            turnosPorFecha.get(LocalDate.of(2021, 3, i + 1)).add(personas[cont]);
            System.out.println("SE AÑADE A LA FECHA " + LocalDate.of(2021, 3, i + 1) + ": " + personas[cont]);
            if (cont == personas.length - 1) {
                cont = 0;
            }
            turnosPorFecha.get(LocalDate.of(2021, 3, i + 1)).add(personas[cont + 1]);
            System.out.println("SE AÑADE A LA FECHA " + LocalDate.of(2021, 3, i + 1) + ": " + personas[cont + 1]);
            if (cont == personas.length - 2) {
                cont = 0;
            }
            turnosPorFecha.get(LocalDate.of(2021, 3, i + 1)).add(personas[cont + 2]);
            System.out.println("SE AÑADE A LA FECHA " + LocalDate.of(2021, 3, i + 1) + ": " + personas[cont + 2]);
            if (cont == personas.length - 3) {
                cont = 0;
            }
            cont++;
        }
        System.out.println(turnosPorFecha.toString());

        for (int i = 1; i < 8; i++) {
            for (String lista : turnosPorFecha.get(LocalDate.of(2021, Month.MARCH, i))) {
                if (!turnosPorPersona.containsKey(lista)) {
                    turnosPorPersona.put(lista, new LinkedList<LocalDate>());
                }
            }
        }
         for (int i = 1; i < 8; i++) {
            LocalDate fecha = LocalDate.of(2021, Month.MARCH, i);
            for (String lista : turnosPorFecha.get(fecha)) {
            turnosPorPersona.get(lista).add(fecha);
            }
         }
       
        System.out.println(turnosPorPersona.toString());
    }
}
