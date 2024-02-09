/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JuegoAdivinar;

import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class TestAdivinar {

    public static void main(String[] args) {
        JuegoAdivinar juego1;
        JuegoAdivinar juego2;
        JuegoAdivinar juego3;
        JuegoAdivinar juego4 = null;
        try {
            juego1 = new JuegoAdivinar(10, 41);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            juego2 = new JuegoAdivinar(11);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            juego3 = new JuegoAdivinar(0);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            juego4 = new JuegoAdivinar();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }       
        Scanner teclado = new Scanner(System.in);
        int num, intento;
        boolean adivinado = false;

        System.out.printf("El usuario tiene %d intentos, el numero maximo"
                + " es %d\n", juego4.getIntentosRestantes(),
                juego4.getMaxValPosible());

        while (juego4.getIntentosRestantes() > 0 && !adivinado) {
            System.out.println("Ingresa un numero para intentar adivinar");
            num = teclado.nextInt();
            intento = juego4.adivinarNumero(num);
            adivinado = intento == 0;
            if (!adivinado) {
                if (intento == 1) {
                    System.out.println("ERROR, tu numero es menor al secreto");
                } else {
                    System.out.println("ERROR, tu numero es mayor al secreto");
                }
            }
        }
        if (adivinado) {
            System.out.println("CORRECTO, has adivinado el numero secreto");
        } else {
            System.out.println("Numero de intentos maximos alcanzado");
        }
    }
}
