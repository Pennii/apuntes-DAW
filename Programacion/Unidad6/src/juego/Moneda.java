/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author matii
 */
public class Moneda extends ElementoJugador implements Valorable{
    
    private double valor;

    public Moneda(String nombre, String jugador, double valor) {
        super(nombre, jugador);
        this.valor = valor;
    }
    
    public String toString(){
        return String.format("%s, valor: %.2f", super.toString(), this.valor);
    }

    @Override
    public double getValor() {
        return this.valor;
    }

    @Override
    public void revalorizar() {
        this.valor *= 1.05;
    }
}
