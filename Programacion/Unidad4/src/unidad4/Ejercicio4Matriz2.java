/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class Ejercicio4Matriz2 {

    public static void main(String[] args) {
        String texto = "Cuenta la historia de un mago que un dia en su bosque encantado"
                + " lloro, porque a pesar de  su magia no habia podido encontrar el amor",
                borrado, salida = "", listaFin[];
        String[] textos;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa las palabras que desees eliminar del texto:");
        System.out.println(texto);
        textos = texto.toLowerCase().split(" ");
        borrado = teclado.nextLine();
        listaFin = borrado.split(" ");

        for (int i = 0; i < textos.length; i++) {
            for (int j = 0; j < listaFin.length; j++) {
                if (listaFin[j].toLowerCase().equals(textos[i])) {
                    textos[i] = "";
                }
            }
        }
        for (int i = 0; i < textos.length; i++) {
            if (!textos[i].equals("")) {
                salida += textos[i] + " ";
            }
        }
        System.out.printf("El texto final es: %s\n", salida.trim());
    }

}
