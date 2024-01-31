
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maniana
 */
public class PracticaArray2_1 {

    public static void main(String[] args) {
        final int LARGO = 20;
        
        char lista[];
        int num;
        String resultado = "";
        
        lista = new char[LARGO];
        
        for (int i = 0; i < lista.length; i++) {
            num = (int)(Math.random() * 4);
            
            switch (num) {
                case 1:
                    lista[i] = 'O';
                    break;
                case 2:
                    lista[i] = 'X';
                    break;
                case 3:
                    lista[i] = 'L';
                    break;
                default:
                    lista[i] = 'B';
            }
        }
        for (int i = 1; i < lista.length && !resultado.contains("encontrado"); i++) {
            if (lista[i-1] == 'O' && lista[i] == 'X') {
                resultado = String.format("OX encontrado en la posicion %d\n",
                        i);
            }
        }
        if (resultado.equals("")) {
            for (int i = lista.length-2; i > 0 && !resultado.contains("encontrado"); i--) {
                if (lista[i + 1] == 'O' && lista[i] == 'X') {
                    resultado = String.format("OX encontrado de manera inversa"
                            + "en la posicion %d", i+1);
                }
            }
        }
        if (resultado.equals("")) {
            resultado = "OX no encontrado";
        }
        System.out.println(Arrays.toString(lista));
        System.out.println(resultado);
    }
}
