/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 *
 * @author maniana
 */
public class Silla extends Asiento implements Ajustable {

    public static final int POS_MIN = 1;
    public static final int POS_MAX = 4;
    public static final int PLAZAS_DEFAULT = 1;

    private int posicion;

    public Silla(double precio, String desc, String tapiceria, String color) throws IllegalArgumentException {
        super(precio, desc, Silla.PLAZAS_DEFAULT, tapiceria, color);

        this.posicion = Silla.POS_MIN;
    }

    public int getPos(){
        return this.posicion;
    }
    
    @Override
    public String toString() {
        return String.format("%s posicion: %-2d", super.toString(), this.posicion);
    }

    @Override
    public int obtenerPosicion() {
        return this.posicion;
    }

    @Override
    public int subirPosicion() throws IllegalStateException {
        if (this.posicion == Silla.POS_MAX) {
            throw new IllegalStateException("LA SILLA YA ESTA EN SU POSICION MAXIMA");
        }
        this.posicion++;
        return this.posicion;
    }

    @Override
    public int bajarPosicion() throws IllegalStateException {
        if (this.posicion == Silla.POS_MIN) {
            throw new IllegalStateException("LA SILLA YA ESTA EN SU POSICION MINIMA");
        }
        this.posicion--;
        return this.posicion;
    }

}
