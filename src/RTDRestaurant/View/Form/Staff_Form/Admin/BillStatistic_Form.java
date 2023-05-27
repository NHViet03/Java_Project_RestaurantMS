package RTDRestaurant.View.Form.Staff_Form.Admin;

import EasyXLS.Constants.DataType;
import EasyXLS.ExcelDocument;
import EasyXLS.ExcelTable;
import EasyXLS.ExcelWorksheet;
import RTDRestaurant.Controller.Service.ServiceAdmin;
import RTDRestaurant.Model.ModelHoaDon;
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

public class BillStatistic_Form extends javax.swing.JPanel {

    private ServiceAdmin serviceA;
    private ArrayList<ModelHoaDon> list;
    private final MainForm main;
    private DecimalFormat df;
    private SimpleDateFormat simpleDateFormat;
    private MS_Success obj;

    public BillStatistic_Form(MainForm main) {
        this.main = main;
        serviceA = new ServiceAdmin();
        initComponents();
        init();
    }

    public void init() {
        txtSearch.setHint("Tìm kiếm Hóa Đơn . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        df = new DecimalFormat("##,###,###");
        obj=new MS_Success(Main_Admin_Frame.getFrames()[0], true);
        //Thêm data cho Menu
        initTable();
        getRevenue();
        setCurrentDate();
    }
    //Lấy doanh thu hóa đơn trong ngày
    public void getRevenue() {
        try {
            txtprofit.setText(df.format(serviceA.getRevenueHD("Hôm nay")) + "đ");
        } catch (SQLException ex) {
            Logger.getLogger(BillStatistic_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCurrentDate() {
        simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        lbDate.setText("Ngày hiện tại: " + simpleDateFormat.format(new Date()));
    }

    public void initTable() {
        try {
            list = serviceA.getListHDIn("Tất cả");
            for (ModelHoaDon data : list) {
                tableHD.addRow(new Object[]{data.getIdHoaDon(), data.getIdKH(), data.getIdBan(), data.getNgayHD(), df.format(data.getTienMonAn()) + "đ", df.format(data.getTienGiam()) + "đ", df.format(data.getTongtien()) + "đ"});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void searchTable(String txt) {
        tableHD.removeAllRow();
        for (ModelHoaDon data : list) {
            if ((data.getIdHoaDon() + "").toLowerCase().contains(txt.toLowerCase())) {
                tableHD.addRow(new Object[]{data.getIdHoaDon(), data.getIdKH(), data.getIdBan(), data.getNgayHD(), df.format(data.getTienMonAn()) + "đ", df.format(data.getTienGiam()) + "đ", df.format(data.getTongtien()) + "đ"});
            }
        }
        tableHD.repaint();
        tableHD.revalidate();
    }

    public void FilterTable(String txt) {
        tableHD.removeAllRow();
        list.clear();
        try {
            list = serviceA.getListHDIn(txt);
        } catch (SQLException ex) {
            Logger.getLogger(BillStatistic_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (ModelHoaDon data : list) {
            tableHD.addRow(new Object[]{data.getIdHoaDon(), data.getIdKH(), data.getIdBan(), data.getNgayHD(), df.format(data.getTienMonAn()) + "đ", df.format(data.getTienGiam()) + "đ", df.format(data.getTongtien()) + "đ"});
        }
        tableHD.repaint();
        tableHD.revalidate();
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
        tableHD = new RTDRestaurant.View.Swing.Table();
        lbDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        filter = new javax.swing.JComboBox<>();
        cmdCTHD = new RTDRestaurant.View.Swing.Button();
        cmdExcel = new RTDRestaurant.View.Swing.Button();

        setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bill (1).png"))); // NOI18N
        lbTitle.setText("Thống kê Hóa Đơn");
        lbTitle.setIconTextGap(10);

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe (1).png"))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        lbprofit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbprofit.setForeground(new java.awt.Color(89, 89, 89));
        lbprofit.setText("Doanh thu Hóa Đơn trong ngày");

        txtprofit.setEditable(false);
        txtprofit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtprofit.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lbCus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbCus.setForeground(new java.awt.Color(89, 89, 89));
        lbCus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbCus.setText("Danh sách Hóa Đơn");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tableHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã KH", "Mã Bàn", "Ngày Hóa Đơn", "Tiền món ăn", "Tiền giảm", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableHD);
        if (tableHD.getColumnModel().getColumnCount() > 0) {
            tableHD.getColumnModel().getColumn(0).setMinWidth(120);
            tableHD.getColumnModel().getColumn(0).setMaxWidth(120);
            tableHD.getColumnModel().getColumn(1).setMinWidth(120);
            tableHD.getColumnModel().getColumn(1).setMaxWidth(120);
            tableHD.getColumnModel().getColumn(2).setMinWidth(120);
            tableHD.getColumnModel().getColumn(2).setMaxWidth(120);
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

        cmdCTHD.setBackground(new java.awt.Color(108, 91, 123));
        cmdCTHD.setForeground(new java.awt.Color(255, 255, 255));
        cmdCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboard.png"))); // NOI18N
        cmdCTHD.setText("XEM CTHĐ");
        cmdCTHD.setFocusable(false);
        cmdCTHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCTHDActionPerformed(evt);
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
                        .addComponent(cmdCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(cmdCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            workbook.easy_getSheetAt(0).setSheetName("Danh sách Hóa Đơn");
            ExcelTable xlsTable = ((ExcelWorksheet) workbook.easy_getSheetAt(0)).easy_getExcelTable();
            //Them data cho header
            DefaultTableModel model = (DefaultTableModel) tableHD.getModel();
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
            workbook.easy_WriteXLSXFile(".\\src\\ExportFile_Excel\\DanhsachHoaDon_" + simpleDateFormat.format(new Date()) + ".xlsx");
            File file=new File("src\\ExportFile_Excel\\DanhsachHoaDon_" + simpleDateFormat.format(new Date()) + ".xlsx");
            String path=file.getAbsolutePath();
            System.out.println(path);
            obj.ExportFileSuccess(path);
            workbook.Dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmdExcelActionPerformed

    private void cmdCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCTHDActionPerformed
        int idHD=tableHD.getFirstCol_RowSelected(tableHD.getSelectedRow());
        ModelHoaDon bill=null;
        for(ModelHoaDon data:list){
            if(data.getIdHoaDon()==idHD){
                bill=data;
                break;
            }
        }
        main.showForm(new CTHD_Form(bill,main));
    }//GEN-LAST:event_cmdCTHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Swing.Button cmdCTHD;
    private RTDRestaurant.View.Swing.Button cmdExcel;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCus;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbprofit;
    private RTDRestaurant.View.Swing.Table tableHD;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    private RTDRestaurant.View.Swing.MyTextField txtprofit;
    // End of variables declaration//GEN-END:variables
}
