/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication8;

/**
 *
 * @author matii
 */
import java.util.Scanner;

public class Bol4Ej3 {

    public static void main(String[] args) {
        int num[] = new int[5], mediaPos = 0, mediaNeg = 0, ceros = 0, sumaPos = 0,
                sumaNeg = 0;
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < num.length;) {
            try {
                System.out.println("Ingresa un numero");
                num[i] = teclado.nextInt();
                if (num[i] > 0) {
                    sumaPos += num[i];
                    mediaPos++;
                } else if (num[i] < 0) {
                    sumaNeg += num[i];
                    mediaNeg++;
                } else {
                    ceros++;
                }
                i++;
            } catch (Exception e) {
                System.err.println("ERROR AL INGRESAR NUMERO ENTERO");
                teclado.nextLine();
            }
        }
        if (mediaPos > 0) {
            mediaPos = sumaPos / mediaPos;
        }
        if (mediaNeg > 0) {
            mediaNeg = sumaNeg / mediaNeg;
        }

        System.out.printf("La media de numeros positivos es: %d \n", mediaPos);
        System.out.printf("La media de numeros negativos es: %d\n", mediaNeg);
        System.out.printf("La media de ceros es: %d\n", ceros);
    }

}
