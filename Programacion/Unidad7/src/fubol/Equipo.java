/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package fubol;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author maniana
 */
public class Equipo {
    
    private String nombre;
    private Set<String> jugadores = new HashSet<>();
    
    public Equipo(String name){
        this.nombre = name;
    }
    
    public void agregarJugador(Fubolista jugador){
        this.jugadores.add(jugador.getNombre());
    }
    
    public void eliminarJugador(Fubolista jugador){
        this.jugadores.remove(jugador.getNombre());
    }
    
    public void mostrarJugadores(){
        for(String name : jugadores){
            System.out.println(name);
        }
    }
    
    public boolean isEnEquipo(Fubolista jugador){
        boolean resultado;
        
        resultado = this.jugadores.add(jugador.getNombre());
        
        return resultado;
    }
    
}
