/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author maniana
 */
public class Combinacion {
    
    public static final int TAM = 10;
    
    private final Set<Integer> numeros;
    
    public Combinacion(){
        numeros = new HashSet();
        for (int i = 0; i < TAM; i++) {
            while(!numeros.add((int)(Math.random() * 20 + 1)));
        }
    }
    
    public String toString(){
        String resultado = "Los numeros son: ";
        for (int nums : numeros) {
           resultado = resultado.concat(nums+" ");
        }
        return resultado;
    }
    
    public static void main(String[] args) {
        Combinacion comb1 = new Combinacion();
        Combinacion comb2 = new Combinacion();
        
        System.out.println(comb1.toString());
        System.out.println(comb2.toString());
    }
}

