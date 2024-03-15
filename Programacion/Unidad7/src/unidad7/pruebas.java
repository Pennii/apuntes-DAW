package unidad7;


import java.util.Arrays;
import java.util.Iterator;
import unidad7.Contenedor;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author maniana
 */
public class pruebas {

    public static void main(String[] args) {
        String nombres[] = {"lola", "lala", "lele"};
        Integer lista[] = {1,2,3};
        Contenedor<String> c1 = new Contenedor<>();
        Contenedor<Integer> c2 = new Contenedor<>();
        
        Iterator nums = Arrays.asList(lista).iterator();
        Iterator it = Arrays.asList(nombres).iterator();
//        for (String nombre : nombres) {
//            System.out.println(nombre);
//        }
        
        while (nums.hasNext()) {
            System.out.println(nums.next());
        }
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        c1.setContenido("hola");
        c2.setContenido(2);
        System.out.println(c1+""+c2);
    }
}
