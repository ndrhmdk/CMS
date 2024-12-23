/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package customer_panel;

import main_view.Guest;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import main_view.CustomerView;
import main_view.StaffView;
import model.Movie;
import model.User;
import staff_panel.StaffScreenPanel;

/**
 *
 * @author OS
 */
public class MovieInfoPanel extends javax.swing.JPanel {
    private CustomerView customer_view;
    private Guest user_view;
    private StaffView staff_view;
    private Movie movie;
    
    /**
     * Creates new form P2_MovieInfo
     */
    public MovieInfoPanel() {
        initComponents();
    }
    public MovieInfoPanel(StaffView frame, Movie movie_){
        initComponents();
        this.staff_view = frame;
        movie = movie_;
        setInfo();
       
    }
    

    public MovieInfoPanel(CustomerView frame, Movie movie_){
        initComponents();
        this.customer_view = frame;
        movie = movie_;
        setInfo();
       
    }
    
    public MovieInfoPanel(Guest frame, Movie movie_){
        initComponents();
        this.user_view = frame;
        movie = movie_;
        setInfo();
    }
    public void setInfo(){
        byte[] image_bytes = movie.getImage();
        ByteArrayInputStream input = new ByteArrayInputStream(image_bytes);
        try {
            BufferedImage buffered_image = ImageIO.read(input);
            ImageIcon imageIcon = new ImageIcon(buffered_image);
                Image image = imageIcon.getImage().getScaledInstance(400, 525, Image.SCALE_SMOOTH);
                lb_poster.setIcon(new ImageIcon(image));
        } catch (IOException ex) {
//            Logger.getLogger(MovieManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        lb_title.setText("<html>" + movie.getTitle() + "</html>");
        lb_genre.setText(movie.getGenre());
        lb_actor.setText(movie.getActor());
        int minutes = movie.getDuration();
        int hour = minutes/60;
        int minute = minutes%60;
        if (hour == 1){
            lb_duration.setText(hour + "hour" + minute + "minutes" );
        }else{
            lb_duration.setText(hour + "hours" + minute + "minutes" );
        }
        
        lb_description.setText("<html>" + movie.getDescription() + "</html>");
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lb_title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lb_actor = new javax.swing.JLabel();
        lb_genre = new javax.swing.JLabel();
        bt_back = new javax.swing.JButton();
        lb_description = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bt_book_ticket = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        lb_actor1 = new javax.swing.JLabel();
        lb_duration = new javax.swing.JLabel();
        lb_poster = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lb_title.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        lb_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_title.setText("La La Land");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(24, 55, 93));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Movie Details");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 2, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(125, 124, 123));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Actor");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 2, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(125, 124, 123));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Genre");

        lb_actor.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lb_actor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_actor.setText("2016");

        lb_genre.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lb_genre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_genre.setText("Drama");

        bt_back.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        bt_back.setForeground(new java.awt.Color(223, 177, 96));
        bt_back.setText("back");
        bt_back.setBorder(null);
        bt_back.setContentAreaFilled(false);
        bt_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backActionPerformed(evt);
            }
        });

        lb_description.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lb_description.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_description.setText("2016");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 2, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(125, 124, 123));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Duration");

        bt_book_ticket.setBackground(new java.awt.Color(223, 177, 96));
        bt_book_ticket.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        bt_book_ticket.setText("BOOK TICKET");
        bt_book_ticket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bt_book_ticket.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_book_ticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_book_ticketActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 2, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(125, 124, 123));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("ShowDate");

        lb_actor1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lb_actor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_actor1.setText("Today");

        lb_duration.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lb_duration.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_duration.setText("2016");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_back, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_description, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(bt_book_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_title, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_actor)
                            .addComponent(lb_genre)
                            .addComponent(lb_actor1)
                            .addComponent(lb_duration)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lb_title, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lb_genre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lb_actor))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lb_duration))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lb_actor1))
                .addGap(60, 60, 60)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_description, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(bt_book_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_back)
                .addContainerGap())
        );

        lb_poster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lb_poster, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lb_poster, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_book_ticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_book_ticketActionPerformed
        // TODO add your handling code here:
        if (customer_view != null){
            customer_view.getMainForm().showForm(new CustomerScreenPanel(movie, customer_view.getCustomer()));
            return;   
        }
        if (user_view != null){
            user_view.getMainForm().showForm(new GuestScreenPanel(movie));
            return;
        }
        if (staff_view != null){
            staff_view.getMainForm().showForm(new StaffScreenPanel(movie));
        }
        
        
    }//GEN-LAST:event_bt_book_ticketActionPerformed

    private void bt_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backActionPerformed
        // TODO add your handling code here:
        if (customer_view == null){
            user_view.getMainForm().showForm(new MovieDisplayPanel());
            
        }else{
            customer_view.getMainForm().showForm(new MovieDisplayPanel());
        }
       
    }//GEN-LAST:event_bt_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_back;
    private javax.swing.JButton bt_book_ticket;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb_actor;
    private javax.swing.JLabel lb_actor1;
    private javax.swing.JLabel lb_description;
    private javax.swing.JLabel lb_duration;
    private javax.swing.JLabel lb_genre;
    private javax.swing.JLabel lb_poster;
    private javax.swing.JLabel lb_title;
    // End of variables declaration//GEN-END:variables
}
