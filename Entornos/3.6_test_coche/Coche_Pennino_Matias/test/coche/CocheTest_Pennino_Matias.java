/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package coche;

import junit.framework.TestCase;
import sun.jvm.hotspot.utilities.Assert;

/**
 *
 * @author maniana
 */
public class CocheTest_Pennino_Matias extends TestCase {

    public CocheTest_Pennino_Matias(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of asignarNombre method, of class Coche.
     */
    public void testAsignarNombre() {
        System.out.println("asignarNombre");
        String nom = "";
        Coche instance = new Coche();
        instance.asignarNombre(nom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerNombre method, of class Coche.
     */
    public void testObtenerNombre() {
        System.out.println("obtenerNombre");
        Coche instance = new Coche();
        String expResult = "";
        String result = instance.obtenerNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerStock method, of class Coche.
     */
    public void testObtenerStock() {
        System.out.println("obtenerStock");
        Coche instance = new Coche();
        int expResult = 0;
        int result = instance.obtenerStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test de valores validos para comprar.
     *
     * @throws Exception
     */
    public void testComprarValidos() throws Exception {
        System.out.println("comprar");
        int cantidad = 20;
        Coche instance = new Coche("fiat", 12000.0, 50);
        try {
            instance.comprar(cantidad);
            assertTrue(instance.obtenerStock() == cantidad + 50);
        } catch (Exception e) {
            fail("No debería saltar ninguna excepción");
        }
    }

    /**
     * test de valor valido para comprar en el limite inferior
     *
     * @throws Exception
     */
    public void testComprarValidosLimite() throws Exception {
        System.out.println("comprar con valor limite");
        int cantidad = 1;
        Coche instance = new Coche("fiat", 12000.0, 50);
        try {
            instance.comprar(cantidad);
            assertTrue(instance.obtenerStock() == cantidad + 50);
        } catch (Exception e) {
            fail("No debería saltar ninguna excepción");
        }
    }

    /**
     * test de valor invalido para comprar cantidad negativa
     *
     * @throws Exception
     */
    public void testComprarInvalidosNeg() throws Exception {
        System.out.println("comprar con valor negativo");
        int cantidad = -20;
        Coche instance = new Coche("fiat", 12000.0, 50);
        try {
            instance.comprar(cantidad);
            fail("debe saltar excepción");
        } catch (Exception e) {
            assertTrue(instance.obtenerStock() == 50);
        }
    }

    /**
     * test de valor invalido para comprar cantidad 0
     *
     * @throws Exception
     */
    public void testComprarInvalidos0() throws Exception {
        System.out.println("comprar con valor 0");
        int cantidad = 0;
        Coche instance = new Coche("fiat", 12000.0, 50);
        try {
            instance.comprar(cantidad);
            fail("debe saltar excepción");
        } catch (Exception e) {
            assertTrue(instance.obtenerStock() == 50);
        }
    }

    /**
     * test de valores validos para vender
     *
     * @throws Exception
     */
    public void testVenderValidos() throws Exception {
        System.out.println("vender valido");
        int cantidad = 5;
        Coche instance = new Coche("ford", 5000, 10);

        try {
            instance.vender(cantidad);
        } catch (Exception e) {
            fail("No deberia saltar excepción");
        }
        assertTrue(instance.obtenerStock() == 10 - cantidad);
    }

    /**
     * test de valor valido para vender en el limite superior
     *
     * @throws Exception
     */
    public void testVenderValidosLimiteSuperior() throws Exception {
        //En el limite superior encontraremos la cantidad en stock como valido
        System.out.println("vender valido limite superior");
        int cantidad = 10;
        Coche instance = new Coche("ford", 5000, 10);

        try {
            instance.vender(cantidad);
        } catch (Exception e) {
            fail("No deberia saltar excepción");
        }
        assertTrue(instance.obtenerStock() == 10 - cantidad);
    }

    /**
     * test de valor valido para vender en el limite inferior
     *
     * @throws Exception
     */
    public void testVenderValidosLimiteInferior() throws Exception {
        System.out.println("vender valido limite inferior");
        int cantidad = 1;
        Coche instance = new Coche("ford", 5000, 10);

        try {
            instance.vender(cantidad);
        } catch (Exception e) {
            fail("No deberia saltar excepción");
        }
        assertTrue(instance.obtenerStock() == 10 - cantidad);
    }

    /**
     * test de valor invalido negativo
     *
     * @throws Exception
     */
    public void testVenderInvalidosNegativo() throws Exception {
        System.out.println("vender invalido negativo");
        int cantidad = -16;
        Coche instance = new Coche("ford", 5000, 10);

        try {
            instance.vender(cantidad);
            fail("deberia saltar excepción");
        } catch (Exception e) {
            assertTrue(instance.obtenerStock() == 10);
        }

    }

    /**
     * test de valor invalido 0
     *
     * @throws Exception
     */
    public void testVenderInvalidos0() throws Exception {
        System.out.println("vender invalido 0");
        int cantidad = 0;
        Coche instance = new Coche("ford", 5000, 10);

        try {
            instance.vender(cantidad);
            fail("deberia saltar excepción");
        } catch (Exception e) {
            assertTrue(instance.obtenerStock() == 10 - cantidad);
        }
    }

    /**
     * test de valor invalido sobre el limite
     *
     * @throws Exception
     */
    public void testVenderInvalidosSobreLimite() throws Exception {
        //vender mas de lo que hay en stock deberia ser imposible
        System.out.println("vender invalido sobre el limite");
        int cantidad = 11;
        Coche instance = new Coche("ford", 5000, 10);

        try {
            instance.vender(cantidad);
            fail("deberia saltar excepción");
        } catch (Exception e) {
            assertTrue(instance.obtenerStock() == 10);
        }
    }

}
