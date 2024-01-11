/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;

/**
 *
 * @author matii
 */
public class Ejercicio1Strings {
    public static void main(String[] args) {
//         Programa que reciba un número de DNI y calcule su letra (mediante un "super-switch" con 23 case).

        final int LARGO = 8;
        
        String dni;
             
        int numDni;
        
        char ultima;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.printf("Ingresa tu DNI\n");
        dni = teclado.nextLine();
        } while (!(dni.length()==LARGO));
        
        numDni = Integer.parseInt(dni.substring(0, LARGO));
        
            numDni = numDni%23;
            switch (numDni){
                case 0:{
                    ultima = 'T';
                    break;
                }
                case 1:{
                    ultima = 'R';
                    break;
                }
                case 2:{
                    ultima = 'W';
                    break;
                }
                case 3:{
                    ultima = 'A';
                    break;
                }
                case 4:{
                    ultima = 'G';
                    break;
                }
                case 5:{
                    ultima = 'M';
                    break;
                }
                case 6:{
                    ultima = 'Y';
                    break;
                }
                case 7:{
                    ultima = 'F';
                    break;
                }
                case 8:{
                    ultima = 'P';
                    break;
                }
                case 9:{
                    ultima = 'D';
                    break;
                }
                case 10:{
                    ultima = 'X';
                    break;
                }
                case 11:{
                    ultima = 'B';
                    break;
                }
                case 12:{
                    ultima = 'N';
                    break;
                }
                case 13:{
                    ultima = 'J';
                    break;
                }
                case 14:{
                    ultima = 'Z';
                    break;
                }
                case 15:{
                    ultima = 'S';
                    break;
                }
                case 16:{
                    ultima = 'Q';
                    break;
                }
                case 17:{
                    ultima = 'V';
                    break;
                }
                case 18:{
                    ultima = 'H';
                    break;
                }
                case 19:{
                    ultima = 'L';
                    break;
                }
                case 20:{
                    ultima = 'C';
                    break;
                }
                case 21:{
                    ultima = 'K';
                    break;
                }
                case 22:{
                    ultima = 'E';
                    break;
                }
                default: System.out.println("ERROR");
                ultima = 'i';
            }
             System.out.printf("La ultima letra del dni es la %c\n",ultima);
        
       
       
    }
}
