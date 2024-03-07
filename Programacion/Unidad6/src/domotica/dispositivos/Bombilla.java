/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domotica.dispositivos;

/**
 *
 * @author matii
 */
public class Bombilla extends Dispositivo implements Activable, Regulable {

    public static final int MIN_INTENSIDAD = 0;
    public static final int MAX_INTENSIDAD = 10;

    private int intensidad;
    private int veces;

    public Bombilla(String desc, int ubi) throws IllegalArgumentException {
        super(desc, ubi);
        this.intensidad = MIN_INTENSIDAD;
    }

    public int getVecesManip() {
        return this.veces;
    }

    @Override
    public boolean getEstado() {
        boolean estado = false;
        if (this.intensidad != MIN_INTENSIDAD) {
            estado = true;
        }
        return estado;
    }

    @Override
    public void on() {
        if (this.getEstado()) {
            throw new IllegalStateException();
        }
        this.intensidad = MAX_INTENSIDAD;
        this.veces++;
    }

    @Override
    public void off() {
        if (!this.getEstado()) {
            throw new IllegalStateException();
        }
        this.intensidad = MIN_INTENSIDAD;
        this.veces++;
    }

    @Override
    public int getIntensidad() {
        return this.intensidad;
    }

    @Override
    public int up() {
        if (this.intensidad < MAX_INTENSIDAD) {
            this.intensidad++;
            this.veces++;
        }
        return this.intensidad;
    }

    @Override
    public int down() {
        if (this.intensidad > MIN_INTENSIDAD) {
            this.intensidad--;
            this.veces++;
        }
        return this.intensidad;
    }

    public String toString() {
        return String.format("%s estado: %s intensidad: %d Veces manipulada: %d",
                super.toString(), this.getEstado() ? "encendido" : "apagado", this.intensidad,
                this.veces);
    }
}
