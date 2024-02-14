package cuenta;

/**
 *
 * @author profesora
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta miCuenta;
        double saldoActual;
        int x;
        
        miCuenta = new Cuenta("Antonio Sánchez","1000-2365-85-123456799",4500,0);
        System.out.println("Saldo inicial de la cuenta: "+miCuenta.estado()+"€");
        try 
        {
            x=2300;
            System.out.println("Retirada en cuenta de "+x+"€");
            miCuenta.retirar(x);
        } catch (Exception e)
        {
            System.out.print("Fallo al retirar");
        }
        
        try
        {
            x=200;
            System.out.println("Ingreso en cuenta de "+x+"€");
            miCuenta.ingresar(x);
        } catch (Exception e)
        {
            System.out.print("Fallo al ingresar");
        }
        saldoActual = miCuenta.estado();
        System.out.println("El saldo actual es "+ saldoActual );
    }

}
