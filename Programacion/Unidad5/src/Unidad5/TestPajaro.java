package Unidad5;



/**
 *
 * @author maniana
 */
public class TestPajaro {
    public static void main(String[] args) {
//        TEST PAJARO
        Pajaro p[] = new Pajaro[4];
        p[0] = new Pajaro();
        p[1] = new Pajaro(2, 'a');
        p[2] = new Pajaro(3);
        p[3] = new Pajaro('n');
        
        p[2].setColor('v');
        p[3].setEdad(1);
        
        System.out.printf("edad del pajaro 2: %d\ncolor: %s\n",
                p[1].getEdad(),p[1].getColorCompleto());
//        METODO TOSTRING
        System.out.println(p[2]);
        
        System.out.println(Pajaro.getNumeroPajaros());
    }
   
}
