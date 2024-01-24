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
        ChipiBici bici2 = new ChipiBici(5, 4);
        ChipiBici bici3 = new ChipiBici(LocalDate.of(2024, 4, 20), 3, 7);
    }
}
