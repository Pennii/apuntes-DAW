/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

/**
 *
 * @author maniana
 */
public class aa {
    public static void main(String[] args) {
        Vehiculo auto = new Vehiculo(50);
        auto.cargar(50);
        auto.arrancar();
        //ejemplo de metodo con parametros variables
        System.out.println("Recorrio: "+auto.recorrerTrayecto(1, 4, 1));
        System.out.println(auto.toString());
    }
}
