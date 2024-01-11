import java.util.Scanner;

import biblioteca.Libros;

public class Biblioteca {
    // Se desea conocer la cantidad total de libros de una biblioteca, cuantos de
    // cada genero hay, cuantos se vendieron, y cual es el genero mas vendido.
    // Los generos seran: Terror, Comedia, Drama.
    // El fin de ingreso de datos sera con cantidad = 0

    public static void main(String[] args) {
        int cant, ven, cantTotal = 0, ventTotal = 0, genMax = 0;
        String gen;
        Scanner teclado = new Scanner(System.in);
        Libros bibliotica = new Libros();
        // se ingresaran libros hasta que la cantidad sea 0
        do {
            System.out.println("Ingresa la cantidad de libros");
            cant = teclado.nextInt();
            teclado.nextLine();
            if (cant != 0) {
                System.out.println("Ingresa el genero del libro");
                gen = teclado.nextLine();
                System.out.println("Ingresa cuantos libros se han vendido");
                ven = teclado.nextInt();
                teclado.nextLine();
                bibliotica.agregarLibro(gen, cant, ven);
                ventTotal += ven;
                cantTotal += cant;
                System.out.println("INGRESO COMPLETADO");
            } else {

            }
        } while (cant != 0);
        System.out.println("Se han vendido: " + ventTotal + " libros");
        System.out.println("la cantidad total de libros en la biblioteca es: " + cantTotal);
        System.out.println("la cantidad total de libros de terror es: " + bibliotica.getTerror());
        System.out.println("la cantidad total de libros de comedia es: " + bibliotica.getComedia());
        System.out.println("la cantidad total de libros de drama es: " + bibliotica.getDrama());
        System.out.println("El genero mas vendido es: " + bibliotica.getGeneroVendido(genMax));
    }
}