/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author maniana
 */
public class Asignatura {

//    private static Set<Integer> identificadores = new LinkedHashSet<>();
    public static int ids = 0;

    private int id;
    private double calificacion;

    /**
     * constructor de un parametro
     * @param id identificador de la asignatura
     * @throws IllegalArgumentException
     */
    public Asignatura(int id) throws IllegalArgumentException {
//        if (identificadores.contains(id)) {
//            throw new IllegalArgumentException("id ya usado");
//        }

        this.id = id;
//        identificadores.add(id);
    }
    
    /**
     * Constructor copia
     * @param copia elemento a copiar
     */
    public Asignatura(Asignatura copia){
        this.id = copia.id;
    }

    /**
     * devuelve el identificador de la asginatura
     *
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * devuelve la calificacion de la asignatura
     *
     * @return calificacion
     */
    public double getCalificacion() {
        return this.calificacion;
    }

    /**
     * actualiza la calificacion
     *
     * @param nota nueva calificacion
     */
    public void setCalificacion(double nota) {
        this.calificacion = nota;
    }
}
