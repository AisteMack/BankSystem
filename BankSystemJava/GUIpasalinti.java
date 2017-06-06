
package bank;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class GUIpasalinti extends javax.swing.JFrame {

    /**
     * Creates new form GUIpasalinti
     */
    private Bankas bankas;
    
    public GUIpasalinti(Bankas bank) {
        try {
            initComponents();
            this.bankas = bank;
            jBoxNr.setModel(new DefaultComboBoxModel());
            jBoxNr.removeAllItems();
            jBoxAk.setModel(new DefaultComboBoxModel());
            List <String> sar = bank.getAkKlientu();
            for(String s: sar){
                jBoxAk.addItem(s);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(GUIpasalinti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelak2 = new javax.swing.JLabel();
        jLabelSasNr = new javax.swing.JLabel();
        jButtonKlienta = new javax.swing.JButton();
        jButtonSaskaita = new javax.swing.JButton();
        jBoxAk = new javax.swing.JComboBox<>();
        jLabelVardas = new javax.swing.JLabel();
        jLabelPavarde = new javax.swing.JLabel();
        jBoxNr = new javax.swing.JComboBox<>();
        jLabelError = new javax.swing.JLabel();
        jLabelLikutis = new javax.swing.JLabel();
        jLabelError1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pašalinti");

        jLabelak2.setText("Asmens kodas");

        jLabelSasNr.setText("Saskaitos numeris");

        jButtonKlienta.setText("Pašalinti klientą");
        jButtonKlienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKlientaActionPerformed(evt);
            }
        });

        jButtonSaskaita.setText("Pašalinti sąskaitą");
        jButtonSaskaita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaskaitaActionPerformed(evt);
            }
        });

        jBoxAk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jBoxAk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoxAkActionPerformed(evt);
            }
        });

        jLabelVardas.setText("Vardas:");

        jLabelPavarde.setText("Pavardė:");

        jBoxNr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jBoxNr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoxNrActionPerformed(evt);
            }
        });

        jLabelLikutis.setText("Likutis:");

        jLabelError1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonKlienta)
                    .addComponent(jLabelSasNr)
                    .addComponent(jLabelak2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelVardas)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 143, Short.MAX_VALUE)
                                .addComponent(jButtonSaskaita))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBoxNr, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBoxAk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(43, 43, 43)))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLikutis)
                            .addComponent(jLabelPavarde))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabelError))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelError1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelError1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelak2)
                            .addComponent(jBoxAk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelVardas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPavarde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSasNr)
                            .addComponent(jBoxNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLikutis)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSaskaita)
                            .addComponent(jButtonKlienta))
                        .addGap(31, 31, 31)
                        .addComponent(jLabelError)))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonKlientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKlientaActionPerformed
        
        jLabelError1.setText("");
        try {
            bankas.pasalintiKlientaSQL(jBoxAk.getSelectedItem().toString());
        } catch (SQLException ex) {
            
            if(ex.getMessage().contains("Prisijungimo duomenys yra naudojami! Ju pasalinti negalima")){
               jLabelError1.setText("Šio kliento pašalinti negalima! (Klientas turi aktyvių sąskaitų)"); 
            }else{
               System.err.println(ex.toString());
               jLabelError1.setText("Ivyko nenumatyta klaida. Bandykite dar kartą");
            }
        }
    }//GEN-LAST:event_jButtonKlientaActionPerformed

    private void jBoxAkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoxAkActionPerformed
        
        
        jLabelError1.setText("");
        try {
            jLabelPavarde.setText("Pavarde:  " + bankas.getPavardeSQL(jBoxAk.getSelectedItem().toString()));
            jLabelVardas.setText("Vardas:   " + bankas.getVardasSQL(jBoxAk.getSelectedItem().toString()));
            jBoxNr.removeAllItems();
            List <String> sar = this.bankas.getSasNrKliento(jBoxAk.getSelectedItem().toString());
            for(String s: sar){
                jBoxNr.addItem(s);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(GUIpasalinti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBoxAkActionPerformed

    private void jBoxNrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoxNrActionPerformed
        try {
            jLabelError1.setText("");
            jLabelLikutis.setText("Likutis: ");
            if(jBoxNr.getSelectedItem() != null){
                jLabelLikutis.setText("Likutis:  " + bankas.getSaskaitosLikutiSQL(jBoxNr.getSelectedItem().toString()) + " eur.");
            }
         } catch (SQLException ex) {
            Logger.getLogger(GUIpasalinti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jBoxNrActionPerformed

    private void jButtonSaskaitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaskaitaActionPerformed
        jLabelError.setText("");
        try {
            if(jBoxNr.getSelectedItem() != null){
                bankas.pasalintiSaskaitaSQL(jBoxAk.getSelectedItem().toString(), jBoxNr.getSelectedItem().toString());
            }else{
                jLabelError1.setText("Pasirinkite saskaitą");
            }
        } catch (SQLException ex) {
            
            if(ex.getMessage().contains("Saskaitoje dar yra pnigu arba negrazintas kreditas!")){
               jLabelError1.setText("Šios saskaitos pašalinti negalima! (Saskaitoje yra pnigų arba negražintas kreditas!)"); 
            }else{
               System.err.println(ex.toString());
               jLabelError1.setText("Ivyko nenumatyta klaida. Bandykite dar kartą");
            }
        }
    }//GEN-LAST:event_jButtonSaskaitaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIpasalinti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIpasalinti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIpasalinti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIpasalinti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //   new GUIpasalinti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jBoxAk;
    private javax.swing.JComboBox<String> jBoxNr;
    private javax.swing.JButton jButtonKlienta;
    private javax.swing.JButton jButtonSaskaita;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelError1;
    private javax.swing.JLabel jLabelLikutis;
    private javax.swing.JLabel jLabelPavarde;
    private javax.swing.JLabel jLabelSasNr;
    private javax.swing.JLabel jLabelVardas;
    private javax.swing.JLabel jLabelak2;
    // End of variables declaration//GEN-END:variables
}
