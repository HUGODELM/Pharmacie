/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.Graphique;

import Pharmacie.DAO.PatientDAO;
import Pharmacie.DAO.PrescriptionDAO;
import Pharmacie.metier.Patient;
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
public class RechPatNom extends javax.swing.JPanel {

    Prescription pres;
    PrescriptionDAO presdao = null;
    PatientDAO patdao = null;
    Patient p;
    DefaultTableModel dft1 = new DefaultTableModel();

    /**
     * Creates new form RechPatNom
     */
    public RechPatNom() {
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

    public void setPatdao(PatientDAO patdao) {
        this.patdao = patdao;
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
        TxtNomPat = new javax.swing.JTextField();
        PrePat = new javax.swing.JLabel();
        TelPat = new javax.swing.JLabel();
        IdPat = new javax.swing.JLabel();
        BtRechNomPat = new javax.swing.JButton();

        TabPres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TabPres);

        TxtNomPat.setText("Nom");

        PrePat.setText("Prénom");

        TelPat.setText("Téléphone");

        IdPat.setText("Identifiant");

        BtRechNomPat.setText("Recherche");
        BtRechNomPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRechNomPatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(TxtNomPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(PrePat)
                        .addGap(59, 59, 59)
                        .addComponent(TelPat)
                        .addGap(62, 62, 62)
                        .addComponent(IdPat))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(BtRechNomPat))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNomPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrePat)
                    .addComponent(TelPat)
                    .addComponent(IdPat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtRechNomPat)
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtRechNomPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRechNomPatActionPerformed
        String nom = TxtNomPat.getText();
        List idTab;
        try {
            idTab = patdao.search(nom);
            if ((int) idTab.get(0) != 0) {
                pres = presdao.read((int) idTab.get(0));
                p = patdao.read(pres.getIdpat());
                IdPat.setText(Integer.toString(p.getIdpat()));
                PrePat.setText(p.getPrenom());
                TelPat.setText(p.getTel());
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERREURSQL", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "erreur: "+e.getMessage(), "ERREURPasSQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtRechNomPatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtRechNomPat;
    private javax.swing.JLabel IdPat;
    private javax.swing.JLabel PrePat;
    private javax.swing.JTable TabPres;
    private javax.swing.JLabel TelPat;
    private javax.swing.JTextField TxtNomPat;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}