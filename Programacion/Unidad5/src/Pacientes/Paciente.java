/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pacientes;

/**
 *
 * @author maniana
 */
public class Paciente {
    
    private final String nombre;
    private double gastoAcumulado;
    private int numPinchazos;
    
    /**
     * Constructor completo de la clase
     * @param nombre nombre del paciente
     * @param gastoAcumulado gasto que acumula el paciente
     * @param numPinchazos veces que pincharon al paciente
     * @throws IllegalArgumentException 
     */
    public Paciente(String nombre, double gastoAcumulado, int numPinchazos) throws IllegalArgumentException{
        if (gastoAcumulado < 0 || numPinchazos < 0) {
            throw new IllegalArgumentException("Datos iniciales erroneos");
        }
        
        this.nombre = nombre;
        this.gastoAcumulado = gastoAcumulado;
        this.numPinchazos = numPinchazos;
    }
    
    /**
     * devuelve el nombre del paciente
     * @return 
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * devuelve la cantidad de pinchazos
     * @return 
     */
    public int getNumPinchazos(){
        return this.numPinchazos;
    }
    
    /**
     * devuelve el gasto del paciente
     * @return 
     */
    public double getGastoAcumulado(){
        return this.gastoAcumulado;
    }
    
    /**
     * Actualiza el gasto y pinchazos del paciente. si ambos parametros son 
     * positivos el metodo devolvera true y se actualizaran los datos, sino
     * devolvera false
     * @param numPinchazosHoy
     * @param importePinchazo
     * @return 
     */
    public boolean actualizarGastoAcumulado(int numPinchazosHoy, double importePinchazo){
        boolean resultado;
        if (numPinchazosHoy >= 0 && importePinchazo >= 0) {
            resultado = true;
            
            this.numPinchazos += numPinchazosHoy;
            this.gastoAcumulado += importePinchazo * numPinchazosHoy;
        }else{
            resultado = false;
        }
        
        return resultado;
    }
    
    /**
     * devolvera el tipo de paciente. El tipo dependera del gasto acumulado, los
     * valores son premium (10000), muy interesante (7750), interasnte (4000)
     * o estandar.
     * @return 
     */
    public String tipoPaciente(){
        String tipo;
        double gasto = this.gastoAcumulado;
        if (gasto >= 10000) {
            tipo = "premium";
        }else if (gasto >= 7750) {
            tipo = "Muy interesante";
        }else if (gasto >= 4000) {
            tipo = "interesante";
        }else{
            tipo = "estandar";
        }
        
        return tipo;
    }
    
    public String toString(){
        return String.format("Paciente: %s, número de pinchazos: %d, "
                + "gasto acumulado: %.2f",this.nombre, this.numPinchazos,
                this.gastoAcumulado);
    }
}
