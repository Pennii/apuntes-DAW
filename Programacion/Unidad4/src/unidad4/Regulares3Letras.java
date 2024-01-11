/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author maniana
 */
public class Regulares3Letras {
    public static void main(String[] args) {
        Pattern combinacion = Pattern.compile("[a-zA-Z][\\w.-]{2,14}@[a-zA-Z][a-zA-Z\\d-]{0,59}\\.[a-zA-Z]{2,6}");
        String texto;
        
        Scanner teclado = new Scanner(System.in);
        texto = teclado.nextLine();
        
        Matcher igual = combinacion.matcher(texto); 
        
        if (igual.matches() && !texto.contains("--")) {
            System.out.println("son matches");
        }
    }
}
