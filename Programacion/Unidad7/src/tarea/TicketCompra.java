/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author maniana
 */
public class TicketCompra {

    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");

    private String vendedor;
    private LocalDateTime instante;
    private List<Compra> lista;

    public TicketCompra(String vendedor, LocalDateTime instante, List<Compra> lista) {
        this.vendedor = vendedor;
        this.instante = instante;
        if (lista != null) {
            this.lista = lista;
        }else{
            this.lista = new LinkedList<>();
        }
    }
    
     public TicketCompra(String vendedor, LocalDateTime instante) {
       this(vendedor, instante, null);
    }

    /**
     * @return the vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the instante
     */
    public LocalDateTime getInstante() {
        return instante;
    }

    /**
     * @return the lista
     */
    public List<Compra> getLista() {
        return lista;
    }

    public double getImporte() {
        double importe = 0.0;

        for (int i = 0; i < this.lista.size(); i++) {
            importe += this.lista.get(i).getImporte();
        }

        return importe;
    }

    public int getNumArticulos() {
        int cantidad = 0;

        for (int i = 0; i < this.lista.size(); i++) {
            cantidad += this.lista.get(i).getCantidad();
        }

        return cantidad;
    }

    @Override
    public String toString() {
        return String.format("vendedor %s instante: %s numero de articulos: %d "
                + "importe total: %.2f", this.vendedor, this.instante.format(FORMATO),
                this.getNumArticulos(), this.getImporte());
    }

}
