package RTDRestaurant.View.Form.Staff_Form.WarehouseStaff;

import RTDRestaurant.Controller.Service.ServiceStaff;
import RTDRestaurant.Model.ModelNhanVien;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.Model.ModelPXK;
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

public class Export_Form extends javax.swing.JPanel {

    private ServiceStaff service;
    private ArrayList<ModelPXK> list;
    private final MainForm main;
    private final ModelNguoiDung user;
    private ModelNhanVien staff;
    DecimalFormat df;

    public Export_Form(ModelNguoiDung user, MainForm main) {
        this.main = main;
        this.user = user;
        service = new ServiceStaff();
        try {
            staff=service.getStaff(user.getUserID());
        } catch (SQLException ex) {
            Logger.getLogger(Export_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        init();
    }

    public void init() {
        txtSearch.setHint("Tìm kiếm Phiếu XK . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        df = new DecimalFormat("##,###,###");
        //Thêm data cho Menu
        initTable();
        //Lấy số lượng phiếu xuất trong trong ngày hôm nay
        setSL_PNK();
        setCurrentDate();
        //Them event cho Button ThemPNK
        cmdAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.showForm(new InsertPXK_Form(user,staff,main));
            }
        });
        //Them event cho Button ChitietPNK
        cmdCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ModelPXK pxk= service.getPXKbyID(tablePXK.getFirstCol_RowSelected(tablePXK.getSelectedRow()));
                    main.showForm(new CTXK_Form(user,pxk,main));
                } catch (SQLException ex) {
                    Logger.getLogger(Export_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void setCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        lbDate.setText("Ngày hiện tại: "+simpleDateFormat.format(new Date()));
    }

    public void setSL_PNK() {
        try {
            txtslPXK.setText(service.getSLPXK()+"");
        } catch (SQLException ex) {
            Logger.getLogger(Export_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initTable() {
        try {
            list = service.MenuPXK();
            for (ModelPXK data : list) {
                tablePXK.addRow(new Object[]{data.getIdXK(), data.getIdNV(),data.getNgayXK()});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void searchTable(String txt) {
        tablePXK.removeAllRow();
        for (ModelPXK data : list) {
            if ((data.getIdXK()+"").toLowerCase().contains(txt.toLowerCase())) {
                tablePXK.addRow(new Object[]{data.getIdXK(), data.getIdNV(),data.getNgayXK()});
            }
        }
        tablePXK.repaint();
        tablePXK.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        lbSL = new javax.swing.JLabel();
        txtslPXK = new RTDRestaurant.View.Swing.MyTextField();
        lbPXK = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePXK = new RTDRestaurant.View.Swing.Table();
        cmdAdd = new RTDRestaurant.View.Swing.Button();
        cmdCT = new RTDRestaurant.View.Swing.Button();
        lbDate = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/export.png"))); // NOI18N
        lbTitle.setText("Quản lý Xuất Kho");
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

        lbSL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSL.setForeground(new java.awt.Color(89, 89, 89));
        lbSL.setText("Số Phiếu xuất kho hôm nay");

        txtslPXK.setEditable(false);
        txtslPXK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtslPXK.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lbPXK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbPXK.setForeground(new java.awt.Color(89, 89, 89));
        lbPXK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPXK.setText("Danh sách Phiếu Xuất Kho");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tablePXK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã XK", "Mã NV", "Ngày XK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePXK);
        if (tablePXK.getColumnModel().getColumnCount() > 0) {
            tablePXK.getColumnModel().getColumn(1).setPreferredWidth(30);
            tablePXK.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        cmdAdd.setBackground(new java.awt.Color(108, 91, 123));
        cmdAdd.setForeground(new java.awt.Color(255, 255, 255));
        cmdAdd.setText("Thêm PXK");
        cmdAdd.setFocusable(false);
        cmdAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cmdCT.setBackground(new java.awt.Color(108, 91, 123));
        cmdCT.setForeground(new java.awt.Color(255, 255, 255));
        cmdCT.setText("Chi tiết PXK");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
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
                                .addComponent(lbSL)
                                .addGap(50, 50, 50)
                                .addComponent(txtslPXK, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbPXK))
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
                    .addComponent(lbSL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtslPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lbPXK, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
    private javax.swing.JLabel lbPXK;
    private javax.swing.JLabel lbSL;
    private javax.swing.JLabel lbTitle;
    private RTDRestaurant.View.Swing.Table tablePXK;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    private RTDRestaurant.View.Swing.MyTextField txtslPXK;
    // End of variables declaration//GEN-END:variables
}
