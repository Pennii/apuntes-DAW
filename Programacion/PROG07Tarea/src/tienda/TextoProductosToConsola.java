package tienda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Programa de prueba de carga de productos a partir de un archivo de texto
 */
public class TextoProductosToConsola {

    private static final String NOMBRE_ARCHIVO_ENTRADA_TXT_DEFAULT = "productos_entrada.txt";

    /**
     * Método principal
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) {
        String patron = "[0-9]+::[a-zA-Z]+::[a-zA-Z ]+[0-9]::[0-9]+\\.[0-9]{0,2}",
                leer, conjunto[];
        
        Pattern pat = Pattern.compile(patron);
        List<Producto> lista = new LinkedList<>();
        Matcher match;
        Producto prod;
        
        try(FileReader fr = new FileReader(NOMBRE_ARCHIVO_ENTRADA_TXT_DEFAULT); BufferedReader br = new BufferedReader(fr)){
            while((leer = br.readLine()) != null){
                match = pat.matcher(leer);
                if (match.matches()) {
                    conjunto = leer.split("::");
                    prod = new Producto(conjunto[0], conjunto[1], conjunto[2], Double.parseDouble(conjunto[3]));
                    lista.add(prod);
                }
            }
        }
        catch (FileNotFoundException ex){
            
        }
        catch(IOException ex){
            
        }
        int contador = 1;
        for (Producto producto : lista) {
            System.out.print("producto "+contador++ +": ");
            System.out.println(producto);
            
        }
    }
}
