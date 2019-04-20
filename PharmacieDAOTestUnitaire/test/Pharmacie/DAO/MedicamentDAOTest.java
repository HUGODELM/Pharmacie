/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.Infos;
import Pharmacie.metier.Medecin;
import Pharmacie.metier.Medicament;
import Pharmacie.metier.Patient;
import Pharmacie.metier.Prescription;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeString.trim;
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
public class MedicamentDAOTest {

    static Connection dbConnect;

    public MedicamentDAOTest() {
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
     * Test of read method, of class MedicamentDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idmedoc = 0;
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);
        Medicament obj = new Medicament(0, "testNom", "testDesc", "testRef");
        Medicament expResult = instance.create(obj);
        idmedoc = expResult.getIDMEDOC();
        Medicament result = instance.read(idmedoc);
        assertEquals("noms différents", expResult.getNOM(), result.getNOM());
        assertEquals("descriptions différentes", expResult.getDESCRIPTION(), result.getDESCRIPTION());
        assertEquals("références différentes", trim(expResult.getREFERENCE()), trim(result.getREFERENCE()));
        assertEquals("id différents", expResult.getIDMEDOC(), result.getIDMEDOC());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of create method, of class MedicamentDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Medicament obj = new Medicament(0, "testNom", "testDesc", "testRef");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);
        Medicament expResult = new Medicament(0, "testNom", "testDesc", "testRef");
        Medicament result = instance.create(obj);
        assertEquals("Noms différents", expResult.getNOM(), result.getNOM());
        assertEquals("Descriptions différentes", expResult.getDESCRIPTION(), result.getDESCRIPTION());
        assertEquals("Descriptions différentes", trim(expResult.getREFERENCE()), trim(result.getREFERENCE()));
        assertNotEquals("id non généré", expResult.getIDMEDOC(), result.getIDMEDOC());
        int idmedoc = result.getIDMEDOC();
        obj = new Medicament(0, "testNom2", "testDesc2", "testRef");
        try {
            Medicament result2 = instance.create(obj);
            fail("exception de référence unique non déclenchée");
            instance.delete(result2);
        } catch (SQLException e) {
            System.out.println(e);
        }
        instance.delete(result);
    }

    /**
     * Test of update method, of class MedicamentDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Medicament obj = new Medicament(0, "testNom", "testDesc", "testRef");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setNOM("TestNom2");
        obj.setDESCRIPTION("testDesc2");
        obj.setREFERENCE("testRef2");
        Medicament expResult = obj;
        Medicament result = instance.update(obj);
        assertEquals("nom différents", expResult.getNOM(), result.getNOM());
        assertEquals("descriptions différentes", expResult.getDESCRIPTION(), result.getDESCRIPTION());
        assertEquals("références différentes", trim(expResult.getREFERENCE()), trim(result.getREFERENCE()));
        Medicament obj2 = new Medicament(0, "testNom3", "testDesc3", "testRef3");
        obj2 = instance.create(obj2);
        Medicament result2 = obj2;
        try {
            obj2.setREFERENCE("testRef2");
            result = instance.update(obj2);
            fail("exception de réfrence unique non déclenchée");
        } catch (SQLException e) {
            System.out.println("erreur sql: " + e);
        }
        instance.delete(obj);
        instance.delete(obj2);
    }

    /**
     * Test of delete method, of class MedicamentDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Medicament obj = new Medicament(0, "testNom", "testDesc", "testRef");
        MedicamentDAO instance = new MedicamentDAO();
        PrescriptionDAO instance2 = new PrescriptionDAO();
        PatientDAO instance3 = new PatientDAO();
        MedecinDAO instance4 = new MedecinDAO();
        InfosDAO instance5=new InfosDAO();
        instance.setConnection(dbConnect);
        instance2.setConnection(dbConnect);
        instance3.setConnection(dbConnect);
        instance4.setConnection(dbConnect);
        instance5.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIDMEDOC());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
        obj = new Medicament(0, "testNom", "testDesc", "testRef");
        obj = instance.create(obj);
        Medecin obj4 = new Medecin(0, "testMatricule", "testNom", "testPrenom", "testTel");
        Patient obj3 = new Patient(0, "testNom", "testPrenom", "testTel");
        obj3 = instance3.create(obj3);
        obj4 = instance4.create(obj4);
        Prescription obj2 = new Prescription(0, "01/06/94", obj4.getIdmed(), obj3.getIdpat());
        obj2 = instance2.create(obj2);
        Infos obj5=new Infos(0,obj.getIDMEDOC(),obj2.getIdpres(),15,"testunite");
        obj5=instance5.create(obj5);
        instance.delete(obj);
        try {
            instance5.read(obj5.getIdinfos());
            fail("exception de suppression en cascade non effectuée");
        } catch (SQLException e) {
        }
        instance4.delete(obj4);
        instance3.delete(obj3);
        
    }

    /**
     * Test of search method, of class MedicamentDAO.
     */
    @Test
    public void testSearch() throws Exception {
        System.out.println("search");
        Medicament obj1 = new Medicament(0, "TestNom", "TestDescription", "TestRef");
        Medicament obj2 = new Medicament(0, "TestNom2", "TestDescription", "TestRef2");
        String descrech = "TestDescription";
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);
        obj1 = instance.create(obj1);
        obj2 = instance.create(obj2);

        List<Integer> result = instance.search(descrech);
        if (result.size() != 2) {
            fail("record introuvable");
        }
        instance.delete(obj1);
        instance.delete(obj2);
    }

}
