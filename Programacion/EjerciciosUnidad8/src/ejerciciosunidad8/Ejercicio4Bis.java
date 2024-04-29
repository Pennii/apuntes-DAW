

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 Programa que rellene un array de enteros de tamaño aleatorio entre 10 y 20 con números 
 aleatorios entre 0 y 9 y guarde en un archivo binario el contenido del array de int.
 A continuación, lee del archivo binario recién creado los números almacenados y 
 muestralos por pantalla.
*/

public class Ejercicio4Bis {

public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada       
        int[] arrayEnteros = new int[10+(int) (Math.random() * 11)];
        
        // Variables de salida
        String rutaFichero="recursos/aleatorios2.dat";

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ALEATORIOS EN ARCHIVO BINARIO");
        System.out.println("-----------------------------");

        for (int i = 0; i < arrayEnteros.length; i++) {
            arrayEnteros[i] = (int) (Math.random() * 10);
        }

        System.out.println("Escribiendo contenido del array en archivo \"aleatorios2.dat\"");
        System.out.println (Arrays.toString(arrayEnteros));
        System.out.println("");
        
        try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(rutaFichero))){
           
            for (int i = 0; i < arrayEnteros.length; i++) {
                salida.writeInt(arrayEnteros[i]);
            }
        } catch (FileNotFoundException ex) {
            System.out.printf ("Error: %s\n", ex.getMessage());
        } catch (IOException ex) {
            System.out.printf ("Error: %s\n", ex.getMessage());
        }

       /*
         Como en esta ocasión, no hemos almacenado el tamaño del array. No sabemos
         cuántos números enteros tenemos que leer...¿Cómo podríamos solucionar esto?
         Podemos utilizar la excepción EOFException que es lanzada por el método
         readInt() cuando alcanzamos el final del fichero.
        */
       
       System.out.println("Leemos del fichero \"aleatorios2.dat\""); 
       try (DataInputStream entrada = new DataInputStream(new FileInputStream(rutaFichero))){            
           
            boolean hayElementos = true;    
            while (hayElementos) {
                try {
                    int numero= entrada.readInt();
                    System.out.printf("%d ",numero);
                } catch (EOFException ex) {
                    hayElementos = false;
                }
            }            
        } catch (FileNotFoundException ex) {
            System.out.printf("Error: %s\n", ex.getMessage());
        } catch (IOException ex) {
            System.out.printf("Error: %s\n", ex.getMessage());
        }

    }
    
}
