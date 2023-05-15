package RTDRestaurant.View.Component.Customer_Component;

import RTDRestaurant.Controller.Event.EventMenu;
import RTDRestaurant.Controller.Event.EventMenuSelected;
import RTDRestaurant.Model.ModelMenu;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import RTDRestaurant.View.Swing.MenuAnimation;
import RTDRestaurant.View.Swing.MenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private boolean enableMenu = true;

    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);

    }

    //Khởi tạo data cho Menu 
    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/astrology.png")), "Menu - Zodiac Concept", "Aries - Bạch Dương", "Taurus - Kim Ngưu", "Gemini - Song Tử", "Cancer - Cự Giải",
                "Leo - Sư Tử", "Virgo - Xử Nữ", "Libra - Thiên Bình", "Scorpio - Bọ Cạp", "Sagittarius - Nhân Mã", "Capricorn - Ma Kết", "Aquarius - Bảo Bình", "Pisces - Song Ngư"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/table.png")), "Đặt bàn", "Tầng 1", "Tầng 2", "Tầng 3"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/information.png")), "About US"));
        addMenu(new ModelMenu(null, ""));
        addMenu(new ModelMenu(null, "Thông tin cá nhân"));
        addMenu(new ModelMenu(null, ""));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/user.png")), "Tài Khoản"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/star.png")), "Điểm tích lũy"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/invoice.png")), "Lịch sử hóa đơn"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/logout.png")), "Đăng Xuất"));
    }

    //Add Panel MenuIteam vào Panel Menu
    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPress(Component com, boolean open) {
                if (enableMenu) {
                    if (open) {
                        new MenuAnimation(layout, com).openMenu();
                    } else {
                        new MenuAnimation(layout, com).closeMenu();
                    }
                    return true;
                }
                return false;
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setFocusCycleRoot(true);

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setFocusable(false);
        sp.setOpaque(false);

        panel.setFocusable(false);
        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        logo.setBackground(new java.awt.Color(255, 255, 255));
        logo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/restaurant (1).png"))); // NOI18N
        logo.setText("<html> Royal TheDreamers <br> Restaurant ★★★★★</html>");
        logo.setIconTextGap(15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp= new GradientPaint(0, 0, Color.decode("#516395"), 0, getHeight(), Color.decode("#614385"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
