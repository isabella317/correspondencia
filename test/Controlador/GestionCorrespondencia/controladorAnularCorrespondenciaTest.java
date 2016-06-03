/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.GestionCorrespondencia;

import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ISABELLA
 */
public class controladorAnularCorrespondenciaTest {
    
    public controladorAnularCorrespondenciaTest() {
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
     * Test of actionPerformed method, of class controladorAnularCorrespondencia.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        controladorAnularCorrespondencia instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compararFechas method, of class controladorAnularCorrespondencia.
     */
    @Test
    public void testCompararFechas() {
        System.out.println("compararFechas");
        Date actual = null;
        Date ingresado = null;
        boolean expResult = false;
        boolean result = controladorAnularCorrespondencia.compararFechas(actual, ingresado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeStringADate method, of class controladorAnularCorrespondencia.
     */
    @Test
    public void testDeStringADate() {
        System.out.println("DeStringADate");
        String fecha = "";
        Date expResult = null;
        Date result = controladorAnularCorrespondencia.DeStringADate(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarFilas method, of class controladorAnularCorrespondencia.
     */
    @Test
    public void testBorrarFilas() {
        System.out.println("borrarFilas");
        int InFilas = 0;
        DefaultTableModel model = null;
        controladorAnularCorrespondencia instance = null;
        instance.borrarFilas(InFilas, model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelarCorrespondencia method, of class controladorAnularCorrespondencia.
     */
    @Test
    public void testCancelarCorrespondencia() {
        System.out.println("cancelarCorrespondencia");
        controladorAnularCorrespondencia instance = null;
        instance.cancelarCorrespondencia();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistros method, of class controladorAnularCorrespondencia.
     */
    @Test
    public void testGetRegistros() {
        System.out.println("getRegistros");
        String fechaInicial = "";
        String fechaFinal = "";
        controladorAnularCorrespondencia instance = null;
        instance.getRegistros(fechaInicial, fechaFinal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
