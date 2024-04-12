/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoExamen;

import java.util.Comparator;

/**
 *
 * @author maniana
 */
public class PersonaOrdenCrono implements Comparator<Persona>{

    @Override
    public int compare(Persona o1, Persona o2) {
        return o2.getNacimiento().compareTo(o1.getNacimiento());
    }
    
}