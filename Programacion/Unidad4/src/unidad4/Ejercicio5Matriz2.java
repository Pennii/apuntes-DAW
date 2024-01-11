/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Ejercicio5Matriz2 {

    public static void main(String[] args) {
        final byte DERECHA = 1, IZQUIERDA = 2, SALIR = 0;

        byte[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        byte instruccion = 0, auxiliar = 0;
        boolean valido;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.printf("Tienes la siguiente lista de numeros\n%s\n"
                    + "Que deseas hacer con ellos?\n%d. rotar a la derecha  %d. rotar"
                    + " a la izquierda  %d. salir\n", Arrays.toString(numeros), DERECHA,
                    IZQUIERDA, SALIR);
            do {
                try {
                    instruccion = teclado.nextByte();
                    valido = instruccion == DERECHA || instruccion == IZQUIERDA
                            || instruccion == SALIR;
                } catch (InputMismatchException ex) {
                    System.err.println("INTRODUZCA UN NUMERO ENTERO ENTRE LAS OPCIONES");
                    valido = false;
                    teclado.nextLine();
                }
                if (!valido) {
                    System.out.println("NUMERO FUERA DE RANGO, ELIJA UNA OPCION");
                }
            } while (!valido);
            switch (instruccion) {
                case DERECHA: {
                    for (int i = numeros.length - 1; i >= 0; i--) {
                        if (i == numeros.length - 1) {
                            auxiliar = numeros[i];
                        }
                        if (i > 0) {
                            numeros[i] = numeros[i - 1];
                        } else {
                            numeros[i] = auxiliar;
                        }

                    }
                    break;
                }
                case IZQUIERDA: {
                    for (int i = 0; i < numeros.length; i++) {
                        if (i == 0) {
                            auxiliar = numeros[i];
                        }
                        if (i < numeros.length - 1) {
                            numeros[i] = numeros[i + 1];
                        } else {
                            numeros[i] = auxiliar;
                        }
                    }
                }
            }

        } while (instruccion != SALIR);

    }

}
