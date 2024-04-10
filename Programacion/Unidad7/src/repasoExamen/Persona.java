/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoExamen;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author maniana
 */
public class Persona{

    /*diseñar una clase persona con las siguientes caracteristicas: nombre, sexo,
    fecha de nacimiento. Implementar constructor, getters, setters, equals, hashcode,
    toString.
    Rellenar una lista de 10 personas y mostrarla ordenada por nombre, cronologico
    de menor a mayor.
    Rellenar un conjunto con las 10 personas y mostrarlo por orden cronologico,
    mostrar la menor y la mayor.
    creamos un mapa en el cual la clave sea el sexo de la persona y el valor una 
    lista de personas que pertenezcan a ese sexo. Mostrar el contenido del mismo.
    Crear otro mapa en el cual la clave sea el año de nacimiento de las personas,
    y el valor las personas nacidas ese año
     */
    private String nombre;
    private String sexo;
    private LocalDate nacimiento;

    public Persona(String nombre, String sexo, LocalDate nacimiento) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
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
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the nacimiento
     */
    public LocalDate getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.sexo);
        hash = 47 * hash + Objects.hashCode(this.nacimiento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean iguales = false;

        if (this == obj) {
            iguales = true;
        } else if (this.getClass() == obj.getClass()) {
            Persona otra = (Persona) obj;
            iguales = this.nacimiento.equals(otra.nacimiento) && this.nombre.equals(otra.nombre) && this.sexo.equals(otra.sexo);
        }

        return iguales;
    }
    
    @Override
    public String toString(){
        return String.format("Nombre: %s | fecha de nacimiento: %s | sexo: %s", this.nombre, this.nacimiento.toString(), this.sexo);
    }

}
