package RTDRestaurant.View.Form.Staff_Form.WarehouseStaff;

import RTDRestaurant.Controller.Service.ServiceStaff;
import RTDRestaurant.Model.ModelNguyenLieu;
import RTDRestaurant.View.Form.MainForm;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class InsertAndUpdate_Ingredient_Form extends javax.swing.JPanel {

    private ServiceStaff service;
    private final MainForm main;
    private ModelNguyenLieu data;
    private boolean insert;  //Thêm hay sửa
    public InsertAndUpdate_Ingredient_Form(MainForm main,ModelNguyenLieu data) {
        this.main = main;
        this.data=data;
        initComponents();
        init();
    }

    public void init() {
        service = new ServiceStaff();
        if(data==null){
            insert=true;
            lbTitle.setText("Thêm NGUYÊN LIỆU");
            pic.setIcon(new ImageIcon(getClass().getResource("/Icons/ingredient.jpg")));
            data = new ModelNguyenLieu();
            initID_NL(); 
        }else{
            insert=false;
            lbTitle.setText("Sửa NGUYÊN LIỆU");
            pic.setIcon(new ImageIcon(getClass().getResource("/Icons/ingredient1.jpg")));
            txtmaNL.setText(data.getId()+"");
            txttenNL.setText(data.getTenNL());
            txtdongia.setText(data.getDonGia()+"");
            jComboBoxDVT.setSelectedItem(data.getDvt());
        }
              
        
    }
    
    public void initID_NL(){
        try {
            data.setId(service.getNextID_NL());
            txtmaNL.setText(data.getId()+"");
        } catch (SQLException ex) {
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new RTDRestaurant.View.Swing.PanelRound();
        pic = new RTDRestaurant.View.Swing.ImageAvatar();
        lbmaNL = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbtenNL = new javax.swing.JLabel();
        txttenNL = new RTDRestaurant.View.Swing.MyTextField();
        lbdongia = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbDVT = new javax.swing.JLabel();
        txtmaNL = new RTDRestaurant.View.Swing.MyTextField();
        txtdongia = new RTDRestaurant.View.Swing.MyTextField();
        jComboBoxDVT = new javax.swing.JComboBox<>();
        cmdOK = new RTDRestaurant.View.Swing.ButtonOutLine();
        cmdCancel = new RTDRestaurant.View.Swing.ButtonOutLine();

        setBackground(new java.awt.Color(222, 222, 222));

        bg.setBackground(new java.awt.Color(247, 247, 247));

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ingredient.jpg"))); // NOI18N

        lbmaNL.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbmaNL.setForeground(new java.awt.Color(89, 89, 89));
        lbmaNL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmaNL.setText("Mã Nguyên Liệu");

        lbTitle.setBackground(new java.awt.Color(255, 255, 255));
        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/grocery.png"))); // NOI18N
        lbTitle.setText("Thêm NGUYÊN LIỆU");
        lbTitle.setIconTextGap(10);

        lbtenNL.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbtenNL.setForeground(new java.awt.Color(89, 89, 89));
        lbtenNL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbtenNL.setText("Tên Nguyên Liệu");

        txttenNL.setForeground(new java.awt.Color(93, 98, 101));
        txttenNL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttenNL.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N

        lbdongia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbdongia.setForeground(new java.awt.Color(89, 89, 89));
        lbdongia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbdongia.setText("Đơn Giá");

        jSeparator1.setBackground(new java.awt.Color(76, 76, 76));

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        lbDVT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbDVT.setForeground(new java.awt.Color(89, 89, 89));
        lbDVT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDVT.setText("Đơn Vị Tính");

        txtmaNL.setEditable(false);
        txtmaNL.setBackground(new java.awt.Color(175, 185, 203));
        txtmaNL.setForeground(new java.awt.Color(93, 98, 101));
        txtmaNL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmaNL.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N

        txtdongia.setForeground(new java.awt.Color(93, 98, 101));
        txtdongia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdongia.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        txtdongia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdongiaKeyTyped(evt);
            }
        });

        jComboBoxDVT.setBackground(new java.awt.Color(215, 221, 232));
        jComboBoxDVT.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jComboBoxDVT.setForeground(new java.awt.Color(83, 105, 118));
        jComboBoxDVT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "g", "kg", "ml", "l" }));
        jComboBoxDVT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jComboBoxDVT.setFocusable(false);

        cmdOK.setBackground(new java.awt.Color(17, 153, 142));
        cmdOK.setForeground(new java.awt.Color(108, 91, 123));
        cmdOK.setText("Xác nhận");
        cmdOK.setFocusable(false);
        cmdOK.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOKActionPerformed(evt);
            }
        });

        cmdCancel.setBackground(new java.awt.Color(237, 33, 58));
        cmdCancel.setForeground(new java.awt.Color(108, 91, 123));
        cmdCancel.setText("Hủy");
        cmdCancel.setFocusable(false);
        cmdCancel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbdongia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbDVT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                                        .addGap(29, 29, 29)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtdongia, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(jComboBoxDVT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(1, 1, 1))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbtenNL, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                            .addComponent(lbmaNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(30, 30, 30)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttenNL, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmaNL, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(80, 80, 80))))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbTitle)
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbmaNL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmaNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbtenNL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbdongia, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtdongiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdongiaKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtdongiaKeyTyped

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        data.setTenNL(txttenNL.getText().trim());
        data.setDonGia(Integer.parseInt(txtdongia.getText()));
        data.setDvt(jComboBoxDVT.getSelectedItem().toString());
      
        try {
            if(insert){
               service.InsertNL(data);
            }else{
               service.UpdateNL(data);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InsertAndUpdate_Ingredient_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
        main.showForm(new Ingredient_Form(main));
    }//GEN-LAST:event_cmdOKActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        main.showForm(new Ingredient_Form(main));
    }//GEN-LAST:event_cmdCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Swing.PanelRound bg;
    private RTDRestaurant.View.Swing.ButtonOutLine cmdCancel;
    private RTDRestaurant.View.Swing.ButtonOutLine cmdOK;
    private javax.swing.JComboBox<String> jComboBoxDVT;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDVT;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbdongia;
    private javax.swing.JLabel lbmaNL;
    private javax.swing.JLabel lbtenNL;
    private RTDRestaurant.View.Swing.ImageAvatar pic;
    private RTDRestaurant.View.Swing.MyTextField txtdongia;
    private RTDRestaurant.View.Swing.MyTextField txtmaNL;
    private RTDRestaurant.View.Swing.MyTextField txttenNL;
    // End of variables declaration//GEN-END:variables
}
