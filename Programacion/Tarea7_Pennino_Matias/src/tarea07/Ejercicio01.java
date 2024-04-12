package tarea07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Variables de entrada        
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

        List<Mascota> lista = new ArrayList<>();

        // rellenamos la lista con las mascotas
        for (int i = 0; i < arrayMascotas.length; i++) {
            lista.add(arrayMascotas[i]);
        }

        System.out.println("LISTA DE MASCOTAS: ");
        for (Mascota mascota : lista) {
            System.out.println(mascota);
        }
        System.out.println("---------------------");

        //mostramos la lista ordenada segun las clases "comparator" que se han creado
        System.out.println("LISTA ORDENADA POR NOMBRE:");
        /*cada clase "comparator" implementa esa interfaz y mediante el metodo 
        compare le damos un criterio de ordenacion
         */
        Collections.sort(lista, new OrdenarNombre());
        for (Mascota mascota : lista) {
            System.out.println(mascota);
        }
        System.out.println("---------------------");

        System.out.println("LISTA ORDENADA POR EDAD:");
        Collections.sort(lista, new OrdenarEdad());
        for (Mascota mascota : lista) {
            System.out.println(mascota);
        }
        System.out.println("---------------------");

        System.out.println("LISTA ORDENADA POR NUMERO DE CARACTERISTICAS:");
        Collections.sort(lista, new OrdenarCaracteristicas());
        for (Mascota mascota : lista) {
            System.out.println(mascota);
        }
        System.out.println("---------------------");
    }
}
