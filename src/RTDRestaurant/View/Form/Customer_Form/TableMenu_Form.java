
package RTDRestaurant.View.Form.Customer_Form;

import RTDRestaurant.Controller.Service.ServiceCustomer;
import RTDRestaurant.Model.ModelKhachHang;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.Model.ModelBan;
import RTDRestaurant.View.Component.Customer_Component.CardBan;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import RTDRestaurant.View.Swing.WrapLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class TableMenu_Form extends javax.swing.JPanel {

    private final String floor;
    private ServiceCustomer service;
    private ArrayList<ModelBan> list;
    private ModelNguoiDung user;
    private ModelKhachHang customer;
    
    public TableMenu_Form(String floor) {
        this.floor=floor;
        service=new ServiceCustomer();
        initComponents();
        init();
    }
    
    public TableMenu_Form(String floor,ModelNguoiDung user) {
        this.floor=floor;
        this.user=user;
        service=new ServiceCustomer();
        initComponents();
        init();
    }

    public void init(){
        try {
            customer=service.getCustomer(user.getUserID());
            panel.setLayout(new WrapLayout(WrapLayout.LEADING,20,20));
            txtSearch.setHint("Tìm kiếm bàn . . .");
            jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
            //Thêm data cho Menu
            initMenuTable();
            
            switch (floor) {
                case "Tang 1" -> {
                    lbTitle.setText("Đặt bàn/Tầng 1");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/one.png")));
                }
                case "Tang 2" -> {
                    lbTitle.setText("Đặt bàn/Tầng 2");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/two.png")));
                }
                case "Tang 3" -> {
                    lbTitle.setText("Đặt bàn/Tầng 3");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/three.png")));
                }
                default -> {
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableMenu_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
          
 
    }
    public void initMenuTable(){
        try {
            
            list = service.MenuTable(floor);
            for(ModelBan data:list){
            panel.add(new CardBan(data,customer));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void searchTable(String txt){
        panel.removeAll();
        for(ModelBan data:list){
            if(data.getName().toLowerCase().contains(txt.toLowerCase())){
                panel.add(new CardBan(data,customer));
            }
        }
        panel.repaint();
        panel.revalidate();
    }
    public void initMenuTableState(String txt){
        try {
            list=service.MenuTableState(floor,txt);
            panel.removeAll();
            for(ModelBan data:list){   
            panel.add(new CardBan(data,customer));
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
        state = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 247, 247));

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
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/one.png"))); // NOI18N
        lbTitle.setText("Đặt Bàn/Tầng 1");
        lbTitle.setIconTextGap(10);

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

        state.setEditable(true);
        state.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        state.setForeground(new java.awt.Color(108, 91, 123));
        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn trống", "Đang dùng bữa", "Đã đặt trước", " " }));
        state.setToolTipText("Sắp xếp");
        state.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 145, 145), 2));
        state.setFocusable(false);
        state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(108, 91, 123));
        jLabel1.setText("Hiển thị theo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(state)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseEntered
        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchMouseEntered

    private void stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateActionPerformed
        initMenuTableState(state.getSelectedItem().toString());
    }//GEN-LAST:event_stateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JComboBox<String> state;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
