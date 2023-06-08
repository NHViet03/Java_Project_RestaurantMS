package RTDRestaurant.View.Component.Customer_Component;

import RTDRestaurant.Model.ModelKhachHang;
import RTDRestaurant.Model.ModelHoaDon;
import RTDRestaurant.Model.ModelVoucher;
import RTDRestaurant.View.Dialog.MS_ConfirmExchangeVoucher;
import RTDRestaurant.View.Dialog.MS_Warning;
import RTDRestaurant.View.Main_Frame.Main_Customer_Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class CardVoucher extends javax.swing.JPanel {

    private final ModelVoucher data;
    private final ModelKhachHang customer;
    private final ModelHoaDon hoadon;
    private MS_Warning warning;
    private MS_ConfirmExchangeVoucher exchange;
    public ModelVoucher getData() {
        return data;
    }

    public CardVoucher(ModelVoucher data,ModelKhachHang customer,ModelHoaDon hoadon) {
        this.data = data;
        this.customer=customer;
        this.hoadon=hoadon;
        warning  = new MS_Warning(Main_Customer_Frame.getFrames()[0], true);
        exchange  = new MS_ConfirmExchangeVoucher(Main_Customer_Frame.getFrames()[0], true);
        initComponents();
        init();
        cmdExchange.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int Vpoint=data.getPoint();
                if(hoadon==null){
                    
                }
                else{
                    if(customer.getPoints()<Vpoint){
                    warning.WarningExchange(Vpoint-customer.getPoints());
                    }else{
                        exchange.ConfirmExchange(hoadon, data);
                    }
                }
            }
        });
        setOpaque(false);
    }
    
    public void init(){
        
        setPreferredSize(new Dimension(300, 325));
        ibDescription.setText(data.getDescription());
        lbQuantity.setText("Số lượng: " + data.getQuantity());
        lbPoint.setText(data.getPoint() + " xu");
        switch (data.getPercent()) {
            case 20 -> {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/20off.jpg")));
            }
            case 30 -> {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/30off.jpg")));
            }
            case 50 -> {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/50off.jpg")));
            }
            case 60 -> {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/60off.jpg")));
            }
            case 100 -> {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/100off.jpg")));
            }
            default -> {
            }
        }
        if (data.getQuantity() == 0) {
            cmdExchange.setText("ĐÃ HẾT");
            cmdExchange.setBackground(Color.decode("#232526"));
            cmdExchange.setEnabled(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new RTDRestaurant.View.Swing.PanelRound();
        img = new javax.swing.JLabel();
        lbQuantity = new javax.swing.JLabel();
        cmdExchange = new RTDRestaurant.View.Swing.Button();
        ibDescription = new javax.swing.JLabel();
        lbPoint = new javax.swing.JLabel();

        panelRound1.setPreferredSize(new java.awt.Dimension(300, 300));

        img.setBackground(new java.awt.Color(233, 228, 240));
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Voucher/20off.jpg"))); // NOI18N
        img.setOpaque(true);

        lbQuantity.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbQuantity.setForeground(new java.awt.Color(108, 91, 123));
        lbQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuantity.setText("Quantity");

        cmdExchange.setBackground(new java.awt.Color(108, 91, 123));
        cmdExchange.setForeground(new java.awt.Color(255, 255, 255));
        cmdExchange.setText("ĐỔI VOUCHER");
        cmdExchange.setToolTipText("");
        cmdExchange.setFocusable(false);
        cmdExchange.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        ibDescription.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ibDescription.setForeground(new java.awt.Color(108, 91, 123));
        ibDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ibDescription.setText("Title");

        lbPoint.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbPoint.setForeground(new java.awt.Color(108, 91, 123));
        lbPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPoint.setText("Point");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ibDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(lbPoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(cmdExchange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(83, 83, 83))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ibDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPoint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdExchange, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
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
    private RTDRestaurant.View.Swing.Button cmdExchange;
    private javax.swing.JLabel ibDescription;
    private javax.swing.JLabel img;
    private javax.swing.JLabel lbPoint;
    private javax.swing.JLabel lbQuantity;
    private RTDRestaurant.View.Swing.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
