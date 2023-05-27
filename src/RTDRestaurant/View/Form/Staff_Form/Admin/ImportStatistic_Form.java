package RTDRestaurant.View.Form.Staff_Form.Admin;

import EasyXLS.Constants.DataType;
import EasyXLS.ExcelDocument;
import EasyXLS.ExcelTable;
import EasyXLS.ExcelWorksheet;
import RTDRestaurant.Controller.Service.ServiceAdmin;
import RTDRestaurant.Model.ModelPNK;
import RTDRestaurant.View.Dialog.MS_Success;
import RTDRestaurant.View.Form.MainForm;
import RTDRestaurant.View.Main_Frame.Main_Admin_Frame;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import java.awt.Color;
import java.io.File;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ImportStatistic_Form extends javax.swing.JPanel {

    private ServiceAdmin serviceA;
    private ArrayList<ModelPNK> list;
    private final MainForm main;
    private DecimalFormat df;
    private SimpleDateFormat simpleDateFormat;
    private MS_Success obj;

    public ImportStatistic_Form(MainForm main) {
        this.main = main;
        serviceA = new ServiceAdmin();
        initComponents();
        init();
    }

    public void init() {
        txtSearch.setHint("Tìm kiếm Phiếu NK . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        df = new DecimalFormat("##,###,###");
        obj=new MS_Success(Main_Admin_Frame.getFrames()[0], true);
        //Thêm data cho Menu
        initTable();
        getCost();
        setCurrentDate();
    }
    //Lấy chi phí nhập kho trong ngày
    public void getCost() {
        try {
            txtprofit.setText(df.format(serviceA.getCostNK("Hôm nay")) + "đ");
        } catch (SQLException ex) {
            Logger.getLogger(ImportStatistic_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCurrentDate() {
        simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        lbDate.setText("Ngày hiện tại: " + simpleDateFormat.format(new Date()));
    }

    public void initTable() {
        try {
            list = serviceA.getListPNKIn("Tất cả");
            for (ModelPNK data : list) {
                tablePNK.addRow(new Object[]{data.getIdNK(),data.getIdNV(),data.getNgayNK(),df.format(data.getTongTien())+"đ"});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void searchTable(String txt) {
        tablePNK.removeAllRow();
        for (ModelPNK data : list) {
            if ((data.getIdNK() + "").toLowerCase().contains(txt.toLowerCase())) {
                tablePNK.addRow(new Object[]{data.getIdNK(),data.getIdNV(),data.getNgayNK(),df.format(data.getTongTien())+"đ"});
            }
        }
        tablePNK.repaint();
        tablePNK.revalidate();
    }

    public void FilterTable(String txt) {
        tablePNK.removeAllRow();
        list.clear();
        try {
            list = serviceA.getListPNKIn(txt);
        } catch (SQLException ex) {
            Logger.getLogger(ImportStatistic_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (ModelPNK data : list) {
            tablePNK.addRow(new Object[]{data.getIdNK(),data.getIdNV(),data.getNgayNK(),df.format(data.getTongTien())+"đ"});
        }
        tablePNK.repaint();
        tablePNK.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        lbprofit = new javax.swing.JLabel();
        txtprofit = new RTDRestaurant.View.Swing.MyTextField();
        lbCus = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePNK = new RTDRestaurant.View.Swing.Table();
        lbDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        filter = new javax.swing.JComboBox<>();
        cmdCTNK = new RTDRestaurant.View.Swing.Button();
        cmdExcel = new RTDRestaurant.View.Swing.Button();

        setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/inventory.png"))); // NOI18N
        lbTitle.setText("Thống kê Nhập Kho");
        lbTitle.setIconTextGap(10);

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe (1).png"))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        lbprofit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbprofit.setForeground(new java.awt.Color(89, 89, 89));
        lbprofit.setText("Chi phí Nhập Kho trong ngày");

        txtprofit.setEditable(false);
        txtprofit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtprofit.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lbCus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbCus.setForeground(new java.awt.Color(89, 89, 89));
        lbCus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbCus.setText("Danh sách Phiếu Nhập Kho");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tablePNK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NK", "Mã NV", "Ngày Nhập Kho", "Tổng tiền"
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
            tablePNK.getColumnModel().getColumn(0).setMinWidth(200);
            tablePNK.getColumnModel().getColumn(0).setMaxWidth(200);
            tablePNK.getColumnModel().getColumn(1).setMinWidth(200);
            tablePNK.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        lbDate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbDate.setForeground(new java.awt.Color(108, 91, 123));
        lbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calendar.png"))); // NOI18N
        lbDate.setText("Ngày hiện tại");
        lbDate.setIconTextGap(20);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(108, 91, 123));
        jLabel1.setText("Hiển thị theo");

        filter.setEditable(true);
        filter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filter.setForeground(new java.awt.Color(108, 91, 123));
        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Hôm nay", "Tháng này", "Năm này" }));
        filter.setToolTipText("Sắp xếp");
        filter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 145, 145), 2));
        filter.setFocusable(false);
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        cmdCTNK.setBackground(new java.awt.Color(108, 91, 123));
        cmdCTNK.setForeground(new java.awt.Color(255, 255, 255));
        cmdCTNK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboard.png"))); // NOI18N
        cmdCTNK.setText("XEM CTNK");
        cmdCTNK.setFocusable(false);
        cmdCTNK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdCTNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCTNKActionPerformed(evt);
            }
        });

        cmdExcel.setBackground(new java.awt.Color(108, 91, 123));
        cmdExcel.setForeground(new java.awt.Color(255, 255, 255));
        cmdExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/excel.png"))); // NOI18N
        cmdExcel.setText("XUẤT FILE EXCEL");
        cmdExcel.setFocusable(false);
        cmdExcel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbCus)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(7, 7, 7)
                                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cmdCTNK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbprofit)
                        .addGap(50, 50, 50)
                        .addComponent(txtprofit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lbDate))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbprofit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprofit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(lbCus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCTNK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        FilterTable(filter.getSelectedItem().toString());
    }//GEN-LAST:event_filterActionPerformed

    private void cmdExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExcelActionPerformed
        //Xuất danh sách Hóa Đơn ra file Excel
        try {
            ExcelDocument workbook = new ExcelDocument(1);
            workbook.easy_getSheetAt(0).setSheetName("Danh sách Phiếu Nhập Kho");
            ExcelTable xlsTable = ((ExcelWorksheet) workbook.easy_getSheetAt(0)).easy_getExcelTable();
            //Them data cho header
            DefaultTableModel model = (DefaultTableModel) tablePNK.getModel();
            for (int col = 0; col < model.getColumnCount(); col++) {
                xlsTable.easy_getCell(0, col).setValue(model.getColumnName(col));
                xlsTable.easy_getCell(0, col).setDataType(DataType.STRING);
                xlsTable.easy_getCell(0, col).setBold(true);
            }
            //Thêm data cho bảng
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    xlsTable.easy_getCell(row+1, col).setValue(model.getValueAt(row, col)+"");
                    xlsTable.easy_getCell(row+1, col).setDataType(DataType.STRING);
                }
            }
            workbook.easy_WriteXLSXFile(".\\src\\ExportFile_Excel\\DanhsachPNK_" + simpleDateFormat.format(new Date()) + ".xlsx");
            File file=new File("src\\ExportFile_Excel\\DanhsachPNK_" + simpleDateFormat.format(new Date()) + ".xlsx");
            String path=file.getAbsolutePath();
            System.out.println(path);
            obj.ExportFileSuccess(path);
            workbook.Dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmdExcelActionPerformed

    private void cmdCTNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCTNKActionPerformed
        int idNK=tablePNK.getFirstCol_RowSelected(tablePNK.getSelectedRow());
        ModelPNK bill=null;
        for(ModelPNK data:list){
            if(data.getIdNK()==idNK){
                bill=data;
                break;
            }
        }
        main.showForm(new CTNK_Form(bill, main));
    }//GEN-LAST:event_cmdCTNKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Swing.Button cmdCTNK;
    private RTDRestaurant.View.Swing.Button cmdExcel;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCus;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbprofit;
    private RTDRestaurant.View.Swing.Table tablePNK;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    private RTDRestaurant.View.Swing.MyTextField txtprofit;
    // End of variables declaration//GEN-END:variables
}
