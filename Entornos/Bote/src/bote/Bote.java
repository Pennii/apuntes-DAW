package bote;

/**
 * Metodo que simula el comportamiento de un bote de pintura
 * @author Pennino Matias
 */
public class Bote {

    /**
     * metodo que permite establecer el valor del contenido del bote
     * @param contenido the contenido to set
     */
    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    /**
     * metodo que devuelve la cantidad de centilitros que consume pintar un metro
     * @return centilitros consumidos por metro
     */
    public int getCentilitros_metro() {
        return centilitros_metro;
    }

    /**
     * metodo que establece el valor de los cetilitros consumidos por metro
     * @param centilitros_metro centilitros consumidos al pintar un metro
     */
    public void setCentilitros_metro(int centilitros_metro) {
        this.centilitros_metro = centilitros_metro;
    }

    /**
     * metodo que devuelve el color de pintura del bote
     * @return color de pintura
     */
    public String getColor() {
        return color;
    }

    /**
     * metodo que establece el color de la pintura del bote
     * @param color nuevo color de pintura
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * metodo que devuelve el valor del bote
     * @return precio del bote
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * metodo que permite establecer el valor del bote
     * @param precio nuevo precio del bote
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * metodo que devuelve la capacidad del bote
     * @return la capacidad del bote
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * metodo que permite establecer la cantidad del bote
     * @param capacidad capacidad maxima del bote
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    private int contenido;//Centilitros de pintura disponibles en el bote
    private int centilitros_metro;//Centrilitros necesarios para pintar un metro cuadrado
    private String color;//Color de la pintura
    private int precio;//Precio en céntimos del centilitro de pintura
    private int capacidad;//Número máximo de centilitros que caben en el bote
    
    /**
     * constructor sin parametros
     */
    public Bote(){}
    
    /**
     * constructor con 5 parametros
     * @param contenido cuanta pintura tiene el bote
     * @param centilitros_metro cuantos centilitros consume por metro
     * @param color color de la pintura
     * @param precio valor del bote
     * @param capacidad capacidad maxima del bote
     */
    public Bote(int contenido, int centilitros_metro, String color,int precio, int capacidad){
    this.contenido=contenido;
    this.centilitros_metro=centilitros_metro;
    this.color=color;
    this.precio=precio;
    this.capacidad=capacidad;
    }

    /**
     * metodo que devuelve el contenido en centilitros del bote
     * @return contenido del bote
     */
    public int getContenido() {
        return contenido;
    }

    

    /**
     * Método que permite pintar una superficie, es necesario que haya suficiente
     * pintura en el bote y que la superficie que se va a pintar sea positiva
     * @param metros metros a pintar
     * @throws Exception si la pintura es insuficiente o los metros son negativos
     */
    public void pintar(int metros) throws Exception{
        if(metros*this.getCentilitros_metro()>this.getContenido())
            throw new Exception("No hay pintura suficiente para pintar esa superficie");
        if(metros<=0)
            throw new Exception("No tiene sentido pintar una superficie que no sea positiva");
        this.setContenido(this.getContenido() - (metros * this.getCentilitros_metro()));
    }

    /**
     * Método que permite aumentar el contenido del bote de pintura, es necesario
     * que la cantidad que se quiere añadir y el dinero con que se va a pagar
     * sean positvos, además el dinero debe ser suficiente para pagar la cantidad
     * que se va a añadir  
     * @param centilitros cantidad de pintura a rellenar
     * @param centimos dinero con el que se pagara 
     * @param color color de pintura
     * @throws Exception si el dinero o los centilitros son negativos o 0, si se
     * quiere llenar mas de lo posible el bote, o si el dinero es insuficiente
     */
    public void rellenar(int centilitros, int centimos, String color) throws Exception{
        if (centimos<=0){
            throw new Exception("Se necesita una cantidad positiva de dinero");
        }
        if (centilitros<=0){
            throw new Exception("Los centilitros deben ser positivos");
        }
    
         if (this.getContenido() + centilitros > getCapacidad()) {
            throw new Exception("No se puede superar la capacidad del bote");
        }
        if (centimos < centilitros * getPrecio()){
            throw new Exception("No tiene dinero suficiente");
         }
        this.setContenido(this.getContenido() + centilitros);
    }
       
}
