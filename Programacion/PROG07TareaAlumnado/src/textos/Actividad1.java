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
        List<cesar.TextoEncriptado> lista;
        int contador = 1;
        cesar.TextoEncriptado texto;

        try (FileInputStream file = new FileInputStream("texto_encriptado_entrada.dat"); ObjectInputStream ois = new ObjectInputStream(file) {
        }) {
            lista = (List<TextoEncriptado>) ois.readObject();
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
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Actividad1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
