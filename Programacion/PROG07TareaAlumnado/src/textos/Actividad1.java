package textos;

import cesar.TextoEncriptado;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actividad1 {

    /**
     * Método principal
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<cesar.TextoEncriptado> lista = null;
        int contador = 1;
        FileInputStream file = null;
        ObjectInputStream ois = null;

        try {
            file = new FileInputStream("texto_encriptado_entrada.dat");
            ois = new ObjectInputStream(file);
            lista = (List<TextoEncriptado>) ois.readObject();

        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println("error");
                }
            }
            if (file != null) {
                try {
                    file.close();
                } catch (IOException ex) {
                    System.out.println("error");
                }
            }
        }

        for (TextoEncriptado textoEncriptado : lista) {

            String salida, textoDesen = textoEncriptado.descifradoCesar().trim();
            int palabras = 1;
            for (int i = 0; i < textoDesen.length(); i++) {
                if (textoDesen.charAt(i) == ' ') {
                    palabras++;
                }
            }

            salida = String.format("ORACION %d - %d palabras: %s", contador++, palabras, textoDesen);
            System.out.println(salida);
        }

    }
}
