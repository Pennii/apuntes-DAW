/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author matii
 */
public class Ejercicio7 {
    public static void main(String[] args) {
        int[][] lista;
        int filas, cols;
        
        try(FileInputStream file = new FileInputStream("recursos/bidimensional.bin");
                DataInputStream ds = new DataInputStream(file)){
            filas = ds.readInt();
            cols = ds.readInt();
            
            lista = new int[filas][cols];
            
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < cols; j++) {
                    lista[i][j] = ds.readInt();
                }
            }
            
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(lista[i][j]+" ");
                }
                System.out.println("");
            }
            
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }
}
