/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package churrero;

/**
 *
 * @author maniana
 */
public class Perecedero extends Producto {

    private int DiasCaducar;

    public Perecedero(String nombre, double precio, int dias) {
        super(nombre, precio);
        this.DiasCaducar = dias;
    }

    public int getDias() {
        return this.DiasCaducar;
    }

    public void setDias(int dias) {
        this.DiasCaducar = dias;
    }

    public double calcular(int cantidad) {
        double precioFinal = super.calcular(cantidad);
        switch (this.DiasCaducar) {
            case 1 -> {
                precioFinal *= 0.5;
            }
            case 2 -> {
                precioFinal *= 0.6;
            }
            case 3 -> {
                precioFinal *= 0.8;
            }
        }
        return precioFinal;
    }

    public String toString() {
        return String.format("%s, dias para caducar: %d", super.toString(),
                this.DiasCaducar);
    }
}
