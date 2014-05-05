package display;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author Jeffrey Creighton
 */
public class AddGeneWindow extends javax.swing.JFrame {
    private Gene gene;
    private String name;
    private String variant;
    private String rsNumber;
    private String type;
    private String color;
    private boolean sucessful_build;
    /**
     * Creates new AddGeneWindow, no attributes
     */
    public AddGeneWindow() {
        initComponents();                
    }

    public Gene getGene(){

        return gene;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        new_gene_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name_text = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        variant_text = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rs_text = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        type_box = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        urgency_box = new javax.swing.JComboBox();
        cancel_button = new javax.swing.JButton();
        accept_button = new javax.swing.JButton();

        new_gene_panel.setBackground(new java.awt.Color(172, 172, 184));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Gene");

        jLabel2.setText("Name:");

        jLabel3.setText("Variant:");

        jLabel4.setText("RS Number:");

        jLabel5.setText("Type:");

        type_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Absent", "Heterozygous", "Homozygous", "Wild" }));

        jLabel6.setText("Urgency:");

        urgency_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "red", "yellow", "green", "blue", "purple" }));

        cancel_button.setText("Cancel");
        cancel_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_buttonMouseClicked(evt);
            }
        });

        accept_button.setText("Accept");
        accept_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accept_buttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout new_gene_panelLayout = new javax.swing.GroupLayout(new_gene_panel);
        new_gene_panel.setLayout(new_gene_panelLayout);
        new_gene_panelLayout.setHorizontalGroup(
            new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(new_gene_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(new_gene_panelLayout.createSequentialGroup()
                        .addGroup(new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name_text)
                            .addComponent(variant_text)
                            .addComponent(rs_text)
                            .addComponent(type_box, 0, 140, Short.MAX_VALUE)
                            .addComponent(urgency_box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(new_gene_panelLayout.createSequentialGroup()
                        .addComponent(cancel_button)
                        .addGap(137, 137, 137)
                        .addComponent(accept_button)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        new_gene_panelLayout.setVerticalGroup(
            new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(new_gene_panelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(variant_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rs_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(type_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(urgency_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(new_gene_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_button)
                    .addComponent(accept_button))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(new_gene_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(new_gene_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_buttonMouseClicked
        sucessful_build = false;
        this.setVisible(false);//close out window
    }//GEN-LAST:event_cancel_buttonMouseClicked

    private void accept_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accept_buttonMouseClicked
        //LATE GAME:
        //      **Insert a check here to ensure all fields are filled.      
        /**
         * Construct a new gene from the user's input
         */        
        gene = new Gene(name_text.getText().trim(),
                variant_text.getText().trim(),
                rs_text.getText().trim(),
                type_box.getSelectedItem().toString(),
                urgency_box.getSelectedItem().toString());
        
        this.setVisible(false);//Close out window
        sucessful_build = true;
    }//GEN-LAST:event_accept_buttonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept_button;
    private javax.swing.JButton cancel_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField name_text;
    private javax.swing.JPanel new_gene_panel;
    private javax.swing.JTextField rs_text;
    private javax.swing.JComboBox type_box;
    private javax.swing.JComboBox urgency_box;
    private javax.swing.JTextField variant_text;
    // End of variables declaration//GEN-END:variables
}
