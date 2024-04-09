/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Ejercicio6 {

    public static void main(String[] args) {
        int[][] array;
        int filas, cols;
        Scanner teclado = new Scanner(System.in);

        try (FileOutputStream file = new FileOutputStream("recursos/bidimensional.bin"); DataOutputStream ds = new DataOutputStream(file);) {
            System.out.println("Introduce la cantidad de filas: ");
            filas = teclado.nextInt();
            System.out.println("Introduce las columnas: ");
            cols = teclado.nextInt();
            
            array = new int[filas][cols];
            
            ds.writeInt(filas);
            ds.writeInt(cols);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = (int)(Math.random() * 9);
                    ds.writeInt(array[i][j]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}
