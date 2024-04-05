/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad8;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author maniana
 */
public class Ejemplo1 {

    public static void main(String[] args) {
        final byte CR = 13; //Salto de linea
        final byte LF = 10; //Retorno de carro

        try {
            FileOutputStream file1 = new FileOutputStream("fich1.bin");
            file1.write('h');
            file1.write('o');
            file1.write('l');
            file1.write('a');
            file1.write(CR);
            file1.write(LF);
            file1.write('a');
            file1.write('d');
            file1.write('i');
            file1.write('o');
            file1.write('s');
            file1.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
