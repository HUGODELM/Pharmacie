/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.Graphique;

import java.awt.CardLayout;

/**
 *
 * @author huggy
 */
public class MedecinMenu extends javax.swing.JPanel {
    CardLayout cardl;
    /**
     * Creates new form MedecinMenu
     */
    public MedecinMenu() {
        initComponents();
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
        BtCreaMed = new javax.swing.JButton();
        BtRetourMenu = new javax.swing.JButton();

        jLabel1.setText("Médecin");

        BtCreaMed.setText("Création");
        BtCreaMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCreaMedActionPerformed(evt);
            }
        });

        BtRetourMenu.setText("Retour");
        BtRetourMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRetourMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtRetourMenu)
                            .addComponent(BtCreaMed))))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(BtCreaMed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(BtRetourMenu)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtCreaMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCreaMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtCreaMedActionPerformed

    private void BtRetourMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRetourMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtRetourMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCreaMed;
    private javax.swing.JButton BtRetourMenu;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
