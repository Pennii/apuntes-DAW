/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad8;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 *
 * @author maniana
 */
public class Ejemplo2 {
    public static void main(String[] args) {
        byte cr = 13;
        byte lf = 10;
        
        try {
            FileOutputStream file2 = new FileOutputStream("file2.bin");
            BufferedOutputStream buff1 = new BufferedOutputStream(file2);
            
            buff1.write('h');
            buff1.write('o');
            buff1.write('l');
            buff1.write('a');
            buff1.close();
            file2.close();
          
        } catch (Exception e) {
        }
    }
}
