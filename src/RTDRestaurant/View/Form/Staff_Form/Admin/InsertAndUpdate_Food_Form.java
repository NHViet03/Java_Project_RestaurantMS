package RTDRestaurant.View.Form.Staff_Form.Admin;

import RTDRestaurant.Controller.Service.ServiceAdmin;
import RTDRestaurant.Model.ModelMonAn;
import RTDRestaurant.View.Dialog.MS_Admin_Confirm;
import RTDRestaurant.View.Dialog.MS_Warning;
import RTDRestaurant.View.Form.MainForm;
import RTDRestaurant.View.Main_Frame.Main_Admin_Frame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class InsertAndUpdate_Food_Form extends javax.swing.JPanel {

    private ServiceAdmin service;
    private final MainForm main;
    private ModelMonAn data;
    private boolean insert;  //Thêm hay sửa
    private MS_Warning obj;
    private MS_Admin_Confirm confirm;

    public InsertAndUpdate_Food_Form(ModelMonAn data, MainForm main) {
        this.data = data;
        this.main = main;

        initComponents();
        init();
    }

    public void init() {
        service = new ServiceAdmin();
        obj = new MS_Warning(Main_Admin_Frame.getFrames()[0], true);
        confirm = new MS_Admin_Confirm(Main_Admin_Frame.getFrames()[0], true);

        if (data == null) {
            insert = true;
            lbTitle.setText("Thêm MÓN ĂN");
            pic.setIcon(new ImageIcon(getClass().getResource("/Icons/Food/Unknown/unknown.jpg")));
            data = new ModelMonAn();
            initID();
            cmdStop.setVisible(false);
        } else {
            insert = false;
            lbTitle.setText("Sửa THÔNG TIN");
            pic.setIcon(data.getIcon());
            if (data.getState().equals("Dang kinh doanh")) {
                cmdStop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        confirm.ConfirmStop(data);
                        main.showForm(new MenuManagement_Form(main));

                    }
                });
            } else if (data.getState().equals("Ngung kinh doanh")) {
                cmdStop.setIcon(new ImageIcon(getClass().getResource("/Icons/selling.png")));
                cmdStop.setText("KINH DOANH LẠI");
                cmdStop.setBackground(Color.decode("#DA4453"));
                cmdStop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        confirm.ConfirmBack(data);
                        main.showForm(new MenuManagement_Form(main));
                    }
                });
            }
            cmdStop.setVisible(true);
            initData();
        }

    }

    public void initID() {
        try {
            data.setId(service.getNextID_MA());
            txtmaMA.setText(data.getId() + "");

        } catch (SQLException ex) {

        }
    }

    public void initData() {
        txtmaMA.setText(data.getId()+"");
        txttenMA.setText(data.getTitle());
        txtgia.setText(data.getValue()+"");
        cbboxLoai.setSelectedItem(data.getType());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new RTDRestaurant.View.Swing.PanelRound();
        pic = new RTDRestaurant.View.Swing.ImageAvatar();
        lbmaMA = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbtenMA = new javax.swing.JLabel();
        txttenMA = new RTDRestaurant.View.Swing.MyTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbloai = new javax.swing.JLabel();
        txtmaMA = new RTDRestaurant.View.Swing.MyTextField();
        cbboxLoai = new javax.swing.JComboBox<>();
        cmdOK = new RTDRestaurant.View.Swing.ButtonOutLine();
        cmdCancel = new RTDRestaurant.View.Swing.ButtonOutLine();
        lbDonGia = new javax.swing.JLabel();
        txtgia = new RTDRestaurant.View.Swing.MyTextField();
        cmdStop = new RTDRestaurant.View.Swing.Button();
        jPanel1 = new javax.swing.JPanel();
        bg1 = new RTDRestaurant.View.Swing.PanelRound();
        pic1 = new RTDRestaurant.View.Swing.ImageAvatar();
        lbmaMA1 = new javax.swing.JLabel();
        lbTitle1 = new javax.swing.JLabel();
        lbtenMA1 = new javax.swing.JLabel();
        txttenMA1 = new RTDRestaurant.View.Swing.MyTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        lbloai1 = new javax.swing.JLabel();
        txtmaMA1 = new RTDRestaurant.View.Swing.MyTextField();
        cbboxLoai1 = new javax.swing.JComboBox<>();
        cmdOK1 = new RTDRestaurant.View.Swing.ButtonOutLine();
        cmdCancel1 = new RTDRestaurant.View.Swing.ButtonOutLine();
        lbDonGia1 = new javax.swing.JLabel();
        txtgia1 = new RTDRestaurant.View.Swing.MyTextField();
        cmdStop1 = new RTDRestaurant.View.Swing.Button();

        setBackground(new java.awt.Color(222, 222, 222));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Food/Unknown/unknown.jpg"))); // NOI18N

        lbmaMA.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbmaMA.setForeground(new java.awt.Color(89, 89, 89));
        lbmaMA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmaMA.setText("Mã Món Ăn");

        lbTitle.setBackground(new java.awt.Color(255, 255, 255));
        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/online-order.png"))); // NOI18N
        lbTitle.setText("Thêm MÓN ĂN");
        lbTitle.setIconTextGap(10);

        lbtenMA.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbtenMA.setForeground(new java.awt.Color(89, 89, 89));
        lbtenMA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbtenMA.setText("Tên Món Ăn");

        txttenMA.setForeground(new java.awt.Color(93, 98, 101));
        txttenMA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttenMA.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(76, 76, 76));

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        lbloai.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbloai.setForeground(new java.awt.Color(89, 89, 89));
        lbloai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbloai.setText("Loại Món");

        txtmaMA.setEditable(false);
        txtmaMA.setBackground(new java.awt.Color(175, 185, 203));
        txtmaMA.setForeground(new java.awt.Color(93, 98, 101));
        txtmaMA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmaMA.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N

        cbboxLoai.setBackground(new java.awt.Color(215, 221, 232));
        cbboxLoai.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        cbboxLoai.setForeground(new java.awt.Color(83, 105, 118));
        cbboxLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces" }));
        cbboxLoai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        cbboxLoai.setFocusable(false);

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

        lbDonGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbDonGia.setForeground(new java.awt.Color(89, 89, 89));
        lbDonGia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDonGia.setText("Đơn Giá");

        txtgia.setForeground(new java.awt.Color(93, 98, 101));
        txtgia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtgia.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        txtgia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtgiaKeyTyped(evt);
            }
        });

        cmdStop.setBackground(new java.awt.Color(108, 91, 123));
        cmdStop.setForeground(new java.awt.Color(255, 255, 255));
        cmdStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/no-food.png"))); // NOI18N
        cmdStop.setText("NGƯNG KINH DOANH");
        cmdStop.setFocusable(false);
        cmdStop.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cmdStop.setIconTextGap(10);

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
                        .addComponent(cmdStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbtenMA, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(lbmaMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbloai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtgia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmaMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttenMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbboxLoai, 0, 250, Short.MAX_VALUE))))
                .addGap(60, 60, 60))
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
                .addGap(35, 35, 35)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitle)
                    .addComponent(cmdStop, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbmaMA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmaMA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbtenMA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbboxLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbloai, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        jPanel1.setBackground(new java.awt.Color(222, 222, 222));

        bg1.setBackground(new java.awt.Color(255, 255, 255));

        pic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Food/Unknown/unknown.jpg"))); // NOI18N

        lbmaMA1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbmaMA1.setForeground(new java.awt.Color(89, 89, 89));
        lbmaMA1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmaMA1.setText("Mã Món Ăn");

        lbTitle1.setBackground(new java.awt.Color(255, 255, 255));
        lbTitle1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lbTitle1.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/online-order.png"))); // NOI18N
        lbTitle1.setText("Thêm MÓN ĂN");
        lbTitle1.setIconTextGap(10);

        lbtenMA1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbtenMA1.setForeground(new java.awt.Color(89, 89, 89));
        lbtenMA1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbtenMA1.setText("Tên Món Ăn");

        txttenMA1.setForeground(new java.awt.Color(93, 98, 101));
        txttenMA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttenMA1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        jSeparator3.setBackground(new java.awt.Color(76, 76, 76));

        jSeparator4.setBackground(new java.awt.Color(76, 76, 76));

        lbloai1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbloai1.setForeground(new java.awt.Color(89, 89, 89));
        lbloai1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbloai1.setText("Loại Món");

        txtmaMA1.setEditable(false);
        txtmaMA1.setBackground(new java.awt.Color(175, 185, 203));
        txtmaMA1.setForeground(new java.awt.Color(93, 98, 101));
        txtmaMA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmaMA1.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N

        cbboxLoai1.setBackground(new java.awt.Color(215, 221, 232));
        cbboxLoai1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        cbboxLoai1.setForeground(new java.awt.Color(83, 105, 118));
        cbboxLoai1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces" }));
        cbboxLoai1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        cbboxLoai1.setFocusable(false);

        cmdOK1.setBackground(new java.awt.Color(17, 153, 142));
        cmdOK1.setForeground(new java.awt.Color(108, 91, 123));
        cmdOK1.setText("Xác nhận");
        cmdOK1.setFocusable(false);
        cmdOK1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cmdOK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOK1ActionPerformed(evt);
            }
        });

        cmdCancel1.setBackground(new java.awt.Color(237, 33, 58));
        cmdCancel1.setForeground(new java.awt.Color(108, 91, 123));
        cmdCancel1.setText("Hủy");
        cmdCancel1.setFocusable(false);
        cmdCancel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cmdCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancel1ActionPerformed(evt);
            }
        });

        lbDonGia1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbDonGia1.setForeground(new java.awt.Color(89, 89, 89));
        lbDonGia1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDonGia1.setText("Đơn Giá");

        txtgia1.setForeground(new java.awt.Color(93, 98, 101));
        txtgia1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtgia1.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        txtgia1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtgia1KeyTyped(evt);
            }
        });

        cmdStop1.setBackground(new java.awt.Color(108, 91, 123));
        cmdStop1.setForeground(new java.awt.Color(255, 255, 255));
        cmdStop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/no-food.png"))); // NOI18N
        cmdStop1.setText("NGƯNG KINH DOANH");
        cmdStop1.setFocusable(false);
        cmdStop1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cmdStop1.setIconTextGap(10);

        javax.swing.GroupLayout bg1Layout = new javax.swing.GroupLayout(bg1);
        bg1.setLayout(bg1Layout);
        bg1Layout.setHorizontalGroup(
            bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg1Layout.createSequentialGroup()
                        .addComponent(lbTitle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdStop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg1Layout.createSequentialGroup()
                        .addComponent(pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbtenMA1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(lbmaMA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDonGia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbloai1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtgia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmaMA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttenMA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbboxLoai1, 0, 250, Short.MAX_VALUE))))
                .addGap(60, 60, 60))
            .addGroup(bg1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(cmdOK1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(cmdCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bg1Layout.setVerticalGroup(
            bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitle1)
                    .addComponent(cmdStop1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbmaMA1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmaMA1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbtenMA1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenMA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDonGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgia1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbboxLoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbloai1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bg1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdOK1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        if (insert) {
            //Thêm mới
            if ("".equals(txttenMA.getText().trim()) || "".equals(txtgia.getText())) {
                obj.WarningLackofInfo();
            } else {
                data.setTitle(txttenMA.getText().trim());
                data.setValue(Integer.parseInt(txtgia.getText()));
                data.setType(cbboxLoai.getSelectedItem().toString());
                try {
                    service.insertMA(data);
                } catch (SQLException ex) {
                    Logger.getLogger(InsertAndUpdate_Food_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
                main.showForm(new MenuManagement_Form(main));
            }
        } else {
            data.setTitle(txttenMA.getText().trim());
            data.setValue(Integer.parseInt(txtgia.getText()));
            data.setType(cbboxLoai.getSelectedItem().toString());
            try {
                //Cập nhật (Chỉ được cập nhật Tên,Giá,Loại món ăn)
                service.UpdateMonAn(data);
            } catch (SQLException ex) {
                Logger.getLogger(InsertAndUpdate_Food_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
            main.showForm(new MenuManagement_Form(main));
        }
        
    }//GEN-LAST:event_cmdOKActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        main.showForm(new MenuManagement_Form(main));
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void txtgiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgiaKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtgiaKeyTyped

    private void cmdOK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOK1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdOK1ActionPerformed

    private void cmdCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdCancel1ActionPerformed

    private void txtgia1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgia1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgia1KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Swing.PanelRound bg;
    private RTDRestaurant.View.Swing.PanelRound bg1;
    private javax.swing.JComboBox<String> cbboxLoai;
    private javax.swing.JComboBox<String> cbboxLoai1;
    private RTDRestaurant.View.Swing.ButtonOutLine cmdCancel;
    private RTDRestaurant.View.Swing.ButtonOutLine cmdCancel1;
    private RTDRestaurant.View.Swing.ButtonOutLine cmdOK;
    private RTDRestaurant.View.Swing.ButtonOutLine cmdOK1;
    private RTDRestaurant.View.Swing.Button cmdStop;
    private RTDRestaurant.View.Swing.Button cmdStop1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbDonGia;
    private javax.swing.JLabel lbDonGia1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitle1;
    private javax.swing.JLabel lbloai;
    private javax.swing.JLabel lbloai1;
    private javax.swing.JLabel lbmaMA;
    private javax.swing.JLabel lbmaMA1;
    private javax.swing.JLabel lbtenMA;
    private javax.swing.JLabel lbtenMA1;
    private RTDRestaurant.View.Swing.ImageAvatar pic;
    private RTDRestaurant.View.Swing.ImageAvatar pic1;
    private RTDRestaurant.View.Swing.MyTextField txtgia;
    private RTDRestaurant.View.Swing.MyTextField txtgia1;
    private RTDRestaurant.View.Swing.MyTextField txtmaMA;
    private RTDRestaurant.View.Swing.MyTextField txtmaMA1;
    private RTDRestaurant.View.Swing.MyTextField txttenMA;
    private RTDRestaurant.View.Swing.MyTextField txttenMA1;
    // End of variables declaration//GEN-END:variables
}
