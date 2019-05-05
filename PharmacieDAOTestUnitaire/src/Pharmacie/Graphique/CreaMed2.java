/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.Graphique;

import Pharmacie.DAO.MedecinDAO;
import Pharmacie.metier.Medecin;
import javax.swing.JOptionPane;

/**
 *
 * @author hugo.delmarche
 */
public class CreaMed2 extends javax.swing.JPanel {

    MedecinDAO meddao = null;
    
    /**
     * Creates new form CreaMed2
     */
    public CreaMed2() {
        initComponents();
        txtIdMed.setEditable(false);
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

        jLabel1 = new javax.swing.JLabel();
        IdMed = new javax.swing.JLabel();
        NomMed = new javax.swing.JLabel();
        PreMed = new javax.swing.JLabel();
        MatMed = new javax.swing.JLabel();
        TelMed = new javax.swing.JLabel();
        txtIdMed = new javax.swing.JTextField();
        txtNomMed = new javax.swing.JTextField();
        txtPreMed = new javax.swing.JTextField();
        txtMatMed = new javax.swing.JTextField();
        txtTelMed = new javax.swing.JTextField();
        btCreaMed = new javax.swing.JButton();
        btRetour = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        IdMed.setText("identifiant");

        NomMed.setText("Nom");

        PreMed.setText("Prénom");

        MatMed.setText("Matricule");

        TelMed.setText("Téléphone");

        txtMatMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatMedActionPerformed(evt);
            }
        });

        btCreaMed.setText("Création");
        btCreaMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreaMedActionPerformed(evt);
            }
        });

        btRetour.setText("Retour");
        btRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IdMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NomMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PreMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MatMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TelMed, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdMed)
                    .addComponent(txtNomMed)
                    .addComponent(txtPreMed)
                    .addComponent(txtMatMed)
                    .addComponent(txtTelMed, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(btCreaMed)
                .addGap(54, 54, 54)
                .addComponent(btRetour)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdMed)
                    .addComponent(txtIdMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomMed)
                    .addComponent(txtNomMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreMed)
                    .addComponent(txtPreMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MatMed)
                    .addComponent(txtMatMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelMed)
                    .addComponent(txtTelMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreaMed)
                    .addComponent(btRetour))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCreaMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreaMedActionPerformed
        try {
            String nom = txtNomMed.getText();
            String prenom = txtPreMed.getText();
            String matricule = txtMatMed.getText();
            String telephone = txtTelMed.getText();
            Medecin med = new Medecin(0, matricule, nom, prenom, telephone);
            med = meddao.create(med);
            txtIdMed.setText("" + med.getIdmed());
            JOptionPane.showMessageDialog(this, "Médecin créé", "succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btCreaMedActionPerformed

    private void txtMatMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatMedActionPerformed

    private void btRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetourActionPerformed

    }//GEN-LAST:event_btRetourActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdMed;
    private javax.swing.JLabel MatMed;
    private javax.swing.JLabel NomMed;
    private javax.swing.JLabel PreMed;
    private javax.swing.JLabel TelMed;
    private javax.swing.JButton btCreaMed;
    private javax.swing.JButton btRetour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtIdMed;
    private javax.swing.JTextField txtMatMed;
    private javax.swing.JTextField txtNomMed;
    private javax.swing.JTextField txtPreMed;
    private javax.swing.JTextField txtTelMed;
    // End of variables declaration//GEN-END:variables
}
