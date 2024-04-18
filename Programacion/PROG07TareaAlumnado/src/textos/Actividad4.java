package textos;

import cesar.TextoEncriptado;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Actividad4 {

    /**
     * Método principal
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) {
        List<TextoEncriptado> lista = new ArrayList<>();
        try (FileReader file = new FileReader("texto_en_claro_salida.txt"); FileOutputStream fileS = new FileOutputStream("salida_4.bin"); ObjectOutputStream oos = new ObjectOutputStream(fileS); BufferedReader bfr = new BufferedReader(file) {
        }) {
            TextoEncriptado encriptado;
            String texto;
            int contador = 1;
            while((texto = bfr.readLine()) != null){
                encriptado = new TextoEncriptado(texto, contador++);
                lista.add(encriptado);
            }
            oos.writeObject(lista);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
