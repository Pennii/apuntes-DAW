/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author maniana
 */
public class AsigTurnos {

    public static void main(String[] args) {
        String[] personas = {"Juan", "Luisa", "Clara", "Rogelio", "Francisco"};
        Map<LocalDate, LinkedList<String>> turnosPorFecha = new TreeMap();
        Map<String, LinkedList<LocalDate>> turnosPorPersona = new HashMap();
        int cont = 0;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YY");

        for (int i = 0; i < 7; i++) {
            turnosPorFecha.put(LocalDate.of(2021, 3, i + 1), new LinkedList<>());
        }
        for (LocalDate fechas : turnosPorFecha.keySet()) {
            for (int i = 0; i < 3; i++) {
                String persona = personas[(i + cont) % personas.length];
                turnosPorFecha.get(fechas).add(persona);
                System.out.println("SE AÑADE A LA FECHA " + fechas.format(formato) + ": " + persona);
            }
            cont++;
        }

        System.out.println("---------------------");
        for (LocalDate fecha : turnosPorFecha.keySet()) {
            for (String lista : turnosPorFecha.get(fecha)) {
                if (!turnosPorPersona.containsKey(lista)) {
                    turnosPorPersona.put(lista, new LinkedList<>());
                    System.out.println("ENCONTRADO " + lista + " ASIGNANDOLE TURNO...");
                }
                turnosPorPersona.get(lista).add(fecha);
                System.out.println(lista + " ASIGNADO A " +fecha.format(formato));
            }
            System.out.println("--");
        }

        for(String persona : turnosPorPersona.keySet()){
            System.out.println(persona+": "+turnosPorPersona.get(persona));
        }
    }
}
