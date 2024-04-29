/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosunidad8;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matii
 */
public class Ejercicio5 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Persona a = new Persona();
        Persona b = new Persona();
        Persona c = new Persona();
        Persona d = new Persona();

        try (FileOutputStream fos = new FileOutputStream("entrada de personas.bin"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(c);
            oos.writeObject(b);
            oos.writeObject(c);
            oos.writeObject(d);
        } catch (IOException e) {

        }
        Persona aux;
        try (FileInputStream fis = new FileInputStream("entrada de personas.bin"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            while ((aux = (Persona) ois.readObject()) != null){
                System.out.println(aux.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println("fin del programa");
    }
}
