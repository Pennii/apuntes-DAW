/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.util.Comparator;
import tarea2.OrdProd.Producto;

/**
 *
 * @author matii
 */
public class CompararProdPrecio implements Comparator<Producto> {

    @Override
    public int compare(Producto o1, Producto o2) {
        int res;
        if (o1.getPrecio() > o2.getPrecio()) {
            res = 1;
        } else if (o1.getPrecio() == o2.getPrecio()) {
            res = 0;
        } else {
            res = -1;
        }
        return res;
    }

}
