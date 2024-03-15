/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fubol2;

import java.util.Objects;

/**
 *
 * @author maniana
 */
public class Futbolista {

    private final String nombre;
    private String apodo;

    public Futbolista(String nombre, String apodo) {
        this.nombre = nombre;
        this.apodo = apodo;
    }

    public Futbolista(String nombre) {
        this(nombre, nombre);
    }

    public Futbolista() {
        this("messi", "pulga");
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the apodo
     */
    public String getApodo() {
        return apodo;
    }

    public String toString() {
        return String.format("Nombre: %s Apodo: %s", this.nombre, this.apodo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.apodo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;

        if (this == obj) {
            resultado = true;
        } else if (this.getClass() == obj.getClass()) {
            Futbolista otro = (Futbolista) obj;
            if (otro.getNombre().equals(this.nombre) && otro.getApodo().equals(this.apodo)) {
                resultado = true;
            }
        }

        return resultado;
    }

}
