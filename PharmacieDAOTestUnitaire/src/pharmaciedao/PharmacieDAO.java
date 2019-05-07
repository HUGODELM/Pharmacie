/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmaciedao;

import Pharmacie.DAO.MedecinDAO;
import Pharmacie.DAO.MedicamentDAO;
import Pharmacie.DAO.PatientDAO;
import Pharmacie.DAO.PrescriptionDAO;
import Pharmacie.metier.Medecin;
import Pharmacie.metier.Medicament;
import Pharmacie.metier.Patient;
import Pharmacie.metier.Prescription;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import myconnections.DBConnection;

/**
 *
 * @author huggy
 */
public class PharmacieDAO {

    Scanner sc = new Scanner(System.in);
    Medicament medactu = null;
    MedicamentDAO meddao = null;
    Medecin medeactu = null;
    MedecinDAO mededao = null;
    Patient patactu = null;
    PatientDAO patdao = null;

    /**
     * constructeur par défaut
     */
    public PharmacieDAO() {

    }

    /**
     * mhétode permettant la gestion de toutes les classes
     *
     * @throws SQLException gère les éventuelles exception sql
     */
    public void gestion() throws SQLException {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");
        meddao = new MedicamentDAO();
        meddao.setConnection(dbConnect);
        mededao = new MedecinDAO();
        mededao.setConnection(dbConnect);
        patdao = new PatientDAO();
        patdao.setConnection(dbConnect);
        int choix = 0;
        do {
            System.out.println("Dans quel menu voulez-vous rentrez? ");
            System.out.println("1.Médicament\n2.Médecin\n3.Patient\n4.fin");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    menuMedoc();
                    break;
                case 2:
                    menuMed();
                    break;
                case 3:
                    menuPat();
                    break;
                case 4:
                    System.out.println("goodbye");
                    break;
                default:
                    System.out.println("numéro incorrect");
            }
        } while (choix != 4);
        DBConnection.closeConnection();
        System.out.println("connection fermée");
    }

    /**
     * méthode permettant l'ajout d'un nouveau médicament dans la base de
     * données grâce a l'appel de la méthode create contenue dans la classe
     * MedicamentDAO
     */
    public void ajout() {
        System.out.print("Nom? ");
        String nom = sc.nextLine();
        System.out.print("Description? ");
        String desc = sc.nextLine();
        System.out.print("Référence? ");
        String ref = sc.nextLine();
        medactu = new Medicament(0, nom, desc, ref);
        try {
            medactu = meddao.create(medactu);
            System.out.println("identifiant du médicament créé: " + medactu.getIDMEDOC());
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
    }

    /**
     * méthode permettant la recherche d'un médicament de la base de données sur
     * base de l'identifiant grâce a l'appel de la méthode read contenue dans la
     * classe MedicamentDAO
     */
    public void recherche() {
        System.out.print("ID recherché? ");
        int ID = sc.nextInt();
        try {
            medactu = meddao.read(ID);
            System.out.println(medactu);
        } catch (SQLException e) {
            System.out.println("erreur: " + e);
        }

    }

    /**
     * méthode permettant la modification d'un médicament de la base de données
     * grâce a l'appel de la méthode update contenue dans la classe
     * MedicamentDAO
     */
    public void modif() {
        System.out.print("ID du médicament à modifier? ");
        int id = sc.nextInt();
        try {
            medactu = meddao.read(id);
            System.out.println("Que voulez-vous modifiez?");
            System.out.println("1.Nom\n2.Description\n3.Référence");
            int choix = sc.nextInt();
            sc.skip("\n");
            switch (choix) {
                case 1:
                    System.out.println("Entrez le nouveau nom");
                    String n = sc.nextLine();
                    medactu.setNOM(n);
                    break;
                case 2:
                    System.out.println("Entrez la nouvelle description");
                    String d = sc.nextLine();
                    medactu.setDESCRIPTION(d);
                    break;
                case 3:
                    System.out.println("Entrez la nouvelle référence");
                    String r = sc.nextLine();
                    medactu.setREFERENCE(r);
                    break;
                default:
                    System.out.println("Veuillez entrer le bon numéro");
            }
            try {
                meddao.update(medactu);
            } catch (SQLException e) {
                System.out.println("erreur " + e);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e);
        }
    }

    /**
     * méthode permettant la suppression d'un médicament de la base de données
     * grâce a l'appel de la méthode delete contenue dans la classe
     * MedicamentDAO
     */
    public void suppression() {
        int choix = 1;
        do {
            System.out.print("ID du médicament à supprimer? ");
            int id = sc.nextInt();
            try {
                medactu = meddao.read(id);
                System.out.println("est-ce le bon médicament?(tapez 0 pour confirmer ou n'importe qu'elle autre chiffre pour saisir un autre identifiant) \n" + medactu);
                choix = sc.nextInt();
                if (choix == 0) {
                    meddao.delete(medactu);
                    System.out.println("Suppression effectuée");
                }

            } catch (SQLException e) {
                System.out.println("erreur " + e);
            }
        } while (choix != 0);
    }

    /**
     * méthode permettant la recherche (sur base d'un mot clé de la description)
     * d'un médicament de la base de données grâce a l'appel de la méthode
     * search contenue dans la classe MedicamentDAO
     *
     * @throws SQLException gère les éventuels exception liées à la base de
     * donnée
     */
    public void rechDesc() throws SQLException {
        System.out.print("Mot clé de la description? ");
        String rech = sc.nextLine();
        List idTab;
        idTab = meddao.search(rech);
        if ((int) idTab.get(0) != 0) {
            for (int i = 0; i < idTab.size(); i++) {
                try {
                    medactu = meddao.read((int) idTab.get(i));
                    System.out.println(medactu);
                } catch (SQLException e) {
                    System.out.println("erreur " + e);
                }
            }
        }

    }

    /**
     * menu s'occupant de la gestion de la table médicament
     *
     * @throws SQLException gère les éventuelles exception liées à la base de
     * données
     */
    public void menuMedoc() throws SQLException {
        int choix;
        System.out.println("MEDICAMENT");
        System.out.println("1.nouveau \n2.recherche médicament\n3.modification\n4.suppression\n5.recherche sur description\n6.retour au menu princpial");
        System.out.print("choix : ");
        choix = sc.nextInt();
        sc.skip("\n");
        switch (choix) {
            case 1:
                ajout();
                break;
            case 2:
                recherche();
                break;
            case 3:
                modif();
                break;
            case 4:
                suppression();
                break;
            case 5:
                rechDesc();
                break;
            case 6:;
                break;
            default:
                System.out.println("numéro incorrect");
        }
    }

    /**
     * menu s'occupant de la gestion de la table médecin
     */
    public void menuMed() {
        System.out.println("MEDECIN");
        int choix;
        System.out.println("1.nouveau \n2.recherche\n3.modification\n4.suppression\n5.retour au menu principal");
        choix = sc.nextInt();
        sc.skip("\n");
        switch (choix) {
            case 1:
                nouvMed();
                break;
            case 2:
                rechMed();
                break;
            case 3:
                modMed();
                break;
            case 4:
                suppressionMed();
                break;
            case 5:;
                break;
            default:
                System.out.println("numéro incorrect");

        }
    }

    /**
     * menu s'occupant de la gestion de la table patient
     */
    public void menuPat() {
        System.out.println("PATIENT");
        sc.skip("\n");
        int choix;
        System.out.println("1.nouveau \n2.recherche\n3.modification\n4.suppression\n5.retour au menu principal");
        choix = sc.nextInt();
        sc.skip("\n");
        switch (choix) {
            case 1:
                creaPat();
                break;
            case 2:
                rechPat();
                break;
            case 3:
                modifPat();
                break;
            case 4:
                supprPat();
                break;
            case 5:;
                break;
            default:
                System.out.println("numéro incorrect");

        }
    }

    /**
     * méthode permettant l'ajout d'un nouveau médecin dans la base de données
     * grâce a l'appel de la méthode create contenue dans la classe MedecinDAO
     */
    public void nouvMed() {
        System.out.print("Nom? ");
        String nom = sc.nextLine();
        System.out.print("Prénom? ");
        String pre = sc.nextLine();
        System.out.print("Matricule? ");
        String mat = sc.nextLine();
        System.out.print("Numéro de téléphone? ");
        String tel = sc.nextLine();
        medeactu = new Medecin(0, mat, nom, pre, tel);
        try {
            medeactu = mededao.create(medeactu);
            System.out.println("identifiant du médecin créé: " + medeactu.getIdmed());
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }

    /**
     * méthode permettant la recherche d'un médecin de la base de données sur
     * base de l'identifiant grâce a l'appel de la méthode read contenue dans la
     * classe MedecinDAO
     */
    public void rechMed() {
        System.out.print("ID recherché? ");
        int ID = sc.nextInt();
        try {
            medeactu = mededao.read(ID);
            System.out.println(medeactu);
        } catch (SQLException e) {
            System.out.println("erreur: " + e);
        }
    }

    /**
     * méthode permettant la modification d'un médecin de la base de données
     * grâce a l'appel de la méthode update contenue dans la classe MedecinDAO
     */
    public void modMed() {
        System.out.print("ID du médecin à modifier? ");
        int id = sc.nextInt();
        try {
            medeactu = mededao.read(id);
            System.out.println("Que voulez-vous modifiez?");
            System.out.println("1.Matricule\n2.Nom\n3.Prénom\n4.Numéro de téléphone");
            int choix = sc.nextInt();
            sc.skip("\n");
            switch (choix) {
                case 1:
                    System.out.println("Entrer le nouveau Matricule");
                    String m = sc.nextLine();
                    medeactu.setMatricule(m);
                    break;
                case 2:
                    System.out.println("Entrer le nouveau nom");
                    String n = sc.nextLine();
                    medeactu.setNom(n);
                    break;
                case 3:
                    System.out.println("Entrer le nouveau prénom");
                    String p = sc.nextLine();
                    medeactu.setPrenom(p);
                    break;
                case 4:
                    System.out.println("Entrer le nouveau numéro de téléphone");
                    String t = sc.nextLine();
                    medeactu.setTel(t);
                    break;
                default:
                    System.out.println("mauvais numéro...");
            }
            try {
                mededao.update(medeactu);
            } catch (SQLException e) {
                System.out.println("erreur " + e);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e);
        }
    }

    /**
     * méthode permettant la suppression d'un médecin de la base de données
     * grâce a l'appel de la méthode delete contenue dans la classe MedecinDAO
     */
    public void suppressionMed() {
        int choix = 1;
        do {
            System.out.print("ID du médecin à supprimer? ");
            int id = sc.nextInt();
            try {
                medeactu = mededao.read(id);
                System.out.println("est-ce le bon médecin?(tapez 0 pour confirmer ou n'importe qu'elle autre chiffre pour saisir un autre identifiant) \n" + medeactu);
                choix = sc.nextInt();
                if (choix == 0) {
                    mededao.delete(medeactu);
                    System.out.println("Suppression effectuée");
                }

            } catch (SQLException e) {
                System.out.println("erreur " + e);
            }
        } while (choix != 0);
    }

    /**
     * méthode permettant la recherche d'un patient de la base de données sur
     * base de l'identifiant grâce a l'appel de la méthode read contenue dans la
     * classe PatientDAO
     */
    public void rechPat() {
        System.out.print("ID recherché? ");
        int ID = sc.nextInt();
        try {
            patactu = patdao.read(ID);
            System.out.println(patactu);
        } catch (SQLException e) {
            System.out.println("erreur: " + e);
        }
    }

    /**
     * méthode permettant l'ajout d'un nouveau patient dans la base de données
     * grâce a l'appel de la méthode create contenue dans la classe PatientDAO
     */
    public void creaPat() {
        System.out.print("Nom? ");
        String nom = sc.nextLine();
        System.out.print("Prénom? ");
        String pre = sc.nextLine();
        System.out.print("Numéro de téléphone? ");
        String tel = sc.nextLine();
        patactu = new Patient(0, nom, pre, tel);
        try {
            patactu = patdao.create(patactu);
            System.out.println("Identifiant du patient créé: " + patactu.getIdpat());
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
    }

    /**
     * * méthode permettant la modification d'un patient de la base de données
     * grâce a l'appel de la méthode update contenue dans la classe PatientDAO
     */
    public void modifPat() {
        System.out.print("ID du patient à modifier? ");
        int id = sc.nextInt();
        try {
            patactu = patdao.read(id);
            System.out.println("Que voulez-vous modifiez?");
            System.out.println("1.Nom\n2.Prénom\n3.Numéro de téléphone");
            int choix = sc.nextInt();
            sc.skip("\n");
            switch (choix) {
                case 1:
                    System.out.println("Entrer le nouveau nom");
                    String n = sc.nextLine();
                    patactu.setNom(n);
                    break;
                case 2:
                    System.out.println("Entrer le nouveau prénom");
                    String p = sc.nextLine();
                    patactu.setPrenom(p);
                    break;
                case 3:
                    System.out.println("Entrer le nouveau numéro de téléphone");
                    String t = sc.nextLine();
                    patactu.setTel(t);
                    break;
                default:
                    System.out.println("mauvais numéro...");
            }
            try {
                patdao.update(patactu);
            } catch (SQLException e) {
                System.out.println("erreur " + e);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e);
        }
    }

    /**
     * méthode permettant la suppression d'un patient de la base de données
     * grâce a l'appel de la méthode delete contenue dans la classe PatientDAO
     */
    public void supprPat() {
        int choix = 1;
        do {
            System.out.print("ID du patient à supprimer? ");
            int id = sc.nextInt();
            try {
                patactu = patdao.read(id);
                System.out.println("est-ce le bon patient?(tapez 0 pour confirmer ou n'importe qu'elle autre chiffre pour saisir un autre identifiant) \n" + patactu);
                choix = sc.nextInt();
                if (choix == 0) {
                    patdao.delete(patactu);
                    System.out.println("Suppression effectuée");
                }

            } catch (SQLException e) {
                System.out.println("erreur " + e);
            }
        } while (choix != 0);
    }

    public static void main(String[] args) throws SQLException {
        //test des méthode d'affichage des prescription lié à un médecin ou un patient
        Scanner sc2 = new Scanner(System.in);
        Patient patactu = null;
        MedecinDAO mededao = null;
        PatientDAO patdao = null;
        Prescription presactu = null;
        PrescriptionDAO presdao = null;
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
        mededao = new MedecinDAO();
        mededao.setConnection(dbConnect);
        presdao = new PrescriptionDAO();
        presdao.setConnection(dbConnect);
        patdao = new PatientDAO();
        patdao.setConnection(dbConnect);

        //TestSearchPat
        System.out.print("Nom du Patient ");
        String rech = sc2.nextLine();
        List idTab;
        idTab = patdao.search(rech);
        try {
            if ((int) idTab.get(0) != 0) {
                presactu = presdao.read((int) idTab.get(0));
                patactu=patdao.read(presactu.getIdpat());
                System.out.println(patactu);
                for (int i = 0; i < idTab.size(); i++) {
                    presactu = presdao.read((int) idTab.get(i));
                    System.out.println(presactu);

                }
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e);
        }
        //TestSearchMed
        System.out.print("Nom du Medecin? ");
        String rech2 = sc2.nextLine();
        List idTab2;
        idTab2 = mededao.search(rech2);
        if ((int) idTab2.get(0) != 0) {
            for (int i = 0; i < idTab2.size(); i++) {
                try {
                    presactu = presdao.read((int) idTab2.get(i));
                    System.out.println(presactu);
                } catch (SQLException e) {
                   System.out.println("erreur " + e);
                }
            }
        }
        PharmacieDAO gstn = new PharmacieDAO();
        gstn.gestion();
    }
}
