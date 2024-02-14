/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package cuenta;

import junit.framework.TestCase;

/**
 *
 * @author matii
 */
public class CuentaTest extends TestCase {

    public CuentaTest(String testName) {
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
     * Test valor valido 0.01
     */
    public void testIngresarValido() throws Exception {
        System.out.println("ingresar valido");
        double cantidad = 0.01;
        Cuenta instance = new Cuenta("Raul", "cuenta1", 0.0, 1);
        try {
            instance.ingresar(cantidad);
            assertTrue(instance.estado() == 0.01);
        } catch (Exception e) {
            fail("No deberia saltar excepcion");
        }
    }

    /**
     * test valor invalido 0
     *
     * @throws Exception
     */
    public void testIngresarInvalido0() throws Exception {
        System.out.println("ingresar invalido 0");
        double cantidad = 0.0;
        Cuenta instance = new Cuenta("Raul", "cuenta1", 0.0, 1);
        try {
            instance.ingresar(cantidad);
            fail("Deberia saltar excepcion");

        } catch (Exception e) {
            assertTrue(instance.estado() == 0.0);
        }
    }

    /**
     * test valor invalido negativo
     *
     * @throws Exception
     */
    public void testIngresarInvalidoNegativo() throws Exception {
        System.out.println("ingresar invalido negativo");
        double cantidad = -5.0;
        Cuenta instance = new Cuenta("Raul", "cuenta1", 0.0, 1);
        try {
            instance.ingresar(cantidad);
            fail("Deberia saltar excepcion");

        } catch (Exception e) {
            assertTrue(instance.estado() == 0.0);
        }
    }

    /**
     * Test retirar valor valido 0.01
     * @throws Exception
     */
    public void testRetirarValidoLimiteInf() throws Exception {
        System.out.println("retirar valor valido 0.01");
        double cantidad = 0.01;
        Cuenta instance = new Cuenta("Raul", "cuenta1", 20.0, 1);
        try {
            instance.retirar(cantidad);
        } catch (Exception e) {
            fail("No deberia saltar excepcion");
        }
        assertTrue(instance.estado() == 19.99);
    }

    /**
     * Test retirar valor valido limite
     * @throws Exception
     */
    public void testRetirarValidoLimiteSup() throws Exception {
        System.out.println("retirar valor valido 20");
        double cantidad = 20;
        Cuenta instance = new Cuenta("Raul", "cuenta1", 20.0, 1);
        try {
            instance.retirar(cantidad);
        } catch (Exception e) {
            fail("No deberia saltar excepcion");
        }
        assertTrue(instance.estado() == 0);
    }

    /**
     * Test retirar valor invalido 0
     * @throws Exception
     */
    public void testRetirarInvalido0() throws Exception {
        System.out.println("retirar valor invalido 0");
        double cantidad = 0;
        Cuenta instance = new Cuenta("Raul", "cuenta1", 20.0, 1);
        try {
            instance.retirar(cantidad);
            fail("Deberia saltar excepcion");
        } catch (Exception e) {
            assertTrue(instance.estado() == 20);
        }
    }
    
    /**
     * test retirar valor invalido negativo
     * @throws Exception 
     */
    public void testRetirarInvalidoNegativo() throws Exception {
        System.out.println("retirar valor invalido negativo");
        double cantidad = -10;
        Cuenta instance = new Cuenta("Raul", "cuenta1", 20.0, 1);
        try {
            instance.retirar(cantidad);
            fail("Deberia saltar excepcion");
        } catch (Exception e) {
            assertTrue(instance.estado() == 20);
        }
    }
    
    /**
     * test retirar valor invalido sobre el limite
     * @throws Exception 
     */
    public void testRetirarInvalidoSobreLim() throws Exception {
        System.out.println("retirar valor invalido sobre el limite");
        double cantidad = 20.01;
        Cuenta instance = new Cuenta("Raul", "cuenta1", 20.0, 1);
        try {
            instance.retirar(cantidad);
            fail("Deberia saltar excepcion");
        } catch (Exception e) {
            assertTrue(instance.estado() == 20);
        }
    }
}
