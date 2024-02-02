/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package coche;

import junit.framework.TestCase;

/**
 *
 * @author maniana
 */
public class CocheTest extends TestCase {
    
    public CocheTest(String testName) {
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
     * Test of comprar method, of class Coche.
     */
    public void testComprar() throws Exception {
        System.out.println("comprar");
        int cantidad = 0;
        Coche instance = new Coche();
        instance.comprar(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vender method, of class Coche.
     */
    public void testVender() throws Exception {
        System.out.println("vender");
        int cantidad = 0;
        Coche instance = new Coche();
        instance.vender(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
