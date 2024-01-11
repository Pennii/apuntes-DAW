/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inmutable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class TrabajandoLocalDate {

    public static void main(String[] args) {
//          Ejercicio 1
        LocalDate fecha = LocalDate.of(2023, 15, 1);
        System.out.println(fecha);
//        LocalDate fecha2 = LocalDate.from(fecha).plusDays(1).plusMonths(1).plusYears(1);
//        System.out.println(fecha2);
//          EJERCICIO 2
//          LocalDate fecha = LocalDate.now();
//          System.out.println("Dia del mes: "+fecha.getDayOfMonth());
//          System.out.println("Dia del año: "+fecha.getDayOfYear());
//          System.out.println("Dia de la semana: "+fecha.getDayOfWeek());
//          System.out.println("Mes en numero: "+fecha.getMonthValue());
//          System.out.println("Mes en nombre: "+fecha.getMonth());
//          System.out.println("Año: "+fecha.getYear());
//          System.out.println("¿Año bisiesto?: "+(fecha.isLeapYear() ? "SI":"NO"));
//           Ejercicio 3
//        int anio;
//        Scanner teclado = new Scanner(System.in);
//        do {
//            System.out.println("Ingresa un año");
//            anio = teclado.nextInt();
//        } while (anio < 1900 || anio > 2100);
//        System.out.println("SABADOS:");
//        System.out.println("");
//        for (int i = 1; i <= 12; i++) {
//            LocalDate fecha = LocalDate.of(anio, i, 1);
//            for (int j = 1; j < fecha.lengthOfMonth(); j++) {
//                fecha = LocalDate.of(anio, i, j);
//                if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY) {
//                    System.out.println(fecha);
//                }
//
//            }
//        }
//        System.out.println("");
//        System.out.println("DOMINGOS");
//        System.out.println("");
//        for (int i = 1; i <= 12; i++) {
//            LocalDate fecha = LocalDate.of(anio, i, 1);
//            for (int j = 1; j < fecha.lengthOfMonth(); j++) {
//                fecha = LocalDate.of(anio, i, j);
//                if (fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
//                    System.out.println(fecha);
//                }
//
//            }
//        }
//        LocalTime hora = LocalTime.of(15, 20);
//        System.out.println(hora);

//          Ejercicio 4
//        boolean domingo;
//        do {
//            System.out.println("Ingresa un año:");
//            anio = teclado.nextInt();
//        } while (anio < 1900 || anio > 2100);
//        for (int i = 1; i <= 12; i++) {
//            domingo = false;
//            LocalDate fecha = LocalDate.of(anio, i, 1);
//            for (int j = fecha.lengthOfMonth(); j > 1 && !domingo; j--) {
//                fecha = LocalDate.of(anio, i, j);
//                if (fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
//                    System.out.println(fecha);
//                    domingo = true;
//                }
//            }
//        }
//           Ejercicio 5
//        final int ANIO_MIN = 1900, ANIO_MAX = 2100;
//        int anio = 0, domingos, domingosTot = 0;
//        boolean valido;
//        Scanner teclado = new Scanner(System.in);
//        do {
//            try {
//                System.out.println("Ingresa un año valido [" + ANIO_MIN + " - " + ANIO_MAX + "]");
//                anio = teclado.nextInt();
//                valido = anio >= ANIO_MIN && ANIO_MAX >= anio;
//            } catch (InputMismatchException e) {
//                System.err.println("Error de inicializacion");
//                valido = false;
//                teclado.nextLine();
//            }
//
//        } while (!valido);
//        for (int i = 1; i <= 12; i++) {
//            domingos = 0;
//           LocalDate fecha = LocalDate.of(anio, i, 1);
//            for (int j = 1; j <= fecha.lengthOfMonth(); j++) {
//                fecha = LocalDate.of(anio, i, j);
//                if (fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
//                    domingos++;
//                }
//            }
//            System.out.println("El mes "+i+" tiene "+domingos+" domingos");
//            domingosTot += domingos;
//        }
//        System.out.println("El año tiene en total "+domingosTot+" domingos");
    }
}
