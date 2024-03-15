/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fubol2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author maniana
 */
public class Equipo {

    private Set<Futbolista> jugadores;

    public Equipo() {
        this.jugadores = new TreeSet<>(Comparator.comparing(Futbolista::getNombre));
    }

    public boolean insertarJugador(Futbolista... f) {
        boolean insertados = false, repetido = false;
        Futbolista[] agr = f;
        Futbolista[] repetidos = new Futbolista[agr.length];

        for (int i = 0; i < agr.length && !repetido; i++) {
            repetidos[i] = agr[i];
            if (i > 0) {
                for (int j = 0; j < i && !repetido; j++) {
                    repetido = agr[j].equals(repetidos[i]);
                }
            }
        }

        if (!repetido) {
            for (int i = 0; i < agr.length && !insertados; i++) {
                insertados = this.jugadores.contains(agr[i]);
            }
            if (!insertados) {
                for (int i = 0; i < agr.length; i++) {
                    insertados = this.jugadores.add(agr[i]);
                }
            }
        }

        return insertados;
    }

    public boolean borrarJugador(Futbolista... f) {
        boolean borrados = true;
        Futbolista[] elm = f;
        for (int i = 0; i < elm.length && borrados; i++) {
            borrados = this.jugadores.contains(elm[i]);
        }
        if (borrados) {
            for (int i = 0; i < elm.length; i++) {
                if (this.jugadores.contains(elm[i])) {
                    this.jugadores.remove(elm[i]);
                }
            }
        }
        return borrados;
    }

    public void mostrar() {
        int contador = 1;
        for (Futbolista lista : this.jugadores) {
            System.out.printf("Jugador %d %s\n", contador++, lista.toString());
        }
    }

    public boolean contiene(Futbolista f1) {
        return this.jugadores.contains(f1);
    }
}
