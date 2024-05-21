/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author maniana
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        List<Mascota> lista = null;
        TreeSet<Integer> edades = new TreeSet<>();
        int contador = 1;
        boolean lleno = false;

        // leemos las mascotas del archivo binario y las agregamos a una lista
        try (FileInputStream fis = new FileInputStream("recursos/Mascotas.dat"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            lista = (List<Mascota>) ois.readObject();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println("INFORMACION LEIDA DEL ARCHIVO BINARIO:");
        System.out.println("NUMERO DE MASCTOAS: " + lista.size());
        for (Mascota masc : lista) {
            System.out.printf("------------------\n"
                    + "MASCOTA %d.- %s\n", contador++, masc);
        }

        // de cada mascota almacenaremos su edad en un archivo binario nuevo
        try (FileOutputStream fos = new FileOutputStream("recursos/Edades.dat"); DataOutputStream dos = new DataOutputStream(fos); FileInputStream fis = new FileInputStream("recursos/Edades.dat"); DataInputStream dis = new DataInputStream(fis)) {
            for (Mascota mascota : lista) {
                dos.writeInt(mascota.getEdad());
            }
            /* una vez agregadas todas las edades, y como no es necesario mostrar
            o almacenar todas las edades, las guardaremos en un TreeSet, para no
            tener la necesidad de recorrer la coleccion para saber la edad maxima */
            try {
                while (!lleno) {
                    edades.add(dis.readInt());
                }
            } /* el bucle terminara cuando en el archivo no haya mas numeros y salte
               la excepcion
             */ catch (EOFException ex) {
                lleno = true;
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        System.out.println("INFORMACION LEIDA DEL ARCHIVO DE TEXTO:");
        System.out.printf("La maxima edad de las mascotas es: %d\n", edades.last());
    }

}
