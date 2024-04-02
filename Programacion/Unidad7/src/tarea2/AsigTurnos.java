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
        Map<String, LinkedList> turnosPorPersona = new HashMap();
        int cont = 0;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YY");

        for (int i = 0; i < 7; i++) {
            turnosPorFecha.put(LocalDate.of(2021, 3, i + 1), new LinkedList<String>());
        }
        for(LocalDate fechas : turnosPorFecha.keySet()){
            for (int i = 0; i < 3; i++) {
                String persona = personas[(i + cont)%personas.length];
                turnosPorFecha.get(fechas).add(persona);
                System.out.println("SE AÑADE A LA FECHA "+fechas+": "+persona);
            }
            cont++;
        }
        
//        for (int i = 0; i < 7; i++) {
//            
////            turnosPorFecha.get(LocalDate.of(2021, 3, i + 1)).add(personas[cont]);
////            System.out.println("SE AÑADE A LA FECHA " + LocalDate.of(2021, 3, i + 1).format(formato) + ": " + personas[cont]);
////            if (cont == personas.length - 1) {
////                cont = 0;
////            }
////            turnosPorFecha.get(LocalDate.of(2021, 3, i + 1)).add(personas[cont + 1]);
////            System.out.println("SE AÑADE A LA FECHA " + LocalDate.of(2021, 3, i + 1).format(formato) + ": " + personas[cont + 1]);
////            if (cont == personas.length - 2) {
////                cont = 0;
////            }
////            turnosPorFecha.get(LocalDate.of(2021, 3, i + 1)).add(personas[cont + 2]);
////            System.out.println("SE AÑADE A LA FECHA " + LocalDate.of(2021, 3, i + 1).format(formato) + ": " + personas[cont + 2]);
////            if (cont == personas.length - 3) {
////                cont = 0;
////            }
////            cont++;
//        }
        

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
