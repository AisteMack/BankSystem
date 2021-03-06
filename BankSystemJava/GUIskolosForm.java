
package bank;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class GUIskolosForm extends javax.swing.JFrame {
    
    private final ZmogusKlientas klientas;
    private final Bankas bank;
    
    /**
     * Creates new form GUIskolosForm
     * @param bank
     * @param klientas
     */
    public GUIskolosForm(Bankas bank, ZmogusKlientas klientas) {
        initComponents();
        this.klientas = klientas;
        this.bank = bank;
        jComboBoxSas.setModel(new DefaultComboBoxModel());
        List<Saskaita> saskaitos = klientas.getSaskaitos();
        for(Saskaita itm : saskaitos){
            jComboBoxSas.addItem(itm.toStringNr());
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

        jComboBoxSas = new javax.swing.JComboBox<>();
        jLabelNrI = new javax.swing.JLabel();
        jLabelLikutis = new javax.swing.JLabel();
        jTextSkolaIs = new javax.swing.JTextField();
        jLabelNrIs = new javax.swing.JLabel();
        jLabelVardas = new javax.swing.JLabel();
        jTextVardas = new javax.swing.JTextField();
        jLabelSuma = new javax.swing.JLabel();
        jTextSuma = new javax.swing.JTextField();
        jButtonAtlikti = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Skolos forma");

        jComboBoxSas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSasActionPerformed(evt);
            }
        });

        jLabelNrI.setText("Sąskaitos numeris");

        jLabelLikutis.setText("Sąskaitos likutis");

        jLabelNrIs.setText("Sąskaitos numeris");

        jLabelVardas.setText("Vardas ir pavardė");

        jTextVardas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextVardasActionPerformed(evt);
            }
        });

        jLabelSuma.setText("Skolos suma");

        jTextSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSumaActionPerformed(evt);
            }
        });

        jButtonAtlikti.setText("Atlikti");
        jButtonAtlikti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtliktiActionPerformed(evt);
            }
        });

        jLabel6.setText("Skolą norite gauti iš:");

        jLabel7.setText("Skolą norite gauti į:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVardas)
                            .addComponent(jLabelNrIs)
                            .addComponent(jLabelSuma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(jButtonAtlikti))
                            .addComponent(jTextSkolaIs)
                            .addComponent(jComboBoxSas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextVardas))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelLikutis)
                            .addComponent(jLabelNrI))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextVardas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVardas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSkolaIs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNrIs))
                .addGap(36, 36, 36)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNrI)
                    .addComponent(jComboBoxSas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelLikutis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAtlikti))
                    .addComponent(jLabelSuma, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSumaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSumaActionPerformed

    private void jTextVardasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextVardasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextVardasActionPerformed

    private void jComboBoxSasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSasActionPerformed
        String saskaita = jComboBoxSas.getSelectedItem().toString();
        Saskaita sas = klientas.getSaskaita(saskaita);
        jLabelLikutis.setText("Sąskaitos likutis:   " + sas.toStringLikutis() + " eur.");
    }//GEN-LAST:event_jComboBoxSasActionPerformed

    private void jButtonAtliktiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtliktiActionPerformed
        String skolaIs = jTextSkolaIs.getText();
        String skolaI = jComboBoxSas.getSelectedItem().toString();
        String sumaString = jTextSuma.getText();
        String name = jTextVardas.getText();
        double suma;
        try{
            
            suma = Double.parseDouble(sumaString);
            if(suma > 0 ){
                (new TransakcijaThread(this.bank, skolaI, skolaIs, suma, name)).start();
            }
        
        }catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Sumą turi sudaryti tik skaičiai", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonAtliktiActionPerformed

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
            java.util.logging.Logger.getLogger(GUIskolosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIskolosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIskolosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIskolosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new GUIskolosForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtlikti;
    private javax.swing.JComboBox<String> jComboBoxSas;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelLikutis;
    private javax.swing.JLabel jLabelNrI;
    private javax.swing.JLabel jLabelNrIs;
    private javax.swing.JLabel jLabelSuma;
    private javax.swing.JLabel jLabelVardas;
    private javax.swing.JTextField jTextSkolaIs;
    private javax.swing.JTextField jTextSuma;
    private javax.swing.JTextField jTextVardas;
    // End of variables declaration//GEN-END:variables
}
