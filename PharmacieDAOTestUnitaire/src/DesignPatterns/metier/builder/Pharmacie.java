/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.builder;

import DesignPatterns.metier.Infos;
import DesignPatterns.metier.Medecin;
import DesignPatterns.metier.Medicament;
import DesignPatterns.metier.Patient;

/**
 *
 * @author hugo.delmarche
 */
public class Pharmacie {

    public static void main(String[] args) {
        Patient p = new Patient(1, "NomP", "PrenomP", "TelP");
        Medecin m = new Medecin(1, "MatM", "NomM", "PrenomM", "TelM");
        String date = "02/02/02";
        Medicament medoc = new Medicament(1, "NomMedoc", "DescMedoc", "RefMedoc");
        Infos inf = new Infos(1, 20, "UniteIfos", medoc);

        try {
            Prescription.PrescriptionBuilder pb= new Prescription.PrescriptionBuilder();
            pb.setDate(date).
                    setIdpres(1).
                    setM(m).
                    setP(p).
                    AddInfo(inf);
            Prescription pres=pb.Build();
            System.out.println("Prescription:\n"+pres);
        } catch (Exception e) {
            System.out.println("erreur de création " + e);
        }

    }
}
