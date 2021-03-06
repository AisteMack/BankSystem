
package bank;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class GUIklientoMeniu extends javax.swing.JFrame {
    
    private GUIprisijungimas gui;
    /**
     * Creates new form userMeniu
     */
    public GUIklientoMeniu(Bankas bank, ZmogusKlientas klientas, GUIprisijungimas gui) {
        initComponents();
        this.gui = gui;
        this.bank = bank;
        this.klientas = klientas;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonInfo = new javax.swing.JButton();
        jButtonSaskaitos = new javax.swing.JButton();
        jButtonNaujaSaskaita = new javax.swing.JButton();
        jButtonPervedimas = new javax.swing.JButton();
        jButtonAtsijungti = new javax.swing.JButton();
        jButtonInesti = new javax.swing.JButton();
        jButtonPaimti = new javax.swing.JButton();
        jButtonGautiSkola = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kliento meniu");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Sveikiname prisijungus prie banko sistemos!");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Meniu:");

        jButtonInfo.setText("Informacija");
        jButtonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInfoActionPerformed(evt);
            }
        });

        jButtonSaskaitos.setText("Sąskaitos likučiai");
        jButtonSaskaitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaskaitosActionPerformed(evt);
            }
        });

        jButtonNaujaSaskaita.setText("Nauja sąskaita");
        jButtonNaujaSaskaita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNaujaSaskaitaActionPerformed(evt);
            }
        });

        jButtonPervedimas.setText("Pervedimas eurasi");
        jButtonPervedimas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPervedimasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSaskaitos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNaujaSaskaita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPervedimas, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonInfo)
                .addGap(18, 18, 18)
                .addComponent(jButtonSaskaitos)
                .addGap(18, 18, 18)
                .addComponent(jButtonNaujaSaskaita)
                .addGap(18, 18, 18)
                .addComponent(jButtonPervedimas)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jButtonAtsijungti.setText("Atsijungti");
        jButtonAtsijungti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtsijungtiActionPerformed(evt);
            }
        });

        jButtonInesti.setText("Transakcijų sąrašas");
        jButtonInesti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInestiActionPerformed(evt);
            }
        });

        jButtonPaimti.setText("Paimti/inešti  pinigus į sąskaitą");
        jButtonPaimti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPaimtiActionPerformed(evt);
            }
        });

        jButtonGautiSkola.setText("Gauti skolą");
        jButtonGautiSkola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGautiSkolaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonAtsijungti)
                            .addComponent(jButtonInesti, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPaimti, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(jButtonGautiSkola, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAtsijungti)
                        .addGap(16, 16, 16)
                        .addComponent(jButtonInesti)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPaimti)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGautiSkola)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPervedimasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPervedimasActionPerformed
        GUImokForma forma = new GUImokForma(bank, klientas);
        forma.setVisible(true);
    }//GEN-LAST:event_jButtonPervedimasActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed
        GUIklientas client = new GUIklientas(this.bank);
        client.setVisible(true);
    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonAtsijungtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtsijungtiActionPerformed
        this.setVisible(false);
        gui.setVisible(true);
    }//GEN-LAST:event_jButtonAtsijungtiActionPerformed

    private void jButtonSaskaitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaskaitosActionPerformed
        GUIregistracija sask = new GUIregistracija(this.bank, 2);
        sask.setVisible(true);
    }//GEN-LAST:event_jButtonSaskaitosActionPerformed

    private void jButtonInestiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInestiActionPerformed
        GUIregistracija sask = new GUIregistracija(this.bank, 3);
        sask.setVisible(true);
    }//GEN-LAST:event_jButtonInestiActionPerformed

    private void jButtonNaujaSaskaitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNaujaSaskaitaActionPerformed
        GUInaujaSaskaita nauja = new GUInaujaSaskaita(bank);
        nauja.setVisible(true);
    }//GEN-LAST:event_jButtonNaujaSaskaitaActionPerformed

    private void jButtonGautiSkolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGautiSkolaActionPerformed
        GUIskolosForm naujas = new GUIskolosForm(bank, klientas);
        naujas.setVisible(true);
    }//GEN-LAST:event_jButtonGautiSkolaActionPerformed

    private void jButtonPaimtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPaimtiActionPerformed
        GUIinestiPaimti naujas = new GUIinestiPaimti(bank, klientas);
        naujas.setVisible(true);
    }//GEN-LAST:event_jButtonPaimtiActionPerformed

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
            java.util.logging.Logger.getLogger(GUIklientoMeniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIklientoMeniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIklientoMeniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIklientoMeniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           //     new GUIklientoMeniu().setVisible(true);
            }
        });
    }
    
    private Bankas bank;
    private ZmogusKlientas klientas;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtsijungti;
    private javax.swing.JButton jButtonGautiSkola;
    private javax.swing.JButton jButtonInesti;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonNaujaSaskaita;
    private javax.swing.JButton jButtonPaimti;
    private javax.swing.JButton jButtonPervedimas;
    private javax.swing.JButton jButtonSaskaitos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
