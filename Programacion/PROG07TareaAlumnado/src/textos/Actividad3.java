package textos;

import cesar.TextoEncriptado;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Actividad3 {

    /**
     * Método principal
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) {
        List<cesar.TextoEncriptado> lista;
        int contador = 1;
        String salida;

        try (FileInputStream file = new FileInputStream("texto_encriptado_entrada.dat"); ObjectInputStream ois = new ObjectInputStream(file); FileWriter fw = new FileWriter("salida_3.txt") {
        }) {
            lista = (List<TextoEncriptado>) ois.readObject();
            salida = String.format("TOTAL DE ORACIONES: %d\n",lista.size());
            System.out.println(salida);
            for(cesar.TextoEncriptado text : lista){
                salida += String.format("oracion %d - %d palabras: %s\n",contador++,text.getTexto().split(" ").length, text.getTexto());
                System.out.printf("oracion %d - %d palabras: %s\n",contador++,text.getTexto().split(" ").length, text.getTexto());
            }
            fw.write(salida);
        } catch (ClassNotFoundException | IOException ex) {

        }
       
    }
}
