/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programacionunidad2;

import java.util.Scanner;

/**
 *
 * @author Marian
 */
public class Actividad6b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Definicion Scanner entrada
        Scanner s = new Scanner(System.in);

        /*  ENUNCIADO
            ---------
            Hacer un programa compruebe si el pin introducido es "2024"
            Si lo es, que diga "PIN correcto. Entrando al sistema..." sino
            que vuelva a pedir el n�mero un total de 3 intentos. En cada 
            intento se muestra un mensaje de "Pin incorrecto.
            Por favor int�ntelo de nuevo". Esta version es parecida a la 
            Actividad 6a pero recogiendo pin como String y trabajando con 
            cadenas en vez de con enteros.
         */
        //variables entrada
        String pin;

        //variables auxiliares
        int longPin, digito;
        boolean esDigito, longValida, pinValido, pinCorrecto;

        System.out.println("ACCESO AL SISTEMA");
        System.out.println("Introduce un pin de 4 d�gitos: ");
        pin = s.nextLine();
        longPin = pin.length();
        longValida = longPin == 4;
        pinCorrecto = pin.equals("2024");

        for (int cantIntentos = 2; cantIntentos > 0; cantIntentos--) {

            esDigito = true;
            for (int i = 0; i < longPin; i++) {

                digito = pin.charAt(i);
                if (digito >= '0' && digito <= '9') {
                    esDigito = esDigito && true;

                } else {
                    esDigito = esDigito && false;
                }
            }
            pinValido = esDigito && longValida;
                   
            while (!pinValido) {
                System.out.println("PIN inv�lido. S�lo se permiten 4 d�gitos del 0 al 9: ");

                pin = s.nextLine();
                longPin = pin.length();
                longValida = longPin == 4;
                esDigito = true;
                for (int i = 0; i < longPin; i++) {

                    digito = pin.charAt(i);
                    if (digito >= '0' && digito <= '9') {
                        esDigito = esDigito && true;

                    } else {
                        esDigito = esDigito && false;
                    }
                }
                pinValido = esDigito && longValida;
                
                pinCorrecto = pin.equals("2024");
                
            }
            
            if (!pinCorrecto && pinValido) {
                System.out.println("Intentos restantes: " + cantIntentos);
                System.out.println("PIN incorrecto. Por favor vuelva a intentarlo: ");
                
                pin = s.nextLine();
                
                longPin = pin.length();
                longValida = longPin == 4;
                pinCorrecto = pin.equals("2024");
                       
            }
            if (!pinCorrecto && pinValido && cantIntentos == 0) {
                System.out.println("Se han producido tres intentos de acceso con PIN incorrecto. Sistema bloqueado.");
            }
            
        }

        esDigito = true;
        for (int i = 0; i < longPin; i++) {

            digito = pin.charAt(i);
            if (digito >= '0' && digito <= '9') {
                esDigito = esDigito && true;

            } else {
                esDigito = esDigito && false;
            }
        }
        pinValido = esDigito && longValida;

        while (!pinValido) {
            System.out.println("PIN inv�lido. S�lo se permiten 4 d�gitos del 0 al 9: ");
            pin = s.nextLine();
            longPin = pin.length();
            longValida = longPin == 4;
            esDigito = true;
            for (int i = 0; i < longPin; i++) {

                digito = pin.charAt(i);
                if (digito >= '0' && digito <= '9') {
                    esDigito = esDigito && true;

                } else {
                    esDigito = esDigito && false;
                }
            }
            pinValido = esDigito && longValida;
            
            pinCorrecto = pin.equals("2024");
        }
        if (!pinCorrecto && pinValido) {
            System.out.println("Se han producido tres intentos de acceso con PIN incorrecto. Sistema bloqueado.");
        }
        
        if (pinCorrecto) {
            System.out.println("PIN correcto. Entrando al sistema...");
        } 
    }

}
