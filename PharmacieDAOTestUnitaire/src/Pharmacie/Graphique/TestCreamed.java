/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.Graphique;

import Pharmacie.DAO.MedecinDAO;
import java.sql.Connection;
import javax.swing.JOptionPane;
import myconnections.DBConnection;

/**
 *
 * @author hugo.delmarche
 */
public class TestCreamed extends javax.swing.JFrame {

    /**
     * Creates new form TestCreamed
     */
    public static TestCreamed tc = new TestCreamed();

    public TestCreamed() {
        initComponents();
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            JOptionPane.showMessageDialog(this, "connexion invalide", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

        MedecinDAO meddao= new MedecinDAO();
        meddao.setConnection(dbConnect);
        creaMed21.setMeddao(meddao);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creaMed21 = new Pharmacie.Graphique.CreaMed2();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        creaMed21.setPreferredSize(new java.awt.Dimension(400, 367));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(creaMed21, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(706, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(creaMed21, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tc.setVisible(true);
                tc.setLocationRelativeTo(null);
                tc.setSize(600, 400);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Pharmacie.Graphique.CreaMed2 creaMed21;
    // End of variables declaration//GEN-END:variables
}
