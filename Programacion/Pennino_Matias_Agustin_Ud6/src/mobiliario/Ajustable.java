/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mobiliario;

/**
 *
 * @author maniana
 */
public interface Ajustable {
    
    public int obtenerPosicion();
    public int subirPosicion() throws IllegalStateException;
    public int bajarPosicion() throws IllegalStateException;
    
}
