/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 *
 * @author maniana
 */
public class TestComputadorVuelo {

    public static void main(String[] args) {

        try {
            ComputadorVuelo avion = new ComputadorVuelo(null, "AA1", "Carlos");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            ComputadorVuelo avion = new ComputadorVuelo("AAAAA", null, "Mauro");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            ComputadorVuelo avion = new ComputadorVuelo("AAAAA", "ZZZ", null);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            ComputadorVuelo avion = new ComputadorVuelo("", "FFF");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ComputadorVuelo avion = new ComputadorVuelo("YYYY", "");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ComputadorVuelo avion[] = ComputadorVuelo.crearArrayComputadorVuelo(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("");
        ComputadorVuelo aviones[] = ComputadorVuelo.crearArrayComputadorVuelo(2);
        aviones[0].despegar(860, 2000);
        aviones[1].despegar(900, 2500);

        for (int i = 0; i < aviones.length; i++) {
            System.out.printf("Informacion del avion %d:\n%s\n", i + 1, aviones[i].toString());
        }

        aviones[0].setAltitud(2500);
        aviones[0].setVelocidad(950);

        System.out.println("");
        System.out.printf("Nueva velocidad del avion 1: %.2f\nNueva altura: %.2f\n",
                aviones[0].getVelocidad(), aviones[0].getAltitud());

        System.out.println("");
        try {
            System.out.println("Intento de despegue repetido en el avion 2");
            aviones[1].despegar(100, 2000);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("");
        for (int i = 0; i < aviones.length; i++) {
            System.out.printf("Informacion del avion %d:\n%s\n", i + 1, aviones[i].toString());
        }
    }

}
