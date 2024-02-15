/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta;

import java.time.LocalDate;

/**
 * simula una cuenta bancaria. realiza consultas, embargos, ingresos,
 * extracciones, y transferencias.
 *
 * @author maniana
 */
public class CuentaBancaria {

    /**
     * cantidad maxima de descubierto
     */
    public static final int MAX_DESCUBIERTO = -2000;
    /**
     * saldo maximo permitido en una cuenta
     */
    public static final double MAX_SALDO = 50000000;
    /**
     * año minimo de creacion de la cuenta
     */
    public static final int MIN_YEAR = 1900;
    /**
     * porcentaje maximo que puede alcanzar el embargo
     */
    public static final double MAX_EMBARGO = 100;
    /**
     * porcentaje minimo del embargo
     */
    public static final double MIN_EMBARGO = 0;
    /**
     * valor predeterminado del saldo
     */
    public static final double DEFAULT_SALDO = 0;
    /**
     * valor predeterminado del descubierto
     */
    public static final int DEFAULT_MAX_DESCUBIERTO = 0;

    private static int identificadorGlobal = 0;
    private static double saldoGlobal;
    private static int numEmbargadas = 0;
    private static LocalDate cuentaNueva = LocalDate.MIN;

    private final int identificador;
    private final LocalDate fechaCreacion;
    private final int limiteDescubierto;

    private double saldoActual;
    private double porcentajeEmbargo;
    private double cantidadTotIngresada;
    private double saldoMaximo;

    /**
     * constructor que inicializa los valores necesarios a su por defecto.
     *
     * @param saldoInicial saldo con el que se crea la cuenta
     * @param fechaCreacion fecha de creacion
     * @param limiteDescubierto limite de descubierto de la cuenta
     * @throws IllegalArgumentException
     */
    public CuentaBancaria(double saldoInicial, LocalDate fechaCreacion,
            int limiteDescubierto) throws IllegalArgumentException {
        if (saldoInicial > CuentaBancaria.MAX_SALDO) {
            throw new IllegalArgumentException("Saldo fuera de limite");
        }
        if (fechaCreacion.getYear() < CuentaBancaria.MIN_YEAR) {
            throw new IllegalArgumentException("Año menor al minimo");
        }
        if (limiteDescubierto < CuentaBancaria.MAX_DESCUBIERTO
                || limiteDescubierto > 0) {
            throw new IllegalArgumentException("limite descubierto fuera de "
                    + "rango");
        }

        this.fechaCreacion = fechaCreacion;
        this.cantidadTotIngresada = saldoInicial;
        this.limiteDescubierto = limiteDescubierto;
        this.porcentajeEmbargo = CuentaBancaria.MIN_EMBARGO;
        this.saldoActual = saldoInicial;
        this.saldoMaximo = saldoInicial;
        this.identificador = CuentaBancaria.identificadorGlobal++;

        if (this.fechaCreacion.isAfter(CuentaBancaria.cuentaNueva)) {
            CuentaBancaria.cuentaNueva = this.fechaCreacion;
        }
    }
    
    /**
     * constructor que usa el de 3 parametros usando los valores por defecto del 
     * descubierto
     * @param saldoInicial saldo inicial de la cuenta
     * @param fechaCreacion fecha de creacion de la cuenta
     */
    public CuentaBancaria(double saldoInicial, LocalDate fechaCreacion){
        this(saldoInicial, fechaCreacion, CuentaBancaria.DEFAULT_MAX_DESCUBIERTO);
    }
}
