/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 *
 * @author matii
 */
public class TestTienda {
    
    public static void main(String[] args) {
        Compra producto1 = new Compra("coca", 10, 5);
        Compra producto2 = new Compra("hamburguesa", 2, 3);
        Compra producto3 = new Compra("lata", 1.3, 1);
        Tienda tiendita = new Tienda(5);
        
        TicketCompra ticket1 = new TicketCompra("raul", LocalDateTime.of(LocalDate.of(2012, 3, 10), LocalTime.MIN));
        TicketCompra ticket2 = new TicketCompra("juan", LocalDateTime.of(LocalDate.of(2012, 3, 10), LocalTime.MIN));
        TicketCompra ticket3 = new TicketCompra("raul", LocalDateTime.of(LocalDate.of(2014, 3, 10), LocalTime.MIN));
        TicketCompra ticket5 = new TicketCompra("juan", LocalDateTime.of(LocalDate.of(2014, 3, 10), LocalTime.MIN));
        TicketCompra ticket4 = new TicketCompra("juan", LocalDateTime.of(LocalDate.of(2018, 3, 10), LocalTime.MIN));
        
        ticket1.getLista().add(producto1);
        ticket1.getLista().add(producto2);
        
        ticket2.getLista().add(producto1);
        ticket2.getLista().add(producto2);
        ticket2.getLista().add(producto3);
        
        ticket3.getLista().add(producto2);
        
        ticket4.getLista().add(producto1);
        
        ticket5.getLista().add(producto1);
        ticket5.getLista().add(producto2);
        
        tiendita.getTickets().add(ticket3);
        tiendita.getTickets().add(ticket2);
        tiendita.getTickets().add(ticket1);
        tiendita.getTickets().add(ticket4);
        tiendita.getTickets().add(ticket5);
        
        System.out.println(tiendita.getImportePorFecha());
        
        System.out.println(tiendita.getProductosComprados(LocalDate.of(2012, Month.MARCH, 10)));
        
        System.out.println(tiendita.getComprasPorVendedorYear());
        
        System.out.println(tiendita.toString());
        
        
    }
    
}
