/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.Observer;

/**
 *
 * @author huggy
 */
public class Pharmacie {

    public static void main(String[] args) {
        Patient p = new Patient(1, "NomP", "PrenomP", "TelP");
        Medecin m = new Medecin(1, "MatM", "NomM", "PrenomM", "TelM");
        Patient p2 = new Patient(1, "NomP2", "PrenomP2", "TelP2");
        Medecin m2= new Medecin(1, "MatM2", "NomM2", "PrenomM2", "TelM2");
        Patient p3 = new Patient(1, "NomP3", "PrenomP3", "TelP3");
        m.AddObserver(p);
        m.AddObserver(p2);
        m2.AddObserver(p3);
        m.setTel("0493218517");
        m2.setTel("0434932185176795024");
    }
}
