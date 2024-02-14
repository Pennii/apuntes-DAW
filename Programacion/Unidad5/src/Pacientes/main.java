/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pacientes;

/**
 *
 * @author maniana
 */
public class main {

    public static void main(String[] args) {
        try {
            Paciente paciente1 = new Paciente("Julio Guevara", 0, -8);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al ingresar paciente");
        }

        Paciente paciente2 = new Paciente("Fulgencio Pérez", 5, 1);
        Paciente paciente3 = new Paciente("Julián Piqueras Gómez", 0, 0);

        System.out.println(paciente2.toString());
        System.out.println(paciente3.toString());

        paciente3.actualizarGastoAcumulado(2, 7025.50);
        System.out.println(paciente3.toString());

        paciente2.actualizarGastoAcumulado(5, 76.87);
        System.out.println(paciente2.toString());

        System.out.printf("El tipo de paciente de: %s es %s\n",
                paciente2.getNombre(), paciente2.tipoPaciente());
        System.out.printf("El tipo de paciente de: %s es %s\n",
                paciente3.getNombre(), paciente3.tipoPaciente());
    }
}
