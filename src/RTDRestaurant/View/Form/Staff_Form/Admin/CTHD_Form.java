package RTDRestaurant.View.Form.Staff_Form.Admin;

import RTDRestaurant.Controller.Service.ServiceCustomer;
import RTDRestaurant.Model.ModelCTHD;
import RTDRestaurant.Model.ModelHoaDon;
import RTDRestaurant.View.Form.MainForm;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CTHD_Form extends javax.swing.JPanel {

    private ServiceCustomer service;
    private ArrayList<ModelCTHD> list;
    private ModelHoaDon bill;
    private final MainForm main;
    DecimalFormat df;

    public CTHD_Form(ModelHoaDon bill, MainForm main) {
        this.bill = bill;
        this.main = main;
        service = new ServiceCustomer();
        initComponents();
        init();
    }

    public void init() {
        txtSearch.setHint("Tìm kiếm Món Ăn  . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        df = new DecimalFormat("##,###,###");
        //Thêm data cho Menu
        initTable();

        lbDate.setText("Ngày hóa đơn: " + bill.getNgayHD());
        txtidHD.setText(bill.getIdHoaDon() + "");
    }

    public void initTable() {
        try {
            list = service.getCTHD(bill.getIdHoaDon());
            for (ModelCTHD data : list) {
                tableCTHD.addRow(new Object[]{data.getID_MonAn(),data.getTenMonAn(),data.getSoluong(),df.format(data.getThanhTien())+"đ"});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void searchTable(String txt) {
        tableCTHD.removeAllRow();
        for (ModelCTHD data : list) {
            if ((data.getTenMonAn()).toLowerCase().contains(txt.toLowerCase())) {
                tableCTHD.addRow(new Object[]{data.getID_MonAn(),data.getTenMonAn(),data.getSoluong(),df.format(data.getThanhTien())+"đ"});
            }
        }
        tableCTHD.repaint();
        tableCTHD.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        lbidHD = new javax.swing.JLabel();
        txtidHD = new RTDRestaurant.View.Swing.MyTextField();
        lbCTHD = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCTHD = new RTDRestaurant.View.Swing.Table();
        lbDate = new javax.swing.JLabel();
        cmdReturn = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/receipt (2).png"))); // NOI18N
        lbTitle.setText("Chi tiết Hóa Đơn");
        lbTitle.setIconTextGap(10);

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe (1).png"))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        lbidHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbidHD.setForeground(new java.awt.Color(89, 89, 89));
        lbidHD.setText("Mã Hóa Đơn");

        txtidHD.setEditable(false);
        txtidHD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtidHD.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lbCTHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbCTHD.setForeground(new java.awt.Color(89, 89, 89));
        lbCTHD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbCTHD.setText("Danh sách Món Ăn");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tableCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Món Ăn", "Tên Món Ăn", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCTHD);
        if (tableCTHD.getColumnModel().getColumnCount() > 0) {
            tableCTHD.getColumnModel().getColumn(0).setMinWidth(150);
            tableCTHD.getColumnModel().getColumn(0).setMaxWidth(150);
            tableCTHD.getColumnModel().getColumn(1).setMinWidth(330);
            tableCTHD.getColumnModel().getColumn(1).setMaxWidth(330);
        }

        lbDate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbDate.setForeground(new java.awt.Color(108, 91, 123));
        lbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calendar.png"))); // NOI18N
        lbDate.setText("Ngày hiện tại");
        lbDate.setIconTextGap(20);

        cmdReturn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cmdReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        cmdReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdReturnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbidHD, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(txtidHD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbCTHD))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbidHD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cmdReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdReturnMouseClicked
        main.showForm(new BillStatistic_Form(main));
    }//GEN-LAST:event_cmdReturnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cmdReturn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCTHD;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbidHD;
    private RTDRestaurant.View.Swing.Table tableCTHD;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    private RTDRestaurant.View.Swing.MyTextField txtidHD;
    // End of variables declaration//GEN-END:variables
}
