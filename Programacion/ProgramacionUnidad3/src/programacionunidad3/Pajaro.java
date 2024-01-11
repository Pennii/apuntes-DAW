package programacionunidad3;

/**
 *
 * @author maniana
 */
public class Pajaro {
//    definicion de atributos

    private static int numP = 0;
    private char color;
    private int edad;

////    definicion de metodos
//    public void setEdad(int e) {
//        edad = e;
//    }
    Pajaro(char c, int e) {
        color = c;
        edad = e;
        numPajaros();
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pajaro other = (Pajaro) obj;
        if (this.color != other.color) {
            return false;
        }
        return this.edad == other.edad;
    }

    public void printEdad() {
        System.out.println("la edad del pajaro es: " + edad);
    }

    public static void numPajaros() {
        numP++;
    }

    public static void printPajaros() {
        System.out.println("en total hay " + numP + " pajaros");
    }

    public void setColor(char c) {
        color = c;
    }

    public void setEdad(int e) {
        edad = e;
    }

    public int getEdad() {
        return edad;
    }

    public char getColor() {

        switch (color) { //verde o amarillo sino invalido
            case 'v' -> {
                System.out.println("verde");
                break;
            }
            case 'a' -> {
                System.out.println("su color es: amarillo");
                break;
            }
            default -> {
                System.out.println("su color es: invalido");
                break;
            }
        }
        return color;
    }
//    public int getEdad(){
//        return edad;
//    }
//    el main

    public static void main(String[] args) {
        Pajaro pajarito = new Pajaro('v', 5);
        Pajaro pajarito1 = new Pajaro('v', 3);
        Pajaro pajarito2 = new Pajaro('v', 5);
        pajarito.getColor();
        System.out.println(pajarito.equals(pajarito2));
        printPajaros();
        switch (pajarito.getEdad()) {
            case 3 -> System.out.println("hola");
            case 5 -> System.out.println("adios");
            default -> System.out.println("default");
        }
        switch (pajarito1.getEdad()) {
            case 3 -> System.out.println("hola");
            case 5 -> System.out.println("adios");
            default -> System.out.println("default");
        }
    }
    
}
