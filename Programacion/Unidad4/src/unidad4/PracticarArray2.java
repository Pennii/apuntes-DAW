package unidad4;

/**
 *
 * @author maniana
 */
public class PracticarArray2 {

    public static void main(String[] args) {
        int lista[] = {1, 15, 35, 40, 7, 8, 8, 8, 10, 51, 41, 42, 99, 1, 2, 2,
        3, 3}, totDecrece = 0, totRepite = 0;
        
        StringBuilder decrece, repite;
        
        decrece = new StringBuilder();
        repite = new StringBuilder();
        
        for (int i = 1; i < lista.length; i++) {
            if (lista[i] < lista[i-1]) {
                decrece.append(String.format("%2d: %2d -> %2d\n", i, lista[i-1]
                , lista[i]));
                totDecrece++;
            }else if (lista[i] == lista[i-1]) {
                repite.append(String.format("%2d: %2d -> %2d\n",i, lista[i-1],
                        lista[i]));
                totRepite++;
            }
        }
        
        System.out.println("Se decrece en las posiciones: ");
        System.out.printf("%stotal: %d\n",decrece,totDecrece);
        System.out.println("Se repite en las posiciones:");
        System.out.printf("%stotal: %d\n",repite, totRepite);
    }
}
