/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author maniana
 */
public class Arrrays {
    public static void main(String[] args) {
        int numeros[]= new int[2];
//        Los int float double etc son primitivos para verlos usamos toString
        Integer[] numerosb = {1,2,3};
//        Cualquier clase que sea objeto, usara el deepToString
        String[] nombre = {"mauro", "alicia"};
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = teclado.nextInt();
        }
        
        System.out.println(Arrays.deepToString(numerosb));
        
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Numero %d: %d\n",(i+1),numeros[i]);
            System.out.printf("Nombre %d: %s\n",(i+1),nombre[i]);
        }
    }
   
}
