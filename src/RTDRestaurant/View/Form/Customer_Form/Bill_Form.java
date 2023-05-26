
package RTDRestaurant.View.Form.Customer_Form;

import RTDRestaurant.Controller.Service.ServiceCustomer;
import RTDRestaurant.Model.ModelKhachHang;
import RTDRestaurant.Model.ModelHoaDon;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Bill_Form extends javax.swing.JPanel {

    private ModelNguoiDung user;
    private ModelKhachHang customer;
    private ServiceCustomer service;
    private ArrayList<ModelHoaDon> list;
    DecimalFormat df;

    public Bill_Form(ModelNguoiDung user) {
        this.user=user;
        service=new ServiceCustomer();
        initComponents();
        init();
    }

    public void init(){
        txtSearch.setHint("Tìm kiếm Hóa Đơn . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        df = new DecimalFormat("##,###,###");
        getUserSales();
        //Thêm data cho Menu
        initTable();
        
    }
    public void getUserSales(){
        try {
            customer=service.getCustomer(user.getUserID());
            txtPoint.setText(df.format(customer.getSales())+"đ");
        } catch (SQLException ex) {
            Logger.getLogger(Bill_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void initTable(){
        try {
            list = service.getListHD(customer.getID_KH());
            for(ModelHoaDon data:list){  
                tableHD.addRow(new Object[]{data.getIdHoaDon(),data.getNgayHD(),df.format(data.getTienMonAn())+"đ"
                               ,data.getCode_voucher(),df.format(data.getTienGiam())+"đ"
                               ,df.format(data.getTongtien())+"đ"});
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void searchTable(String txt){
        tableHD.removeAllRow();
        for(ModelHoaDon data:list){
            if((data.getIdHoaDon()+"").toLowerCase().contains(txt.toLowerCase())){
                tableHD.addRow(new Object[]{data.getIdHoaDon(),data.getNgayHD(),df.format(data.getTienMonAn())+"đ"
                               ,data.getCode_voucher(),df.format(data.getTienGiam())+"đ"
                               ,df.format(data.getTongtien())+"đ"});
            }
        }
        tableHD.repaint();
        tableHD.revalidate();
    }
    public void initTableHDbyTotal(String byTotal){
        try {
            list=service.getListHDOrder(customer.getID_KH(),byTotal);
            tableHD.removeAllRow();
            for(ModelHoaDon data:list){  
                tableHD.addRow(new Object[]{data.getIdHoaDon(),data.getNgayHD(),df.format(data.getTienMonAn())+"đ"
                               ,data.getCode_voucher(),df.format(data.getTienGiam())+"đ"
                               ,df.format(data.getTongtien())+"đ"});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bill_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        cbbox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lbDso = new javax.swing.JLabel();
        txtPoint = new RTDRestaurant.View.Swing.MyTextField();
        lbBill = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHD = new RTDRestaurant.View.Swing.Table();

        setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clock.png"))); // NOI18N
        lbTitle.setText("Lịch sử hóa đơn");
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
        cbbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Dưới 1.000.000đ", "Từ 1 đến 5.000.000đ", "Trên 5.000.000đ" }));
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

        lbDso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDso.setForeground(new java.awt.Color(89, 89, 89));
        lbDso.setText("Doanh số của bạn");

        txtPoint.setEditable(false);
        txtPoint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPoint.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lbBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbBill.setForeground(new java.awt.Color(89, 89, 89));
        lbBill.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbBill.setText("Danh sách Hóa Đơn");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tableHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Ngày HĐ", "Tiền Món Ăn", "Voucher", "Tiền Giảm", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableHD);
        if (tableHD.getColumnModel().getColumnCount() > 0) {
            tableHD.getColumnModel().getColumn(0).setMinWidth(120);
            tableHD.getColumnModel().getColumn(0).setMaxWidth(120);
            tableHD.getColumnModel().getColumn(1).setPreferredWidth(30);
            tableHD.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableHD.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableHD.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbDso, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbTitle)
                            .addComponent(lbBill))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        initTableHDbyTotal(cbbox.getSelectedItem().toString());
    }//GEN-LAST:event_cbboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbBill;
    private javax.swing.JLabel lbDso;
    private javax.swing.JLabel lbTitle;
    private RTDRestaurant.View.Swing.Table tableHD;
    private RTDRestaurant.View.Swing.MyTextField txtPoint;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
