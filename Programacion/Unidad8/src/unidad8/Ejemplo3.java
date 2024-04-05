/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad8;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author maniana
 */
public class Ejemplo3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            FileOutputStream file3 = new FileOutputStream("file3.bin");
            DataOutputStream dat = new DataOutputStream(file3);
            FileWriter fw = new FileWriter("file4.bin");
            String texto = "cadena prueba";
            int num = 22;
            dat.writeInt(num);
            
            dat.writeUTF(texto);
            dat.close();
            file3.close();
            
            fw.write("EJEMPLO DE ESCRITURA CON FILEWRITER \n\r");
            fw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
