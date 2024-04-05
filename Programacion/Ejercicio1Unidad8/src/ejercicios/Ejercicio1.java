/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author maniana
 */
public class Ejercicio1 {

    public static double calcularNotaFinal(double notT, double notP, double coT, double coP) {
        return (notT * coT / 100) + (notP * coP / 100);
    }

    public static String calcularNotaActa(double notaFinal, double apr, double sob, double not) {
        String resultado;

        if (notaFinal >= sob) {
            resultado = "Sobresaliente";
        } else if (notaFinal >= not) {
            resultado = "Notable";
        } else if (notaFinal >= apr) {
            resultado = "Aprobado";
        } else {
            resultado = "desaprobado";
        }

        return resultado;
    }

    public static void main(String[] args) {

        String rutaCoe = "recursos/coeficientes.txt";
        String rutaList = "recursos/listadoAlumnos.txt";

        String rutaActa = "recursos/acta.txt";

        String cadena, notaActa, nombre, dni;
        String cadenaSeparada[];
        double notaFinal, notaTeorica, notaPractica, coefTeoria = 0, coefPractica = 0,
                aprobado = 0, notable = 0, sobresaliente = 0;

        //leemos los coeficientes
        try (
                BufferedReader buffCoe = new BufferedReader(new FileReader(rutaCoe));) {
            cadena = buffCoe.readLine();

            cadenaSeparada = cadena.split(";");
            coefTeoria = Double.parseDouble(cadenaSeparada[0]);
            coefPractica = Double.parseDouble(cadenaSeparada[1]);
            aprobado = Double.parseDouble(cadenaSeparada[2]);
            notable = Double.parseDouble(cadenaSeparada[3]);
            sobresaliente = Double.parseDouble(cadenaSeparada[4]);

        } catch (IOException ex) {
            System.out.println(ex);
        }

        //abrimos los archivos con los alumnos y actas
        try (BufferedReader buffLista = new BufferedReader(new FileReader(rutaList)); PrintWriter pwActa = new PrintWriter(new FileWriter(rutaActa));) {
            pwActa.printf("%-30s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n",
                    "nombre", "dni", "nota teoria", "nota practica", "nota final",
                    "nota acta");

            while ((cadena = buffLista.readLine()) != null) {
                cadenaSeparada = cadena.split(";");

                nombre = cadenaSeparada[0];
                dni = cadenaSeparada[1];
                notaTeorica = Double.parseDouble(cadenaSeparada[2]);
                notaPractica = Double.parseDouble(cadenaSeparada[3]);
                notaFinal = calcularNotaFinal(notaTeorica, notaPractica, coefTeoria, coefPractica);
                notaActa = calcularNotaActa(notaFinal, aprobado, sobresaliente, notable);
                pwActa.printf("%-30s\t%-10s\t%-10.2f\t%-10.2f\t%-10.2f\t%-10s\n",
                        nombre, dni, notaTeorica, notaPractica, notaFinal,
                        notaActa);
            }

        } catch (IOException ex) {

        }
    }
}
