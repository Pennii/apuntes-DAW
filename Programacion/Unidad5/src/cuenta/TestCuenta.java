/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author matii
 */
public class TestCuenta {
    
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria(0, LocalDate.of(2024, Month.FEBRUARY, 15));
        
        System.out.println(cuenta1.getDiasCuenta());
    }
}
