/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package customer_panel;

import controller.CustomerController;
import main_view.Guest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import main_view.CustomerView;

import main_view.StaffView;
import model.Movie;

/**
 *
 * @author mac
 */
public class MovieDisplayPanel extends javax.swing.JPanel {
    private static CustomerController customer_controller = CustomerController.getInstance();
    private CustomerView customer_view;
    private Guest my_guest;
    private StaffView staff_view;
    ArrayList<Movie> movies_list = customer_controller.getMovies();
    private JPanel temp_panel;
    private JScrollPane scrollPane;
    /**
     * Creates new form MovieDisplayPanel
     */
    public MovieDisplayPanel() {
        initComponents();
    }
     public MovieDisplayPanel(StaffView frame) {
        this.staff_view = frame;
        initComponents();
        this.add(search_panel, BorderLayout.NORTH);
        temp_panel = moviesPanel;
        
    }
    
    
    public MovieDisplayPanel(Guest frame) {
        this.my_guest = frame;
        initComponents();
        this.add(search_panel, BorderLayout.NORTH);
        temp_panel = moviesPanel;
        
    }
    
    public MovieDisplayPanel(CustomerView frame){
        this.customer_view = frame;
        initComponents();
        this.add(search_panel, BorderLayout.NORTH);
        temp_panel = moviesPanel;
    }
    
    
    static class ScalableImagePanel extends JPanel {
        private BufferedImage originalImage;

        public ScalableImagePanel(byte[] imageBytes) {
            try (ByteArrayInputStream is = new ByteArrayInputStream(imageBytes)) {
                this.originalImage = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (originalImage != null) {
                // Dynamically scale the image to the current panel size
                int width = getWidth();
                int height = getHeight();
                g.drawImage(originalImage, 0, 0, width, height, this);
            }
        }
    }
    // Method to create a movie panel
    private JPanel createMoviePanel(Movie movie) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setPreferredSize(new Dimension(300, 400));
        panel.setBackground(Color.WHITE);
        // Custom scalable image panel
        ScalableImagePanel imagePanel = new ScalableImagePanel(movie.getImage());
        imagePanel.setPreferredSize(new Dimension(300, 340));
        
        imagePanel.add(Box.createRigidArea(new Dimension(0, 20))); 
        // Movie title
        JLabel titleLabel = new JLabel(movie.getTitle(), JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 17));

        // Add components to the panel
        panel.add(imagePanel, BorderLayout.CENTER);
        panel.add(titleLabel, BorderLayout.SOUTH);
        
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                if (my_guest != null){
                    my_guest.getMainForm().showForm(new MovieInfoPanel(my_guest, movie));
                  
                }else if(customer_view != null){
                    customer_view.getMainForm().showForm(new MovieInfoPanel(customer_view, movie));             
                }else{
                    staff_view.getMainForm().showForm(new MovieInfoPanel(staff_view, movie));
                }
                

        } });
        return panel;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        search_panel = new javax.swing.JPanel();
        tf_search = new cms.component.SearchTextField();
        moviesPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 650));

        search_panel.setBackground(new java.awt.Color(255, 255, 255));
        search_panel.setLayout(new java.awt.BorderLayout());

        tf_search.setText("Search movie here...");
        tf_search.setMinimumSize(new java.awt.Dimension(64, 30));
        tf_search.setPreferredSize(new java.awt.Dimension(131, 30));
        tf_search.setPrefixIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/main/image_folder/loupe.png"));
        tf_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_searchMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tf_searchMousePressed(evt);
            }
        });
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });
        search_panel.add(tf_search, java.awt.BorderLayout.CENTER);

        moviesPanel.setBackground(new java.awt.Color(255, 255, 255));
        moviesPanel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(moviesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(search_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moviesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margin around posters
        gbc.fill = GridBagConstraints.BOTH; // Make components fill the available space
        gbc.weightx = 1.0; // Allow horizontal resizing
        gbc.weighty = 1.0; // Allow vertical resizing

        int columns = 3; // Number of columns for the layout
        int currentColumn = 0;

        // Example list of movies
        for (int i = 0; i < movies_list.size(); i++) {
            Movie movie = movies_list.get(i);
            JPanel moviePanel = createMoviePanel(movie);

            // Position movie panels in the grid
            gbc.gridx = currentColumn; // Column index
            gbc.gridy = i / columns; // Row index
            moviesPanel.add(moviePanel, gbc);

            // Move to the next column
            currentColumn++;
            if (currentColumn >= columns) {
                currentColumn = 0;
            }
        }
        // Wrap the moviesPanel in a JScrollPane
        scrollPane = new JScrollPane(moviesPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //// Add the scrollPane to the main panel
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    public void printArrayList(ArrayList<Movie> movies){
        for (Movie movie : movies){
            System.out.println("Movie search title: " + movie.getTitle());
        }
    }
    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
        String search_title = tf_search.getText();
        System.out.printf("We are searching for '%s'", search_title);
        if (search_title.isEmpty()){
            displaySearchMovie(movies_list);
            return;
        }
        ArrayList<Movie> search_movies = customer_controller.searchByTitles(search_title);
        
        if (search_movies.isEmpty()){
            System.out.println("Searching movies is null");
            moviesPanel.removeAll();
            moviesPanel.add(new JLabel("New searching is not found"));
            moviesPanel.repaint();
             moviesPanel.revalidate();
            
        }else{
            printArrayList(search_movies);

            displaySearchMovie(search_movies);
        }
        
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_searchMouseClicked
        // TODO add your handling code here:
        tf_search.setText("");
    }//GEN-LAST:event_tf_searchMouseClicked

    private void tf_searchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_searchMousePressed
        // TODO add your handling code here:
        tf_search.setText("");
    }//GEN-LAST:event_tf_searchMousePressed
    private void displaySearchMovie(ArrayList<Movie> searched_movie){
        moviesPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margin around posters
        gbc.fill = GridBagConstraints.NONE; // Make components fill the available space
        gbc.anchor  = GridBagConstraints.LINE_START;
        gbc.weightx = 0; // Allow horizontal resizing
        gbc.weighty = 0; // Allow vertical resizing
            
        int columns = 3; // Number of columns for the layout
        int currentColumn = 0;

        // Example list of movies
        for (int i = 0; i < searched_movie.size(); i++) {
            Movie movie = searched_movie.get(i);
            JPanel moviePanel = createMoviePanel(movie);
            
            
            // Position movie panels in the grid
            gbc.gridx = currentColumn; // Column index
            gbc.gridy = i / columns; // Row index
            moviesPanel.add(moviePanel, gbc);

            // Move to the next column
            currentColumn++;
            if (currentColumn >= columns) {
                currentColumn = 0;
            }
        }

        
        moviesPanel.repaint();
        moviesPanel.revalidate();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel moviesPanel;
    private javax.swing.JPanel search_panel;
    private cms.component.SearchTextField tf_search;
    // End of variables declaration//GEN-END:variables
}
