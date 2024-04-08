/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act_practicar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author maniana
 */
public class Fechas {

    public static void main(String[] args) {
        Set<LocalDate> fec1 = new HashSet<>();
        Set<LocalDate> fec2 = new HashSet<>();
        Set<LocalDate> fec3 = new HashSet<>();
        Set<LocalDate> fec4 = new HashSet<>();
        Set<LocalDate> fec5 = new HashSet<>();
        DayOfWeek dia;
        int num;
        LocalDate fecAux, fecAux2;

        for (int i = 0; i < 10; i++) {
            do {
                num = (int) (Math.random() * 31 + 1);
            } while (!fec1.add(LocalDate.of(2020, Month.MARCH, num)));
            do {
                num = (int) (Math.random() * 31 + 1);
            } while (!fec2.add(LocalDate.of(2020, Month.MARCH, num)));
        }

        Iterator<LocalDate> it = fec1.iterator();
        Iterator<LocalDate> it2 = fec2.iterator();

        while (it.hasNext()) {
            fecAux = it.next();
            fecAux2 = it2.next();
            if (!fec2.contains(fecAux)) {
                fec3.add(fecAux);
            }
            dia = fecAux.getDayOfWeek();
            if (dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY && fec2.contains(fecAux)) {
                fec4.add(fecAux);
            }
            if (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY) {
                fec5.add(fecAux);
            }
            dia = fecAux2.getDayOfWeek();
            if (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY) {
                fec5.add(fecAux2);
            }
        }
        System.out.println("fechas 1");
        for (LocalDate fechas : fec1) {
            System.out.println(fechas);
        }
        System.out.println("fechas 2");
        for (LocalDate fechas : fec2) {
            System.out.println(fechas);
        }
        System.out.println("fechas del primero que no estan en el segundo");
        for (LocalDate fechas : fec3) {
            System.out.println(fechas);
        }
        System.out.println("fechas conjuntas de semana:");
        for (LocalDate fechas : fec4) {
            System.out.println(fechas);
        }
        System.out.println("fechas de ambos conjuntos en fin de semana: ");
        for (LocalDate fechas : fec5) {
            System.out.println(fechas);
        }
    }
}
