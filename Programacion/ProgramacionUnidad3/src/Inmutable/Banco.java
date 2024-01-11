package Inmutable;

import aguadulce.CuentaBancaria;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
//      Punto 1:
        CuentaBancaria cuentaPrivada;
        CuentaBancaria cuentaConjunta;
        CuentaBancaria cuentaFamiliar;
//--------------------------------------------------------------
//      Punto 2:
        try {
            cuentaPrivada = new CuentaBancaria(1000,
                    LocalDate.of(20237, Month.MARCH, 15),
                    -200);
        } catch (IllegalArgumentException ex) {

            System.out.println(ex.getMessage());
        }

        cuentaPrivada = new CuentaBancaria(1000, LocalDate.of(2021, Month.JULY, 1), -200);

        cuentaConjunta = new CuentaBancaria(200,
                LocalDate.of(2021, Month.JULY, 1));

        cuentaFamiliar = new CuentaBancaria();
//        ----------------------------------------
//      Punto 3:
        System.out.println("CUENTA PRIVADA:");
        System.out.println("id: " + cuentaPrivada.getId());
        System.out.println("Fecha creacion: " + cuentaPrivada.getFechaCreacion());
        System.out.printf("Limite descubierto: %.2f %n", cuentaPrivada.getLimiteDescubierto());
        System.out.println("¿Esta embargada? " + (cuentaPrivada.isEmbargada() ? "SI" : "NO"));
        System.out.println("¿Esta descubierta? " + (cuentaPrivada.isDescubierta() ? "SI" : "NO"));
        System.out.println("Dias abierta: "+cuentaPrivada.getDiasCuenta());
//--------------------------------------------------------------------------
//      Punto 4:
        cuentaFamiliar.ingresar(100.0);
        cuentaConjunta.extraer(100.0);
        cuentaPrivada.transferir(1100, cuentaFamiliar);
//      ----------------------------------------------------------------
//      Punto 5:
        System.out.println("Cuenta privada: "+cuentaPrivada);
        System.out.println("Cuenta conjunta: "+cuentaConjunta);
        System.out.println("Cuenta familiar: "+cuentaFamiliar);

    }
}
