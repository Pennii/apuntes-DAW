/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author matii
 */
public abstract class ElementoJuego {

    public static final String NOMBRE_DEFAULT = "Sin nombre";

    private String nombre;

    public ElementoJuego(String nombre) {
        if (nombre == null || nombre.equals("")) {
            this.nombre = ElementoJuego.NOMBRE_DEFAULT;
        } else {
            this.nombre = nombre;
        }
    }

    public String getJuego() {
        return this.nombre;
    }

    public String toString() {
        return String.format("juego: %s", this.nombre);
    }
}
