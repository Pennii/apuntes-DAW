/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author maniana
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        int[] array;
        int tam;

        try (FileInputStream file = new FileInputStream("recursos/arrayAleatorio.bin"); DataInputStream ds = new DataInputStream(file);) {
            tam = ds.readInt();
            array = new int[tam];

            for (int i = 0; i < array.length; i++) {
                array[i] = ds.readInt();
            }
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
