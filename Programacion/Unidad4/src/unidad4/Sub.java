package unidad4;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matii
 */
public class Sub {

    public static void main(String[] args) {
        System.out.println("BUSQUEDA DE SUBCADENA");
        System.out.println("---------------------");

        final String SUBCADENA = "mal";
        Scanner teclado = new Scanner(System.in);
        int contador = 0, posicion;
        System.out.println("Ingresa un texto");
        
        String texto = teclado.nextLine();
        texto = texto.toLowerCase();
        boolean contiene = texto.contains(SUBCADENA);
        
        
        if (contiene) {
            posicion = texto.indexOf(SUBCADENA);
            while  (posicion != -1) {
                contador++;
                System.out.println("El texto contiene la subcadena en la posicion: "+(posicion+1));
                posicion = texto.indexOf(SUBCADENA,posicion+1);
            }
        }
            System.out.println("La subcadena aparace "+contador+" veces");
            
        }
        

    }

