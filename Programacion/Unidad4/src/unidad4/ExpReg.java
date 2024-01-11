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
public class ExpReg {
    public static void main(String[] args) {
        Pattern patron = Pattern.compile("([A-Z][a-z]+)+");
        String texto;
        Scanner teclado = new Scanner(System.in);
        texto = teclado.nextLine();
        
        Matcher igual = patron.matcher(texto);
        for (int i = 1; i <= texto.length(); i++) {
          if (igual.find()) {
             int inicio = igual.start();
             int fin = igual.end();
            System.out.printf("""
                              %d. Palabra con mayuscula encontrada en la posicion %d hasta %d: %s
                              """,i,(inicio+1), (fin+1), 
                    texto.substring(inicio, fin));
        }  
        }
     
    }
}
