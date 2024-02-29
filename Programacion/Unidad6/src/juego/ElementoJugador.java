/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author matii
 */
public abstract class ElementoJugador extends ElementoJuego{
    
    private String propietario;
    
    public ElementoJugador(String nombre, String jugador) {
        super(nombre);
        this.propietario = jugador;
    }
    
    public  String getPropietario(){
        return this.propietario;
    }
    
    public void setPropietario(String jugador){
        this.propietario = jugador;
    }
    
    public String toString(){
        return String.format("%s, propietario: %s",super.toString(), this.propietario);
    }
}
