package vehiculo;

import java.time.LocalDate;

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

//  atributos de clase
    private static double kilTot; //kilometros recorridos por todos los vehiculos
    private static short prendidos; //numero de vehiculos encendidos actualmente
    private static short numVehi; //numero de vehiculos creados

//  atributos de objeto constantes
    private final double CAPACIDAD; //capacidad del tanque
    private final String MATRICULA; //matricula del vehiculo
    private final LocalDate FECHA_MATR; //fecha en la que se emitio la matricula

//  atributos de objeto
    private boolean motorEncendido; //si el motor esta encendido o no 
    private double distTot; //combustibleNec total recorrida por el vehiculo
    private double distRec; //combustibleNec recorrida en su ultimo encendido
    private double consumMed; //media de consumo de combustible del vehiculo
    private double nivelTan; //litros de combustible en el tanque

    public Vehiculo() {
        this.CAPACIDAD = 0;
        this.MATRICULA = null;
        this.FECHA_MATR = null;
    }

    public double getNivelDeposito() { //devuelve el nivel de tanque restante
        return this.nivelTan;
    }

    public void arrancar() throws IllegalStateException { //vuelve true el estado del motor
        if (this.motorEncendido) {
            throw new IllegalStateException("Vehiculo ya encendido");
        }

        if (this.nivelTan == 0) {
            throw new IllegalStateException("Vehiculo apagado");
        }
        this.motorEncendido = true;
        prendidos++;

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
                    String.format("Cantidad invalida: %2f", a));
        }

        if (a + this.nivelTan <= this.CAPACIDAD) {
            this.nivelTan += a;
        } else {
            carga = this.nivelTan + a;
            this.nivelTan = this.CAPACIDAD;
            exceso = carga - this.nivelTan;

            throw new IllegalStateException(String.format(
                    "Cantidad excesiva: %2f", exceso));
        }

    }

    public double recorrerTrayecto(double km) throws IllegalArgumentException, IllegalStateException {
        /*Se calcula cuanto combustible se necesita para recorrer la distancia
        indicada y se evalua si es posible el trayecto
        */
        double combustibleNec, distancia;
        if (km < 0) {
            throw new IllegalArgumentException(String.format(
                    "Cantidad invalida de kilometros: %2.f", km));
        }

        if (!this.motorEncendido) {
            throw new IllegalStateException("Vehiculo apagado");
        }
        
        combustibleNec = this.nivelTan / this.consumMed;
        distancia = km;
        /*Si la cantidad de combustible no es suficiente se recorre menos distancia
        y el motor se apaga
        */
        if (this.nivelTan < combustibleNec ) {
            distancia = this.nivelTan * this.consumMed;
            this.motorEncendido = false;
            prendidos--;
        }
        /*Se actualizan los valores de kilometros y combustible*/
        this.distTot += distancia;
        this.distRec = distancia;
        kilTot += distancia;
        this.nivelTan -= this.consumMed * distancia;

        return distancia;
    }
    
    public double recorrerTrayecto(double tiempo, double velocidad) {
        /*Se calcula la distancia en base a los parametros dados y se llama al
        metodo con el parametro de distancia
        */
        double dist, recorrido;
        
        if (tiempo < 0) {
            throw new IllegalArgumentException("Tiempo invalido: "+tiempo);
        }
        
        if (velocidad < 0) {
            throw new IllegalArgumentException("Velocidad invalida: "+velocidad);
        }
        
        dist = tiempo * velocidad;
        
        recorrido = this.recorrerTrayecto(dist);
        return recorrido;
    }

}
