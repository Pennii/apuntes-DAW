/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fubol2;

import java.util.Arrays;

/**
 *
 * @author maniana
 */
public class TestEquipo {

    public static void main(String[] args) {
        Futbolista jugador1 = new Futbolista();
        Futbolista jugador2 = new Futbolista("julian alvarez", "la araña");
        Futbolista jugador3 = new Futbolista("barco", "colo");
        Futbolista jugador4 = new Futbolista("messi", "pulga");
        Futbolista jugador5 = new Futbolista("veron", "brujita");

        Futbolista[] jugadores = {jugador1, jugador2, jugador3, jugador4, jugador5};
        Futbolista[] jugadores2 = {jugador1, jugador2, jugador3, jugador5};

        Equipo equipo1 = new Equipo();
        System.out.printf("tenemos los siguientes jugadores: %s\n", Arrays.toString(jugadores));
        System.out.println(equipo1.insertarJugador(jugadores));
        System.out.printf("tenemos los siguientes jugadores: %s\n", Arrays.toString(jugadores2));
        System.out.println(equipo1.insertarJugador(jugadores2));
        equipo1.mostrar();
        
        System.out.println(equipo1.borrarJugador(jugador1));
         System.out.println(equipo1.borrarJugador(jugador1));
        equipo1.mostrar();

        if (equipo1.contiene(jugador2)) {
            System.out.println("aaa");
        }
    }

}
