/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domotica.dispositivos;

/**
 *
 * @author matii
 */
public interface Activable {
    
    public boolean getEstado();
    public void on();
    public void off();
    
}
