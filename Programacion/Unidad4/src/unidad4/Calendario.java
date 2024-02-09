/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class Calendario {

    public static void main(String[] args) {
        LocalDate fecha;
        int calendario[][] = new int[12][7];
        int anio, diasMax;
        String dia;
        String espacio ="";
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa un año");
        anio = teclado.nextInt();
        fecha = LocalDate.of(anio, 1, 1);

        //rellenar el array
        for (int i = 0; i < calendario.length; i++) {
            fecha = LocalDate.of(anio, i + 1, 1);
            switch (fecha.getMonthValue()) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    diasMax = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    diasMax = 30;
                    break;
                default:
                    if (fecha.isLeapYear()) {
                        diasMax = 29;
                    } else {
                        diasMax = 28;
                    }
            }
            for (int j = 0; j < diasMax; j++) {
                fecha = LocalDate.of(anio, i + 1, j + 1);
                dia = fecha.getDayOfWeek().toString();
                switch (dia) {
                    case "SUNDAY":
                        calendario[i][6]++;
                        break;
                    case "MONDAY":
                        calendario[i][0]++;
                        break;
                    case "TUESDAY":
                        calendario[i][1]++;
                        break;
                    case "WEDNESDAY":
                        calendario[i][2]++;
                        break;
                    case "THURSDAY":
                        calendario[i][3]++;
                        break;
                    case "FRIDAY":
                        calendario[i][4]++;
                        break;
                    default:
                        calendario[i][5]++;
                }
            }
        }

        System.out.printf("Año %d:\n--------------\n", fecha.getYear());
        System.out.printf("%8sL M X J V S D\n",espacio);
        for (int i = 0; i < calendario.length; i++) {
            System.out.printf("Mes %2d: %d %d %d %d %d %d %d\n", i + 1,
                    calendario[i][0], calendario[i][1], calendario[i][2],
                    calendario[i][3], calendario[i][4], calendario[i][5],
                    calendario[i][6]);
        }
    }
}
