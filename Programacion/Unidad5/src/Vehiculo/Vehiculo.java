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
    private double distTot; //distancia total recorrida por el vehiculo
    private double distRec; //distancia recorrida en su ultimo encendido
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

    public boolean arrancar() { //vuelve true el estado del motor
        this.motorEncendido = true;
        return this.motorEncendido;
    }

    public boolean parar() { //vuelve false el estado del motor
        this.motorEncendido = false;
        return this.motorEncendido;
    }

    private boolean isEncendido() { //devuelve el estado del motor
        return this.motorEncendido;
    }

    public void cargar(double a){ /*verifica si se puede cargar combustible, si
        puede, lo hace*/
        if (a + this.nivelTan <= this.CAPACIDAD) {
            this.nivelTan += a;
        }else{
            System.out.println("la cantidad que quieres ingresar supera la "
                    + "capacidad del tanque");   
        }
    }
    
    public void recorrerTrayecto(double km){ /*la distancia indicada es sumada
        a los valores de distancia del objeto y al global*/
        this.distTot += km;
        this.distRec = km;
        kilTot += km;
    }
}
