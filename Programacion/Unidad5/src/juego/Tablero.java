/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author maniana
 */
public class Tablero {
    
    public static void main(String[] args) {
        String tablero[][] = new String[19][19];
        
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19 ; j++) {
                if ((i < 8 || i > 10) && (j < 8 || j > 10)) {
                    tablero[i][j] = " ";
                }else{
                    tablero[i][j] = "*";
                }
            }
        }
        
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
}
