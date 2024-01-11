/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

/**
 *
 * @author matii
 */
public class EjercicioAnexo1 {

    public static void main(String[] args) {
        System.out.println("RECONOCIMIENTO DE PALINDROMOS");
        System.out.println("------------------------------");

        String[] entrada = {"Reconocer",
            "AMANECER",
            "Esto no es un palindromo",
            "Dabale arroz a la zorra el abad.",
            "A man, a plan, a canal: Panama.",
            "A man a plan and a canal, Panama.",
            "No deseo ese don..."};
        String[] reves = new String[entrada.length];
        boolean[] palin = new boolean[entrada.length];
        
        System.out.println("Textos a analizar:");
        for (int i = 0; i < entrada.length; i++) {
            System.out.printf("Texto %d: %s\n",(i+1),entrada[i]);
        }
        
        for (int i = 0; i < entrada.length; i++) {
            reves[i]="";
        }
        
        for (int i = 0; i < entrada.length; i++) {
            entrada[i]=entrada[i].replace(",","");
            entrada[i]=entrada[i].replace(".","");
            entrada[i]=entrada[i].replace(" ","");
            entrada[i]=entrada[i].replace(":","");
            entrada[i]=entrada[i].toLowerCase();
            for (int j = entrada[i].length()-1; j >=0; j--) {
                reves[i]+=entrada[i].charAt(j);
            }
            palin[i] = reves[i].equals(entrada[i]);
        }
        System.out.printf("Lista de palindromos:\n");
        for (int i = 0; i < entrada.length; i++) {
            System.out.printf("Entrada %d: %s\n",(i+1),palin[i]);
        }
    }
}
