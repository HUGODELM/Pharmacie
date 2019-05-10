/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.Graphique;

import Pharmacie.DAO.MedecinDAO;
import Pharmacie.DAO.PrescriptionDAO;
import Pharmacie.metier.Medecin;
import Pharmacie.metier.Prescription;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huggy
 */
public class RechMedNom extends javax.swing.JPanel {

    Prescription pres;
    PrescriptionDAO presdao = null;
    MedecinDAO meddao = null;
    Medecin med;
    DefaultTableModel dft1 = new DefaultTableModel();

    /**
     * Creates new form RechPatNom
     */
    public RechMedNom() {
        initComponents();
        dft1.addColumn("Id prescription");
        dft1.addColumn("Id patient");
        dft1.addColumn("Id médecin");
        dft1.addColumn("Date prescription");
        TabPres.setModel(dft1);
    }

    public void setPresdao(PrescriptionDAO presdao) {
        this.presdao = presdao;
    }

    public void setMeddao(MedecinDAO meddao) {
        this.meddao = meddao;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabPres = new javax.swing.JTable();
        TxtNomMed = new javax.swing.JTextField();
        PreMed = new javax.swing.JLabel();
        TelMed = new javax.swing.JLabel();
        IdMed = new javax.swing.JLabel();
        MatMed = new javax.swing.JLabel();
        BtRechMedNom = new javax.swing.JButton();

        TabPres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TabPres);

        TxtNomMed.setText("Nom");

        PreMed.setText("Prénom");

        TelMed.setText("Téléphone");

        IdMed.setText("Identifiant");

        MatMed.setText("Matricule");

        BtRechMedNom.setText("Recherche");
        BtRechMedNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRechMedNomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(TxtNomMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(PreMed)
                            .addGap(65, 65, 65)
                            .addComponent(MatMed)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TelMed)
                            .addGap(40, 40, 40)
                            .addComponent(IdMed))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BtRechMedNom)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNomMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreMed)
                    .addComponent(TelMed)
                    .addComponent(IdMed)
                    .addComponent(MatMed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtRechMedNom)
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtRechMedNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRechMedNomActionPerformed
           String nom = TxtNomMed.getText();
        List idTab;
        try {
            idTab = meddao.search(nom);
            if ((int) idTab.get(0) != 0) {
                pres = presdao.read((int) idTab.get(0));
                med = meddao.read(pres.getIdmed());
                IdMed.setText(Integer.toString(med.getIdmed()));
                MatMed.setText(med.getMatricule());
                PreMed.setText(med.getPrenom());
                TelMed.setText(med.getTel());
                for (int i = 0; i < idTab.size(); i++) {
                    Vector v = new Vector();
                    pres = presdao.read((int) idTab.get(i));
                    v.add(pres.getIdpres());
                    v.add(pres.getIdpat());
                    v.add(pres.getIdmed());
                    v.add(pres.getDate());
                    dft1.addRow(v);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Médecin inconnu", "", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERREURSQL", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "erreur: "+e.getMessage(), "ERREURPasSQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtRechMedNomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtRechMedNom;
    private javax.swing.JLabel IdMed;
    private javax.swing.JLabel MatMed;
    private javax.swing.JLabel PreMed;
    private javax.swing.JTable TabPres;
    private javax.swing.JLabel TelMed;
    private javax.swing.JTextField TxtNomMed;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
