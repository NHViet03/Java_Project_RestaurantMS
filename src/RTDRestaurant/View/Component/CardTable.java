package RTDRestaurant.View.Component;

import RTDRestaurant.Model.ModelCard;
import RTDRestaurant.Model.Model_CardTable;
import RTDRestaurant.View.Swing.ImageFood;
import RTDRestaurant.View.Swing.ImageLogo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;

public class CardTable extends javax.swing.JPanel {

    private final Model_CardTable data;

    public CardTable(Model_CardTable data) {
        this.data = data;
        initComponents();
        setPreferredSize(new Dimension(300, 325));
        lbTitle.setText(data.getName());
        lbValue.setText(data.getStatus());
        switch (data.getStatus()) {
            case "Con trong" -> {
                img.setBackground(Color.decode("#E9E4F0"));
            }
            case "Dang dung bua" -> {
                img.setBackground(Color.decode("#605C3C"));
                cmdAccept.setText("KHÔNG THỂ ĐẶT");
                cmdAccept.setBackground(Color.decode("#232526"));
                cmdAccept.setEnabled(false);
            }
            case "Da dat truoc" -> {
                img.setBackground(Color.decode("#FFE000"));
                cmdAccept.setText("KHÔNG THỂ ĐẶT");
                cmdAccept.setBackground(Color.decode("#232526"));
                cmdAccept.setEnabled(false);
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
        cmdAccept = new RTDRestaurant.View.Swing.Button();
        lbTitle = new javax.swing.JLabel();

        panelRound1.setPreferredSize(new java.awt.Dimension(300, 300));

        img.setBackground(new java.awt.Color(233, 228, 240));
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/table2.png"))); // NOI18N
        img.setOpaque(true);

        lbValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbValue.setForeground(new java.awt.Color(108, 91, 123));
        lbValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValue.setText("Value");

        cmdAccept.setBackground(new java.awt.Color(108, 91, 123));
        cmdAccept.setForeground(new java.awt.Color(255, 255, 255));
        cmdAccept.setText("ĐẶT BÀN");
        cmdAccept.setToolTipText("");
        cmdAccept.setFocusable(false);
        cmdAccept.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Title");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(lbValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(cmdAccept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(93, 93, 93))
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
                .addComponent(cmdAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
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
    private RTDRestaurant.View.Swing.Button cmdAccept;
    private javax.swing.JLabel img;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValue;
    private RTDRestaurant.View.Swing.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
