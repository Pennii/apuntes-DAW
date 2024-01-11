/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Ejercicio9Matriz2 {

    public static void main(String[] args) {
        int ventasMes, ventaMes[][], ventasAnio, ventasTotAnio = 0;
        ventaMes = new int[2][12];
        Scanner teclado = new Scanner(System.in);

        System.out.println("Se ingresaran las ventas de cada empleado por mes");

        for (int i = 0; i < ventaMes.length; i++) {
            System.out.printf("Empleado %d:\n", i + 1);
            for (int j = 0; j < ventaMes[i].length; j++) {
                System.out.printf("Mes %d: ", j + 1);
                ventaMes[i][j] = teclado.nextInt();
            }
        }
        for (int i = 0; i < ventaMes[0].length; i++) {
            ventasMes = 0;
            for (int[] ventaMe : ventaMes) {
                ventasMes += ventaMe[i];
            }
            ventasTotAnio += ventasMes;
            System.out.printf("Las ventas totales de el mes %d son: %d\n", i + 1, ventasMes);
        }
        System.out.printf("Las ventas totales del año son: %d\n", ventasTotAnio);

        for (int i = 0; i < ventaMes.length; i++) {
            ventasAnio = 0;
            for (int j = 0; j < ventaMes[i].length; j++) {
                ventasAnio += ventaMes[i][j];
            }
            System.out.printf("El empleado %d realizo %d ventas en todo el año\n", i + 1, ventasAnio);
        }
    }
}
