/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea07;

import java.util.Comparator;

/**
 *
 * @author maniana
 */
public class OrdenarNombre implements Comparator<Mascota>{

    @Override
    public int compare(Mascota o1, Mascota o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
    
}
