/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 *
 * @author maniana
 */
public class Sillon extends Asiento implements Ajustable {

    public static final int POS_BAJADO = 0;
    public static final int POS_SUBIDO = 1;
    public static final int PLAZAS_DEFAULT = 1;

    private int posicion;

    public Sillon(double precio, String desc, String tapiceria, String color) throws IllegalArgumentException {
        super(precio, desc, Sillon.PLAZAS_DEFAULT, tapiceria, color);

        this.posicion = Sillon.POS_BAJADO;
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
        if (this.posicion == Sillon.POS_SUBIDO) {
            throw new IllegalStateException("EL SILLON YA ESTA SUBIDO");
        }
        this.posicion = Sillon.POS_SUBIDO;
        return this.posicion;
    }

    @Override
    public int bajarPosicion() throws IllegalStateException {
        if (this.posicion == Sillon.POS_BAJADO) {
            throw new IllegalStateException("EL SILLON YA ESTA BAJADO");
        }
        this.posicion = Sillon.POS_BAJADO;
        return this.posicion;
    }

}
