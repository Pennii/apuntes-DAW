/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 *
 * @author maniana
 */
public class ComputadorVuelo {

    public static final double MAX_ALTURA = 3000;
    public static final double MIN_ALTURA = 1000;
    public static final String MODELO_DEFECTO = "Cessna123";
    public static final String PILOTO_DEFECTO = "Emilio Sanchez";
    public static final String MATRICULA_DEFECTO = "SP-ABC";

    private static int totalAviones = 0;
    private static int totalAvionesVolando = 0;
    private static double totalHorasVuelo = 0;

    private final String matricula;
    private final String modelo;
    private boolean volando;
    private String piloto;
    private int tiempoVuelo;
    private double velocidad;
    private double altitud;

//    CONSTRUCTORES
    /**
     * Constructor de 3 parametros
     *
     * @param matricula matricula del avion
     * @param modelo modelo del avion
     * @param piloto el primer piloto que tendra el avion
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    public ComputadorVuelo(String matricula, String modelo, String piloto) throws NullPointerException, IllegalArgumentException {
        if (matricula == null) {
            throw new NullPointerException("ERROR: MATRICULA NO PUEDE SER NULA");
        }
        if (modelo == null) {
            throw new NullPointerException("ERROR: MODELO NO PUEDE SER NULO");
        }
        if (piloto == null) {
            throw new NullPointerException("ERROR: PILOTO NO PUEDE SER NULO");
        }
        if (matricula.equals("")) {
            throw new IllegalArgumentException("ERROR: MATRICULA NO PUEDE SER "
                    + "UNA CADENA VACIA");
        }
        if (modelo.equals("")) {
            throw new IllegalArgumentException("ERROR: MODELO NO PUEDE SER UNA"
                    + " CADENA VACIA");
        }

        this.matricula = matricula;
        this.modelo = modelo;
        this.piloto = piloto;

        ComputadorVuelo.totalAviones++;
    }

    public ComputadorVuelo(String matricula, String modelo) throws IllegalArgumentException, NullPointerException {
        this(matricula, modelo, ComputadorVuelo.PILOTO_DEFECTO);
    }

    public ComputadorVuelo() {
        this(ComputadorVuelo.MATRICULA_DEFECTO, ComputadorVuelo.MODELO_DEFECTO,
                ComputadorVuelo.PILOTO_DEFECTO);
    }

    public static ComputadorVuelo[] crearArrayComputadorVuelo(int cantidad) throws IllegalArgumentException {
        if (cantidad < 1 || cantidad > 10) {
            throw new IllegalArgumentException(String.format("CANTIDAD INCORRECTA: %s\n", cantidad));
        }

        ComputadorVuelo[] array = new ComputadorVuelo[cantidad];

        for (int i = 0; i < cantidad; i++) {
            array[i] = new ComputadorVuelo();
        }

        return array;
    }

//    METODOS GET
    public String getMatricula() {
        return this.matricula;
    }

    public String getModelo() {
        return this.modelo;
    }

    public boolean getVolando() {
        return this.volando;
    }

    public String getPiloto() {
        return this.piloto;
    }

    public int getTiempoVuelo() {
        return this.tiempoVuelo;
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    public double getAltitud() {
        return this.altitud;
    }

    public static int getNumAviones() {
        return ComputadorVuelo.totalAviones;
    }

    public static int getAvionesVolando() {
        return ComputadorVuelo.totalAvionesVolando;
    }

    public static double getHorasVuelo() {
        return ComputadorVuelo.totalHorasVuelo;
    }

    public static double getAltitudMax() {
        return ComputadorVuelo.MAX_ALTURA;
    }

    public static double getAltitudMin() {
        return ComputadorVuelo.MIN_ALTURA;
    }

    public static String getModeloDefault() {
        return ComputadorVuelo.MODELO_DEFECTO;
    }

    public static String getPilotoDefault() {
        return ComputadorVuelo.PILOTO_DEFECTO;
    }

    public static String getMatriculaDefault() {
        return ComputadorVuelo.MATRICULA_DEFECTO;
    }

//    METODOS SET
    public void setVelocidad(double vel) {
        if (this.volando) {
            this.velocidad = vel;
        }
    }

    public void setAltitud(double alt) {
        if (this.volando) {
            if (alt >= ComputadorVuelo.MIN_ALTURA && alt <= ComputadorVuelo.MAX_ALTURA) {
                this.altitud = alt;
            } else {
                this.altitud = ComputadorVuelo.MIN_ALTURA;
            }
        }
    }

//    RESTO DE METODOS
    /**
     * Metodo que simula el despegue del avion. Establece los valores de
     * velocidad, altitud, y volando. actualiza el atributo global de aviones
     * volando
     *
     * @param vel velocidad del avion
     * @param alt altura a la que volara
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     */
    public void despegar(double vel, double alt) throws IllegalArgumentException, IllegalStateException {
        if (this.volando) {
            throw new IllegalStateException("ERROR: EL AVION YA ESTA VOLANDO");
        }
        if (alt < ComputadorVuelo.MIN_ALTURA || alt > ComputadorVuelo.MAX_ALTURA) {
            throw new IllegalArgumentException("ERROR: LA ALTURA ESTA FUERA DE RANGO");
        }

        this.volando = true;
        this.velocidad = vel;
        this.altitud = alt;
        ComputadorVuelo.totalAvionesVolando++;
    }

    /**
     * Metodo que simula el aterrizaje del avion. Establece los valores de
     * velocidad, altitud, y volando. Actualiza el valor de tiempo de vuelo y
     * cantidad de aviones volando
     *
     * @param tiempo tiempo de vuelo
     * @throws IllegalStateException
     */
    public void aterrizar(int tiempo) throws IllegalStateException {
        if (!this.volando) {
            throw new IllegalStateException("ERROR: EL AVION YA ATERRIZÓ");
        }

        this.altitud = 0;
        this.velocidad = 0;
        ComputadorVuelo.totalHorasVuelo -= this.tiempoVuelo / 60.0;
        this.tiempoVuelo += tiempo;
        ComputadorVuelo.totalHorasVuelo += this.tiempoVuelo / 60.0;
        this.volando = false;
        ComputadorVuelo.totalAvionesVolando--;
    }

    /**
     * Devuelve los datos del avion en ese momento
     *
     * @return Los datos del avion en forma de String
     */
    public String toString() {
        return String.format("Matricula: %s, Modelo: %s, Piloto: %s, volando: "
                + "%s, Tiempo toal: %d, V: %.2f KM/H, Altitud: %.2f metros",
                this.matricula, this.modelo, this.piloto, this.volando,
                this.tiempoVuelo, this.velocidad, this.altitud);
    }
}
