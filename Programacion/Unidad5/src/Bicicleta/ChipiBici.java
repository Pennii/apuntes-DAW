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

    /**
     * constructor de 3 parametros.
     * 
     * constructor con fecha de compra, version y revision, el resto de parametros
     * seran predeterminados
     * @param fecha
     * @param ver
     * @param rev
     * @throws IllegalArgumentException 
     */
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

    /**
     * constructor con dos parametros.
     * 
     * este constructor utiliza la version y revision para establecerlos, el resto
     * de parametros son los default
     * @param ver
     * @param rev
     * @throws IllegalArgumentException 
     */
    public ChipiBici(int ver, int rev) throws IllegalArgumentException {
        this(LocalDate.now(), ver, rev);
    }

    /**
     * constructor sin parametros.
     * 
     * Se utilizaran unicamente los valores predeterminados
     */
    public ChipiBici() {
        this(LocalDate.now(), VER_DEF, REV_DEF);
    }

    /**
     * metodo fabrica
     * 
     * metodo que genera bicis con valores predeterminados en un array
     * @param num
     * @return Array de bicis
     */
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

    /**
     * metodo para obtener el numero de serie
     * @return numero de serie
     */
    public String getNumSerie() {
        return this.NUM_SERIE;
    }

    /**
     * metodo para obtener la fecha de compra
     * @return fecha de compra
     */
    public LocalDate getFechaCompra() {
        return this.FECHA_COMPRA;
    }

    /**
     * metodo para obtener la version
     * @return version 
     */
    public int getVersion() {
        return this.ver;
    }

    /**
     * metodo para obtener la revision
     * @return revision 
     */
    public int getRevision() {
        return this.rev;
    }

    /**
     * metodo que devuelve la version y revision
     * 
     * por ejemplo 1.0
     * @return version y revision 
     */
    public String getVerRev() {
        return String.format("%d.%d", this.ver, this.rev);
    }

    /**
     * metodo que obtiene el alquiler.
     * 
     * si este es false la bici no estara alquilada, si es true, si lo estara
     * @return estado del alquiler 
     */
    public boolean isAlquilada() {
        return this.alquilada;
    }

    /**
     * metodo que devuelve los km recorridos en total por la bici
     * @return kilometros recorridos en total 
     */
    public double getKmTot() {
        return this.kmRecorridos;
    }

    /**
     * 
     * @return fecha y hora del alquiler actual 
     */
    public LocalDateTime getRegistroInicioAlquilerActual() {
        return this.fechaHoraAlquiler;
    }

    /**
     * 
     * @return km recorridos en este alquiler
     */
    public double getKmAlquilerActual() {
        return this.kmRecAlquilerActual;
    }

    /**
     * 
     * @return fecha y hora de inicio del ultimo alquiler 
     */
    public LocalDateTime getRegistroInicioUltimoAlquiler() {
        return this.fechaHoraIniUltAlquiler;
    }

    /**
     * 
     * @return fecha y hora de fin del ultimo alquiler 
     */
    public LocalDateTime getRegistroFinUltimoAlquiler() {
        return this.fechaHoraFinUltAlquiler;
    }

    /**
     * 
     * @return km recorridos en el ultimo alquiler 
     */
    public double getKmRecUltAlquiler() {
        return this.kmRecUltAlquiler;
    }

    /**
     * 
     * @return numero total de bicis creadas 
     */
    public static int getNumBicis() {
        return ChipiBici.totBicis;
    }

    /**
     * 
     * @return numero total de bicis alquiladas 
     */
    public static int getNumBicisAlquiladas() {
        return ChipiBici.totBicisAlq;
    }

    /**
     * 
     * @return km totales recorridos por todas las bicis 
     */
    public static double getKmGlobales() {
        return ChipiBici.kmTotalGlob;
    }

    /**
     * metodo que cambia el valor de alquilada a true
     * @throws IllegalStateException 
     */
    public void alquilar() throws IllegalStateException {
        if (this.isAlquilada()) {
            throw new IllegalStateException("BICICLETA ALQUILADA");
        }

        this.alquilada = true;
        this.fechaHoraAlquiler = LocalDateTime.now();
        this.kmRecAlquilerActual = 0.0;
        totBicisAlq++;
    }

    /**
     * metodo que cambia el valor de alquilada a false
     * @throws IllegalStateException 
     */
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

    /**
     * metodo para actualizar los valores de km
     * 
     * actualiza los valores de la bici y globales en base a la distancia 
     * porporcionada como parametro
     * @param distancia
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalStateException 
     */
    public double recorrerTrayecto(double distancia) throws IllegalArgumentException, IllegalStateException {
        if (distancia < 0 || distancia > MAX_DIST) {
            throw new IllegalArgumentException(String.format(
                    "Distancia invalida %.2f", distancia));
        }
        if (!this.alquilada) {
            throw new IllegalStateException("Bicicleta no alquilada");
        }

        this.kmRecAlquilerActual += distancia;
        this.kmRecorridos += distancia;
        kmTotalGlob += distancia;

        return this.kmRecAlquilerActual;
    }

    /**
     * metodo para actualizar los valores de km
     * 
     * llama al metodo de un parametro utilizando el valor maximo de distancia
     * @return
     * @throws IllegalStateException 
     */
    public double recorrerTrayecto() throws IllegalStateException {
        return this.recorrerTrayecto(MAX_DIST);
    }

    /**
     * metodo que actualiza el frimware
     * @param ver
     * @param rev
     * @throws IllegalArgumentException
     * @throws IllegalStateException 
     */
    public void actualizarFrimware(int ver, int rev) throws IllegalArgumentException, IllegalStateException {
        if (this.alquilada) {
            throw new IllegalStateException("Bicicleta alquilada, imposible actualizar");
        }
        if (ver == this.ver && rev <= this.rev) {
            throw new IllegalArgumentException("se debe actualizar");
        }
        if (ver < this.ver || ver > VER_MAX || ver < VER_MIN) {
            throw new IllegalArgumentException("version invalida");
        }
        if (rev > REV_MAX || ver < VER_MIN) {
            throw new IllegalArgumentException("revision invalida");
        }

        this.ver = ver;
        this.rev = rev;
    }

    /**
     * metodo que actualiza el frimware
     * 
     * utiliza unicamente la version como parametro, la revision sera le default
     * @param ver 
     */
    public void actualizarFrimware(int ver) {
        this.actualizarFrimware(ver, REV_DEF);
    }

    /**
     * metodo que reinicia los valores de la bici a los por defecto
     */
    public void reset() {
        if (this.alquilada) {
            throw new IllegalStateException("Bici alquilada, imposible resetear");
        }
        this.fechaHoraAlquiler = null;
        this.fechaHoraFinUltAlquiler = null;
        this.fechaHoraIniUltAlquiler = null;
        this.kmRecAlquilerActual = 0;
        this.kmRecUltAlquiler = 0;
        this.kmRecorridos = 0;
        this.ver = VER_DEF;
        this.rev = REV_DEF;
    }

    public String toString() {
        String salida;
        if (this.alquilada && this.fechaHoraIniUltAlquiler != null) {
            salida = String.format("{ NS:%s, %d/%d/%d, FW: %s, ALQUILADA, %.2fKM TOTALES;"
                    + "ALQUILER ACTUAL: %d/%d/%d, %d:%d:%d, %.2fKM; ULTIMO ALQUILER:"
                    + "%d/%d/%d, %d:%d:%d, %.2fKM }", this.NUM_SERIE,
                    this.FECHA_COMPRA.getDayOfMonth(), this.FECHA_COMPRA.getMonthValue(),
                    this.FECHA_COMPRA.getYear(), this.getVerRev(),
                    this.kmRecorridos, this.fechaHoraAlquiler.getDayOfMonth(),
                    this.fechaHoraAlquiler.getMonthValue(), this.fechaHoraAlquiler.getYear(),
                    this.fechaHoraAlquiler.getHour(), this.fechaHoraAlquiler.getMinute(),
                    this.fechaHoraAlquiler.getSecond(), this.kmRecAlquilerActual,
                    this.fechaHoraIniUltAlquiler.getDayOfMonth(), this.fechaHoraIniUltAlquiler.getMonthValue(),
                    this.fechaHoraIniUltAlquiler.getYear(), this.fechaHoraIniUltAlquiler.getHour(),
                    this.fechaHoraIniUltAlquiler.getMinute(), this.fechaHoraIniUltAlquiler.getSecond(),
                    this.kmRecUltAlquiler);
        } else if (this.alquilada && this.fechaHoraIniUltAlquiler == null) {
            salida = String.format("{ NS:%s, %d/%d/%d, FW: %s, ALQUILADA, %.2fKM TOTALES;"
                    + "ALQUILER ACTUAL: %d/%d/%d, %d:%d:%d, %.2fKM; ULTIMO ALQUILER:"
                    + "---, ---, %.2fKM }", this.NUM_SERIE,
                    this.FECHA_COMPRA.getDayOfMonth(), this.FECHA_COMPRA.getMonthValue(),
                    this.FECHA_COMPRA.getYear(), this.getVerRev(),
                    this.kmRecorridos, this.fechaHoraAlquiler.getDayOfMonth(),
                    this.fechaHoraAlquiler.getMonthValue(), this.fechaHoraAlquiler.getYear(),
                    this.fechaHoraAlquiler.getHour(), this.fechaHoraAlquiler.getMinute(),
                    this.fechaHoraAlquiler.getSecond(), this.kmRecAlquilerActual);
        } else if (!this.alquilada && this.fechaHoraIniUltAlquiler != null) {
            salida = String.format("{ NS:%s, %d/%d/%d, FW: %s, NO ALQUILADA, %.2fKM TOTALES;"
                    + "ALQUILER ACTUAL: --------; ULTIMO ALQUILER:"
                    + "%d/%d/%d, %d:%d:%d, %.2fKM }", this.NUM_SERIE,
                    this.FECHA_COMPRA.getDayOfMonth(), this.FECHA_COMPRA.getMonthValue(),
                    this.FECHA_COMPRA.getYear(), this.getVerRev(),
                    this.kmRecorridos, this.fechaHoraIniUltAlquiler.getDayOfMonth(), this.fechaHoraIniUltAlquiler.getMonthValue(),
                    this.fechaHoraIniUltAlquiler.getYear(), this.fechaHoraIniUltAlquiler.getHour(),
                    this.fechaHoraIniUltAlquiler.getMinute(), this.fechaHoraIniUltAlquiler.getSecond(),
                    this.kmRecUltAlquiler);
        } else {
            salida = String.format("{ NS:%s, %d/%d/%d, FW: %s, NO ALQUILADA, %.2fKM TOTALES;"
                    + "ALQUILER ACTUAL: ------; ULTIMO ALQUILER:"
                    + "---, --- }", this.NUM_SERIE,
                    this.FECHA_COMPRA.getDayOfMonth(), this.FECHA_COMPRA.getMonthValue(),
                    this.FECHA_COMPRA.getYear(), this.getVerRev(),
                    this.kmRecorridos);
        }
        return salida;
    }
}
