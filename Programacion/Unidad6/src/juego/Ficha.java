/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author matii
 */
public class Ficha extends ElementoJugador implements Movible{

    private int posicion;

    public Ficha(String nombre, String jugador, int pos) {
        super(nombre, jugador);
        this.posicion = pos;
    }

    public String toString() {
        return String.format("%s, posicion: %d", super.toString(), this.posicion);
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public void avanzar(int posicion) {
        this.posicion += posicion;
    }

    @Override
    public void retroceder(int posicion) {
        this.posicion -= posicion;
    }

    
}
