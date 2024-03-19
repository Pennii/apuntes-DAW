/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author maniana
 */
public class Tienda {

    private final int id;
    private List<TicketCompra> tickets;

    public Tienda(int id, List<TicketCompra> tickets) {
        this.id = id;
        if (tickets != null) {
            this.tickets = tickets;
        } else {
            this.tickets = new ArrayList();
        }
    }

    public Tienda(int id) {
        this(id, null);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the tickets
     */
    public List<TicketCompra> getTickets() {
        return tickets;
    }

    public int getNumArticVendidos() {
        int cant = 0;

        for (TicketCompra listita : this.tickets) {
            cant += listita.getNumArticulos();
        }

        return cant;
    }

    public double getFacturacion() {
        double fact = 0;

        for (TicketCompra lista : this.tickets) {
            fact += lista.getImporte();
        }
        return fact;
    }

    public Set<String> getProductosComprados(LocalDate fecha) {
        Set<String> lista = new HashSet();
        for (TicketCompra listaTicket : this.tickets) {
            if (listaTicket.getInstante().toLocalDate().isAfter(fecha)) {
                for (Compra prod : listaTicket.getLista()) {
                    lista.add(prod.getNombre());
                }
            }
        }
        return lista;
    }

    public Map<LocalDate, Double> getImportePorFecha() {
        Map<LocalDate, Double> mapa = new LinkedHashMap();
        Set<LocalDate> fechas = new HashSet();
        double fact;

        for (TicketCompra lista : this.tickets) {
            fechas.add(lista.getInstante().toLocalDate());
        }

        for (LocalDate fecha : fechas) {
            fact = 0;
            for (TicketCompra lista : this.tickets) {
                if (lista.getInstante().toLocalDate().equals(fecha)) {
                    fact += lista.getImporte();
                }
            }
            mapa.put(fecha, fact);
        }
        return mapa;
    }

    public Map<String, Map<Integer, Double>> getComprasPorVendedorYear() {
        Map<String, Map<Integer, Double>> mapa = new HashMap();
        Map <Integer, Double> ventas = new HashMap();
        double venta;
        Set<String> nombre = new HashSet();
        Set<Integer> fechas = new HashSet();
        for (TicketCompra lista : this.tickets) {
            fechas.add(lista.getInstante().getYear());
        }

        for (TicketCompra lista : this.tickets) {
            nombre.add(lista.getVendedor());
        }

        for (String nombres : nombre) {
            for (int anio : fechas) {
                venta = 0;
                for (TicketCompra ticket : this.tickets) {
                    if (ticket.getInstante().getYear() == anio && ticket.getVendedor().equals(nombres)) {
                        venta += ticket.getImporte();
                    }
                }
                ventas.put(anio, venta);
            }
            mapa.put(nombres, ventas);
        }

        return mapa;
    }

    public String toString() {
        int contador = 1;
        String resultado = "";
        resultado += String.format("id: %d, cantidad de articulos vendidos: %d, "
                + "facturacion total: %.2f\n", this.id, this.getNumArticVendidos(),
                this.getFacturacion());
        for (TicketCompra lista : this.tickets) {
            resultado += String.format("ticket %d: %s\n", contador++, lista.toString());
        }

        return resultado;
    }
}
