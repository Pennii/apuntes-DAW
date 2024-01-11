/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;
import aguadulce.Dado;
/**
 *
 * @author maniana
 */
public class MatricesEj9 {
    public static void main(String[] args) {
        int[] lanzamientos;
        String lanzamiento;
        
        Dado dado1 = new Dado();
        lanzamientos = new int[dado1.getNumeroCaras()];
        
        for (int i = 0; i < 30; i++) {
            lanzamiento = dado1.lanzar();
            
            switch(lanzamiento){
                case "UNO":{
                    lanzamientos[0]++;
                    break;
                }
                case "DOS":{
                    lanzamientos[1]++;
                    break;
                }
                case "TRES":{
                    lanzamientos[2]++;
                    break;
                }
                case "CUATRO":{
                    lanzamientos[3]++;
                    break;
                }
                case "CINCO":{
                    lanzamientos[4]++;
                    break;
                }
                default:{
                    lanzamientos[5]++;
                }
            }
        }
        
        for (int i = 0; i < lanzamientos.length; i++) {
            System.out.printf("La cara %-2d ha salido %-3d veces\n",i+1,lanzamientos[i]);
        }
    }
}
