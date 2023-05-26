package RTDRestaurant.View.Form.Staff_Form.Admin;

import RTDRestaurant.Model.ModelCard;
import RTDRestaurant.Model.ModelChart;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

public class RevenueReport_Form extends javax.swing.JPanel {

    private DecimalFormat df;
    private SimpleDateFormat simpleDateFormat;

    public RevenueReport_Form() {
        initComponents();
        init();
    }

    public void init() {
        df = new DecimalFormat("##,###,###");
        setCurrentDate();
        //Thêm data cho Card
        initCard();
        //Thêm data cho Biểu đồ
        initChart();

    }

    public void initCard() {
        Crevenue.setData(new ModelCard(new ImageIcon(getClass().getResource("/Icons/revenue.png")), "Doanh Thu", df.format(10000000) + "đ", "..."));
        Cexpenses.setData(new ModelCard(new ImageIcon(getClass().getResource("/Icons/expenses.png")), "Chi Phí", df.format(8000000) + "đ", "..."));
        Cprofit.setData(new ModelCard(new ImageIcon(getClass().getResource("/Icons/profit.png")), "Lợi Nhuận", df.format(2000000) + "đ", "..."));
    }

    public void initChart() {
        lineChart.addLegend("Doanh thu", new Color(12, 84, 175), new Color(0, 108, 247));
        lineChart.addLegend("Chi Phí", new Color(54, 4, 143), new Color(104, 49, 200));
        lineChart.addLegend("Lợi nhuận", new Color(5, 125, 0), new Color(95, 209, 69));
        lineChart.addData(new ModelChart("January", new double[]{500, 200, 80}));
        lineChart.addData(new ModelChart("February", new double[]{600, 750, 90}));
        lineChart.addData(new ModelChart("March", new double[]{200, 350, 460}));
        lineChart.addData(new ModelChart("April", new double[]{480, 150, 750}));
        lineChart.addData(new ModelChart("May", new double[]{350, 540, 300}));
        lineChart.addData(new ModelChart("June", new double[]{190, 280, 81}));
        lineChart.start();
    }

    public void setCurrentDate() {
        simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        lbDate.setText("Ngày hiện tại: " + simpleDateFormat.format(new Date()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbprofit = new javax.swing.JLabel();
        panelCard = new javax.swing.JLayeredPane();
        Crevenue = new RTDRestaurant.View.Component.Admin_Component.Card();
        Cexpenses = new RTDRestaurant.View.Component.Admin_Component.Card();
        Cprofit = new RTDRestaurant.View.Component.Admin_Component.Card();
        lbDate = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lbchart = new javax.swing.JLabel();
        lineChart = new RTDRestaurant.View.Swing.Chart.LineChart();
        filter = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/analytics (1).png"))); // NOI18N
        lbTitle.setText("Báo cáo Doanh Thu");
        lbTitle.setIconTextGap(10);

        lbprofit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbprofit.setForeground(new java.awt.Color(89, 89, 89));
        lbprofit.setText("Thống kê Doanh Thu");

        panelCard.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        Crevenue.setColor1(new java.awt.Color(101, 78, 163));
        Crevenue.setColor2(new java.awt.Color(234, 175, 200));
        panelCard.add(Crevenue);

        Cexpenses.setColor1(new java.awt.Color(100, 209, 189));
        Cexpenses.setColor2(new java.awt.Color(171, 198, 229));
        panelCard.add(Cexpenses);

        Cprofit.setColor1(new java.awt.Color(44, 62, 80));
        Cprofit.setColor2(new java.awt.Color(76, 161, 175));
        panelCard.add(Cprofit);

        lbDate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbDate.setForeground(new java.awt.Color(108, 91, 123));
        lbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calendar.png"))); // NOI18N
        lbDate.setText("Ngày hiện tại");
        lbDate.setIconTextGap(20);

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        jSeparator3.setBackground(new java.awt.Color(76, 76, 76));

        lbchart.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbchart.setForeground(new java.awt.Color(89, 89, 89));
        lbchart.setText("Biểu Đồ Doanh Thu");

        filter.setEditable(true);
        filter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filter.setForeground(new java.awt.Color(108, 91, 123));
        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hôm nay", "Tháng này", "Năm này" }));
        filter.setToolTipText("Sắp xếp");
        filter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 145, 145), 2));
        filter.setFocusable(false);
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbchart, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbprofit, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbprofit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbchart)
                .addGap(10, 10, 10)
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        
    }//GEN-LAST:event_filterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Component.Admin_Component.Card Cexpenses;
    private RTDRestaurant.View.Component.Admin_Component.Card Cprofit;
    private RTDRestaurant.View.Component.Admin_Component.Card Crevenue;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbchart;
    private javax.swing.JLabel lbprofit;
    private RTDRestaurant.View.Swing.Chart.LineChart lineChart;
    private javax.swing.JLayeredPane panelCard;
    // End of variables declaration//GEN-END:variables
}
