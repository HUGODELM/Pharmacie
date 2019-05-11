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
        jLabel2 = new javax.swing.JLabel();
        IdMed = new javax.swing.JLabel();
        NomMed = new javax.swing.JLabel();
        PreMed = new javax.swing.JLabel();
        TelPat = new javax.swing.JLabel();
        txtIdMed = new javax.swing.JTextField();
        txtNomMed = new javax.swing.JTextField();
        txtPreMed = new javax.swing.JTextField();
        txtTelMed = new javax.swing.JTextField();
        btCreaMed = new javax.swing.JButton();
        MatMed = new javax.swing.JLabel();
        TxtMatMed = new javax.swing.JTextField();
        btFin = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        IdMed.setText("identifiant");

        NomMed.setText("Nom");

        PreMed.setText("Prénom");

        TelPat.setText("Téléphone");

        btCreaMed.setText("Création");
        btCreaMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreaMedActionPerformed(evt);
            }
        });

        MatMed.setText("Matricule");

        btFin.setText("Quitter");
        btFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinActionPerformed(evt);
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
                        .addComponent(MatMed, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtMatMed, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IdMed, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(NomMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PreMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdMed, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(txtNomMed)
                            .addComponent(txtPreMed)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TelPat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCreaMed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelMed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btFin)
                                .addGap(21, 21, 21)))))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NomMed)
                    .addComponent(txtIdMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreMed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(IdMed)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtPreMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MatMed, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtMatMed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TelPat)
                    .addComponent(txtTelMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreaMed)
                    .addComponent(btFin))
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCreaMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreaMedActionPerformed
        try{
    String nom = txtNomMed.getText();
    String prenom = txtPreMed.getText();
    String telephone = txtTelMed.getText();
    String matricule = TxtMatMed.getText();
    Medecin med = new Medecin(0,matricule, nom, prenom,telephone);
    med=meddao.create(med);
    txtIdMed.setText(""+med.getIdmed());
    JOptionPane.showMessageDialog(this,"Medecin créé","succès",JOptionPane.INFORMATION_MESSAGE);
}
    catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btCreaMedActionPerformed

    private void btFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinActionPerformed
        JOptionPane.showMessageDialog(this, "Au revoir", "Mise à jour", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_btFinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdMed;
    private javax.swing.JLabel MatMed;
    private javax.swing.JLabel NomMed;
    private javax.swing.JLabel PreMed;
    private javax.swing.JLabel TelPat;
    private javax.swing.JTextField TxtMatMed;
    private javax.swing.JButton btCreaMed;
    private javax.swing.JButton btFin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtIdMed;
    private javax.swing.JTextField txtNomMed;
    private javax.swing.JTextField txtPreMed;
    private javax.swing.JTextField txtTelMed;
    // End of variables declaration//GEN-END:variables
}
