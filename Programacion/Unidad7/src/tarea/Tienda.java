/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
        Map<LocalDate, Double> mapa = new HashMap();
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
        double importe;
        int anio;
        String vendedor;

        for (TicketCompra compra : this.tickets) {
            vendedor = compra.getVendedor();

            if (!mapa.containsKey(vendedor)) {
                mapa.put(vendedor, new HashMap());
            }

            anio = compra.getInstante().getYear();

            if (!mapa.get(vendedor).containsKey(anio)) {
                mapa.get(vendedor).put(anio, 0.0);
            }

            importe = mapa.get(vendedor).get(anio) + compra.getImporte();
            mapa.get(vendedor).put(anio, importe);
        }

        return mapa;
//        Map<Integer, Double> ventas[];
//        double venta;
//        int contador = 0;
//        Set<String> nombre = new HashSet();
//        Set<Integer> fechas = new HashSet();
//        for (TicketCompra lista : this.tickets) {
//            if (!fechas.contains(lista.getInstante().getYear())) {
//                fechas.add(lista.getInstante().getYear());
//            }
//        }
//
//        for (TicketCompra lista : this.tickets) {
//            if (!nombre.contains(lista.getVendedor())) {
//                nombre.add(lista.getVendedor());
//                contador++;
//            }
//        }
//
//        ventas = new HashMap[contador];
//        for (int i = 0; i < ventas.length; i++) {
//            ventas[i] = new HashMap();
//        }
//        contador = 0;
//        for (String nombres : nombre) {
//            for (int anio : fechas) {
//                venta = 0;
//                for (TicketCompra ticket : this.tickets) {
//                    if (ticket.getInstante().getYear() == anio && ticket.getVendedor().equals(nombres)) {
//                        venta += ticket.getImporte();
//                    }
//                }
//                if (venta > 0) {
//                    ventas[contador].put(anio, venta);
//                }
//            }
//            mapa.put(nombres, ventas[contador++]);
//        }
//
//        return mapa;
    }

    public int removeCompras(String nom) {
        int cant = 0;
        Set<TicketCompra> lista = new HashSet();
        for (TicketCompra tick : this.tickets) {
            if (tick.getVendedor().equals(nom)) {
                lista.add(tick);
            }
        }
        for (TicketCompra borrar : lista) {
            this.tickets.remove(borrar);
            cant++;
        }

        return cant;
    }

    public int removeCompras(LocalDate fecha) {
        int cant = 0;
        Set<TicketCompra> lista = new HashSet();
        for (TicketCompra tick : this.tickets) {
            if (tick.getInstante().toLocalDate().equals(fecha)) {
                lista.add(tick);
            }
        }

        for (TicketCompra borrar : lista) {
            this.tickets.remove(borrar);
            cant++;
        }
        return cant;
    }

    public int removeCompras(String vendedor, LocalDate fecha) {
        int cant = 0;
        String ven;
        LocalDate fec;
        TicketCompra tick;
        Iterator<TicketCompra> lista = this.tickets.iterator();
        while (lista.hasNext()) {
            tick = lista.next();
            ven = tick.getVendedor();
            fec = tick.getInstante().toLocalDate();

            if (ven.equals(vendedor) && fec.equals(fecha)) {
                lista.remove();
                cant++;
            }
        }
        return cant;
    }

    public void sortListaTicketsPorInstante() {
        Collections.sort(this.tickets, new ComparadorTicketsPorInstante());
    }
    public void sortListaTicketsPorVendedor() {
        Collections.sort(this.tickets, new ComparadorTicketsPorVendedor());
    }
    public void sortListaTicketsPorImporte() {
        Collections.sort(this.tickets, new ComparadorTicketsPorImporte());
    }
    public void sortListaTicketsPorNumArticulos() {
        Collections.sort(this.tickets, new ComparadorTicketsPorNumArticulos());
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
