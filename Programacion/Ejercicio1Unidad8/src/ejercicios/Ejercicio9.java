/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author matii
 */
public class Ejercicio9 {

    public static void main(String[] args) {
        Set<Integer> listado = new HashSet<>();

        try (FileInputStream file = new FileInputStream("recursos/set.bin"); DataInputStream ds = new DataInputStream(file)) {
            while (ds.available() > 0){
                listado.add(ds.read());
            }
            for(Integer num : listado){
                System.out.println(num);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
