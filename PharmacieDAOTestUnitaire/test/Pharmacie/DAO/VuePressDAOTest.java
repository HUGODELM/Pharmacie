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
import Pharmacie.metier.VuePress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class VuePressDAOTest {

    static Connection dbConnect;

    public VuePressDAOTest() {
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
     * Test of read method, of class VuePressDAO.
     */
    //pas terminer
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idpres = 0;
        VuePressDAO instance = new VuePressDAO();
        MedicamentDAO instance2 = new MedicamentDAO();
        PrescriptionDAO instance3 = new PrescriptionDAO();
        PatientDAO instance4 = new PatientDAO();
        MedecinDAO instance5 = new MedecinDAO();
        InfosDAO instance6 = new InfosDAO();
        instance.setConnection(dbConnect);
        instance2.setConnection(dbConnect);
        instance3.setConnection(dbConnect);
        instance4.setConnection(dbConnect);
        instance5.setConnection(dbConnect);
        instance6.setConnection(dbConnect);
        Medicament obj2 = new Medicament(0, "testNom", "testDesc", "testRef");
        instance2.create(obj2);
        Medecin obj5 = new Medecin(0, "testMatricule", "testNom", "testPrenom", "testTel");
        instance5.create(obj5);
        Patient obj4 = new Patient(0, "testNom", "testPrenom", "testTel");
        instance4.create(obj4);
        Prescription obj3 = new Prescription(0, "01/06/94", obj5.getIdmed(), obj4.getIdpat());
        instance3.create(obj3);
        Infos obj6 = new Infos(0, obj2.getIDMEDOC(), obj3.getIdpres(), 15, "testunite");
        instance6.create(obj6);
        String req1 = "create or replace view VPRES2 as select * FROM API_PRESCRIPTION NATURAL JOIN API_INFOS NATURAL JOIN API_MEDICAMENT WHERE IDPRES=?;";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1)) {
            pstm1.setInt(1, obj3.getIdpres());
            int n = 0;
            n = pstm1.executeUpdate();
            if (n == 0) {
                fail("vue non créée");
            }

        } catch (SQLException e) {
        }
        VuePress obj = instance.read(obj3.getIdpres());
        VuePress result = obj;

        assertEquals("idpress différents", obj3.getIdpres(), result.getIdpress());
        assertEquals("idmedoc différents", obj2.getIDMEDOC(), result.getIdmedoc());
        assertEquals("idinfos différents", obj6.getIdinfos(), result.getIdinfo());
        assertEquals("idpat différents", obj4.getIdpat(), result.getIdpat());
        assertEquals("idmed différents", obj5.getIdmed(), result.getIdmed());
        //assertEquals("date différentes", obj3.getDate(), result.getDate());
        assertEquals("quantite différentes", obj6.getQuantite(), result.getQuantite());
        assertEquals("unite différents", obj6.getUnite(), result.getUnite());
        assertEquals("noms différents", obj2.getNOM(), result.getNom());
        assertEquals("descriptions différentes", obj2.getDESCRIPTION(), result.getDesc());
        assertEquals("références différentes", trim(obj2.getREFERENCE()), trim(result.getRef()));
        //TODO régler le probleme de format de date
        instance2.delete(obj2);
        instance4.delete(obj4);
        instance5.delete(obj5);
    }

    /**
     * Test of create method, of class VuePressDAO.
     */
    // @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        VuePress obj = null;
        VuePressDAO instance = new VuePressDAO();
        VuePress expResult = null;
        VuePress result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class VuePressDAO.
     */
    //@Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        VuePress obj = null;
        VuePressDAO instance = new VuePressDAO();
        VuePress expResult = null;
        VuePress result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class VuePressDAO.
     */
    //@Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        VuePress obj = null;
        VuePressDAO instance = new VuePressDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
