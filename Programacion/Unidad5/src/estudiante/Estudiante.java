/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiante;

/**
 *
 * @author maniana
 */
public class Estudiante {

    private final String nombre;
    private double notaMedia;
    private int numNotas;

    /**
     * Inicializa a un estudiante utilizando los paramteros
     *
     * @param nombre nombre del estudiante
     * @param notaMedia nota media del estudiante
     * @param numNotas numero de notas del estudiante
     * @throws IllegalArgumentException
     */
    public Estudiante(String nombre, double notaMedia, int numNotas) throws IllegalArgumentException {
        if (notaMedia < 0 || numNotas < 0) {
            throw new IllegalArgumentException("Datos iniciales erroneos");
        }

        this.nombre = nombre;
        this.notaMedia = notaMedia;
        this.numNotas = numNotas;
    }

    /**
     * devuelve el nombre del estudiante
     *
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * devuelve la nota media
     *
     * @return
     */
    public double getNotaMedia() {
        return this.notaMedia;
    }

    /**
     * devuelve el numero de notas del estudiante
     *
     * @return
     */
    public int getNumNotas() {
        return this.numNotas;
    }

    /**
     * actualiza el valor de las notas. si la nueva nota es valida actualizara
     * los valores de nota media y numero de notas, si es invalido devolvera
     * false
     *
     * @param nuevaNota
     * @return
     */
    public boolean actualizarNota(double nuevaNota) {
        boolean resultado;
        if (nuevaNota >= 0) {
            resultado = true;
            this.numNotas++;
            this.notaMedia = (this.notaMedia * (this.numNotas - 1) + nuevaNota) / this.numNotas;
        } else {
            resultado = false;
        }

        return resultado;
    }

    /**
     * devuelve una calificacion segun la nota media del estudiante.
     * <br>
     * <b>calificacion - nota</b> <br>
     * A - 9<br>
     * B - 8<br>
     * C - 7<br>
     * D - 6<br>
     * E - 5<br>
     * F - menos de 5<br>
     *
     * @return
     */
    public char calificacionMedia() {
        char resultado;
        double nota = this.notaMedia;

        if (nota >= 9) {
            resultado = 'A';
        } else if (nota >= 8) {
            resultado = 'B';
        } else if (nota >= 7) {
            resultado = 'C';
        } else if (nota >= 6) {
            resultado = 'D';
        } else if (nota >= 5) {
            resultado = 'E';
        } else {
            resultado = 'F';
        }

        return resultado;
    }

    public String toString() {
        return String.format("Estudiante: %s, nota media: %.2f, numero de "
                + "notas: %d", this.nombre, this.notaMedia, this.numNotas);
    }
}