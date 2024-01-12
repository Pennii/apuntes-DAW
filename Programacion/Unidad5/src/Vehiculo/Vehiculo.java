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
}
