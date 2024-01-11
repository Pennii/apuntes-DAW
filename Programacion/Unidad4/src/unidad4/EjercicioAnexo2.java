/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad4;

/**
 *
 * @author matii
 */
public class EjercicioAnexo2 {

    public static void main(String[] args) {
        System.out.println("PALABRAS AL REVES");
        System.out.println("------------------");

        String[] entradas = {"Reconocer",
            "AMANECER",
            "Esto no es un palindromo",
            "Dabale arroz a la zorra el abad.",
            "A man, a plan, a canal: Panama.",
            "A man a plan and a canal, Panama.",
            "No deseo ese don..."};
        String[][] resultados = new String[entradas.length][];
        String[] reversa = new String[entradas.length];
        
        for (int i = 0; i < entradas.length; i++) {
            reversa[i]="";
        }

        System.out.printf("Textos a analizar:\n");
        for (int i = 0; i < entradas.length; i++) {
            System.out.printf("Texto %d: %s\n", i + 1, entradas[i]);
        }

        for (int i = 0; i < entradas.length; i++) {
            entradas[i] = entradas[i].trim().replaceAll("[.,:;]", "");
            resultados[i] = entradas[i].split(" ");
           for(String reves : resultados[i]){
               for (int j = reves.length()-1; j >=0; j--) {
                   reversa[i] += reves.charAt(j);
               }
               reversa[i]+=" ";
           }
        }
        System.out.println("");
        System.out.println("");
        for (String salida : reversa) {
            System.out.println(salida);
        }

    }
}
