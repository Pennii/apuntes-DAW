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
public class Ejercicio3 {

    public static void main(String[] args) {
        int[] lista = new int[10];

        try {
            DataInputStream ds = new DataInputStream(new FileInputStream("recursos/numerosEnteros.bin"));
            for (int i = 0; i < 10; i++) {
                lista[i] = ds.readInt();
                System.out.println(lista[i]);
            }
            
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
