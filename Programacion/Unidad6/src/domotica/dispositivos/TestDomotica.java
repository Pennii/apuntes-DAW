/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domotica.dispositivos;

/**
 *
 * @author matii
 */
public class TestDomotica {

    public static void main(String[] args) {
        Dispositivo dispositivos[] = new Dispositivo[4];
        Bombilla bomb1 = new Bombilla("luminica", 1);
        Bombilla bomb2 = new Bombilla("led", 3);
        Cerradura cerr1 = new Cerradura("wifi", 1, true);
        Cerradura cerr2 = new Cerradura("wifi", 4);
        boolean usado = false;
     
        dispositivos[0] = bomb1; 
        dispositivos[1] = bomb2;
        dispositivos[2] = cerr1;
        dispositivos[3] = cerr2;
        
        CasaDomotica casita = new CasaDomotica("pennino", "grande", dispositivos);
        
        for (int i = 0; i < dispositivos.length && !usado; i++) {
            if (dispositivos[i] instanceof Bombilla bombilla) {
                bombilla.on();
            }
        }
        
        System.out.println(casita.toString());
    }
}
