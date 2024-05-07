package bote;
/**
 * Clase principal del proyecto
 * @author maniana
 * @version 1.0
 * @since 05-07-2024
 */
public class Main {

    /**
     * metodo principal donde se ejecuta todo
     * @param args argumentos pasados como parametro
     */
    public static void main(String[] args) {
        Bote bruger;
        int centilitros=300;
        int centimos=200;
        int metros=2;
        
        bruger=new Bote(300,10,"verde",2,500);
       
        opera_Pinta(bruger, metros);
        opera_Rellena(bruger, centilitros, centimos);
    }

    /**
     * metodo que simula la carga de combustible
     * @param bruger objeto bote a usar
     * @param centilitros cantidad de combustible
     * @param centimos importe total
     */
    private static void opera_Rellena(Bote bruger, int centilitros, int centimos) {
        /*Vamos a intentar añadir 300 centilitros al bote, como se supera la capacidad saltará
        una excepción y no se modificará el contenido del depósito que seguirá siendo 280cl*/
        try {
            System.out.println("Vamos a rellenar el bote");
            bruger.rellenar(centilitros, centimos, "verde");
            System.out.println("Recarga realizada, ahora tiene "+bruger.getContenido()+" centilitros en el bote");
        } catch (Exception e) {
            System.out.println("Error al rellenar el bote, el contenido sigue siendo: "+bruger.getContenido());
            
        }
    }

    private static void opera_Pinta(Bote bruger, int metros) {
        /*Vamos a pintar 2 metros, como hay sufuiciente pintura la operación tendrá éxito y se
        descontarán 20 centilitros del contenido del bote, quedan 280cl*/
        try {
            System.out.println("Vamos a pintar");
            bruger.pintar(metros);
            System.out.println("En el bote quedan "+bruger.getContenido()+" centilitros");
        } catch (Exception e) {
            System.out.println("Error al pintar");
        }
    }
    
}
