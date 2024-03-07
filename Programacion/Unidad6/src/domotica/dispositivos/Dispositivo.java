/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domotica.dispositivos;

import domotica.Domotica;

/**
 *
 * @author matii
 */
public abstract class Dispositivo {
    
    private static int ids = 1;
    
    private int id;
    private String descripcion;
    private int ubicacion;
    
    public Dispositivo(String desc, int ubi) throws IllegalArgumentException{
        if (ubi > Domotica.MAX_UBICACION || ubi < Domotica.MIN_UBICACION) {
            throw new IllegalArgumentException("ubicacion invalida");
        }
        
        this.id = ids++;
        this.descripcion = desc;
        this.ubicacion = ubi;
    }
    
    public int getId(){
        return this.id;
    }
    
    public int getUbi(){
        return this.ubicacion;
    }
    
    public String getDesc(){
        return this.descripcion;
    }
    
    public String toString(){
        return String.format("tipo: %s id: %d descripcion: %s ubicacion: %d",
                this.getClass().getSimpleName(), this.id, this.descripcion,
                this.ubicacion);
    }
}
