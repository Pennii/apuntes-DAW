package ejerciciosunidad8;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio3 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        String rutaFichero = "recursos/aleatorios1.dat";

        // Variables de salida
         int[] arrayEnteros = new int[10];
         
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ALEATORIOS EN ARCHIVO BINARIO");
        System.out.println("-----------------------------");
        System.out.println(" ");

        try (DataInputStream entrada=new DataInputStream(new FileInputStream(rutaFichero))){

            // Leemos los diez int (primeros 10 * 4 bytes)
            for (int i = 0; i < arrayEnteros.length; i++) {
                int numero = entrada.readInt();
                System.out.printf("Elemento leido: %d\n", numero);
                arrayEnteros[i] = numero;
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("Array con los datos leídos del archivo de entrada");
        System.out.println(Arrays.toString(arrayEnteros));

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
