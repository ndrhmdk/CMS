/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin_panel;
//import com.raven.swing.table.ModelAction;
//import com.raven.swing.table.ModelProfile;
//import com.raven.swing.table.Profile;
import cms.component.TableHeader;
import controller.AdminController;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.Movie;
import static util.Util.intInput;
/**
 *
 * @author OS
 */
public class MovieManagementPanel extends javax.swing.JPanel {
    private static AdminController admin_controller = AdminController.getInstance();
    private static File image_file;
    private DefaultTableModel tableModel;
    private static ArrayList<Movie> movies_list = new ArrayList<>();
    private static HashSet<String> movies_set = new HashSet<>();
    private static String original_title = "";
    private static String original_genre = "";
    private static String original_duration = "";
    private static String original_actor = "";
    private static String original_description = "";
    private static DocumentListener docListener;
    
    /**
     * Creates new form P2_MovieManagement
     */
    public MovieManagementPanel() {
        initializeDocListener();
        initComponents();
        
        movies_list = admin_controller.getExistingMovie();
        for (Movie movie : movies_list){ 
            movies_set.add(movie.getTitle());
            Object[] row = {movie.getTitle(), movie.getGenre(), String.valueOf(movie.getDuration()), movie.getActor(), movie.getDescription()};
            tableModel.addRow(row);
        }
        table.setShowHorizontalLines(true);
        table.setGridColor(new Color(230, 230, 230));
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int col) {
                TableHeader header = new TableHeader(o + "");

                  header.setHorizontalAlignment(JLabel.CENTER);

                return header;
            }
        });
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        
        table.setRowHeight(40);
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int row, int col) {

                JTextArea com = new JTextArea(o.toString());
                com.setLineWrap(true);  // Enable text wrapping
                com.setWrapStyleWord(true);  // Wrap at word boundaries
                com.setOpaque(true);
                
                setBorder(noFocusBorder);
                int rowHeight = com.getHeight();
                if (table.getRowHeight(row) < rowHeight) {
                    table.setRowHeight(row, rowHeight + 10);
                }
                
                com.setForeground(new Color(102, 102, 102));
                
                
                if (selected) {
                    com.setBackground(new Color(239, 244, 255));
                } else {
                    com.setBackground(Color.WHITE);
                }
                return com;
                
            }
        }
        );
        table.setModel(tableModel);
        // Custom Renderer Class
    
        bt_update.setEnabled(false);
        bt_delete.setEnabled(false);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        lb_poster = new javax.swing.JLabel();
        bt_import = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_title = new javax.swing.JTextField();
        tf_genre = new javax.swing.JTextField();
        tf_actor = new javax.swing.JTextField();
        tf_duration = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_description = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        bt_add = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        bt_clear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jScrollPane2.setViewportView(jEditorPane1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_poster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_poster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_poster.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_poster.setPreferredSize(new java.awt.Dimension(120, 160));
        lb_poster.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lb_posterPropertyChange(evt);
            }
        });

        bt_import.setBackground(new java.awt.Color(223, 177, 96));
        bt_import.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        bt_import.setText("Import Poster");
        bt_import.setBorder(null);
        bt_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_importActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel2.setText("Movie Title");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel3.setText("Genre");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel4.setText("Duration (in minute)");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel5.setText("Actor");

        tf_title.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        tf_genre.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        tf_actor.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        tf_duration.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel8.setText("Description");

        tf_description.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        bt_add.setBackground(new java.awt.Color(223, 177, 96));
        bt_add.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        bt_add.setText("Add");
        bt_add.setBorder(null);
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });

        bt_update.setBackground(new java.awt.Color(223, 177, 96));
        bt_update.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        bt_update.setText("Update");
        bt_update.setBorder(null);
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_delete.setBackground(new java.awt.Color(223, 177, 96));
        bt_delete.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        bt_delete.setText("Delete");
        bt_delete.setBorder(null);
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        bt_clear.setBackground(new java.awt.Color(223, 177, 96));
        bt_clear.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        bt_clear.setText("Clear");
        bt_clear.setBorder(null);
        bt_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bt_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(bt_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(bt_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_poster, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_import, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_description)
                            .addComponent(tf_actor)
                            .addComponent(tf_duration)
                            .addComponent(tf_genre)
                            .addComponent(tf_title, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lb_poster, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_import, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf_duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_actor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(tf_description, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Title", "Genre", "Duration", "Actor", "Description"
            }
        )
        {public boolean isCellEditable(int row, int column) {
            return false;
        }}
        //{
            //    Class[] types = new Class [] {
                //        java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
                //    };
            //
            //    public Class getColumnClass(int columnIndex) {
                //        return types [columnIndex];
                //    }
            //}
    );
    table.getTableHeader().setReorderingAllowed(false);
    table.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableMouseClicked(evt);
        }
    });
    tableModel = (DefaultTableModel) table.getModel();
    jScrollPane1.setViewportView(table);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(0, 0, 0)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_importActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_importActionPerformed
        // TODO add your handling code here:
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
        int return_value = file_chooser.showOpenDialog(this);
        if (return_value == JFileChooser.APPROVE_OPTION){
            try {
                InputStream stream = null;
                image_file = file_chooser.getSelectedFile();
                BufferedImage buffered_image = ImageIO.read(image_file);
                
                ImageIcon imageIcon = new ImageIcon(buffered_image);
                Image image = imageIcon.getImage().getScaledInstance(196, 196, Image.SCALE_SMOOTH);
                ImageIcon new_icon = new ImageIcon(image);
                lb_poster.setIcon(new_icon);
                
            } catch (IOException ex) {
//                Logger.getLogger(MovieManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_bt_importActionPerformed

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        // TODO add your handling code here:
        if (lb_poster.getIcon() == null ){
            JOptionPane.showMessageDialog(this, "You must import poster first", "Alert", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String title = tf_title.getText();
        if (title.isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing title ", "Missing input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String genre = tf_genre.getText();
        if (genre.isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing genre ", "Missing input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String duration_text = tf_duration.getText();
        if (duration_text.isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing duration ", "Missing input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int duration;
        try{
            duration = intInput(duration_text);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "You must input an integer number", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String actor = tf_actor.getText();
        if (actor.isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing actor ", "Missing input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String description = tf_description.getText();
        if (description.isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing description ", "Missing input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (movies_set.contains(title)){
            JOptionPane.showMessageDialog(this, String.format("'%s' is already added! Please add another film", title), "Status", JOptionPane.ERROR_MESSAGE);
            return;
        }
        movies_set.add(title);
        Object[] row = {title, genre, duration, actor, description};
        tableModel.addRow(row);
        if (image_file == null){
            return;
        }
        FileInputStream input;
        byte[] image = null;
        try {
            input = new FileInputStream(image_file);
            image = input.readAllBytes();
        
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MovieManagementPanel.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
//            Logger.getLogger(MovieManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Movie new_movie = new Movie(title, genre, duration, actor, description, image);
        Movie returned_movie = admin_controller.addMovie(new_movie);
        if(!returned_movie.equals(null)){
            movies_list.add(returned_movie);
            JOptionPane.showMessageDialog(this, String.format("Successful adding %s to the database", title), "Status", JOptionPane.PLAIN_MESSAGE);
            
        }else{
            JOptionPane.showMessageDialog(this, String.format("%s is exist in the database", title), "Status", JOptionPane.PLAIN_MESSAGE);
        }
        clear();
    }//GEN-LAST:event_bt_addActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        int selected_row = table.getSelectedRow();
        Movie removed_movie = movies_list.get(selected_row);
        int response = JOptionPane.showConfirmDialog(this, String.format("Are you sure to delete movie: '%s'",removed_movie.getTitle()), "Confirm your delete..", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION){
            tableModel.removeRow(selected_row);
            admin_controller.deleteMovie(removed_movie);
            movies_set.remove(removed_movie.getTitle());
            bt_delete.setEnabled(false);
            clear();
        }
        
        
        
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        // TODO add your handling code here:
        int selected_row = table.getSelectedRow();
        Movie old_movie = movies_list.get(selected_row);
        String title = tf_title.getText();
        if (title.isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing title ", "Missing input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String genre = tf_genre.getText();
        if (genre.isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing genre ", "Missing input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String duration_text = tf_duration.getText();
        if (duration_text.isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing duration ", "Missing input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int duration;
        try{
            duration = intInput(duration_text);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "You must input an integer number", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String actor = tf_actor.getText();
        if (actor.isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing actor ", "Missing input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String description = tf_description.getText();
        if (description.isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing description ", "Missing input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        byte[] image = null;
        if (image_file == null){
            image = old_movie.getImage();
        }else{
            FileInputStream input;
            try {
                input = new FileInputStream(image_file);
                image = input.readAllBytes();

            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
        }
        
        Movie new_movie = new Movie(old_movie.getMovieID(),title, genre, duration, actor, description, image);
        tableModel.setValueAt(title, selected_row, 0);
        tableModel.setValueAt(genre, selected_row, 1);
        tableModel.setValueAt(duration_text, selected_row, 2);
        tableModel.setValueAt(actor, selected_row, 3);
        tableModel.setValueAt(description, selected_row, 4);
        movies_set.remove(old_movie.getTitle());
        movies_set.add(new_movie.getTitle());
        if(admin_controller.upDateMovieInfo(new_movie, old_movie)){
            JOptionPane.showMessageDialog(this, String.format("Successful update '%s' ", title), "Status", JOptionPane.PLAIN_MESSAGE);
            
        }else{
            JOptionPane.showMessageDialog(this, String.format("%s is failed to be updated", title), "Status", JOptionPane.PLAIN_MESSAGE);
        }
        
        bt_add.setEnabled(true);
        bt_update.setEnabled(false);
        
        clear();
        
    }//GEN-LAST:event_bt_updateActionPerformed
    private void initializeDocListener(){
        if (docListener == null) { 
        docListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            checkForChanges();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkForChanges();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            checkForChanges();
        }
        };
        }
    }
    private void addTextFieldListeners() {
    tf_title.getDocument().addDocumentListener(docListener);
    tf_genre.getDocument().addDocumentListener(docListener);
    tf_duration.getDocument().addDocumentListener(docListener);
    tf_actor.getDocument().addDocumentListener(docListener);
    tf_description.getDocument().addDocumentListener(docListener);
}
    private void removeTextFieldListeners(){
    tf_title.getDocument().removeDocumentListener(docListener);
    tf_genre.getDocument().removeDocumentListener(docListener);
    tf_duration.getDocument().removeDocumentListener(docListener);
    tf_actor.getDocument().removeDocumentListener(docListener);
    tf_description.getDocument().removeDocumentListener(docListener);
    
    }

private void checkForChanges() {
    // Compare current values with original values
    boolean isChanged = !tf_title.getText().equals(original_title) ||
                        !tf_genre.getText().equals(original_genre) ||
                        !tf_duration.getText().equals(original_duration) ||
                        !tf_actor.getText().equals(original_actor) ||
                        !tf_description.getText().equals(original_description);
    
    // Enable or disable the Update button
    bt_update.setEnabled(isChanged);
}

    private void bt_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_clearActionPerformed
        // TODO add your handling code here:
        clear();
        bt_delete.setEnabled(false);
        bt_add.setEnabled(true);
    }//GEN-LAST:event_bt_clearActionPerformed
    private void clear(){
        tf_title.setText("");
        tf_genre.setText("");
        tf_duration.setText("");
        tf_actor.setText("");
        tf_description.setText("");
        original_title = "";
        original_genre = "";
        original_duration = "";
        original_actor = "";
        original_description = "";
        lb_poster.setIcon(null);
        removeTextFieldListeners();
        bt_add.setVisible(true);
    }
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int selected_row = table.getSelectedRow();
        bt_update.setEnabled(false);
        original_title = (String) tableModel.getValueAt(selected_row, 0);
        original_genre = (String) tableModel.getValueAt(selected_row, 1);              
        original_duration =  String.valueOf(tableModel.getValueAt(selected_row, 2));
        original_actor = (String) tableModel.getValueAt(selected_row, 3);
        original_description = (String) tableModel.getValueAt(selected_row, 4);
        
        tf_title.setText(original_title);
        tf_genre.setText(original_genre);
        tf_duration.setText(original_duration);
        tf_actor.setText(original_actor);
        tf_description.setText(original_description);
        byte[] image_bytes = movies_list.get(selected_row).getImage();
        ByteArrayInputStream input = new ByteArrayInputStream(image_bytes);
        try {
            BufferedImage buffered_image = ImageIO.read(input);
            ImageIcon imageIcon = new ImageIcon(buffered_image);
                Image image = imageIcon.getImage().getScaledInstance(150, 170, Image.SCALE_SMOOTH);
                lb_poster.setIcon(new ImageIcon(image));
        } catch (IOException ex) {
//            Logger.getLogger(MovieManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        bt_delete.setEnabled(true);
        bt_add.setEnabled(false);
        addTextFieldListeners();
    }//GEN-LAST:event_tableMouseClicked
    
    private void lb_posterPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lb_posterPropertyChange
        // TODO add your handling code here:
        if (lb_poster.getIcon() == null){
            bt_update.setEnabled(false);
        }
        
    }//GEN-LAST:event_lb_posterPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_clear;
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_import;
    private javax.swing.JButton bt_update;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_poster;
    private javax.swing.JTable table;
    private javax.swing.JTextField tf_actor;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_duration;
    private javax.swing.JTextField tf_genre;
    private javax.swing.JTextField tf_title;
    // End of variables declaration//GEN-END:variables
}