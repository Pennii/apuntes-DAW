/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act_practicar;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author maniana
 */
public class Act1 {

    public static void main(String[] args) {
        Set<String> colores1 = new HashSet<>();
        Set<String> colores2 = new HashSet<>();
        Set<String> colores3 = new HashSet<>();
        Set<String> colores4 = new HashSet<>();
        Set<String> colores5 = new HashSet<>();
        boolean agregado;

        for (int i = 0; i < 3; i++) {
            agregado = false;
            while (!agregado) {
                agregado = colores1.add(Utilidades.colorAleatorio());
            }
            agregado = false;
            while (!agregado) {
                agregado = colores2.add(Utilidades.colorAleatorio());
            }
        }
        for(String color : colores1){
            colores3.add(color);
        }
        for(String color : colores2){
            colores3.add(color);
        }
        
        for(String color : colores1){
            if (colores2.contains(color)) {
                colores4.add(color);
            }else{
                colores5.add(color);
            }
        }
        System.out.println("Conjunto 1: "+colores1);
        System.out.println("Conjunto 2: "+colores2);
        System.out.println("Conjunto union: "+colores3);
        System.out.println("Conjunto interseccion: "+colores4);
        System.out.println("Conjunto diferencia: "+colores5);
    }
}
