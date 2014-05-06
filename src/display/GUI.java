package display;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import model.*;
/**
 *
 * @author Jeffrey Creighton
 */
public class GUI extends javax.swing.JFrame {
    Calendar cal;                           //Calendar to generate report ID
    DefaultTableModel available_model;      //Represents all genes currently available
    DefaultTableModel implemented_model;    //Represents all genes implemented in report
    Patient patient = new Patient();        //Manages patient info
    AddGeneWindow a_window;
    Color available_color = new Color(255, 156, 58);
    Color implemented_color = new Color(102, 255, 204);
    HashMap<String, Gene> test_map;
    Iterator it;
    String [] implemented_genes;
    
    
    String available_gene;      //Depreciated: manages available genes highlighted 
    String implemented_gene;    //Depreciated: manages implemented genes highlighted
    String selected_gene;       //Manages the place of both available and implemented genes
    boolean focus_available;    //Maintains which table has control over 'selected_gene'
    
    String type;
    String urgency;
    
    
    private static String[] available_genes;   
    private static String output_filepath = "";
    
    /**
     * Refreshes the two tables.
     * Perform when a gene type is changed, or when data is imported.
     */
    public void refreshData()
    {
    	String[] available_genes;
    	for(int i = available_model.getRowCount()-1; i >= 0; i--)
    	{
    		available_model.removeRow(i);
    	}
    	for(int i = implemented_model.getRowCount()-1; i >= 0; i--)
    	{
    		implemented_model.removeRow(i);
    	}
    	test_map = (HashMap) Main.getData();
        Set<String> string_list = test_map.keySet();
        available_genes = new String[string_list.size()];
        //available_model = new DefaultTableModel(0, 1);
        for(String key: string_list){
            String[] temp = {key, test_map.get(key).getType(), test_map.get(key).getUrgency(), 
                            test_map.get(key).getRSNumber(), test_map.get(key).getVariant()}; //Added the remaining gene fields
            available_model.insertRow(available_model.getRowCount(), temp);
        }
        test_map = (HashMap)Main.getSelected();
        string_list = test_map.keySet();
        available_genes = new String[string_list.size()];
        for(String key: string_list){
            String[] temp2 = {key, test_map.get(key).getType(), test_map.get(key).getUrgency()};
            implemented_model.insertRow(implemented_model.getRowCount(), temp2);
        }
    }
    
    /**
     * Create new GUI, no attributes
     */
    public GUI() {

        String[] cols = {"Genes", "Types", "Urgency", "RS Number", "Variant"};
        available_model = new DefaultTableModel(cols, 0);
        String[] cols2 = {"Genes", "Types", "Urgency"};
        implemented_model = new DefaultTableModel(cols2, 0); 
        refreshData();
       
        initComponents(); 
        
    }
    
    /**
     * Displays error 'e' for the user
     * 
     * @param e 
     */
    public void displayException(Exception e){
        JFrame frame = new JFrame("Error");
    	JOptionPane.showMessageDialog(frame , e.getMessage());
    }
    
    /**
     * Depreciated, checks the implemented table to ensure only
     *      one instance of a gene.
     * 
     * @param Object 0
     * @return boolean
     */
    private boolean check_implemented_list(Object o) {
        boolean already_here = false;
        Object item; //place holder for checking contents of existing rows 
        for (int i = 0; i < implemented_model.getRowCount(); i++) {
            item = String.valueOf(implemented_model.getValueAt(i, 0));
            if (item.equals(available_gene)) {
                already_here = true;
            }
        }
        return already_here;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        primary_panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        implemented_gene_table = new javax.swing.JTable(){
            private static final long serialVerionUID = 1L;
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        include_gene_button = new javax.swing.JButton();
        exclude_gene_button = new javax.swing.JButton();
        generate_report_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selected_text = new javax.swing.JTextField();
        edit_type_button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        preview_detail_button = new javax.swing.JButton();
        save_as_button = new javax.swing.JButton();
        patient_info_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        available_gene_table = new javax.swing.JTable(){
            private static final long serialVersionUID = 1L;
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        remove_button = new javax.swing.JButton();
        add_button = new javax.swing.JButton();
        urgency_box = new javax.swing.JComboBox();
        type_box = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        import_button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        orange_arrow = new javax.swing.JLabel();
        blue_arrow = new javax.swing.JLabel();
        blue_arrow.setIcon(new ImageIcon("Resources/implemented_arrow.png"));
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Genomic Solutions Now!");
        setIconImages(null);

        primary_panel.setBackground(new java.awt.Color(135, 143, 160));
        primary_panel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        implemented_gene_table.setModel(implemented_model);
        implemented_gene_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        implemented_gene_table.setSelectionBackground(new java.awt.Color(102, 255, 204));
        implemented_gene_table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        implemented_gene_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                implemented_gene_tableMouseClicked(evt);
            }
        });
        implemented_gene_table.addKeyListener(new java.awt.event.KeyListener() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
            	implemented_gene_table_update(evt);
            }

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
        });jScrollPane2.setViewportView(implemented_gene_table);
        jScrollPane2.createHorizontalScrollBar();
        jScrollPane1.createHorizontalScrollBar();
        
        include_gene_button.setText("Include");
        include_gene_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                include_gene_buttonMouseClicked(evt);
            }
        });

        exclude_gene_button.setText("Exclude");
        exclude_gene_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exclude_gene_buttonMouseClicked(evt);
            }
        });

        generate_report_button.setText("Generate Report");
        generate_report_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_report_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Available Genes");

        jLabel5.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Implemented Genes");

        selected_text.setBackground(new java.awt.Color(255, 156, 58));
        selected_text.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        selected_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        edit_type_button.setText("Edit Gene");
        edit_type_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_type_buttonMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Report Generation");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        preview_detail_button.setText("Preview Details");
        preview_detail_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preview_detail_buttonMouseClicked(evt);
            }
        });

        save_as_button.setText("Save As");
        save_as_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_as_buttonMouseClicked(evt);
            }
        });

        patient_info_button.setText("Edit Patient Info");
        patient_info_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patient_info_buttonMouseClicked(evt);
            }
        });

        available_gene_table.setModel(available_model);
        available_gene_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        available_gene_table.setSelectionBackground(new java.awt.Color(255, 156, 58));
        available_gene_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                available_gene_tableMouseClicked(evt);
            }
        });
        available_gene_table.addKeyListener(new java.awt.event.KeyListener() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
            	available_gene_table_update(evt);
            }

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
        });
        jScrollPane1.setViewportView(available_gene_table);

        remove_button.setText("Remove");
        remove_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove_buttonMouseClicked(evt);
            }
        });

        add_button.setText("Add");
        add_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_buttonMouseClicked(evt);
            }
        });

        urgency_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "red", "yellow", "green", "blue", "purple" }));

        type_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Absent ", "Homozygous", "Heterozygous", "Wild" }));

        jLabel2.setFont(new java.awt.Font("Bitstream Charter", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Type:");

        jLabel3.setFont(new java.awt.Font("Bitstream Charter", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Urgency:");

        import_button.setText("Import");
        import_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                import_buttonMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        orange_arrow.setText(" ");
        orange_arrow.setIcon(new ImageIcon("Resources/available_arrow.png"));

        javax.swing.GroupLayout primary_panelLayout = new javax.swing.GroupLayout(primary_panel);
        primary_panel.setLayout(primary_panelLayout);
        primary_panelLayout.setHorizontalGroup(
            primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(primary_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addComponent(add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(remove_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(exclude_gene_button, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(include_gene_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selected_text)
                            .addComponent(orange_arrow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(blue_arrow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addComponent(edit_type_button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(type_box, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(urgency_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addComponent(import_button, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(save_as_button, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(patient_info_button, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(preview_detail_button, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generate_report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        primary_panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {add_button, edit_type_button, remove_button});

        primary_panelLayout.setVerticalGroup(
            primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primary_panelLayout.createSequentialGroup()
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primary_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addComponent(blue_arrow)
                                .addGap(12, 12, 12)
                                .addComponent(exclude_gene_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selected_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(include_gene_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orange_arrow)
                                .addGap(80, 80, 80)))
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add_button)
                            .addComponent(remove_button)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(edit_type_button)
                                .addComponent(jLabel2)
                                .addComponent(type_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(urgency_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(import_button)
                    .addComponent(save_as_button)
                    .addComponent(patient_info_button)
                    .addComponent(preview_detail_button)
                    .addComponent(generate_report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        primary_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {import_button, patient_info_button, preview_detail_button, save_as_button});

        jMenu2.setText("Edit");

        jMenu1.setText("Edit Defaults");

        jMenuItem3.setText("Disease");
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText("Gene");
        jMenu1.add(jMenuItem1);

        jMenu4.setText("Language");

        jMenuItem2.setText("English");
        jMenu4.add(jMenuItem2);

        jMenuItem4.setText("Spanish");
        jMenu4.add(jMenuItem4);

        jMenuItem6.setText("Add New");
        jMenu4.add(jMenuItem6);

        jMenu1.add(jMenu4);

        jMenu2.add(jMenu1);

        jMenuItem5.setText("Change Language");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(primary_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(primary_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
     
    }// </editor-fold>//GEN-END:initComponents

    private void patient_info_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient_info_buttonMouseClicked
        Patient_Info_Window patientw = new Patient_Info_Window(patient);
        patientw.setVisible(true);
    }//GEN-LAST:event_patient_info_buttonMouseClicked

    private void save_as_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_as_buttonMouseClicked
        JFileChooser chooser = new JFileChooser();
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Spreadsheets (.xls)", "xls");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(null);      
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	Main.saveGene(chooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_save_as_buttonMouseClicked

    private void preview_detail_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preview_detail_buttonMouseClicked
        String id = "";
        
        cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH);
        int d = cal.get(Calendar.DAY_OF_MONTH);
        
        id = y + "/" + m + "/" + d;
                
        if(patient.get_first_name().length() >= 1) {
            String f = patient.get_first_name().substring(0, 1);
            String l = patient.get_last_name();
            id = l + f + "-" + id;
        }
        PreviewWindow pw = new PreviewWindow(this, true, implemented_model, patient, id);
        pw.setVisible(true);
    }//GEN-LAST:event_preview_detail_buttonMouseClicked

    private void edit_type_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_type_buttonMouseClicked
        for(int i=0; i<implemented_model.getRowCount(); i++){
                String item = implemented_model.getValueAt(i, 0).toString();
                Gene old = Main.getGene(selected_gene.toString());
                Gene new_gene = new Gene(selected_gene, old.getVariant(), old.getRSNumber(), type_box.getSelectedItem().toString(), urgency_box.getSelectedItem().toString());
                Main.setGene(new_gene);
                refreshData();
        }
    }//GEN-LAST:event_edit_type_buttonMouseClicked

    private void generate_report_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_report_buttonActionPerformed
    	JFileChooser chooser = new JFileChooser();
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Spreadsheets (.xls)", "xls");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	Main.writeOut(chooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_generate_report_buttonActionPerformed

    private void exclude_gene_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exclude_gene_buttonMouseClicked
    		boolean found = false;
    		int i = 0;
    		if(focus_available == false)
    		{
	    		while(found == false && i < implemented_model.getRowCount())
	    		{
	    			String item = implemented_model.getValueAt(i, 0).toString();
	                if(selected_gene.equals(item)){
	                    Main.deselectGene(item);
	                    implemented_model.removeRow(i); 
	                    found = true;
	                }
	                i++;
	    		}
	    		refreshData();
    		}
    }//GEN-LAST:event_exclude_gene_buttonMouseClicked

    private void include_gene_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_include_gene_buttonMouseClicked
    		if(focus_available == true)
    		{
	            Main.selectGene(selected_gene.toString());
	            selected_gene = null;
	            refreshData();
    		}
    }//GEN-LAST:event_include_gene_buttonMouseClicked

    private void import_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_import_buttonMouseClicked
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Spreadsheets (.xls)", "xls");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            Main.readGene(fc.getSelectedFile().toString());
            refreshData();
        }
    }//GEN-LAST:event_import_buttonMouseClicked
    
    
    private void add_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseClicked
        
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                throw new UnsupportedOperationException("They quit the build."); 
            }
        };
        
        //AddGeneWindow a_window;
        a_window = new AddGeneWindow();
        a_window.addPropertyChangeListener("sucessful_build", listener);
        a_window.setVisible(true);   
    }//GEN-LAST:event_add_buttonMouseClicked

    public void propertyChange(PropertyChangeEvent evt){
        boolean b = (Boolean) evt.getNewValue();
        if(b){
            Gene g = a_window.getGene();
            Main.setGene(g);
            refreshData();
        }
    }
    
    private void implemented_gene_table_update(java.awt.event.KeyEvent evt)
    {
    	focus_available = false;
    	if(evt.getKeyCode() == evt.VK_DOWN)
    	{
			if (implemented_gene_table.getSelectedRow() != implemented_gene_table.getRowCount() - 1) {
				selected_gene = implemented_gene_table.getValueAt(implemented_gene_table.getSelectedRow() + 1, 0).toString();
				selected_text.setText(selected_gene);
				selected_text.setBackground(implemented_color);
			}
    	}
    	else if(evt.getKeyCode() == evt.VK_UP)
    	{
    		if(implemented_gene_table.getSelectedRow() != 0)
    		{selected_gene = implemented_gene_table.getValueAt(implemented_gene_table.getSelectedRow() - 1, 0).toString();
            selected_text.setText(selected_gene);
            selected_text.setBackground(implemented_color);}
    	}
    }
    
    
    private void implemented_gene_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_implemented_gene_tableMouseClicked
        focus_available = false;
        selected_gene = implemented_gene_table.getValueAt(implemented_gene_table.getSelectedRow(), 0).toString();
        selected_text.setText(selected_gene);
        selected_text.setBackground(implemented_color);
    }//GEN-LAST:event_implemented_gene_tableMouseClicked

    private void available_gene_table_update(java.awt.event.KeyEvent evt)
    {
    	focus_available = true;
    	if(evt.getKeyCode() == evt.VK_DOWN)
    	{
			if (available_gene_table.getSelectedRow() != available_gene_table
					.getRowCount() - 1) {
				selected_gene = available_gene_table.getValueAt(
						available_gene_table.getSelectedRow() + 1, 0)
						.toString();
				selected_text.setText(selected_gene);
				selected_text.setBackground(available_color);
			}
    	}
    	else if(evt.getKeyCode() == evt.VK_UP)
    	{
    		if(available_gene_table.getSelectedRow() != 0)
    		{selected_gene = available_gene_table.getValueAt(available_gene_table.getSelectedRow() - 1, 0).toString();
            selected_text.setText(selected_gene);
            selected_text.setBackground(available_color);}
    	}
    }
    
    private void available_gene_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_available_gene_tableMouseClicked
        focus_available = true;
        selected_gene = available_gene_table.getValueAt(available_gene_table.getSelectedRow(), 0).toString();
        selected_text.setText(selected_gene);
        selected_text.setBackground(available_color);
    }//GEN-LAST:event_available_gene_tableMouseClicked

    private void remove_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove_buttonMouseClicked
        if(focus_available == true) {
    		Main.removeGene(selected_gene.toString());
    		selected_gene = null;
    		refreshData();
    	}
    }//GEN-LAST:event_remove_buttonMouseClicked
 
    
    public static void set_output_file(String f) {
     output_filepath = f;   
    }
    public static String get_output_file() {
        return output_filepath;
    }
      
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        // Set the Nimbus look and feel 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        // If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         // For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         //
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the form //
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
                new GUI().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JTable available_gene_table;
    private javax.swing.JLabel blue_arrow;
    private javax.swing.JButton edit_type_button;
    private javax.swing.JButton exclude_gene_button;
    private javax.swing.JButton generate_report_button;
    private javax.swing.JTable implemented_gene_table;
    private javax.swing.JButton import_button;
    private javax.swing.JButton include_gene_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel orange_arrow;
    private javax.swing.JButton patient_info_button;
    private javax.swing.JButton preview_detail_button;
    private javax.swing.JPanel primary_panel;
    private javax.swing.JButton remove_button;
    private javax.swing.JButton save_as_button;
    private javax.swing.JTextField selected_text;
    private javax.swing.JComboBox type_box;
    private javax.swing.JComboBox urgency_box;
    // End of variables declaration//GEN-END:variables
}
