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
public class Ejercicio4 {

    public static void main(String[] args) {
        int num, lista[];
        try (FileOutputStream file = new FileOutputStream("recursos/arrayAleatorio.bin"); DataOutputStream ds = new DataOutputStream(file);) {
            num = (int) (Math.random() * 21 + 10);
            lista = new int[num];

            ds.writeInt(num);
            for (int i = 0; i < lista.length; i++) {
                lista[i] = (int) (Math.random() * 9);
                ds.writeInt(lista[i]);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
