/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author maniana
 */
public class EjHashSet {

    public static void main(String[] args) {
//        Set<String> setNombres = new HashSet<>();
//        Set setNombres = new LinkedHashSet<>();
        Set setNombres = new TreeSet<>();
        setNombres.add("Encarni");
        setNombres.add("Antonio");
//        setNombres.add(null);
        setNombres.add("David");
        setNombres.add("Jose");
        setNombres.add("Antonio");
        setNombres.add(1.0);
//        System.out.println(setNombres.add("David"));
        
        // si no se establece el tipo del objeto se utiliza Object
        for(Object nombres : setNombres){
            System.out.println(nombres);
        }
        
        System.out.println("");
        
        Iterator it = setNombres.iterator();
        
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(setNombres);
    }
}
