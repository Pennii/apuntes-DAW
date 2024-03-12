/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 *
 * @author maniana
 */
public class TestMobiliario {

    public static void main(String[] args) {
        Mueble lista[] = new Mueble[5];
        Silla silla1 = new Silla(50, "Comoda", "AAA", "Rojo");
        Silla silla2 = new Silla(20, "Alta", "BBB", "Amarillo");
        Sillon sillon = new Sillon(70, "Largo", "CCC", "Azul");
        Sofa sofa = new Sofa(100.30, "Amplio", 6, "DDD", "Negro", "3+3");
        Mesa mesa = new Mesa(15.36, "De cocina", "Cuadrada", 5);

        boolean salto = false;

        lista[0] = silla1;
        lista[1] = silla2;
        lista[2] = sillon;
        lista[3] = sofa;
        lista[4] = mesa;

        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i].toString());

            if (lista[i] instanceof Silla silla) {
                System.out.println("Se subira la silla a su posicion maxima");
                System.out.printf("La posicion de la silla con id %d es: %d\n",
                        silla.getId(), silla.getPos());
                while (!salto) {
                    try {
                        System.out.printf("La posicion de la silla con id %d es: %d\n",
                                silla.getId(), silla.subirPosicion());
                    } catch (IllegalStateException e) {
                        System.out.printf("La silla alcanzo la posicion maxima: %d, no puede subir mas\n",
                                Silla.POS_MAX);
                        salto = true;
                    }

                }
                salto = false;
            } else if (lista[i] instanceof Sillon sill) {
                System.out.println("Se subira el sillon a su posicion maxima");
                System.out.printf("La posicion del sillon con id %d es: %d\n",
                        sill.getId(), sill.getPos());
                while (!salto) {
                    try {
                        System.out.printf("La posicion del sillon con id %d es: %d\n",
                                sill.getId(), sill.subirPosicion());
                    } catch (IllegalStateException e) {
                        System.out.printf("El sillon alcanzo la posicion \"subido\": %d, no puede volver a subir\n",
                                Sillon.POS_SUBIDO);
                        salto = true;
                    }
                }
            }
            System.out.println("");
        }
    }

}
