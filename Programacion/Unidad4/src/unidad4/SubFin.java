/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author matii
 */
public class SubFin {

    public static void main(String[] args) {
        Pattern subcadena = Pattern.compile("MAL");
        Scanner teclado = new Scanner(System.in);

        String texto;

        System.out.printf("SUBCADENA \"%s\" DE INICIO A FIN\n", subcadena);
        System.out.println("----------------------------------");
        System.out.printf("\nIngresa un texto\n");
        texto = teclado.nextLine();
        texto = texto.toUpperCase();

        Matcher valido = subcadena.matcher(texto);
        while (valido.find()) {
           
                int incio = valido.start() + 1;
                int fin = valido.end();
                System.out.printf("La subcadena \"%s\" aparece desde "
                        + "la posicion %d hasta la %d\n", subcadena, incio, fin);
            
        }

    }
}
