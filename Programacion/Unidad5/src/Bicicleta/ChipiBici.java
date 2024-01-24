/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bicicleta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author maniana
 */
public class ChipiBici {

    public static final int VER_MAX = 10;
    public static final int VER_MIN = 1;
    public static final int REV_MAX = 9;
    public static final int REV_MIN = 0;
    public static final double MAX_DIST = 140.0;
    public static final int VER_DEF = VER_MIN;
    public static final int REV_DEF = REV_MIN;
    public static final LocalDate MIN_FECH_ADQ = LocalDate.of(2020, 6, 15);

    private static double kmTotalGlob;
    private static int numSerieGlob = 1;
    private static int totBicis;
    private static int totBicisAlq;

    private final String NUM_SERIE;
    private final LocalDate FECHA_COMPRA;
    private double kmRecorridos;
    private int ver;
    private int rev;
    private boolean alquilada;
    private LocalDateTime fechaHoraAlquiler;
    private double kmRecAlquilerActual;
    private LocalDateTime fechaHoraIniUltAlquiler;
    private LocalDateTime fechaHoraFinUltAlquiler;
    private double kmRecUltAlquiler;

    public ChipiBici(LocalDate fecha, int ver, int rev) throws IllegalArgumentException {
        if (fecha.isBefore(MIN_FECH_ADQ)) {
            throw new IllegalArgumentException(String.format("FECHA INVALIDA: %d/%d/%d", fecha.getDayOfMonth(), fecha.getMonthValue(), fecha.getYear()));
        }
        if (ver < VER_MIN || ver > VER_MAX) {
            throw new IllegalArgumentException(String.format("VERSION INVALIDA: %d", ver));
        }
        if (rev < REV_MIN || rev > REV_MAX) {
            throw new IllegalArgumentException(String.format("REVISION INVALIDA: %d", rev));
        }

        this.FECHA_COMPRA = fecha;
        this.ver = ver;
        this.rev = rev;
        this.fechaHoraAlquiler = null;
        this.fechaHoraFinUltAlquiler = null;
        this.fechaHoraIniUltAlquiler = null;
        this.NUM_SERIE = Integer.toString(numSerieGlob++);
        totBicis++;
    }

    public ChipiBici(int ver, int rev) throws IllegalArgumentException {
        this(LocalDate.now(), ver, rev);
    }

    public ChipiBici() {
        this(LocalDate.now(), VER_DEF, REV_DEF);
    }

    public static ChipiBici[] fabrica(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(String.format("CANTIDAD INVALIDA: %d", num));
        }
        ChipiBici array[] = new ChipiBici[num];
        for (int i = 0; i < array.length; i++) {
            array[i] = new ChipiBici();
        }
        return array;
    }

    public String getNumSerie() {
        return this.NUM_SERIE;
    }

    public LocalDate getFechaCompra() {
        return this.FECHA_COMPRA;
    }

    public int getVersion() {
        return this.ver;
    }

    public int getRevision() {
        return this.rev;
    }

    public String getVerRev() {
        return String.format("%d.%d", this.ver, this.rev);
    }

    public boolean isAlquilada() {
        return this.alquilada;
    }

    public double getKmTot() {
        return this.kmRecorridos;
    }

    public LocalDateTime getRegistroInicioAlquilerActual() {
        return this.fechaHoraAlquiler;
    }

    public double getKmAlquilerActual() {
        return this.kmRecAlquilerActual;
    }

    public LocalDateTime getRegistroInicioUltimoAlquiler() {
        return this.fechaHoraIniUltAlquiler;
    }

    public LocalDateTime getRegistroFinUltimoAlquiler() {
        return this.fechaHoraFinUltAlquiler;
    }

    public double getKmRecUltAlquiler() {
        return this.kmRecUltAlquiler;
    }

    public static int getNumBicis() {
        return ChipiBici.totBicis;
    }

    public static int getNumBicisAlquiladas() {
        return ChipiBici.totBicisAlq;
    }

    public static double getKmGlobales() {
        return ChipiBici.kmTotalGlob;
    }

    public void alquilar() throws IllegalStateException {
        if (this.isAlquilada()) {
            throw new IllegalStateException("BICICLETA ALQUILADA");
        }

        this.alquilada = true;
        this.fechaHoraAlquiler = LocalDateTime.now();
        this.kmRecAlquilerActual = 0.0;
        totBicisAlq++;
    }

    public void devolver() throws IllegalStateException {
        if (!this.isAlquilada()) {
            throw new IllegalStateException("BICICLETA NO ALQUILADA");
        }

        this.alquilada = false;
        this.fechaHoraIniUltAlquiler = this.fechaHoraAlquiler;
        this.fechaHoraFinUltAlquiler = LocalDateTime.now();
        this.fechaHoraAlquiler = null;
        this.kmRecUltAlquiler = this.kmRecAlquilerActual;
        totBicisAlq--;
    }
}
