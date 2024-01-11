package Unidad5;

/**
 *
 * @author maniana
 */
public class Pajaro {

//    ATRIBUTOS DINAMICOS
    private char color;
    private int edad;

//    ATRIBUTOS ESTATICOS
    private static int contador = 0;

//    CONSTRUCTORES
    public Pajaro() {
        nuevoPajaro();
//        ESTE CONSTRUCTOR ESTABLECE EN VALORES POR DEFECTO
    }

    public Pajaro(int edad, char color) {
        this.edad = edad;
        this.color = color;
        nuevoPajaro();
    }

    public Pajaro(int edad) {
        this.edad = edad;
        nuevoPajaro();
    }

    public Pajaro(char color) {
        this.color = color;
        nuevoPajaro();
    }
//    SI QUIERO QUE EL PARAMETRO COINCIDA CON LA EDAD TENGO QUE USAR THIS

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setColor(char c) {
        color = c;
    }

    public int getEdad() {
        return this.edad;
    }

    public char getColor() {
        return this.color;
    }

    private void nuevoPajaro() {
        Pajaro.contador++;
    }

    public static int getNumeroPajaros() {
        return Pajaro.contador;
    }

    public String getColorCompleto() {
        String colorCompleto;
        switch (this.color) {
            case 'v' -> {
                colorCompleto = "verde";
            }
            case 'a' -> {
                colorCompleto = "amarillo";
            }
            case 'n' -> {
                colorCompleto = "negro";
            }
            default -> {
                colorCompleto = "invalido";
            }
        }
        return colorCompleto;
    }

    @Override
    public String toString() {
        return "Pajaro con edad: " + this.edad + " y color: " + this.getColorCompleto();
    }
}
