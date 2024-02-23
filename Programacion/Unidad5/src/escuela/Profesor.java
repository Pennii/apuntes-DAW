/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela;

/**
 *
 * @author maniana
 */
public class Profesor {

    /**
     * Asigna tres notas aleatorias a un alumno
     *
     * @param a alumno
     */
    public void ponerNotas(Alumno a) {
        double nota;
        
        for (int i = 0; i < a.getAsignaturas(); i++) {
               nota = Math.random() * 11;
        nota = nota > 10.0 ? 10.0 : nota;
            a.getAsig(i).setCalificacion(nota);
        }
    }

    public double calcularMedia(Alumno a) {
        double media = 0;
        
        for (int i = 0; i < a.getAsignaturas(); i++) {
            media += a.getAsig(i).getCalificacion();
        }
        
        media = media / a.getAsignaturas();
        
        return media;
    }

}
