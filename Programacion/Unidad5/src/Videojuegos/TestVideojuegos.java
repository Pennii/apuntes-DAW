/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Videojuegos;

/**
 *
 * @author maniana
 */
public class TestVideojuegos {

    public static void main(String[] args) {
        CompraVideoJuegos ticket1 = new CompraVideoJuegos(
                "God of War Ragnarok,PS5,66.10#FIFA 23,XBOX,57.84#NBA 2k23"
                        + ",XBOX,37.18#Mario Kart 8 Deluxe,Switch,41.31#Need For Speed Unbound,PS5,56.19");
        System.out.println(ticket1.toString());
    }
}
