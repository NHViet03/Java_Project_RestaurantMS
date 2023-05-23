package RTDRestaurant.View.Component.Staff_Component;

import RTDRestaurant.Model.ModelBan;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.Model.ModelNhanVien;
import RTDRestaurant.View.Dialog.MS_CancelReserve;
import RTDRestaurant.View.Dialog.MS_ConfirmReserve;
import RTDRestaurant.View.Form.MainForm;
import RTDRestaurant.View.Form.Staff_Form.Staff.OrderFood_Form;
import RTDRestaurant.View.Main_Frame.Main_Staff_Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardBanS extends javax.swing.JPanel {
    
    private final ModelBan table;
    private ModelNhanVien staff;
    private MainForm main;
    private ModelNguoiDung user;
    private MS_ConfirmReserve book;
    private MS_CancelReserve cancel;
    
    public CardBanS(ModelNguoiDung user,ModelNhanVien staff,ModelBan table,MainForm main) {
        this.user=user;
        this.staff=staff;
        this.table = table;
        this.main=main;
        initComponents();
        init();
    }
    
    public void init(){
        book = new MS_ConfirmReserve(Main_Staff_Frame.getFrames()[0], true);
        cancel = new MS_CancelReserve(Main_Staff_Frame.getFrames()[0], true);
        setPreferredSize(new Dimension(300, 325));
        lbTitle.setText("Mã bàn: "+table.getID()+" - "+table.getName());
        lbValue.setText(table.getStatus());
        switch (table.getStatus()) {
            case "Con trong" -> {
                img.setBackground(Color.decode("#E9E4F0"));
                cmdAdj.setBackground(Color.decode("#355C7D"));
                cmdAdj.setText("ĐẶT TRƯỚC");
                //Nếu bàn trống thì thêm event xử lý đặt bàn
                cmdAdj.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       book.ConfirmReserve(table);
                    }
                });
            }
            case "Dang dung bua" -> {
                img.setBackground(Color.decode("#605C3C"));
                cmdAdj.setText("GỌI MÓN");
                cmdAdj.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       main.showForm(new OrderFood_Form(user,staff,table,main));
                    }
                });
            }
            case "Da dat truoc" -> {
                img.setBackground(Color.decode("#FFE000"));
                cmdAdj.setText("HỦY ĐẶT TRƯỚC");
                cmdAdj.setBackground(Color.decode("#c94b4b"));
                cmdAdj.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       cancel.CancelReserve(table);
                    }
                });
                
            }
            default -> {
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new RTDRestaurant.View.Swing.PanelRound();
        img = new javax.swing.JLabel();
        lbValue = new javax.swing.JLabel();
        cmdAdj = new RTDRestaurant.View.Swing.Button();
        lbTitle = new javax.swing.JLabel();

        panelRound1.setPreferredSize(new java.awt.Dimension(300, 300));

        img.setBackground(new java.awt.Color(233, 228, 240));
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/table2.png"))); // NOI18N
        img.setOpaque(true);

        lbValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbValue.setForeground(new java.awt.Color(108, 91, 123));
        lbValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValue.setText("Value");

        cmdAdj.setBackground(new java.awt.Color(108, 91, 123));
        cmdAdj.setForeground(new java.awt.Color(255, 255, 255));
        cmdAdj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/levels.png"))); // NOI18N
        cmdAdj.setText("TÙY CHỈNH");
        cmdAdj.setToolTipText("");
        cmdAdj.setFocusable(false);
        cmdAdj.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cmdAdj.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cmdAdj.setIconTextGap(20);

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Title");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdAdj, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdAdj, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Swing.Button cmdAdj;
    private javax.swing.JLabel img;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValue;
    private RTDRestaurant.View.Swing.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
