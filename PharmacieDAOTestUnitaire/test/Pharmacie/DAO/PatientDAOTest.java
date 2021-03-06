/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.Medecin;
import Pharmacie.metier.Patient;
import Pharmacie.metier.Prescription;
import java.sql.Connection;
import java.sql.SQLException;
import myconnections.DBConnection;
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

    static Connection dbConnect;

    public PatientDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
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
        instance.setConnection(dbConnect);
        Patient obj = new Patient(0, "testNom", "testPrenom", "testTel");
        Patient expResult = instance.create(obj);
        idpat = expResult.getIdpat();
        Patient result = instance.read(idpat);
        assertEquals("noms différents", expResult.getNom(), result.getNom());
        assertEquals("prénoms différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("téléphones différentes", expResult.getTel(), result.getTel());
        assertEquals("id différents", expResult.getIdpat(), result.getIdpat());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
            System.out.println("erreur sql: " + e);
        }
        instance.delete(result);
    }

    /**
     * Test of create method, of class PatientDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Patient obj = new Patient(0, "testNom", "testPrenom", "testTel");
        PatientDAO instance = new PatientDAO();
        instance.setConnection(dbConnect);
        Patient expResult = new Patient(0, "testNom", "testPrenom", "testTel");
        Patient result = instance.create(obj);
        assertEquals("noms différents", expResult.getNom(), result.getNom());
        assertEquals("prénoms différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("téléphone différents", expResult.getTel(), result.getTel());
        assertNotEquals("id non généré", expResult.getIdpat(), result.getIdpat());
        int idmedoc = result.getIdpat();
        obj = new Patient(0, "testNom", "testPrenom", "testTel");
        try {
            Patient result2 = instance.create(obj);
            fail("exception de triplet unique(nom/prenom/tel) non déclenchée");
            instance.delete(result2);
        } catch (SQLException e) {
            System.out.println(e);
        }
        instance.delete(result);
    }

    /**
     * Test of update method, of class PatientDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Patient obj = new Patient(0, "testNom", "testPrenom", "testTel");
        PatientDAO instance = new PatientDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setNom("TestNom2");
        obj.setPrenom("testPrenom2");
        obj.setTel("testTel2");
        Patient expResult = obj;
        Patient result = instance.update(obj);
        assertEquals("nom différents", expResult.getNom(), result.getNom());
        assertEquals("prénoms différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("téléphones différents", expResult.getTel(), result.getTel());
        Patient obj2 = new Patient(0, "testNom3", "testDesc3", "testRef3");
        obj2 = instance.create(obj2);
        Patient result2 = obj2;
        try {
            obj2.setNom("TestNom2");
            obj2.setPrenom("testPrenom2");
            obj2.setTel("testTel2");
            result = instance.update(obj2);
            fail("exception triplet unique(nom/prénom/tel) non déclenchée");
        } catch (SQLException e) {
            System.out.println("erreur sql: " + e);
        }
        instance.delete(obj);
        instance.delete(obj2);
    }

    /**
     * Test of delete method, of class PatientDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Patient obj = new Patient(0, "testNom", "testPrenom", "testTel");
        PatientDAO instance = new PatientDAO();
        instance.setConnection(dbConnect);
        MedecinDAO instance3 = new MedecinDAO();
        PrescriptionDAO instance2 = new PrescriptionDAO();
        instance.setConnection(dbConnect);
        instance2.setConnection(dbConnect);
        instance3.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdpat());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
        obj = new Patient(0, "testNom", "testPrenom", "testTel");
        obj = instance.create(obj);
        Medecin obj3 = new Medecin(0, "testMatricule", "testNom", "testPrenom", "testTel");
        obj3=instance3.create(obj3);
        Prescription obj2 = new Prescription(0, "01/06/94", obj3.getIdmed(),obj.getIdpat());
        obj2 = instance2.create(obj2);
        instance.delete(obj);
        try {
            instance2.read(obj2.getIdpres());
            fail(" suppression en cascade non déclenchée");
        } catch (SQLException ex) {

        }
       instance3.delete(obj3);
    }

}
