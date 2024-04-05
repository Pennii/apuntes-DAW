/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matii
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> salida = new ArrayList<>();
        int valor;
        
        try ( 
                DataOutputStream dat = new DataOutputStream(new FileOutputStream("recursos/numerosEnteros.bin"));) {
            for (int i = 0; i < array.length; i++) {
                dat.write(array[i]);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try (
                BufferedInputStream bf = new BufferedInputStream(new FileInputStream("recursos/numerosEnteros.bin"));) {
            while ((valor = bf.read()) != -1) {
                salida.add(valor);
            }
            System.out.println(salida.toString());
        } catch (IOException ex) {

        }
    }
}
