/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package display;

/**
 *
 * @author Jeffrey
 */
public class Patient_Info_Window extends javax.swing.JFrame {

    /**
     * Creates new form Patient_Info_Window
     */
    public Patient_Info_Window() {
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

        info_label = new javax.swing.JPanel();
        name_label = new javax.swing.JLabel();
        name_text = new javax.swing.JTextField();
        addr_label = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        addr_text = new javax.swing.JTextArea();
        city_label = new javax.swing.JLabel();
        city_text = new javax.swing.JTextField();
        state_label = new javax.swing.JLabel();
        state_text = new javax.swing.JTextField();
        dob_label = new javax.swing.JLabel();
        dob_text = new javax.swing.JTextField();
        gender_label = new javax.swing.JLabel();
        gender_text = new javax.swing.JTextField();
        save_info_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        info_label.setBackground(new java.awt.Color(204, 204, 255));

        name_label.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        name_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        name_label.setText("Name:");

        addr_label.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addr_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addr_label.setText("Address:");

        addr_text.setColumns(20);
        addr_text.setRows(5);
        jScrollPane5.setViewportView(addr_text);

        city_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        city_label.setText("City:");

        state_label.setText("State:");

        dob_label.setText("Date of Birth:");

        gender_label.setText("Gender:");

        save_info_button.setText("Save");
        save_info_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_info_buttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout info_labelLayout = new javax.swing.GroupLayout(info_label);
        info_label.setLayout(info_labelLayout);
        info_labelLayout.setHorizontalGroup(
            info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, info_labelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dob_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(city_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addr_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name_text)
                    .addComponent(jScrollPane5)
                    .addGroup(info_labelLayout.createSequentialGroup()
                        .addGroup(info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dob_text, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(city_text, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(40, 40, 40)
                        .addGroup(info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gender_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(state_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(state_text)
                            .addComponent(gender_text, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(info_labelLayout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(save_info_button, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                .addContainerGap())
        );
        info_labelLayout.setVerticalGroup(
            info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_labelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addr_label)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(state_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(city_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(city_label)
                        .addComponent(state_label)))
                .addGap(18, 18, 18)
                .addGroup(info_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dob_label)
                    .addComponent(dob_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gender_label)
                    .addComponent(gender_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save_info_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(info_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(info_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_info_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_info_buttonMouseClicked
        GUI.set_name(name_text.getText().toString());
        GUI.set_address(addr_text.getText().toString());
        GUI.set_city(city_text.getText().toString());
        GUI.set_state(state_text.getText().toString());
        GUI.set_dob(dob_text.getText().toString());
        GUI.set_gender(gender_text.getText().toString());    
        this.setVisible(false);
    }//GEN-LAST:event_save_info_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(Patient_Info_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient_Info_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient_Info_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient_Info_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
                new Patient_Info_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addr_label;
    private javax.swing.JTextArea addr_text;
    private javax.swing.JLabel city_label;
    private javax.swing.JTextField city_text;
    private javax.swing.JLabel dob_label;
    private javax.swing.JTextField dob_text;
    private javax.swing.JLabel gender_label;
    private javax.swing.JTextField gender_text;
    private javax.swing.JPanel info_label;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel name_label;
    private javax.swing.JTextField name_text;
    private javax.swing.JButton save_info_button;
    private javax.swing.JLabel state_label;
    private javax.swing.JTextField state_text;
    // End of variables declaration//GEN-END:variables
}
