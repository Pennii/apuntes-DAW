/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seleccion;

/**
 *
 * @author matii
 */
public class Masajista extends Seleccion{

    private String titulacion;
    private int experiencia;
    
    public Masajista(int id, String nombre, String apellido, int edad, String tit, int exp) {
        super(id, nombre, apellido, edad);
        this.experiencia = exp;
        this.titulacion = tit;
    }

    @Override
    public void entrenar() {
        System.out.println("ASISTE");
    }
    
    public void masaje(){
        System.out.println("DA MASAJE");
    }
    
}
