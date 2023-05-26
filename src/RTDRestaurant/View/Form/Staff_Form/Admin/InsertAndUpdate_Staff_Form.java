package RTDRestaurant.View.Form.Staff_Form.Admin;

import RTDRestaurant.Controller.Service.ServiceAdmin;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.Model.ModelNhanVien;
import RTDRestaurant.View.Dialog.MS_Admin_Confirm;
import RTDRestaurant.View.Dialog.MS_Warning;
import RTDRestaurant.View.Form.MainForm;
import RTDRestaurant.View.Main_Frame.Main_Admin_Frame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class InsertAndUpdate_Staff_Form extends javax.swing.JPanel {

    private ServiceAdmin service;
    private final MainForm main;
    private ModelNhanVien admin;
    private ModelNhanVien data;
    private ModelNguoiDung user;
    private boolean insert;  //Thêm hay sửa
    private SimpleDateFormat simpleDateFormat;
    private MS_Warning obj;
    private MS_Admin_Confirm confirm;

    public InsertAndUpdate_Staff_Form(ModelNguoiDung user, ModelNhanVien admin, ModelNhanVien data, MainForm main) {
        this.user = user;
        this.admin = admin;
        this.data = data;
        this.main = main;

        initComponents();
        init();
    }

    public void init() {
        service = new ServiceAdmin();
        obj = new MS_Warning(Main_Admin_Frame.getFrames()[0], true);
        confirm = new MS_Admin_Confirm(Main_Admin_Frame.getFrames()[0], true);
        simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        if (data == null) {
            insert = true;
            lbTitle.setText("Thêm NHÂN VIÊN"); 
            data = new ModelNhanVien();
            initID();
            txtNVL.setDate(new Date());
            cmdKick.setVisible(false);
        } else {
            insert = false;
            lbTitle.setText("Sửa THÔNG TIN");
            if(data.getTinhTrang().equals("Dang lam viec")){
            cmdKick.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (data.getChucvu().equals("Quan ly")) {
                        obj.WarningFireAdmin();
                    } else {
                        confirm.ConfirmFire(data);
                        main.showForm(new StaffManagement_Form(user, main));
                    }
                }
            });
            }else if(data.getTinhTrang().equals("Da nghi viec")) {
                cmdKick.setText("ĐÃ BỊ SA THẢI");
                cmdKick.setBackground(Color.decode("#DA4453"));
            }
            cmdKick.setVisible(true);
            initData();
        }

    }

    public void initID() {
        try {
            data.setId_NV(service.getNextID_NV());
            data.setId_NQL(admin.getId_NV());
            txtmaNV.setText(data.getId_NV() + "");
            txtmaNQL.setText(data.getId_NQL() + "");
        } catch (SQLException ex) {

        }
    }

    public void initData() {
        txtmaNV.setText(data.getId_NV() + "");
        txttenNV.setText(data.getTenNV());
        try {
            txtNVL.setDate(simpleDateFormat.parse(data.getNgayVL()));
        } catch (ParseException ex) {
            Logger.getLogger(InsertAndUpdate_Staff_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNVL.setEnabled(false);
        txttSDT.setText(data.getSdt());
        cbboxCvu.setSelectedItem(data.getChucvu());
        txtmaNQL.setText(data.getId_NQL() + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new RTDRestaurant.View.Swing.PanelRound();
        pic = new RTDRestaurant.View.Swing.ImageAvatar();
        lbmaNV = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbtenNV = new javax.swing.JLabel();
        txttenNV = new RTDRestaurant.View.Swing.MyTextField();
        lbNVL = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbcvu = new javax.swing.JLabel();
        txtmaNV = new RTDRestaurant.View.Swing.MyTextField();
        cbboxCvu = new javax.swing.JComboBox<>();
        cmdOK = new RTDRestaurant.View.Swing.ButtonOutLine();
        cmdCancel = new RTDRestaurant.View.Swing.ButtonOutLine();
        txtNVL = new com.toedter.calendar.JDateChooser();
        lbsdt = new javax.swing.JLabel();
        txttSDT = new RTDRestaurant.View.Swing.MyTextField();
        lbmaNQL = new javax.swing.JLabel();
        txtmaNQL = new RTDRestaurant.View.Swing.MyTextField();
        cmdKick = new RTDRestaurant.View.Swing.Button();

        setBackground(new java.awt.Color(222, 222, 222));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/karina1.jpg"))); // NOI18N

        lbmaNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbmaNV.setForeground(new java.awt.Color(89, 89, 89));
        lbmaNV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmaNV.setText("Mã Nhân Viên");

        lbTitle.setBackground(new java.awt.Color(255, 255, 255));
        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/hired.png"))); // NOI18N
        lbTitle.setText("Thêm NHÂN VIÊN");
        lbTitle.setIconTextGap(10);

        lbtenNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbtenNV.setForeground(new java.awt.Color(89, 89, 89));
        lbtenNV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbtenNV.setText("Tên Nhân Viên");

        txttenNV.setForeground(new java.awt.Color(93, 98, 101));
        txttenNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttenNV.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N

        lbNVL.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbNVL.setForeground(new java.awt.Color(89, 89, 89));
        lbNVL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNVL.setText("Ngày Vào Làm");

        jSeparator1.setBackground(new java.awt.Color(76, 76, 76));

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        lbcvu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbcvu.setForeground(new java.awt.Color(89, 89, 89));
        lbcvu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbcvu.setText("Chức Vụ");

        txtmaNV.setEditable(false);
        txtmaNV.setBackground(new java.awt.Color(175, 185, 203));
        txtmaNV.setForeground(new java.awt.Color(93, 98, 101));
        txtmaNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmaNV.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N

        cbboxCvu.setBackground(new java.awt.Color(215, 221, 232));
        cbboxCvu.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        cbboxCvu.setForeground(new java.awt.Color(83, 105, 118));
        cbboxCvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phuc vu", "Tiep tan", "Thu ngan", "Bep", "Kho", "Quan ly" }));
        cbboxCvu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        cbboxCvu.setFocusable(false);

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

        txtNVL.setBackground(new java.awt.Color(175, 185, 203));
        txtNVL.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 91, 123), 2, true));
        txtNVL.setForeground(new java.awt.Color(83, 105, 118));
        txtNVL.setDateFormatString("dd-MM-YYYY");
        txtNVL.setFocusable(false);
        txtNVL.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        lbsdt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbsdt.setForeground(new java.awt.Color(89, 89, 89));
        lbsdt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbsdt.setText("Số Điện Thoại");

        txttSDT.setForeground(new java.awt.Color(93, 98, 101));
        txttSDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttSDT.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        txttSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttSDTKeyTyped(evt);
            }
        });

        lbmaNQL.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbmaNQL.setForeground(new java.awt.Color(89, 89, 89));
        lbmaNQL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmaNQL.setText("Mã NQL");

        txtmaNQL.setEditable(false);
        txtmaNQL.setBackground(new java.awt.Color(175, 185, 203));
        txtmaNQL.setForeground(new java.awt.Color(93, 98, 101));
        txtmaNQL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmaNQL.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N

        cmdKick.setBackground(new java.awt.Color(108, 91, 123));
        cmdKick.setForeground(new java.awt.Color(255, 255, 255));
        cmdKick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/job.png"))); // NOI18N
        cmdKick.setText("SA THẢI");
        cmdKick.setFocusable(false);
        cmdKick.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cmdKick.setIconTextGap(10);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdKick, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbtenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(lbmaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtNVL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txttenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                        .addComponent(lbsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                        .addGap(30, 30, 30)
                                        .addComponent(txttSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbNVL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcvu, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                                        .addGap(30, 30, 30)
                                        .addComponent(cbboxCvu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(1, 1, 1))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(lbmaNQL, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtmaNQL, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(80, 80, 80))
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
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbTitle)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdKick, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbtenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbNVL, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(txtNVL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcvu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbboxCvu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbmaNQL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmaNQL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
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

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        if (insert) {
            //Thêm mới
            if ("".equals(txttenNV.getText().trim()) || "".equals(txttSDT.getText())) {
                obj.WarningLackofInfo();
            } else {
                data.setTenNV(txttenNV.getText().trim());
                data.setNgayVL(((JTextField) txtNVL.getDateEditor().getUiComponent()).getText());
                data.setSdt(txttSDT.getText());
                data.setChucvu(cbboxCvu.getSelectedItem().toString());
                try {
                    service.insertNV(data);
                } catch (SQLException ex) {
                    Logger.getLogger(InsertAndUpdate_Staff_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
                main.showForm(new StaffManagement_Form(user, main));
            }
        } else {
            try {
                //Cập nhật (Chỉ được cập nhật Tên,SĐT và Chức vụ)
                data.setTenNV(txttenNV.getText().trim());
                data.setSdt(txttSDT.getText());
                data.setChucvu(cbboxCvu.getSelectedItem().toString());
                service.UpdateNV(data);
                main.showForm(new StaffManagement_Form(user, main));
            } catch (SQLException ex) {
                Logger.getLogger(InsertAndUpdate_Staff_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_cmdOKActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        main.showForm(new StaffManagement_Form(user, main));
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void txttSDTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttSDTKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txttSDTKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Swing.PanelRound bg;
    private javax.swing.JComboBox<String> cbboxCvu;
    private RTDRestaurant.View.Swing.ButtonOutLine cmdCancel;
    private RTDRestaurant.View.Swing.Button cmdKick;
    private RTDRestaurant.View.Swing.ButtonOutLine cmdOK;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbNVL;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbcvu;
    private javax.swing.JLabel lbmaNQL;
    private javax.swing.JLabel lbmaNV;
    private javax.swing.JLabel lbsdt;
    private javax.swing.JLabel lbtenNV;
    private RTDRestaurant.View.Swing.ImageAvatar pic;
    private com.toedter.calendar.JDateChooser txtNVL;
    private RTDRestaurant.View.Swing.MyTextField txtmaNQL;
    private RTDRestaurant.View.Swing.MyTextField txtmaNV;
    private RTDRestaurant.View.Swing.MyTextField txttSDT;
    private RTDRestaurant.View.Swing.MyTextField txttenNV;
    // End of variables declaration//GEN-END:variables
}
