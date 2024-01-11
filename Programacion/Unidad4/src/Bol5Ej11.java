/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Bol5Ej11 {

    public static void main(String[] args) {
        int plazas = 0;
        int opcion, anio;
        boolean invalido;
        String participante[][] = new String[10][4];
        Scanner teclado = new Scanner(System.in);

        System.out.println("COMPETICION");
        System.out.println("-----------");

        do {
//            OPCIONES DEL PROGRAMA
            System.out.println("1- Inscribir un participante");
            System.out.println("2- Mostrar listado de datos");
            System.out.println("3- Mostrar listado por marcas");
            System.out.println("4- FIN DEL PROGRAMA");
            opcion = teclado.nextInt();
            teclado.nextLine();

//            CASOS POSIBLES DE LAS OPCIONES
            switch (opcion) {
                case 1 -> {
                    if (plazas <= 9) {
//                        INGRESO DE DATOS EN ORDEN: NOMBRE, MARCA 2000, MARCA
//                        2001, MARCA 2002
                        System.out.printf("Plazas disponibles: %d\n", 10 - plazas);
                        System.out.println("Ingresa el nombre del participante");
                        participante[plazas][0] = teclado.nextLine();
                        System.out.println("Ingresa la mejor marca del 2000");
                        participante[plazas][1] = teclado.nextLine();
                        System.out.println("Ingresa la mejor marca del 2001");
                        participante[plazas][2] = teclado.nextLine();
                        System.out.println("Ingresa la mejor marca del 2002");
                        participante[plazas][3] = teclado.nextLine();
                        plazas++;
                    } else {
                        System.out.println("No quedan plazas vacantes");
                    }
                }
                case 2 -> {
                    for (int i = 0; i < plazas; i++) {
//                        SALIDA DE DATOS EN ORDEN
                        System.out.printf("Participante %d:\n", i + 1);
                        System.out.printf("Nombre: %s\n", participante[i][0]);
                        System.out.printf("Mejor marca del 2000: %s\n", participante[i][1]);
                        System.out.printf("Mejor marca del 2001: %s\n", participante[i][2]);
                        System.out.printf("Mejor marca del 2002: %s\n\n", participante[i][3]);
                    }
                }
                case 3 -> {
                    System.out.println("Se mostrara el listado por marcas, de que año quieres buscar? [2000 - 2001 - 2002]");
                    do {
//                        SE INGRESA LA POSICION DEL ANIO
                        anio = teclado.nextInt();
                        invalido = anio != 2000 && anio != 2001 && anio != 2002;
                        if (invalido) {
                            System.out.println("El año no es valido");
                        } else {
                            if (anio == 2000) {
                                anio = 1;
                            }
                            if (anio == 2001) {
                                anio = 2;
                            }
                            if (anio == 2002) {
                                anio = 3;
                            }
                        }
                    } while (invalido);
                    String[][] marcas = new String[plazas][4];
                    for (int i = 0; i < plazas; i++) {
//                        CREANDO UN NUEVO ARRAY SE IGUALAN LOS DATOS
                        marcas[i][0] = participante[i][0];
                        marcas[i][anio] = participante[i][anio];
                    }
                    String[][] auxiliar = new String[1][2];
                    boolean valido;
                    do {
//                        CON LA AYUDA DE UN ARRAY AUXILIAR ORDENAMOS DE MAYOR A MENOR
                        valido = true;
                        for (int i = plazas - 1; i > 0; i--) {
                            if (Integer.valueOf(marcas[i][anio]) >= Integer.valueOf(marcas[i - 1][anio])) {
                                auxiliar[0][0] = marcas[i][0];
                                auxiliar[0][1] = marcas[i][anio];
                                marcas[i][0] = marcas[i - 1][0];
                                marcas[i][anio] = marcas[i - 1][anio];
                                marcas[i - 1][0] = auxiliar[0][0];
                                marcas[i - 1][anio] = auxiliar[0][1];
                                valido = false;
                            }
                        }
                    } while (!valido);

                    for (int i = 0; i < plazas; i++) {
//                        USANDO EL ARRAY NUEVO YA ORDENADO SE MUESTRAN LOS RESULTADOS
                        System.out.printf("Posicion %d: Participante: %s marca %s\n", i + 1, marcas[i][0], marcas[i][anio]);
                    }

                }
                case 4 -> {
                }
                default ->
                    System.out.println("Opcion erronea");
            }
            System.out.println("");
        } while (opcion != 4);
    }
}
