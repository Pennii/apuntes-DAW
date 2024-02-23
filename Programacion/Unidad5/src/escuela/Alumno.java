/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela;

/**
 *
 * @author maniana
 */
public class Alumno {

    private Asignatura asigs[];

    
    public Alumno(int cantidad) throws IllegalArgumentException{
        if (cantidad <= 0) {
            throw new IllegalArgumentException("cantidad invalida");
        }
        asigs = new Asignatura[cantidad];
        for (int i = 0; i < asigs.length; i++) {
            asigs[i] = new Asignatura(++Asignatura.ids);
        }
    }

    public Asignatura getAsig(int espacio) {
//        Asignatura asig = new Asignatura(this.asignatura1);
//        return asig;
        return this.asigs[espacio];
    }
    
    public int getAsignaturas(){
        return this.asigs.length;
    }

//    public Asignatura getAsig2() {
////        Asignatura asig = new Asignatura(this.asignatura2);
////        return asig;
//        return this.asignatura2;
//    }
//
//    public Asignatura getAsig3() {
////        Asignatura asig = new Asignatura(this.asignatura3);
////        return asig;
//        return this.asignatura3;
//    }
}
