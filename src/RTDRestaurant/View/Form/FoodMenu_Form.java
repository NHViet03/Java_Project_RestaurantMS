
package RTDRestaurant.View.Form;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Controller.Service.ServiceCustomer;
import RTDRestaurant.Model.ModelCard;
import RTDRestaurant.View.Component.Card;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import RTDRestaurant.View.Swing.WrapLayout;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class FoodMenu_Form extends javax.swing.JPanel {

    private final String type;
    private ServiceCustomer service;
    private ArrayList<ModelCard> list;
    public FoodMenu_Form(String type) {
        this.type=type;
        service=new ServiceCustomer();
        initComponents();
        init();
    }

    public void init(){
        panel.setLayout(new WrapLayout(WrapLayout.LEADING,20,20));
        txtSearch.setHint("Tìm kiếm món ăn . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        //Thêm data cho Menu
        initMenuFood();
   
        //Set Data cho Tiêu đề Menu     
        switch (type) {
            case "Arias" -> {
                lbTitle.setText("Menu/"+type+" - Bạch Dương");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/aries.png")));
            }
            case "Taurus" -> {
                lbTitle.setText("Menu/"+type+" - Kim Ngưu");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/taurus.png")));
            }
            case "Gemini" -> {
                lbTitle.setText("Menu/"+type+" - Song tử");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/gemini.png")));
            }
            case "Cancer" -> {
                lbTitle.setText("Menu/"+type+" - Cự Giải");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/cancer.png")));
            }
            case "Leo" -> {
                lbTitle.setText("Menu/"+type+" - Sư tử");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/leo.png")));
            }
            case "Virgo" -> {
                lbTitle.setText("Menu/"+type+" - Xử Nữ");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/virgo.png")));
            }
            case "Libra" -> {
                lbTitle.setText("Menu/"+type+" - Thiên Bình");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/libra.png")));
            }
            case "Scorpio" -> {
                lbTitle.setText("Menu/"+type+" - Bọ Cạp");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/scorpio.png")));
            }
            case "Sagittarius" -> {
                lbTitle.setText("Menu/"+type+" - Nhân Mã");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/sagittarius.png")));
            }
            case "Capricorn" -> {
                lbTitle.setText("Menu/"+type+" - Ma Kết");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/capricorn.png")));
            }
            case "Aquarius" -> {
                lbTitle.setText("Menu/"+type+" - Bảo Bình");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/aquarius.png")));
            }
            case "Pisces" -> {
                lbTitle.setText("Menu/"+type+" - Song Ngư");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/pisces.png")));
            }
            default -> {
            }
        }
    }
    public void initMenuFood(){
        try {
            list = service.MenuFood(type);
            for(ModelCard data:list){   
            panel.add(new Card(data));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void searchFood(String txt){
        panel.removeAll();
        for(ModelCard data:list){
            if(data.getTitle().toLowerCase().contains(txt.toLowerCase())){
                panel.add(new Card(data));
            }
        }
        panel.repaint();
        panel.revalidate();
    }
    public void initMenuFoodOrderby(String txt){
        try {
            list=service.MenuFoodOrder(type,txt);
            panel.removeAll();
            for(ModelCard data:list){   
            panel.add(new Card(data));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FoodMenu_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel.repaint();
        panel.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        header1 = new RTDRestaurant.View.Component.OrderBar();
        orderby = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        panel.setBackground(new java.awt.Color(215, 221, 232));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/MenuBar/aries.png"))); // NOI18N
        lbTitle.setText("Menu/Arias - Bạch Dương");
        lbTitle.setIconTextGap(10);
        lbTitle.setInheritsPopupMenu(false);

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe (1).png"))); // NOI18N
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSearchMouseEntered(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        orderby.setEditable(true);
        orderby.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        orderby.setForeground(new java.awt.Color(108, 91, 123));
        orderby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên A->Z", "Giá tăng dần", "Giá giảm dần" }));
        orderby.setSelectedIndex(-1);
        orderby.setToolTipText("Sắp xếp");
        orderby.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 145, 145), 2));
        orderby.setFocusable(false);
        orderby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderbyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(108, 91, 123));
        jLabel1.setText("Sắp xếp theo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderby, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderby)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(header1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseEntered
        searchFood(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchMouseEntered

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        searchFood(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void orderbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderbyActionPerformed
        initMenuFoodOrderby((String) orderby.getSelectedItem());
    }//GEN-LAST:event_orderbyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Component.OrderBar header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JComboBox<String> orderby;
    private javax.swing.JPanel panel;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
