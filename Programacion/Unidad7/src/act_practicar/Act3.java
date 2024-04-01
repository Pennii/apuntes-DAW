/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act_practicar;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author maniana
 */
public class Act3 {
    public static void main(String[] args) {
        Map<LocalDate, String> colores = new HashMap<>();
        String color;
        
        for (int i = 1; i < 6; i++) {
            color = Utilidades.colorAleatorio();
            while(colores.containsValue(color)){
                color = Utilidades.colorAleatorio();
            }
            colores.put(LocalDate.of(2024, Month.MARCH, i), color);
        }
        for(LocalDate fecha : colores.keySet()){
            System.out.println("clave: "+fecha+", valor: "+colores.get(fecha));
        }
    }
}
