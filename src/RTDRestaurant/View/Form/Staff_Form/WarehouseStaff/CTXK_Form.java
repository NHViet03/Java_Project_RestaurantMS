package RTDRestaurant.View.Form.Staff_Form.WarehouseStaff;

import RTDRestaurant.Controller.Service.ServiceStaff;
import RTDRestaurant.Model.ModelCTXK;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.Model.ModelPXK;
import RTDRestaurant.View.Form.MainForm;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CTXK_Form extends javax.swing.JPanel {

    private ServiceStaff service;
    private ArrayList<ModelCTXK> list;
    private final ModelNguoiDung user;
    private final MainForm main;
    private ModelPXK pxk;
    DecimalFormat df;

    public CTXK_Form(ModelNguoiDung user,ModelPXK pxk, MainForm main) {
        this.user=user;
        this.main = main;
        this.pxk = pxk;
        service = new ServiceStaff();

        initComponents();
        init();
    }

    public void init() {
        txtSearch.setHint("Tìm kiếm NL . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        df = new DecimalFormat("##,###,###");
        //Thêm data cho Menu
        initTable();

        lbDate.setText("Ngày xuất kho: " + pxk.getNgayXK());
        txtidPN.setText(pxk.getIdXK() + "");
        

    }

    public void initTable() {
        try {
            list = service.getCTXK(pxk.getIdXK());
            for (ModelCTXK data : list) {
                tableCTXK.addRow(new Object[]{data.getIdNL(), data.getTenNL(), data.getDvt(),
                                data.getsL()});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void searchTable(String txt) {
        tableCTXK.removeAllRow();
        for (ModelCTXK data : list) {
            if ((data.getTenNL()).toLowerCase().contains(txt.toLowerCase())) {
                tableCTXK.addRow(new Object[]{data.getIdNL(), data.getTenNL(), data.getDvt(),
                                data.getsL()});
            }
        }
        tableCTXK.repaint();
        tableCTXK.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        lbidNK = new javax.swing.JLabel();
        txtidPN = new RTDRestaurant.View.Swing.MyTextField();
        lbPNK = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCTXK = new RTDRestaurant.View.Swing.Table();
        lbDate = new javax.swing.JLabel();
        cmdReturn = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        lbTitle.setText("Chi tiết Phiếu Xuất Kho");
        lbTitle.setIconTextGap(10);

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe (1).png"))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        lbidNK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbidNK.setForeground(new java.awt.Color(89, 89, 89));
        lbidNK.setText("Mã Phiếu Xuất");

        txtidPN.setEditable(false);
        txtidPN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtidPN.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lbPNK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbPNK.setForeground(new java.awt.Color(89, 89, 89));
        lbPNK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPNK.setText("Danh sách nguyên liệu");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tableCTXK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NL", "Tên NL", "Đơn vị tính", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCTXK);
        if (tableCTXK.getColumnModel().getColumnCount() > 0) {
            tableCTXK.getColumnModel().getColumn(2).setMinWidth(200);
            tableCTXK.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        lbDate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbDate.setForeground(new java.awt.Color(108, 91, 123));
        lbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calendar.png"))); // NOI18N
        lbDate.setText("Ngày xuất kho");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbidNK, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(txtidPN, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbPNK))
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
                    .addComponent(lbidNK, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbPNK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        main.showForm(new Export_Form(user, main));
    }//GEN-LAST:event_cmdReturnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cmdReturn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbPNK;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbidNK;
    private RTDRestaurant.View.Swing.Table tableCTXK;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    private RTDRestaurant.View.Swing.MyTextField txtidPN;
    // End of variables declaration//GEN-END:variables
}
