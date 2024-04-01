/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author matii
 */
public class OrdProd {

    public static class Producto implements Comparable<Producto> {

        private String nombre;
        private LocalDate fecha;
        private double precio;

        public Producto(String nombre, LocalDate fecha, double precio) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.precio = precio;
        }

        public String toString() {
            return String.format("%s, %s, %.2f", this.getNombre(), this.getFecha().toString(), this.getPrecio());
        }

        /**
         * @return the nombre
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * @return the fecha
         */
        public LocalDate getFecha() {
            return fecha;
        }

        /**
         * @return the precio
         */
        public double getPrecio() {
            return precio;
        }

        @Override
        public int compareTo(Producto o) {
            int res;
            if (o.precio > this.precio) {
                res = -1;
            } else if (o.precio == this.precio) {
                res = 0;
            } else {
                res = 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Producto prod1 = new Producto("Sardinas", LocalDate.of(2023, 12, 31), 1.5);
        Producto prod2 = new Producto("Caballa", LocalDate.of(2023, 12, 25), 1.7);
        Producto prod3 = new Producto("Navajas", LocalDate.of(2021, 1, 1), 2.4);
        Producto prod4 = new Producto("Mejillones", LocalDate.of(2022, 1, 11), 2.1);

        List<Producto> lista = new ArrayList();
        lista.add(prod1);
        lista.add(prod2);
        lista.add(prod3);
        lista.add(prod4);

        for (Producto prod : lista) {
            System.out.println(prod.toString());
        }
        System.out.println("---------------------");
        System.out.println("ORDENADOS POR PRECIO:\n");
        Collections.sort(lista);
        for (Producto prod : lista) {
            System.out.println(prod.toString());
        }
        System.out.println("");
        System.out.println("SEGUNDA FORMA:\n");
        Collections.sort(lista, new CompararProdPrecio());
        for (Producto prod : lista) {
            System.out.println(prod.toString());
        }
        System.out.println("----------------------");
        System.out.println("ORDENADOS POR NOMBRE:\n");
        Collections.sort(lista, new CompararProdNombre());
        for (Producto producto : lista) {
            System.out.println(producto.toString());
        }
        System.out.println("-------------------------");
        System.out.println("ORDENADOS POR FECHA DE CADUCIDAD:\n");
        Collections.sort(lista, new CompararProdFecha());
        for(Producto prod : lista){
            System.out.println(prod.toString());
        }
        System.out.println("-------------");
    }
}
