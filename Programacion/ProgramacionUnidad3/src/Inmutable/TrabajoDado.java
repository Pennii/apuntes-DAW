/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inmutable;

/**
 *
 * @author maniana
 */
import aguadulce.Dado;
import java.util.Scanner;

public class TrabajoDado {

    public static void main(String[] args) {
//        Dado dado1 = new Dado();
//        EJERCICIOS DEL 1 Y 3
//        int contador = 0 ;
//        String primerLanzamiento, segundoLanzamiento;
//        boolean repetidos;
//        segundoLanzamiento = dado1.lanzar();
//        System.out.println("El resultado del dado es: " + segundoLanzamiento);
//        contador++;
//        do {
//            primerLanzamiento = segundoLanzamiento;
//            segundoLanzamiento = dado1.lanzar();
//            System.out.println("El resultado del dado es: " + segundoLanzamiento);
//            contador++;
//            repetidos = primerLanzamiento.equals("SEIS") && primerLanzamiento == segundoLanzamiento;
//        } while (!repetidos);
//        System.out.println("Se ha lanzado el dado " + contador + " veces.");
//        System.out.println("");
//        System.out.println("Se ha lanzado el dado " + contador + " veces.");
//          EJERCICIO 2
//        System.out.println("");
//        System.out.println("El numero 1 ha salido: "+dado1.getNumeroVecesCara(1)+" veces");
//        System.out.println("El numero 2 ha salido: "+dado1.getNumeroVecesCara(2)+" veces");
//        System.out.println("El numero 3 ha salido: "+dado1.getNumeroVecesCara(3)+" veces");
//        System.out.println("El numero 4 ha salido: "+dado1.getNumeroVecesCara(4)+" veces");
//        System.out.println("El numero 5 ha salido: "+dado1.getNumeroVecesCara(5)+" veces");
//        System.out.println("El numero 6 ha salido: "+dado1.getNumeroVecesCara(6)+" veces");
//          EJERCICIO 4
//        String lanzamiento;
//        int cont, lanzados = 0;
//        boolean todos;
//        do {
//            cont = 0;
//            lanzados++;
//            lanzamiento = dado1.lanzar();
//            System.out.println("Lanzamiento "+lanzados+": "+lanzamiento);
//            for (int i = 1; i < 7; i++) {
//                todos = dado1.getNumeroVecesCara(i)>0;
//                if (todos) {
//                    cont++;
//                }
//            }
//        } while (cont<6);
//        System.out.println("El numero 1 ha salido: "+dado1.getNumeroVecesCara(1)+" veces");
//        System.out.println("El numero 2 ha salido: "+dado1.getNumeroVecesCara(2)+" veces");
//        System.out.println("El numero 3 ha salido: "+dado1.getNumeroVecesCara(3)+" veces");
//        System.out.println("El numero 4 ha salido: "+dado1.getNumeroVecesCara(4)+" veces");
//        System.out.println("El numero 5 ha salido: "+dado1.getNumeroVecesCara(5)+" veces");
//        System.out.println("El numero 6 ha salido: "+dado1.getNumeroVecesCara(6)+" veces");
//          EJERCICIO 5
//        String cadenaLanzamiento;
//        int caras;
//        boolean valido;
//        Scanner teclado = new Scanner(System.in);
//        do{
//        caras = teclado.nextInt();
//        switch (caras){
//            case 4, 6, 8, 12, 20 -> valido = true;
//            default -> valido = false;
//        }
//        }while(!valido);
//        Dado dado2 = new Dado(caras);
//        for (int i = 1; i <= caras; i++) {
//            dado2.lanzar();
//        }
//        cadenaLanzamiento = dado2.getSerieHistoricaLanzamientos();
//        System.out.println(cadenaLanzamiento);
//          EJERCICIO 6
//        int num1, num2, num3;
//        boolean valido;
//        do {
//            num1 = (int) Math.floor((Math.random()*21));
//            switch (num1){
//                case 4: case 6: case 8: case 12: case 20: valido = true; break;
//                default: valido = false;
//            }
//        } while (!valido);
//        do {
//            num2 = (int) Math.floor((Math.random()*20));
//            switch (num2){
//                case 4: case 6: case 8: case 12: case 20: valido = true; break;
//                default: valido = false;
//            }
//        } while (!valido);
//        do {
//            num3 = (int) Math.floor((Math.random()*20));
//            switch (num3){
//                case 4: case 6: case 8: case 12: case 20: valido = true; break;
//                default: valido = false;
//            }
//        } while (!valido);
//        Dado dado1 = new Dado(num1);
//        Dado dado2 = new Dado(num2);
//        Dado dado3 = new Dado(num3);
//        System.out.println("El dado 1 tiene "+num1+" caras");
//        System.out.println("El dado 2 tiene "+num2+" caras");
//        System.out.println("El dado 3 tiene "+num3+" caras");
//        for (int i = 1; i <= num1; i++) {
//            dado1.lanzar();
//        }
//        for (int i = 1; i <= num2; i++) {
//            dado2.lanzar();
//        }
//        for (int i = 1; i <= num3; i++) {
//            dado3.lanzar();
//        }
//        System.out.println("Lanzamientos dado 1: "+dado1.getSerieHistoricaLanzamientos());
//        System.out.println("Lanzamientos dado 2: "+dado2.getSerieHistoricaLanzamientos());
//        System.out.println("Lanzamientos dado 3: "+dado3.getSerieHistoricaLanzamientos());
//          EJERCICIO 7
          Dado dado1 = new Dado(4);
          Dado dado2 = new Dado(6);
          System.out.println("Lanzamientos del primer dado:");
          for (int i = 0; i < 10; i++) {
              System.out.println(dado1.lanzar());
        }
          System.out.println("Numero de veces que salio cada cara:");
          for (int i = 1; i <= dado1.getNumeroCaras(); i++) {
              System.out.println(dado1.getNumeroVecesCara(i));
        }
          System.out.println("Lanzamientos del segundo dado:");
          for (int i = 0; i < 10; i++) {
              System.out.println(dado2.lanzar());
        }
          System.out.println("Numero de veces que salio cada cara:");
          for (int i = 1; i <= dado2.getNumeroCaras(); i++) {
              System.out.println(dado2.getNumeroVecesCara(i));
        }
    
    }

}
