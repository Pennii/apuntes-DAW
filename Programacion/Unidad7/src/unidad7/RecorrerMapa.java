/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author maniana
 */
public class RecorrerMapa {

    public static void main(String[] args) {
        Map<Integer, Integer> mapa = new HashMap<>();
        
        for (int i = 0; i < 10; i++) {
            mapa.put(i, i+10);
        }
        
        System.out.println("Recorrido de mapa con for each");
        for(Integer num : mapa.keySet()){
            System.out.printf("clave: %d, valor: %d\n",num, mapa.get(num));
        }
        System.out.println("------------------");
        
        System.out.println("Recorrido de mapa con iterador");
        Iterator<Integer> it = mapa.keySet().iterator();
        while(it.hasNext()){
            Integer num = it.next();
            System.out.printf("clave: %d, valor: %d\n",num, mapa.get(num));
        }
        System.out.println("------------------");
        
        System.out.println("Recorrido de mapa con entrySet() y for each");
        for(Map.Entry<Integer, Integer> entrada : mapa.entrySet()){
            System.out.println(entrada);
            System.out.printf("clave: %d, valor: %d\n",entrada.getKey(), entrada.getValue());
        }
        System.out.println("------------------");
        
        System.out.println("Recorrido de mapa usando entrySet() e iterador");
        Iterator<Map.Entry<Integer, Integer>> ite = mapa.entrySet().iterator();
        while(ite.hasNext()){
            Map.Entry<Integer, Integer> entrada = ite.next();
            System.out.println(entrada);
            System.out.printf("clave: %d, valor: %d\n",entrada.getKey(), entrada.getValue());
        }
        System.out.println("------------------");
    }
}
