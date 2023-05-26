package RTDRestaurant.View.Form.Staff_Form.WarehouseStaff;

import RTDRestaurant.Controller.Service.ServiceStaff;
import RTDRestaurant.Model.ModelKho;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.Model.ModelNhanVien;
import RTDRestaurant.Model.ModelPXK;
import RTDRestaurant.View.Form.MainForm;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class InsertPXK_Form extends javax.swing.JPanel {

    private ServiceStaff service;
    private ArrayList<ModelKho> list;
    private final ModelNhanVien staff;
    private final ModelNguoiDung user;
    private final MainForm main;
    private SimpleDateFormat simpleDateFormat;

    public InsertPXK_Form(ModelNguoiDung user, ModelNhanVien staff, MainForm main) {
        this.user = user;
        this.staff = staff;
        this.main = main;
        service = new ServiceStaff();
        initComponents();
        init();
        
    }

    public void init() {
        txtSearch.setHint("Tìm kiếm Nguyên Liệu . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        //Thêm data cho Menu
        initTable();
        initPNK();
        setCurrentDate();

        tableCTNK.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if(column>-1){
                    TableModel model = (TableModel) e.getSource();
                    int sl;
                    sl = Integer.parseInt((String) model.getValueAt(row, column));
                    for (ModelKho x : list) {
                        if (x.getIdNL() == tableCTNK.getFirstCol_RowSelected(row)) {
                            x.setSlTon(sl);
                            break;
                        }
                    }
                }
            }
        });
        
    }

    public void initPNK() {
        try {
            txtmaXK.setText(service.getNextID_XK() + "");
            txtmaNV.setText(staff.getId_NV() + "");
            txtNXK.setDate(new Date());
        } catch (SQLException ex) {
            Logger.getLogger(InsertPXK_Form.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCurrentDate() {
        lbDate.setText("Ngày hiện tại: " + simpleDateFormat.format(new Date()));
    }

    public void initTable() {
        try {
            list = service.MenuKhoNL();
            for (ModelKho data : list) {
                data.setSlTon(0);
                tableCTNK.addRow(new Object[]{data.getIdNL(), data.getTenNL(), data.getDvt(), data.getSlTon()});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void searchTable(String txt) {
        tableCTNK.removeAllRow();
        for (ModelKho data : list) {
            if ((data.getTenNL()).toLowerCase().contains(txt.toLowerCase())) {
                tableCTNK.addRow(new Object[]{data.getIdNL(), data.getTenNL(), data.getDvt(), data.getSlTon()});
            }
        }
        tableCTNK.repaint();
        tableCTNK.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        lbCTNK = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCTNK = new RTDRestaurant.View.Swing.Table();
        lbDate = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbmaXK = new javax.swing.JLabel();
        txtmaXK = new RTDRestaurant.View.Swing.MyTextField();
        txtmaNV = new RTDRestaurant.View.Swing.MyTextField();
        lbNXK = new javax.swing.JLabel();
        lbmaNV = new javax.swing.JLabel();
        txtNXK = new com.toedter.calendar.JDateChooser();
        pic = new RTDRestaurant.View.Swing.ImageAvatar();
        cmdOK = new RTDRestaurant.View.Swing.ButtonOutLine();
        cmdCancel = new RTDRestaurant.View.Swing.ButtonOutLine();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bill (1).png"))); // NOI18N
        lbTitle.setText("Thêm PHIẾU XUẤT KHO");
        lbTitle.setIconTextGap(10);

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe (1).png"))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        lbCTNK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbCTNK.setForeground(new java.awt.Color(89, 89, 89));
        lbCTNK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbCTNK.setText("Chi tiết Phiếu Xuất Kho");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tableCTNK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NL", "Tên nguyên liệu", "Đơn vị tính", "Số lượng Xuất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCTNK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableCTNKKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tableCTNK);
        if (tableCTNK.getColumnModel().getColumnCount() > 0) {
            tableCTNK.getColumnModel().getColumn(0).setMinWidth(120);
            tableCTNK.getColumnModel().getColumn(0).setMaxWidth(120);
            tableCTNK.getColumnModel().getColumn(1).setMinWidth(250);
            tableCTNK.getColumnModel().getColumn(1).setPreferredWidth(30);
            tableCTNK.getColumnModel().getColumn(1).setMaxWidth(250);
            tableCTNK.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        lbDate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbDate.setForeground(new java.awt.Color(108, 91, 123));
        lbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calendar.png"))); // NOI18N
        lbDate.setText("Ngày hiện tại");
        lbDate.setIconTextGap(20);

        jSeparator1.setBackground(new java.awt.Color(76, 76, 76));

        lbmaXK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbmaXK.setForeground(new java.awt.Color(89, 89, 89));
        lbmaXK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmaXK.setText("Mã Xuất Kho");

        txtmaXK.setEditable(false);
        txtmaXK.setBackground(new java.awt.Color(175, 185, 203));
        txtmaXK.setForeground(new java.awt.Color(93, 98, 101));
        txtmaXK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmaXK.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N

        txtmaNV.setEditable(false);
        txtmaNV.setBackground(new java.awt.Color(175, 185, 203));
        txtmaNV.setForeground(new java.awt.Color(93, 98, 101));
        txtmaNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmaNV.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N

        lbNXK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbNXK.setForeground(new java.awt.Color(89, 89, 89));
        lbNXK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNXK.setText("Ngày Xuất Kho");

        lbmaNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbmaNV.setForeground(new java.awt.Color(89, 89, 89));
        lbmaNV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmaNV.setText("Mã Nhân Viên");

        txtNXK.setBackground(new java.awt.Color(215, 221, 232));
        txtNXK.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 91, 123), 2, true));
        txtNXK.setForeground(new java.awt.Color(83, 105, 118));
        txtNXK.setDateFormatString("dd-MM-YYYY");
        txtNXK.setFocusable(false);
        txtNXK.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/invoice1.jpg"))); // NOI18N

        cmdOK.setBackground(new java.awt.Color(17, 153, 142));
        cmdOK.setForeground(new java.awt.Color(108, 91, 123));
        cmdOK.setText("Thêm PXK");
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

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCTNK))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbNXK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbmaXK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbmaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmaXK, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .addComponent(txtmaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNXK, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                                .addGap(80, 80, 80))
                            .addComponent(jSeparator2))
                        .addGap(10, 10, 10))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDate)
                    .addComponent(lbTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbmaXK, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmaXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNXK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNXK, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
                    .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCTNK, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        int idXK=Integer.parseInt(txtmaXK.getText());
        int idNV=Integer.parseInt(txtmaNV.getText());
        String ngayXK  = ((JTextField)txtNXK.getDateEditor().getUiComponent()).getText();
        ModelPXK pxk=new ModelPXK(idXK, idNV, ngayXK);
        try {
            service.InsertPXK_CTXK(pxk, list);
        } catch (SQLException ex) {
            Logger.getLogger(InsertPXK_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.showForm(new Export_Form(user, main));
    }//GEN-LAST:event_cmdOKActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        main.showForm(new Export_Form(user, main));
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void tableCTNKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableCTNKKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tableCTNKKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Swing.ButtonOutLine cmdCancel;
    private RTDRestaurant.View.Swing.ButtonOutLine cmdOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCTNK;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbNXK;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbmaNV;
    private javax.swing.JLabel lbmaXK;
    private RTDRestaurant.View.Swing.ImageAvatar pic;
    private RTDRestaurant.View.Swing.Table tableCTNK;
    private com.toedter.calendar.JDateChooser txtNXK;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    private RTDRestaurant.View.Swing.MyTextField txtmaNV;
    private RTDRestaurant.View.Swing.MyTextField txtmaXK;
    // End of variables declaration//GEN-END:variables
}
