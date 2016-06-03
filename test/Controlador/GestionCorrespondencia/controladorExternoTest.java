/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.GestionCorrespondencia;

import DAO.Tablas.FuncionarioExterno;
import java.awt.event.ActionEvent;
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
public class controladorExternoTest {
    
    public controladorExternoTest() {
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
     * Test of getFuncionario method, of class controladorExterno.
     */
    @Test
    public void testGetFuncionario() {
        System.out.println("getFuncionario");
        controladorExterno instance = null;
        FuncionarioExterno expResult = null;
        FuncionarioExterno result = instance.getFuncionario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class controladorExterno.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        controladorExterno instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiar method, of class controladorExterno.
     */
    @Test
    public void testLimpiar() {
        System.out.println("limpiar");
        controladorExterno instance = null;
        instance.limpiar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarTabla method, of class controladorExterno.
     */
    @Test
    public void testLlenarTabla() {
        System.out.println("llenarTabla");
        controladorExterno instance = null;
        instance.llenarTabla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarFilas method, of class controladorExterno.
     */
    @Test
    public void testBorrarFilas() {
        System.out.println("borrarFilas");
        int InFilas = 0;
        DefaultTableModel model = null;
        controladorExterno instance = null;
        instance.borrarFilas(InFilas, model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of asignarRemitente method, of class controladorExterno.
     */
    @Test
    public void testAsignarRemitente() {
        System.out.println("asignarRemitente");
        controladorExterno instance = null;
        instance.asignarRemitente();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
