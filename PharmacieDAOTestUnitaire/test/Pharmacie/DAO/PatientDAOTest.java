/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.Patient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author huggy
 */
public class PatientDAOTest {
    
    public PatientDAOTest() {
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
     * Test of read method, of class PatientDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idpat = 0;
        PatientDAO instance = new PatientDAO();
        Patient expResult = null;
        Patient result = instance.read(idpat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class PatientDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Patient obj = null;
        PatientDAO instance = new PatientDAO();
        Patient expResult = null;
        Patient result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class PatientDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Patient obj = null;
        PatientDAO instance = new PatientDAO();
        Patient expResult = null;
        Patient result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PatientDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Patient obj = null;
        PatientDAO instance = new PatientDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
