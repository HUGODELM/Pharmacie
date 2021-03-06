/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.Graphique;

import Pharmacie.DAO.MedecinDAO;
import Pharmacie.metier.Medecin;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huggy
 */
public class RechNomMed extends javax.swing.JPanel {

    MedecinDAO meddao = null;
    Medecin m;
    DefaultTableModel dft1 = new DefaultTableModel();

    /**
     * Creates new form RechPatNom
     */
    public RechNomMed() {
        initComponents();
        dft1.addColumn("Identifiant");
        dft1.addColumn("Matricule");
        dft1.addColumn("Nom");
        dft1.addColumn("Prénom");
        dft1.addColumn("Téléphone");
        TabPres.setModel(dft1);
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
        TxtNomPat = new javax.swing.JTextField();
        BtRechNomPat = new javax.swing.JButton();
        btFin1 = new javax.swing.JButton();

        TabPres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TabPres);

        TxtNomPat.setText("Nom");

        BtRechNomPat.setText("Recherche");
        BtRechNomPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRechNomPatActionPerformed(evt);
            }
        });

        btFin1.setText("Quitter");
        btFin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFin1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(BtRechNomPat)
                .addGap(247, 247, 247)
                .addComponent(btFin1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(TxtNomPat, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(TxtNomPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtRechNomPat)
                    .addComponent(btFin1))
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtRechNomPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRechNomPatActionPerformed
        String nom = TxtNomPat.getText();
        List idTab;
        try {
            idTab = meddao.search(nom);
            if ((int) idTab.get(0) != 0) {
                for (int i = 0; i < idTab.size(); i++) {
                    Vector v = new Vector();
                    m = meddao.read((int) idTab.get(i));
                    v.add(m.getIdmed());
                    v.add(m.getMatricule());
                    v.add(m.getNom());
                    v.add(m.getPrenom());
                    v.add(m.getTel());
                    dft1.addRow(v);
                }
            }
             else{
                JOptionPane.showMessageDialog(this, "Medecin inconnu", "", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERREURSQL", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "erreur: "+e.getMessage(), "ERREURPasSQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtRechNomPatActionPerformed

    private void btFin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFin1ActionPerformed
        JOptionPane.showMessageDialog(this, "Au revoir", "Fermeture", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_btFin1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtRechNomPat;
    private javax.swing.JTable TabPres;
    private javax.swing.JTextField TxtNomPat;
    private javax.swing.JButton btFin1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
