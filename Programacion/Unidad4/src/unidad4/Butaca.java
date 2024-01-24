/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class Butaca {

    public static void main(String[] args) {
        final double PRECIO_MIN = 10.5, AUMENTO = .5;
        int numButacas;
        double precioButaca[][];
        Scanner teclado = new Scanner(System.in);
        
        do {
            System.out.println("Ingresa el numero de filas [2-50]");
            numButacas = teclado.nextInt();
        } while (numButacas < 2 && numButacas > 50);
    }
}
