/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JuegoAdivinar;

/**
 *
 * @author maniana
 */
public class JuegoAdivinar {

    public static final int LIMITE_MAX_POSIBLE = 40;
    public static final int LIMITE_MAX_INTENTOS = 10;
    public static final int DEFAULT_MAX_VAL_POSIBLE = 10;
    public static final int DEFAULT_LIMITE_MAX_INTENTOS = 5;

    private int numeroSecreto;
    private int intentosActuales;
    private final int MAX_VALOR_POSIBLE;
    private final int MAX_INTENTOS;

    public JuegoAdivinar(int a, int b) throws IllegalArgumentException {
        if (a > LIMITE_MAX_POSIBLE || b > LIMITE_MAX_INTENTOS || a < 0 || b <= 0) {
            throw new IllegalArgumentException("ERROR EN EL INGRESO DE DATOS");
        }

        this.MAX_INTENTOS = b;
        this.MAX_VALOR_POSIBLE = a;
        this.numeroSecreto = (int) (Math.floor(Math.random() * (this.MAX_VALOR_POSIBLE+1)));
    }

    public JuegoAdivinar(int b) throws IllegalArgumentException {
        this(DEFAULT_MAX_VAL_POSIBLE, b);
    }

    public JuegoAdivinar() {
        this(DEFAULT_MAX_VAL_POSIBLE, DEFAULT_LIMITE_MAX_INTENTOS);
    }
    
    public int getIntentosRestantes(){
        return this.MAX_INTENTOS - this.intentosActuales;
    }
    
    public int getMaxValPosible(){
        return this.MAX_VALOR_POSIBLE;
    }
    
    public int adivinarNumero(int num) throws IllegalStateException{
        if (this.MAX_INTENTOS < this.intentosActuales) {
            throw new IllegalStateException("INTENTOS MAXIMOS ALCANZADOS");
        }
        
        int resultado;
        
        if (num > this.numeroSecreto) {
            resultado = - 1;
        }else if (num < this.numeroSecreto) {
            resultado = 1;
        }else{
            resultado = 0;
        }
        this.intentosActuales++;
        return resultado;
    }
}
