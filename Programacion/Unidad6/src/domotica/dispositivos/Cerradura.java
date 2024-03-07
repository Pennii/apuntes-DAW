/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domotica.dispositivos;

/**
 *
 * @author matii
 */
public final class Cerradura extends Dispositivo implements Activable {

    private boolean estado;

    public Cerradura(String desc, int ubi, boolean estado) throws IllegalArgumentException {
        super(desc, ubi);
        this.estado = estado;
    }

    public Cerradura(String desc, int ubi) throws IllegalArgumentException {
        this(desc, ubi, false);
    }

    @Override
    public boolean getEstado() {
        return this.estado;
    }

    @Override
    public void on() {
        if (this.estado) {
            throw new IllegalStateException("CERRADURA YA ACTIVADA");
        }

        this.estado = true;
    }

    @Override
    public void off() {
        if (!this.estado) {
            throw new IllegalStateException("CERRADURA YA DESACTIVADA");
        }

        this.estado = false;
    }

    public String toString() {
        return String.format("%s estado: %s", super.toString(), this.estado);
    }

}
