/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea;

import java.util.Comparator;

/**
 *
 * @author maniana
 */
public class ComparadorTicketsPorNumArticulos implements Comparator<TicketCompra>{

    @Override
    public int compare(TicketCompra o1, TicketCompra o2) {
        return o1.getNumArticulos()-o2.getNumArticulos();
    }
    
}
