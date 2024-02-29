/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela;

/**
 *
 * @author maniana
 */
public class TestEscuela {
    
    public static void main(String[] args) {
        
        Alumno alumno = new Alumno(3);
        Alumno alumno2 = new Alumno(6);
        
        Profesor profe = new Profesor();
        
         profe.ponerNotas(alumno);
        
        for (int i = 0; i < alumno.getAsignaturas(); i++) {
            System.out.printf("La nota de la asignatura %d es: %.2f\n",i+1,
                    alumno.getAsig(i).getCalificacion());
        }
        
        System.out.printf("La media de notas es: %.2f\n",profe.calcularMedia(alumno));
        
        for (int i = 0; i < alumno2.getAsignaturas(); i++) {
            System.out.printf("Id de la asignatura %d: %d\n",i+1, alumno2.getAsig(i).getId());
        }
    }
    
}
