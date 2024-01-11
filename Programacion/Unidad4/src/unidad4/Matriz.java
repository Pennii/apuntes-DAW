/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

/**
 *
 * @author maniana
 */
public class Matriz {
    public static void main(String[] args) {
        int[][] numeros = new int[3][3];
       
        for (int i = (numeros.length-1); i >= 0; i--) {
            for (int j = (numeros[i].length-1); j >= 0; j--) {
                numeros[i][j]=(int)(Math.random()*8+7);
            }
        }
        
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.printf("%2d ",numeros[i][j]);
            }
            System.out.printf("\n");
        }
      
    }
   
}
