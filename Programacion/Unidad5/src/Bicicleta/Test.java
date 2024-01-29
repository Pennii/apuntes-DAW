/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bicicleta;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author maniana
 */
public class Test {
    public static void main(String[] args) {
        ChipiBici bici1 = new ChipiBici();
        ChipiBici bici4[] = ChipiBici.fabrica(4);
        ChipiBici bici2 = new ChipiBici(4, 7);
        ChipiBici bici3 = new ChipiBici(LocalDate.of(2024, 4, 20), 3, 7);
        
        bici1.alquilar();
        System.out.printf("La bici 1 recorre %.2fkm en su alquiler actual\n",bici1.recorrerTrayecto(15));
        System.out.printf("La bici 1 recorre %.2fkm en su alquiler actual\n",bici1.recorrerTrayecto());
        System.out.println(bici1.getVerRev());
        bici1.devolver();
        bici1.actualizarFrimware(4,5);
        System.out.println(bici1.getVerRev());
        bici1.actualizarFrimware(6);
        System.out.println(bici1.getVerRev());
        System.out.println(bici1.toString());
        bici1.alquilar();
        bici1.recorrerTrayecto();
        System.out.println(bici1.toString());
        System.out.println(bici2.toString());
    }
}
