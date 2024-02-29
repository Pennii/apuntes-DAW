/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author matii
 */
public class Inmueble extends ElementoJugador implements Valorable {

    private double valor;
    private int posicion;

    public Inmueble(String nombre, String jugador, int pos, double val) {
        super(nombre, jugador);
        this.posicion = pos;
        this.valor = val;
    }

    public String toString() {
        return String.format("%s, posicion: %d, valor: %.2f", super.toString(), this.posicion, this.valor);
    }

    @Override
    public double getValor() {
        return this.valor;
    }

    @Override
    public void revalorizar() {
        this.valor *= 1.2;
    }

}
