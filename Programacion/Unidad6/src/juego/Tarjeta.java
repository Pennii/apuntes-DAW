/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author matii
 */
public class Tarjeta extends ElementoJuego{
    
    public static final String TEXTO_DEFAULT = "Tarjeta en blanco";
    
    private String texto;

    public Tarjeta(String nombre, String texto) {
        super(nombre);
        
        if (texto == null || texto.equals("")) {
            this.texto = TEXTO_DEFAULT;
        }else{
            this.texto = texto;
        }
    }
    
    public String toString(){
        return String.format("%s, Texto: %s", super.toString(), this.texto);
    }
    
}
