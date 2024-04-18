package textos;

import cesar.TextoEncriptado;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actividad2 {

    /**
     * Método principal
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) {
        List<cesar.TextoEncriptado> lista;

        try (FileInputStream file = new FileInputStream("texto_encriptado_entrada.dat"); ObjectInputStream ois = new ObjectInputStream(file); FileWriter escri = new FileWriter("texto_en_claro_salida.txt"); PrintWriter pw = new PrintWriter(escri){
        }) {
            lista = (List<TextoEncriptado>) ois.readObject();
            for (TextoEncriptado textoEncriptado : lista) {
                String textoDesen = textoEncriptado.descifradoCesar().trim();
                pw.printf("%s\n",textoDesen);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Actividad1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        }
    }
}
