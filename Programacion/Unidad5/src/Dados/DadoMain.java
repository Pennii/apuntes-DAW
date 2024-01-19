/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dados;

/**
 *
 * @author maniana
 */
public class DadoMain {
    public static void main(String[] args) {
        Dado dado1 = new Dado(20);
        
        for (int i = 0; i < 10; i++) {
            System.out.println(dado1.lanzar());
        }
        System.out.println("");
        
        System.out.println(dado1.toString());
        System.out.printf("cara %d: %d\n",dado1.getNumeroCaras(),dado1.getLanzamientosCara(dado1.getNumeroCaras()));

    }
}
