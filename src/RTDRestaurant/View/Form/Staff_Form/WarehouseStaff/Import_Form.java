package RTDRestaurant.View.Form.Staff_Form.WarehouseStaff;

import RTDRestaurant.Controller.Service.ServiceStaff;
import RTDRestaurant.Model.ModelNhanVien;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.Model.ModelPNK;
import RTDRestaurant.View.Form.MainForm;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Import_Form extends javax.swing.JPanel {

    private ServiceStaff service;
    private ArrayList<ModelPNK> list;
    private final MainForm main;
    private final ModelNguoiDung user;
    private ModelNhanVien staff;
    private DecimalFormat df;

    public Import_Form(ModelNguoiDung user, MainForm main) {
        this.main = main;
        this.user = user;
        service = new ServiceStaff();
        try {
            staff=service.getStaff(user.getUserID());
        } catch (SQLException ex) {
            Logger.getLogger(Import_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        init();
    }

    public void init() {
        txtSearch.setHint("Tìm kiếm Phiếu NK . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        df = new DecimalFormat("##,###,###");
        //Thêm data cho Menu
        initTable();
        setTongtienNK();
        //Lấy ngày hiện tại
        setCurrentDate();
        //Them event cho Button ThemPNK
        cmdAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.showForm(new InsertPNK_Form(user,staff,main));
            }
        });
        //Them event cho Button ChitietPNK
        cmdCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ModelPNK pnk= service.getPNKbyID(tablePNK.getFirstCol_RowSelected(tablePNK.getSelectedRow()));
                    main.showForm(new CTNK_Form(user,pnk,main));
                } catch (SQLException ex) {
                    Logger.getLogger(Import_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void setCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        lbDate.setText("Ngày hiện tại: "+simpleDateFormat.format(new Date()));
    }

    public void setTongtienNK() {
        try {
            txtTong.setText(df.format(service.getTongtienNK()) +"đ" );
        } catch (SQLException ex) {
            Logger.getLogger(Import_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initTable() {
        try {
            //Lấy danh sách phiếu Nhập Kho
            list = service.MenuPNK();
            for (ModelPNK data : list) {
                tablePNK.addRow(new Object[]{data.getIdNK(), data.getIdNV(),data.getNgayNK(), df.format(data.getTongTien()) + "đ"});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void searchTable(String txt) {
        tablePNK.removeAllRow();
        for (ModelPNK data : list) {
            if ((data.getIdNK()+"").toLowerCase().contains(txt.toLowerCase())) {
                tablePNK.addRow(new Object[]{data.getIdNK(), data.getIdNV(),data.getNgayNK(), df.format(data.getTongTien()) + "đ"});
            }
        }
        tablePNK.repaint();
        tablePNK.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        lbTong = new javax.swing.JLabel();
        txtTong = new RTDRestaurant.View.Swing.MyTextField();
        lbPNK = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePNK = new RTDRestaurant.View.Swing.Table();
        cmdAdd = new RTDRestaurant.View.Swing.Button();
        cmdCT = new RTDRestaurant.View.Swing.Button();
        lbDate = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/import (1).png"))); // NOI18N
        lbTitle.setText("Quản lý Nhập Kho");
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

        lbTong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTong.setForeground(new java.awt.Color(89, 89, 89));
        lbTong.setText("Tổng tiền nhập kho hôm nay");

        txtTong.setEditable(false);
        txtTong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTong.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lbPNK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbPNK.setForeground(new java.awt.Color(89, 89, 89));
        lbPNK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPNK.setText("Danh sách Phiếu Nhập Kho");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tablePNK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NK", "Mã NV", "Ngày NK", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePNK);
        if (tablePNK.getColumnModel().getColumnCount() > 0) {
            tablePNK.getColumnModel().getColumn(0).setMinWidth(150);
            tablePNK.getColumnModel().getColumn(0).setMaxWidth(150);
            tablePNK.getColumnModel().getColumn(1).setMinWidth(150);
            tablePNK.getColumnModel().getColumn(1).setPreferredWidth(30);
            tablePNK.getColumnModel().getColumn(1).setMaxWidth(150);
            tablePNK.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        cmdAdd.setBackground(new java.awt.Color(108, 91, 123));
        cmdAdd.setForeground(new java.awt.Color(255, 255, 255));
        cmdAdd.setText("Thêm PNK");
        cmdAdd.setFocusable(false);
        cmdAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cmdCT.setBackground(new java.awt.Color(108, 91, 123));
        cmdCT.setForeground(new java.awt.Color(255, 255, 255));
        cmdCT.setText("Chi tiết PNK");
        cmdCT.setFocusable(false);
        cmdCT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lbDate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbDate.setForeground(new java.awt.Color(108, 91, 123));
        lbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calendar.png"))); // NOI18N
        lbDate.setText("Ngày hiện tại");
        lbDate.setIconTextGap(20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cmdCT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTong, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbPNK))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbPNK, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseEntered

        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Swing.Button cmdAdd;
    private RTDRestaurant.View.Swing.Button cmdCT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbPNK;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTong;
    private RTDRestaurant.View.Swing.Table tablePNK;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    private RTDRestaurant.View.Swing.MyTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
