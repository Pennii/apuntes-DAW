/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad7;

/**
 *
 * @author maniana
 */
public class Contenedor<T> {
    
    private T contenido;
    
    public void setContenido(T contenido){
        this.contenido = contenido;
    }
    
    public T getContenido(){
        return this.contenido;
    }

}
