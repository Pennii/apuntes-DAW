/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta;

import java.time.LocalDate;
import java.time.Month;

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
     * constructor que usa el de 2 parametros usando los valores por defecto del
     * descubierto
     *
     * @param saldoInicial saldo inicial de la cuenta
     * @param fechaCreacion fecha de creacion de la cuenta
     */
    public CuentaBancaria(double saldoInicial, LocalDate fechaCreacion) {
        this(saldoInicial, fechaCreacion, CuentaBancaria.DEFAULT_MAX_DESCUBIERTO);
    }

    /**
     * constructor de 1 parametro, usando valores por defecto
     *
     * @param saldoInicial saldo con el que empieza la cuenta
     */
    public CuentaBancaria(double saldoInicial) {
        this(saldoInicial, LocalDate.now(), CuentaBancaria.DEFAULT_MAX_DESCUBIERTO);
    }

    /**
     * constructor sin parametros que solo usa valores por defecto
     */
    public CuentaBancaria() {
        this(CuentaBancaria.DEFAULT_SALDO, LocalDate.now(),
                CuentaBancaria.DEFAULT_MAX_DESCUBIERTO);
    }

    /**
     * metodo para obtener el identificador de la cuenta
     *
     * @return identificador
     */
    public int getId() {
        return this.identificador;
    }

    /**
     * metodo que devuelve el saldo actual de la cuenta
     *
     * @return sueldo
     */
    public double getSaldo() {
        return this.saldoActual;
    }

    /**
     * metodo que devuelve la fecha de creacion de la cuenta
     *
     * @return fecha de creacion
     */
    public LocalDate getFechaCreacion() {
        LocalDate fecha = this.fechaCreacion;
        return fecha;
    }

    /**
     * devuelve el limite de descubierto de la cuenta
     *
     * @return limite de descubierto
     */
    public double getLimiteDescubierto() {
        return this.limiteDescubierto;
    }

    /**
     * devuelve el porcentaje de embargo de la cuenta
     *
     * @return porcentaje de embargo
     */
    public double getPorcentajeEmbargo() {
        return this.porcentajeEmbargo;
    }

    /**
     * indica si la cuenta esta descubierta. si la cuenta tiene un saldo
     * negativo devolvera true, sino false
     *
     * @return estado de la cuenta
     */
    public boolean isDescubierta() {
        boolean descubierta;

        descubierta = this.saldoActual < 0;
        return descubierta;
    }

    /**
     * indica si la cuenta esta embargada o no. si el porcentaje de embargo es
     * mayor a 0, la cuenta esta embargada
     *
     * @return estado de la cuenta
     */
    public boolean isEmbargada() {
        boolean embargo;

        embargo = this.porcentajeEmbargo > 0;
        return embargo;
    }

    /**
     * metodo que devuelve la diferencia de dias entre la fecha actual y la
     * fecha de creacion de la cuenta
     *
     * @return antiguedad de la cuenta
     */
    public int getDiasCuenta() {
        int dias;

        dias = (int) (LocalDate.now().toEpochDay() - this.fechaCreacion.toEpochDay());
        return dias;
    }

    /**
     * devuelve el saldo maximo historico de la cuenta
     *
     * @return saldo maximo
     */
    public double getSaldoMaximo() {
        return this.saldoMaximo;
    }

    /**
     * devuelve el total de euros ingresados a la cuenta
     *
     * @return ingresos totales
     */
    public double getTotalIngresado() {
        return this.cantidadTotIngresada;
    }

    /**
     * devuelve el saldo de todas las cuentas
     *
     * @return saldo global
     */
    public static double getSaldoGlobal() {
        return CuentaBancaria.saldoGlobal;
    }

    /**
     * devuelve la fecha de creacion de la cuenta mas nueva
     *
     * @return fecha de creacion cuenta mas nueva
     */
    public static LocalDate getFechaCreacionMasNueva() {
        return CuentaBancaria.cuentaNueva;
    }

    /**
     * devuelve la cantidad de cuentas que se encuentran embargadas
     *
     * @return numero de cuentas embargadas
     */
    public static int getNumEbargadas() {
        return CuentaBancaria.numEmbargadas;
    }

    /**
     * metodo que establece el porcentaje de embargo de la cuenta
     * @param porcentaje porcentaje a embargar
     * @throws IllegalArgumentException
     * @throws IllegalStateException 
     */
    public void embargar(double porcentaje) throws IllegalArgumentException, IllegalStateException {
        if (porcentaje <= 0 || porcentaje > 100) {
            throw new IllegalArgumentException(String.format("porcentaje "
                    + "de embargo invalido: %.2f", porcentaje));
        }

        if (this.isEmbargada()) {
            throw new IllegalStateException("La cuenta ya esta embargada");
        }

        this.porcentajeEmbargo = porcentaje;
    }
    
    /**
     * desembarga la cuenta
     * @return true si la cuenta tenia porcentaje de embargo, false si no lo tenia
     */
    public boolean desembargar(){
        boolean desembargada;
        
        if (this.porcentajeEmbargo != 0) {
            desembargada = false;
        }else{
            this.porcentajeEmbargo = 0;
            desembargada = true;
        }
        
        return desembargada;
    }
    
}
