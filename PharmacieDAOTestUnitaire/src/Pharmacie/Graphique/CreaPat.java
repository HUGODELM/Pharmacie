/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.Graphique;

import Pharmacie.DAO.PatientDAO;
import Pharmacie.metier.Patient;
import javax.swing.JOptionPane;

/**
 *
 * @author hugo.delmarche
 */
public class CreaPat extends javax.swing.JPanel {
      PatientDAO patdao = null;
    /**
     * Creates new form CreaMed2
     */
    public CreaPat() {
        initComponents();
        txtIdPat.setEditable(false);
    }
    public void setPatdao(PatientDAO meddao) {
        this.patdao = meddao;
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
        TelPat = new javax.swing.JLabel();
        txtIdPat = new javax.swing.JTextField();
        txtNomPat = new javax.swing.JTextField();
        txtPrePat = new javax.swing.JTextField();
        txtTelPat = new javax.swing.JTextField();
        btCreaPat = new javax.swing.JButton();
        btRetour = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        IdMed.setText("identifiant");

        NomMed.setText("Nom");

        PreMed.setText("Prénom");

        TelPat.setText("Téléphone");

        btCreaPat.setText("Création");
        btCreaPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreaPatActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCreaPat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRetour))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IdMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NomMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PreMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TelPat, javax.swing.GroupLayout.PREFERRED_SIZE, 57, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdPat)
                            .addComponent(txtNomPat)
                            .addComponent(txtPrePat)
                            .addComponent(txtTelPat, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdMed)
                    .addComponent(txtIdPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomMed))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreMed)
                    .addComponent(txtPrePat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelPat))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreaPat)
                    .addComponent(btRetour))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCreaPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreaPatActionPerformed
        try{
    String nom = txtNomPat.getText();
    String prenom = txtPrePat.getText();
    String telephone = txtTelPat.getText();
    Patient pat = new Patient(0, nom, prenom,telephone);
    pat=patdao.create(pat);
    txtIdPat.setText(""+pat.getIdpat());
    JOptionPane.showMessageDialog(this,"Patient créé","succès",JOptionPane.INFORMATION_MESSAGE);
}
    catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btCreaPatActionPerformed

    private void btRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetourActionPerformed
      /*TestCreapat.tc.setContentPane(new Patient());
        TestCreapat.tc.repaint();
        TestCreapat.tc.revalidate();*/
    }//GEN-LAST:event_btRetourActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdMed;
    private javax.swing.JLabel NomMed;
    private javax.swing.JLabel PreMed;
    private javax.swing.JLabel TelPat;
    private javax.swing.JButton btCreaPat;
    private javax.swing.JButton btRetour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtIdPat;
    private javax.swing.JTextField txtNomPat;
    private javax.swing.JTextField txtPrePat;
    private javax.swing.JTextField txtTelPat;
    // End of variables declaration//GEN-END:variables
}