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
public class RechMed extends javax.swing.JPanel {

    MedecinDAO meddao = null;
    Medecin m;

    /**
     * Creates new form CreaMed2
     */
    public RechMed() {
        initComponents();
        txtMatMed.setEditable(false);
        txtNomMed.setEditable(false);
        txtPreMed.setEditable(false);
        txtTelMed.setEditable(false);
        BtMajMed.setEnabled(false);
        BtDelMed.setEnabled(false);

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
        jButton1 = new javax.swing.JButton();
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
        btRechMed = new javax.swing.JButton();
        BtMajMed = new javax.swing.JButton();
        BtDelMed = new javax.swing.JButton();
        btFin = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jButton1.setText("jButton1");

        setPreferredSize(new java.awt.Dimension(508, 441));

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

        btRechMed.setText("Recherche");
        btRechMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRechMedActionPerformed(evt);
            }
        });

        BtMajMed.setText("Mise à jour");
        BtMajMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtMajMedActionPerformed(evt);
            }
        });

        BtDelMed.setText("Suppression");
        BtDelMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtDelMedActionPerformed(evt);
            }
        });

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(IdMed, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addComponent(NomMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PreMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MatMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(TelMed, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdMed)
                    .addComponent(txtNomMed)
                    .addComponent(txtPreMed)
                    .addComponent(txtMatMed)
                    .addComponent(txtTelMed, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btRechMed)
                .addGap(35, 35, 35)
                .addComponent(BtMajMed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(BtDelMed)
                .addGap(37, 37, 37)
                .addComponent(btFin, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(25, 25, 25))
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
                    .addComponent(btRechMed)
                    .addComponent(BtMajMed)
                    .addComponent(BtDelMed)
                    .addComponent(btFin))
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btRechMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRechMedActionPerformed
        try {
            int id = Integer.parseInt(txtIdMed.getText());
            m = meddao.read(id);
            txtMatMed.setText(m.getMatricule());
            txtNomMed.setText(m.getNom());
            txtPreMed.setText(m.getPrenom());
            txtTelMed.setText(m.getTel());
            BtMajMed.setEnabled(true);
            BtDelMed.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btRechMedActionPerformed

    private void txtMatMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatMedActionPerformed

    private void BtMajMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtMajMedActionPerformed
        if (txtIdMed.isEditable()) {
            txtIdMed.setEditable(false);
            txtMatMed.setEditable(true);
            txtNomMed.setEditable(true);
            txtPreMed.setEditable(true);
            txtTelMed.setEditable(true);
            JOptionPane.showMessageDialog(this, "Modifier les champs que vous souhaitez mettre à jour puis cliquer à nouveau sur Mise à jour", "Mise à jour", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                m.setMatricule(txtMatMed.getText());
                m.setNom(txtNomMed.getText());
                m.setPrenom(txtPreMed.getText());
                m.setTel(txtTelMed.getText());
                meddao.update(m);
                JOptionPane.showMessageDialog(this, "Médecin mis à jour", "succès", JOptionPane.INFORMATION_MESSAGE);
                txtIdMed.setEditable(true);
                txtMatMed.setEditable(false);
                txtNomMed.setEditable(false);
                txtPreMed.setEditable(false);
                txtTelMed.setEditable(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_BtMajMedActionPerformed

    private void BtDelMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtDelMedActionPerformed
        try {
            meddao.delete(m);
            JOptionPane.showMessageDialog(this, "Médecin supprimer", "succès", JOptionPane.INFORMATION_MESSAGE);
            txtIdMed.setText(" ");
            txtMatMed.setText(" ");
            txtNomMed.setText(" ");
            txtPreMed.setText(" ");
            txtTelMed.setText(" ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BtDelMedActionPerformed

    private void btFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinActionPerformed
        JOptionPane.showMessageDialog(this, "Au revoir", "Fermeture", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_btFinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtDelMed;
    private javax.swing.JButton BtMajMed;
    private javax.swing.JLabel IdMed;
    private javax.swing.JLabel MatMed;
    private javax.swing.JLabel NomMed;
    private javax.swing.JLabel PreMed;
    private javax.swing.JLabel TelMed;
    private javax.swing.JButton btFin;
    private javax.swing.JButton btRechMed;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtIdMed;
    private javax.swing.JTextField txtMatMed;
    private javax.swing.JTextField txtNomMed;
    private javax.swing.JTextField txtPreMed;
    private javax.swing.JTextField txtTelMed;
    // End of variables declaration//GEN-END:variables
}
