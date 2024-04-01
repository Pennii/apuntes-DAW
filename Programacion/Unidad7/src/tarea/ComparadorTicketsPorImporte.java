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
public class ComparadorTicketsPorImporte implements Comparator<TicketCompra> {

    @Override
    public int compare(TicketCompra t1, TicketCompra t2) {
        return Double.compare(t1.getImporte(), t2.getImporte());
    }
    
}
