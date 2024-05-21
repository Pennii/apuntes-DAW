/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea08;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author maniana
 */
public class Ejercicio1 {

    public static void main(String[] args) /* throws IOException*/ {
        Mascota aux;
        List<Mascota> lista = new LinkedList<>();
        String texto, mascota[];
        int contador = 1;

        /* leemos el archivo de texto, y por cada linea dividiremos su contenido
        usando los ";", de ahi podremos establecer las mascotas y agregarlas a 
        una lista
         */
        try (FileReader fr = new FileReader("recursos/Mascotas.txt"); BufferedReader br = new BufferedReader(fr)) {
            while ((texto = br.readLine()) != null) {
                mascota = texto.split(";");
                aux = new Mascota(mascota[0], Integer.parseInt(mascota[1]), mascota[2], mascota[3], mascota[4]);
                lista.add(aux);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println("NUMERO DE MASCTOAS: " + lista.size());
        for (Mascota masc : lista) {
            System.out.printf("------------------\n"
                    + "MASCOTA %d.- %s\n", contador++, masc);
        }

        /* Una vez agregadas las mascotas a la lista, la escribiremos en un archivo
        binario
         */
        try (FileOutputStream fos = new FileOutputStream("recursos/Mascotas.dat"); ObjectOutputStream oos = new ObjectOutputStream(fos) {
        }) {
            oos.writeObject(lista);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
