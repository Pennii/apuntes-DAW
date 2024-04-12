/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoExamen3;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author matii
 */
public class Peleador implements Comparable<Peleador> {

    private String nombre;
    private String estilo;
    private int victorias;
    private LocalDate fechaCombate;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.estilo);
        hash = 79 * hash + this.victorias;
        hash = 79 * hash + Objects.hashCode(this.fechaCombate);
        return hash;
    }


    @Override
    public boolean equals(Object obj) {
        boolean igual = false;

        if (this == obj) {
            igual = true;
        } else if (this.getClass() == obj.getClass()) {
            Peleador otro = (Peleador) obj;
            igual = this.getNombre().equals(otro.getNombre()) && 
                    this.getVictorias() == otro.getVictorias() && this.estilo.equals(otro.estilo);
        }

        return igual;
    }

    public Peleador(String nombre, String estilo, int victorias, LocalDate fechaCombate) {
        this.nombre = nombre;
        this.estilo = estilo;
        this.victorias = victorias;
        this.fechaCombate = fechaCombate;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estilo
     */
    public String getEstilo() {
        return estilo;
    }

    /**
     * @param estilo the estilo to set
     */
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    /**
     * @return the victorias
     */
    public int getVictorias() {
        return victorias;
    }

    /**
     * @param victorias the victorias to set
     */
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    @Override
    public String toString() {
        return "nombre: " + getNombre() + ", estilo: " + getEstilo() + ", victorias: " + getVictorias();
    }

    @Override
    public int compareTo(Peleador o) {
        return this.nombre.compareTo(o.nombre);
    }

    /**
     * @return the fechaCombate
     */
    public LocalDate getFecha() {
        return fechaCombate;
    }

    /**
     * @param fechaCombate the fechaCombate to set
     */
    public void setFecha(LocalDate fechaCombate) {
        this.fechaCombate = fechaCombate;
    }

}
