/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author matii
 */
public class Ejercicio8 {
    public static void main(String[] args) {
        Set<Integer> lista = new HashSet<>();
        int cant = 20;
        
        try(FileOutputStream file = new FileOutputStream("recursos/set.bin");
                DataOutputStream ds = new DataOutputStream(file)){
            for (int i = 0; i < cant; i++) {
                while(lista.add((int)(Math.random()*100+1)));
            }
            
           Iterator<Integer> it = lista.iterator();
           while(it.hasNext()){
               ds.writeInt(it.next());
           }
            
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }
}
