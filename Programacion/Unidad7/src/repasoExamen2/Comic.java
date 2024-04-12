/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoExamen2;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author matii
 */
public class Comic implements Comparable<Comic>{
    
    private String nombre;
    private LocalDate publicacion;
    private int cantidad;
    private String categoria;

    public Comic(String nombre, LocalDate publicacion, int cantidad, String categoria) {
        this.nombre = nombre;
        this.publicacion = publicacion;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }
    
    public Comic(String nombre,  LocalDate publicacion, int cantidad){
        this(nombre, publicacion, cantidad, "Accion");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(LocalDate publicacion) {
        this.publicacion = publicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.publicacion);
        hash = 37 * hash + this.cantidad;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean igual = false;
        
        if (this == obj) {
            igual = true;
        }else if (this.getClass() == obj.getClass()) {
            Comic otro = (Comic) obj;
            igual = this.nombre.equals(otro.nombre) && this.publicacion.equals(otro.publicacion) && this.getCategoria().equals(otro.getCategoria());
        }
        
        return igual;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int compareTo(Comic o) {
        return this.publicacion.compareTo(o.publicacion);
    }
    
    public String toString(){
        return String.format("Nombre: %-15s Genero: %-15s Fecha de publicacion: %s cantidad: %-2d",
                this.nombre, this.categoria, this.publicacion.toString(), this.cantidad);
    }
    
}
