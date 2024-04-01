/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea;

/**
 *
 * @author maniana
 */
public class ejec {

    public static void main(String[] args) {
        try {
            // Obtener la instancia de Runtime
            Runtime runtime = Runtime.getRuntime();

            // Ejecutar el programa especificado
            Process proceso = runtime.exec("C:\\Program Files\\Git\\git-bash.exe");

            // Esperar a que el proceso termine
            proceso.waitFor();

            System.out.println("El programa ha terminado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
