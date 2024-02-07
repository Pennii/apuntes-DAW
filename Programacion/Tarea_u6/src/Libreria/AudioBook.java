/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @author matii
 */
public final class AudioBook extends LibroDigital implements Audible {

    /**
     * cantidad minima de voces: {@value VOCES_MIN}
     * 
     */
    public final int VOCES_MIN = 1;
    /**
     * duracion minima del libro: {@value DURACION_MIN}
     * 
     */
    public final int DURACION_MIN = 1;

    /**
     * duracion en minutos del libro.
     */
    private int duracion;
    /**
     * numero de voces del libro.
     */
    private int voces;

    /**
     * constructor de dos parametros.
     *  ademas del constructo padre inicializa la duracion y la cantidad de voces
     * @param precio
     * @param descripcion
     * @param titulo
     * @param autor
     * @param publicacion
     * @param tam
     * @param duracion
     * @param voces
     * @throws IllegalArgumentException
     */
    public AudioBook(double precio, String descripcion, String titulo, String autor, int publicacion, int tam, int duracion, int voces)
            throws IllegalArgumentException {
        super(precio, descripcion, titulo, autor, publicacion, tam);
        if (duracion < DURACION_MIN) {
            throw new IllegalArgumentException(String.format(
                    "Duracion invalida: %d", duracion));
        }

        if (voces < VOCES_MIN) {
            throw new IllegalArgumentException(String.format("cantidad"
                    + " de voces invalida: %d", voces));
        }

        this.duracion = duracion;
        this.voces = voces;
    }

    /**
     * aumenta el numero de descargas y el tamaño del libro.
     * @return numero de descargas
     */
    @Override
    public int descargar() {
        if (this.size < MAX_SIZE) {
            this.size++;
        }
        return super.descargar();
    }

    /**
     * 
     * @return todos los atributos del producto en String
     */
    @Override
    public String toString() {
        return String.format("%s duracion: %d numVoces: %d", super.toString(),
                this.duracion, this.voces);
    }

    /**
     * devuelve la duracion en minutos enteros.
     * @return duracion del audiobook
     */
    @Override
    public double getDuracion() {
        return this.duracion;
    }

    /**
     * devuelve el numero de voces.
     * @return cantidad de voces
     */
    @Override
    public int getNumVoces() {
        return this.voces;
    }

    /**
     * indica si hay mas de una voz.
     * @return si hay mas de una voz
     */
    @Override
    public boolean isCoral() {
        boolean es;
        es = this.getNumVoces() > 1;
        return es;
    }

    /**
     * indica si hay una sola voz.
     * @return si solo hay una voz
     */
    @Override
    public boolean isMonologo() {
        boolean es;
        es = this.getNumVoces() == 1;
        return es;
    }

}
