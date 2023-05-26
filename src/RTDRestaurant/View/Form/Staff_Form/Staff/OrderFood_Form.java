package RTDRestaurant.View.Form.Staff_Form.Staff;

import RTDRestaurant.Controller.Service.ServiceCustomer;
import RTDRestaurant.Controller.Service.ServiceStaff;
import RTDRestaurant.Model.ModelBan;
import RTDRestaurant.Model.ModelMonAn;
import RTDRestaurant.Model.ModelHoaDon;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.Model.ModelNhanVien;
import RTDRestaurant.View.Component.Customer_Component.CardMonAn;
import RTDRestaurant.View.Form.MainForm;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import RTDRestaurant.View.Swing.WrapLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderFood_Form extends javax.swing.JPanel {

    private final ServiceStaff serviceS;
    private final ServiceCustomer serviceC;
    private ArrayList<ModelMonAn> list;
    private final ModelNhanVien staff;
    private ModelNguoiDung user;
    private ModelBan table;
    private MainForm main;
    private ModelHoaDon HoaDon;

    public OrderFood_Form(ModelNguoiDung user,ModelNhanVien staff,ModelBan table,MainForm main) {
        this.user=user;
        this.staff=staff;
        this.table=table;
        this.main=main;
        serviceS = new ServiceStaff();
        serviceC = new ServiceCustomer();
        initComponents();
        init();

    }

    public void init() {

        panel.setLayout(new WrapLayout(WrapLayout.LEADING, 20, 20));
        txtSearch.setHint("Tìm kiếm món ăn . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        
        //Tìm thông tin hóa đơn
        try {
            HoaDon=serviceS.FindHoaDonbyID_Ban(table);
        } catch (SQLException ex) {
            Logger.getLogger(OrderFood_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtTableID.setText(table.getID()+"");
        txtKH.setText(HoaDon.getIdKH()+"");
        //Tìm thông tin Hóa Đơn mà Khách Hàng vừa tạo
        //Thêm data cho Menu
        initMenuFood("Aries");
        //Thêm event cho nút Xem hóa đơn
        cmdShowBill.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                main.showForm(new BillS_Form(user,staff,table,HoaDon,main));
            }
        });
    }

    public void initMenuFood(String type) {
        try {
            list = serviceC.MenuFood(type);
            panel.removeAll();
            for (ModelMonAn data : list) {
                panel.add(new CardMonAn(data, HoaDon));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        panel.repaint();
        panel.revalidate();
    }

    public void searchFood(String txt) {
        panel.removeAll();
        for (ModelMonAn data : list) {
            if (data.getTitle().toLowerCase().contains(txt.toLowerCase())) {
                panel.add(new CardMonAn(data, HoaDon));
            }
        }
        panel.repaint();
        panel.revalidate();
    }

    public void initMenuFoodOrderby(String txt) {
        try {
            list = serviceC.MenuFoodOrder((String) TypeMenu.getSelectedItem(), txt);
            panel.removeAll();
            for (ModelMonAn data : list) {
                panel.add(new CardMonAn(data, HoaDon));
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderFood_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel.repaint();
        panel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        lbMenu = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        orderby = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cmdShowBill = new RTDRestaurant.View.Swing.Button();
        lbTable = new javax.swing.JLabel();
        txtTableID = new RTDRestaurant.View.Swing.MyTextField();
        cmdBack = new javax.swing.JLabel();
        TypeMenu = new javax.swing.JComboBox<>();
        lbKH = new javax.swing.JLabel();
        txtKH = new RTDRestaurant.View.Swing.MyTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(247, 247, 247));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(215, 221, 232));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 963, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        lbMenu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbMenu.setForeground(new java.awt.Color(108, 91, 123));
        lbMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu.png"))); // NOI18N
        lbMenu.setText("Danh sách Thực Đơn");
        lbMenu.setIconTextGap(10);
        lbMenu.setInheritsPopupMenu(false);

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
        orderby.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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

        cmdShowBill.setBackground(new java.awt.Color(108, 91, 123));
        cmdShowBill.setForeground(new java.awt.Color(255, 255, 255));
        cmdShowBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboard.png"))); // NOI18N
        cmdShowBill.setText("XEM HÓA ĐƠN");
        cmdShowBill.setFocusable(false);
        cmdShowBill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbTable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTable.setForeground(new java.awt.Color(89, 89, 89));
        lbTable.setText("Mã Bàn");

        txtTableID.setEditable(false);
        txtTableID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTableID.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        cmdBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cmdBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        cmdBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdBackMouseClicked(evt);
            }
        });

        TypeMenu.setEditable(true);
        TypeMenu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TypeMenu.setForeground(new java.awt.Color(108, 91, 123));
        TypeMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces" }));
        TypeMenu.setToolTipText("Sắp xếp");
        TypeMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 145, 145), 2));
        TypeMenu.setFocusable(false);
        TypeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeMenuActionPerformed(evt);
            }
        });

        lbKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbKH.setForeground(new java.awt.Color(89, 89, 89));
        lbKH.setText("Mã Khách Hàng");

        txtKH.setEditable(false);
        txtKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKH.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(76, 76, 76));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setBackground(new java.awt.Color(76, 76, 76));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTable)
                                .addGap(50, 50, 50)
                                .addComponent(txtTableID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(lbKH)
                                .addGap(50, 50, 50)
                                .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(20, 20, 20)
                        .addComponent(orderby, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbMenu)
                        .addGap(30, 30, 30)
                        .addComponent(TypeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdShowBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdBack)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTableID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbKH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TypeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmdShowBill, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderby)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void TypeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeMenuActionPerformed
        initMenuFood((String) TypeMenu.getSelectedItem());
    }//GEN-LAST:event_TypeMenuActionPerformed

    private void cmdBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdBackMouseClicked
        main.showForm(new TableMenuS_Form("Tang 1", user, main));
    }//GEN-LAST:event_cmdBackMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> TypeMenu;
    private javax.swing.JLabel cmdBack;
    private RTDRestaurant.View.Swing.Button cmdShowBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbKH;
    private javax.swing.JLabel lbMenu;
    private javax.swing.JLabel lbTable;
    private javax.swing.JComboBox<String> orderby;
    private javax.swing.JPanel panel;
    private RTDRestaurant.View.Swing.MyTextField txtKH;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    private RTDRestaurant.View.Swing.MyTextField txtTableID;
    // End of variables declaration//GEN-END:variables
}
