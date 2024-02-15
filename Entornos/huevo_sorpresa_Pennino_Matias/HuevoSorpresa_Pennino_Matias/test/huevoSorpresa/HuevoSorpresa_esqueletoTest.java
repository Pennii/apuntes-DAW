/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package huevoSorpresa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maniana
 */
public class HuevoSorpresa_esqueletoTest {

    public HuevoSorpresa_esqueletoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sacarHuevosSorpresas method, of class HuevoSorpresa_esqueleto.
     */
    @Test
    public void testSacarHuevosSorpresasUnidadesLimiteInfValido() throws Exception {
        System.out.println("sacarHuevosSorpresas valor limite inferior valido");
        int unidades = 1;
        double dinero = 20.0;
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto(5, 20, "pollito", 360);
        try {
            instance.sacarHuevosSorpresas(unidades, dinero);
            assertTrue(instance.obtenerUnidades() == 4);
        } catch (Exception e) {
            fail("no deberia saltar excepcion");
        }
    }

    /**
     * Test of sacarHuevosSorpresas method, of class HuevoSorpresa_esqueleto.
     */
    @Test
    public void testSacarHuevosSorpresasUnidadesLimiteSupValido() throws Exception {
        System.out.println("sacarHuevosSorpresas valor limite superior valido unidades");
        int unidades = 5;
        double dinero = 100.0;
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto(5, 20, "pollito", 360);
        try {
            instance.sacarHuevosSorpresas(unidades, dinero);
            assertTrue(instance.obtenerUnidades() == 0);
        } catch (Exception e) {
            fail("no deberia saltar excepcion");
        }
    }

    /**
     * Test of sacarHuevosSorpresas method, of class HuevoSorpresa_esqueleto.
     */
    @Test
    public void testSacarHuevosSorpresasDineroLimiteInfValido() throws Exception {
        System.out.println("sacarHuevosSorpresas valor limite inferior valido dinero");
        int unidades = 2;
        double dinero = 40;
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto(5, 20, "pollito", 360);
        try {
            instance.sacarHuevosSorpresas(unidades, dinero);
            assertTrue(instance.obtenerUnidades() == 3);
        } catch (Exception e) {
            fail("no deberia saltar excepcion");
        }
    }

    /**
     * Test of sacarHuevosSorpresas method, of class HuevoSorpresa_esqueleto.
     */
    @Test
    public void testSacarHuevosSorpresasDineroSuperior() throws Exception {
        System.out.println("sacarHuevosSorpresas valor superior de  dinero");
        int unidades = 2;
        double dinero = 400;
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto(5, 20, "pollito", 360);
        try {
            instance.sacarHuevosSorpresas(unidades, dinero);
            assertTrue(instance.obtenerUnidades() == 3);
        } catch (Exception e) {
            fail("no deberia saltar excepcion");
        }
    }

    /**
     * Test of sacarHuevosSorpresas method, of class HuevoSorpresa_esqueleto.
     */
    @Test
    public void testSacarHuevosSorpresasUnidadesInfInvalido() throws Exception {
        System.out.println("sacarHuevosSorpresas valor inferior al limite invalido unidades");
        int unidades = 0;
        double dinero = 400;
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto(6, 5, "gallito", 360);
        try {
            instance.sacarHuevosSorpresas(unidades, dinero);
            fail("deberia saltar excepcion");
        } catch (Exception e) {

            assertTrue(instance.obtenerUnidades() == 6);
        }
    }

    /**
     * Test of sacarHuevosSorpresas method, of class HuevoSorpresa_esqueleto.
     */
    @Test
    public void testSacarHuevosSorpresasUnidadesSupInvalido() throws Exception {
        System.out.println("sacarHuevosSorpresas valor superior al limite invalido unidades");
        int unidades = 7;
        double dinero = 400;
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto(6, 5, "gallito", 360);
        try {
            instance.sacarHuevosSorpresas(unidades, dinero);
            fail("deberia saltar excepcion");
        } catch (Exception e) {

            assertTrue(instance.obtenerUnidades() == 6);
        }
    }

    /**
     * Test of sacarHuevosSorpresas method, of class HuevoSorpresa_esqueleto.
     */
    @Test
    public void testSacarHuevosSorpresasDineroInfInvalido() throws Exception {
        System.out.println("sacarHuevosSorpresas valor inferior al limite invalido dinero");
        int unidades = 3;
        double dinero = 14.99;
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto(6, 5, "gallito", 360);
        try {
            instance.sacarHuevosSorpresas(unidades, dinero);
            fail("deberia saltar excepcion");
        } catch (Exception e) {

            assertTrue(instance.obtenerUnidades() == 6);
        }
    }
    
    /**
     * Test of sacarHuevosSorpresas method, of class HuevoSorpresa_esqueleto.
     */
    @Test
    public void testSacarHuevosSorpresasDineroInvalidoNegativo() throws Exception {
        System.out.println("sacarHuevosSorpresas valor negativo invalido dinero");
        int unidades = 3;
        double dinero = -8;
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto(6, 5, "gallito", 360);
        try {
            instance.sacarHuevosSorpresas(unidades, dinero);
            fail("deberia saltar excepcion");
        } catch (Exception e) {

            assertTrue(instance.obtenerUnidades() == 6);
        }
    }
    
    /**
     * Test of sacarHuevosSorpresas method, of class HuevoSorpresa_esqueleto.
     */
    @Test
    public void testSacarHuevosSorpresasUnidadesInvalidoNegativo() throws Exception {
        System.out.println("sacarHuevosSorpresas valor negativo invalido unidades");
        int unidades = -1;
        double dinero = 5;
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto(6, 5, "gallito", 360);
        try {
            instance.sacarHuevosSorpresas(unidades, dinero);
            fail("deberia saltar excepcion");
        } catch (Exception e) {

            assertTrue(instance.obtenerUnidades() == 6);
        }
    }

}
