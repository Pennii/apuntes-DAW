/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author maniana
 */
public class NewClass {
    public static void main(String[] args) {
        Map<Object, String> mapita = new HashMap<>();
        
        mapita.put(1, "aaa");
        mapita.put("b", "222");
        mapita.put("k", "333");
        mapita.put(3, "bbb");
        
        mapita.entrySet().forEach((m) -> System.out.println(m.getKey()+" : "+m.getValue()));
        Iterator it = mapita.keySet().iterator();
        
        while(it.hasNext()){
            System.out.println(mapita.get(it.next()));
        }
        for (Map.Entry<Object, String> valor : mapita.entrySet()) {
            System.out.println(valor.getKey() + " - " + valor.getValue());
        }
    }
}
