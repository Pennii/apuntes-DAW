/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionunidad2;

/**
 *
 * @author matii
 */
public class Examen05 {
    public static void main(String[] args) {
        int num = 100;
        while(num>=1){
            System.out.println(num--);
        }
        num = 100;
        do{
            System.out.println(num--);
        }while(num > 0);
        for (num = 100; num > 0; num--) {
            System.out.println(num);
        }
    }
}
