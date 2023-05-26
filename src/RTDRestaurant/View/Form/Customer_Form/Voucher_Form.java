
package RTDRestaurant.View.Form.Customer_Form;

import RTDRestaurant.Controller.Service.ServiceCustomer;
import RTDRestaurant.Model.ModelKhachHang;
import RTDRestaurant.Model.ModelHoaDon;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.Model.ModelVoucher;
import RTDRestaurant.View.Component.Customer_Component.CardVoucher;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import RTDRestaurant.View.Swing.WrapLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Voucher_Form extends javax.swing.JPanel {

    private ModelNguoiDung user;
    private ServiceCustomer service;
    private ArrayList<ModelVoucher> list;
    private ModelKhachHang customer;
    private ModelHoaDon hoadon;
    public Voucher_Form() {
        service=new ServiceCustomer();
        initComponents();
        init();
    }
    
    public Voucher_Form(ModelNguoiDung user) {
        this.user=user;
        service=new ServiceCustomer();
        initComponents();
        init();
    }

    public void init(){
        panel.setLayout(new WrapLayout(WrapLayout.LEADING,20,20));
        txtSearch.setHint("Tìm kiếm Voucher . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        
        getCustomerAndBill();
        //Thêm data cho Menu
        initMenuVoucher();
        
    }
    public void getCustomerAndBill(){
        try {
            customer=service.getCustomer(user.getUserID());
            hoadon=service.FindHoaDon(customer);
            txtPoint.setText(customer.getPoints()+" xu");
        } catch (SQLException ex) {
            Logger.getLogger(Voucher_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void initMenuVoucher(){
        try {
            list = service.MenuVoucher();
            for(ModelVoucher data:list){  
            panel.add(new CardVoucher(data,customer,hoadon));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void searchTable(String txt){
        panel.removeAll();
        for(ModelVoucher data:list){
            if(data.getDescription().toLowerCase().contains(txt.toLowerCase())){
                panel.add(new CardVoucher(data,customer,hoadon));
            }
        }
        panel.repaint();
        panel.revalidate();
    }
    public void initMenuVoucherbyPoint(String bypoint){
        try {
            list=service.MenuVoucherbyPoint(bypoint);
            panel.removeAll();
            for(ModelVoucher data:list){   
            panel.add(new CardVoucher(data,customer,hoadon));
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
        cbbox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lbdTL = new javax.swing.JLabel();
        txtPoint = new RTDRestaurant.View.Swing.MyTextField();
        lbVoucher = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(247, 247, 247));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(215, 221, 232));
        panel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/voucher.png"))); // NOI18N
        lbTitle.setText("Điểm tích lũy\n");
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

        cbbox.setEditable(true);
        cbbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbox.setForeground(new java.awt.Color(108, 91, 123));
        cbbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Dưới 300 xu", "Từ 300 đến 500 xu", "Trên 500 xu" }));
        cbbox.setToolTipText("Sắp xếp");
        cbbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 145, 145), 2));
        cbbox.setFocusable(false);
        cbbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbboxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(108, 91, 123));
        jLabel1.setText("Hiển thị theo");

        lbdTL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbdTL.setForeground(new java.awt.Color(89, 89, 89));
        lbdTL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbdTL.setText("Điểm tích lũy của bạn");

        txtPoint.setEditable(false);
        txtPoint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPoint.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lbVoucher.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbVoucher.setForeground(new java.awt.Color(89, 89, 89));
        lbVoucher.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbVoucher.setText("Đổi Voucher");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbdTL)
                                .addGap(50, 50, 50)
                                .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbTitle)
                            .addComponent(lbVoucher))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbdTL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseEntered
        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchMouseEntered

    private void cbboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbboxActionPerformed
        initMenuVoucherbyPoint(cbbox.getSelectedItem().toString());
    }//GEN-LAST:event_cbboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbVoucher;
    private javax.swing.JLabel lbdTL;
    private javax.swing.JPanel panel;
    private RTDRestaurant.View.Swing.MyTextField txtPoint;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
