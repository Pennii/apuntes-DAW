/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiante;

/**
 *
 * @author maniana
 */
public class main {

    public static void main(String[] args) {

        try {
            Estudiante erroneo = new Estudiante("error", 0, -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error de datos");
        }
        
        Estudiante estudiante1 = new Estudiante("Antonio Bernal Campillo", 0, 0);
        Estudiante estudiante2 = new Estudiante("Francisco Cucharas Gómez", 2, 1);
    
        System.out.println(estudiante1.toString());
        System.out.println(estudiante2.toString());
        System.out.println("");
        
        estudiante1.actualizarNota(7.7);
        System.out.println(estudiante1.toString());
        System.out.println("");
        
        estudiante2.actualizarNota(7.5);
        System.out.println(estudiante2.toString());
        System.out.println("");
        
        System.out.printf("La calificacion media de %s es: %s\n",
                estudiante1.getNombre(), estudiante1.calificacionMedia());
    }
}
