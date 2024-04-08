package ejerciciosunidad8;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


/*
   Aunque leer y escribir bytes es útil, a menudo es necesario transmitir datos de tipos primitivos dentro de un flujo. 
   Las clases DataInputStream y DataOutputStream proporcionan métodos para la lectura y escritura de tipos primitivos de 
   un modo independiente de la máquina. Así proporcionan los siguientes pares de métodos lectura/escritura:readBoolean y writeBoolean, 
   readChar y writeChar, readByte y writeByte, readShort y writeShort, readInt y writeInt, etc.
*/

public class Ejercicio2 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int[] arrayEnteros = new int[10];

        // Variables de salida
        String rutaFichero = "recursos/aleatorios1.dat";

        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ALEATORIOS EN ARCHIVO BINARIO");
        System.out.println("-----------------------------");
        System.out.println(" ");

        for (int i = 0; i < arrayEnteros.length; i++) {
            arrayEnteros[i] = (int) (Math.random() * 10);
        }

        //----------------------------------------------
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("Escribiendo contenido del array en archivo de salida");
        System.out.println (Arrays.toString(arrayEnteros));
        
        try(DataOutputStream salida = new DataOutputStream(new FileOutputStream(rutaFichero))){
            for (int i = 0; i < arrayEnteros.length; i++) {
                salida.writeInt(arrayEnteros[i]);
            }
        } catch (FileNotFoundException ex) {
            System.out.printf ("Error: %s\n", ex.getMessage());
        } catch (IOException ex) {
            System.out.printf ("Error: %s\n", ex.getMessage());
        }

        System.out.println();
        System.out.println("Fin del programa.");

    }
    
}
