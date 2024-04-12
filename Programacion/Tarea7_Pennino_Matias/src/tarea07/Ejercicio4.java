/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author maniana
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        Mascota arrayMascotas[] = {new Mascota("Nica", 14, "Gato", "Hembra", "Europeo"),
            new Mascota("Nube", 8, "Perro", "Macho", "Mestizo", "Pelo largo"),
            new Mascota("Tana", 2, "Gato", "Hembra", "Americano", "Pelo corto", "Negro"),
            new Mascota("Yuli", 5, "Perro", "Macho", "Caniche", "Pelo corto", "Negro", "Blanco"),
            new Mascota("Zeus", 1, "Perro", "Macho", "Labrador", "Pelo largo", "Tricolor"),
            new Mascota("Ariel", 7, "Gato", "Macho", "Siam�s", "Pelo largo", "Pardo", "cari�oso"),
            new Mascota("Chispa", 8, "Gato", "Hembra", "Angora", "Pelo corto", "Blanco", "cazador de ratones"),
            new Mascota("Milka", 6, "Perro", "Hembra", "Boxer", "Pelo corto", "Gris"),
            new Mascota("Bola", 9, "Gato", "Macho", "Azul ruso", "Pelo corto"),
            new Mascota("Estrella", 3, "Perro", "Hembra", "Beagle", "Pelo corto", "Casta�o")};
        Map<String, Map<String, List<String>>> mapa = new TreeMap<>(new CompararTipo());

        for (int i = 0; i < arrayMascotas.length; i++) {
            String tipo = arrayMascotas[i].getTipo();
            // introducimos en el mapa cada tipo de animal como clave
            if (!mapa.containsKey(tipo)) {
                mapa.put(tipo, new TreeMap<>());
            }
            String sexo = arrayMascotas[i].getSexo();
            String nombre = arrayMascotas[i].getNombre();
            /* cada mapa por tipo de animal tendra un mapa al cual le asignaremos
            el sexo del animal como clave
             */
            if (!mapa.get(tipo).containsKey(sexo)) {
                mapa.get(tipo).put(sexo, new LinkedList<>());
            }
            // se ingresa como valor el nombre del animal
            mapa.get(tipo).get(sexo).add(nombre);
        }

        for (String tipo : mapa.keySet()) {
            for (String sexo : mapa.get(tipo).keySet()) {
                System.out.printf("NOMBRE DE LOS %sS QUE SON %sS:\n",
                        tipo.toUpperCase(), sexo.toUpperCase());
                System.out.println("----------------------");
                for (String nombre : mapa.get(tipo).get(sexo)) {
                    System.out.println(nombre);
                }
                System.out.println("");
            }
        }
    }
}
