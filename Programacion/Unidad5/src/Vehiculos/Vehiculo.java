package Vehiculos;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author maniana
 */
public class Vehiculo {

//  atributos de clase constantes
    public static final double CAP_MIN = 10.0; //capacidad minima de un tanque
    public static final double CAP_MAX = 150.0; //capacidad max de un tanque
    public static final double CONS_MIN = 1.0; //consumo medio minimo por 100km
    public static final double CONS_MAX = 18.0; //consumo medio max por 100km
    public static final LocalDate FECHA_MIN = LocalDate.of(1920, 1, 1);
    //Fecha minima de una matricula
    public static final String FORM_MAT = "[0-9]{4}[B-DF-HJ-NPR-TV-Z]{3}";
    //Formato de una matricula

//  atributos de clase
    private static double kilTot; //kilometros recorridos por todos los vehiculos
    private static short prendidos; //numero de vehiculos encendidos actualmente
    private static short numVehi; //numero de vehiculos creados

//  atributos de objeto constantes
    private final double CAPACIDAD; //capacidad del tanque
    private final String MATRICULA; //matricula del vehiculo
    private final LocalDate FECHA_MATR; //fecha en la que se emitio la matricula
    private final double CONS_MED; //media de consumo de combustible del vehiculo

//  atributos de objeto
    private boolean motorEncendido; //si el motor esta encendido o no 
    private double distTot; //distancia total recorrida por el vehiculo
    private double distRec; //distancia recorrida en su ultimo encendido
    private double nivelTan; //litros de combustible en el tanque

    /**
     * constructor con 4 parametros
     * @param cap
     * @param mat
     * @param cons
     * @param fec
     * @throws IllegalArgumentException 
     */
    public Vehiculo(double cap, String mat, double cons, LocalDate fec)throws IllegalArgumentException {
        /*Constructor de vehiculo que recibe la capacidad del tanque, la matricula,
        el consumo medio y la fecha de matriculacion
        */
        if (cap > CAP_MAX || cap < CAP_MIN) {
            throw new IllegalArgumentException("capacidad del tanque fuera de rango");
        }
        
        if (!mat.matches(FORM_MAT)) {
            throw new IllegalArgumentException("formato de la matricula invalido");
        }
        
        if (fec.isAfter(LocalDate.now()) || fec.isBefore(FECHA_MIN)) {
            throw new IllegalArgumentException("fecha invalida");
        }
        
        if (cons > CONS_MAX || cons < CONS_MIN) {
            throw new IllegalArgumentException("consumo medio invalido");
        }
        
        this.CAPACIDAD = cap;
        this.MATRICULA = mat;
        this.FECHA_MATR = fec;
        this.CONS_MED = cons;
    }
    
    /**
     * constructor con 1 parametro y 3 defaults
     * @param cap
     * @throws IllegalArgumentException 
     */
    public Vehiculo(double cap) throws IllegalArgumentException{
        this(cap, "1234BBB", 15, LocalDate.now());
    }
    
    public Vehiculo(Vehiculo v) throws NullPointerException{
        this(v.CAPACIDAD, v.MATRICULA, v.CONS_MED, v.FECHA_MATR);
    }
   
    public static double getKilTot() {
        return Vehiculo.kilTot;
    }

    public static short getPrendidos() {
        return Vehiculo.prendidos;
    }

    public static short getNumVehi() {
        return Vehiculo.numVehi;
    }

    public double getNivelDeposito() {
        return this.nivelTan;
    }
    
    public LocalDate getFechaMat(){
        return this.FECHA_MATR;
    }
    
    public double getCapacidad(){
        return this.CAPACIDAD;
    }
    
    public String getMatricula(){
        return this.MATRICULA;
    }
    
    public double getConsMed(){
        return this.CONS_MED;
    }
    
    public double getDistTot(){
        return this.distTot;
    }
    
    public double getDistRec(){
        return this.distRec;
    }

    public void arrancar() throws IllegalStateException { //vuelve true el estado del motor
        if (this.motorEncendido) {
            throw new IllegalStateException("Vehiculo ya encendido");
        }

        if (this.nivelTan == 0) {
            throw new IllegalStateException("Vehiculo sin combustible");
        }
        this.motorEncendido = true;
        prendidos++;
        this.distRec = 0;

    }

    public void parar() throws IllegalStateException { //vuelve false el estado del motor
        if (!this.motorEncendido) {
            throw new IllegalStateException("Motor ya apagado");
        }

        this.motorEncendido = false;
        prendidos--;
    }

    private boolean isEncendido() { //devuelve el estado del motor
        return this.motorEncendido;
    }

    public void cargar(double a) throws IllegalArgumentException, IllegalStateException {
        /*verifica si se puede cargar combustible, si
        puede, lo hace*/
        double carga, exceso;
        if (this.motorEncendido) {
            throw new IllegalStateException("Motor encendido no se puede cargar");
        }
        if (a < 0) {
            throw new IllegalArgumentException(
                    String.format("Cantidad invalida: %.2f", a));
        }

        if (a + this.nivelTan <= this.CAPACIDAD) {
            this.nivelTan += a;
        } else {
            carga = this.nivelTan + a;
            this.nivelTan = this.CAPACIDAD;
            exceso = carga - this.nivelTan;

            throw new IllegalStateException(String.format(
                    "Cantidad excesiva: %.2f", exceso));
        }

    }

    public double recorrerTrayecto(double km) throws IllegalArgumentException, IllegalStateException {
        /*Se calcula cuanto combustible se necesita para recorrer la distancia
        indicada y se evalua si es posible el trayecto
         */
        double combustibleNec, distancia;
        if (km < 0) {
            throw new IllegalArgumentException(String.format(
                    "Cantidad invalida de kilometros: %.2f", km));
        }

        if (!this.motorEncendido) {
            throw new IllegalStateException("Vehiculo apagado");
        }

        combustibleNec = this.nivelTan / this.CONS_MED;
        distancia = km;
        /*Si la cantidad de combustible no es suficiente se recorre menos distancia
        y el motor se apaga
         */
        if (this.nivelTan < combustibleNec) {
            distancia = this.nivelTan * this.CONS_MED;
            this.motorEncendido = false;
            prendidos--;
        }
        /*Se actualizan los valores de kilometros y combustible*/
        this.distTot += distancia;
        this.distRec = distancia;
        kilTot += distancia;
        this.nivelTan -= this.CONS_MED * distancia;

        return distancia;
    }

    public double recorrerTrayecto(double tiempo, double velocidad) throws
            IllegalStateException, IllegalArgumentException{
        /*Se calcula la distancia en base a los parametros dados y se llama al
        metodo con el parametro de distancia
         */
        double dist, recorrido;

        if (tiempo < 0) {
            throw new IllegalArgumentException("Tiempo invalido: " + tiempo);
        }

        if (velocidad < 0) {
            throw new IllegalArgumentException("Velocidad invalida: " + velocidad);
        }
        if (this.motorEncendido) {
            throw new IllegalStateException("Vehiculo apagado");
        }

        dist = tiempo * velocidad;

        recorrido = this.recorrerTrayecto(dist);
        return recorrido;
    }

    public String toString() {
        /*Devolvera el estado del motor, el combustible y
        cuantos kilometros recorrio desde que se encendio por ultima vez
         */
        return String.format("Motor: %s, Combustible: %.2f, Kilometros: %.2f",
                this.motorEncendido ? "encendido" : "apagado", this.nivelTan,
                this.distRec);
    }
}
