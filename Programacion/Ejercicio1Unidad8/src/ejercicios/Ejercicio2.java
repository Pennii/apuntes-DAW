/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author matii
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        try (
                DataOutputStream dat = new DataOutputStream(new FileOutputStream("recursos/numerosEnteros.bin"));) {
            for (int i = 0; i < array.length; i++) {
                dat.writeInt(array[i]);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
