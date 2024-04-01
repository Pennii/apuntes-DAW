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
public class CompararProdNombre implements Comparator<Producto>{

    @Override
    public int compare(Producto o1, Producto o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
    
}
