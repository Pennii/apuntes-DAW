/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoExamen2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author matii
 */
public class Main {

    public static void main(String[] args) {
        Comic comic1 = new Comic("Invencible", LocalDate.of(2005, 2, 10), 100);
        Comic comic2 = new Comic("Spiderman", LocalDate.of(1969, 8, 4), 50, "Aventura");
        Comic comic3 = new Comic("Batman", LocalDate.of(2005, 12, 10), 30, "Misterio");
        Comic comic4 = new Comic("Superman", LocalDate.of(2015, 2, 10), 20);
        Comic comic5 = new Comic("Ghost rider", LocalDate.of(2005, 4, 25), 60, "Terror");
        Tienda tiendita = new Tienda("Ilusion");
        String clave;
        Set<Comic> cajas = new HashSet<>();

        cajas.add(comic1);
        cajas.add(comic2);
        cajas.add(comic3);
        cajas.add(comic4);
        cajas.add(comic5);

        for (Comic comic : cajas) {
            clave = comic.getCategoria();
            tiendita.setClave(clave);
        }
        
        for (Comic comic : cajas) {
            clave = comic.getCategoria();
            tiendita.setElemento(clave, comic);
        }
        
        for(String claves : tiendita.getListado().keySet()){
            System.out.println("Comics del genero "+claves+":");
            for(Comic comic : tiendita.getListado().get(claves)){
                System.out.println(comic);
            }
        }
    }
}
