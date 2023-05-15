
package RTDRestaurant.View.Component.LoginAndRegister_Component;

import RTDRestaurant.View.Swing.ButtonOutLine;
import RTDRestaurant.View.Swing.ImageLogo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

//Panel Cover ở màn hình đăng nhập/đăng ký
public class PanelCover extends javax.swing.JPanel {

    private ActionListener event;
    private final MigLayout layout;
    private ImageLogo logo; //Logo nhà hàng
    private JLabel title; 
    private JLabel subtitle;
    private JLabel description;
    private JLabel description1;
    private ButtonOutLine button;
    private boolean isLogin; // True nếu đang ở màn hình đăng nhập, ngược lại False
    private final DecimalFormat df= new DecimalFormat("##0.###");
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout= new MigLayout("wrap, fill","[center]","push[]40[]10[]25[]10[]25[]push");
        setLayout(layout);
        init();
    }
    
    private void init(){
       
        logo= new ImageLogo();
        logo.setPreferredSize(new Dimension(250,250));
        logo.setIcon(new ImageIcon(getClass().getResource("/Icons/logo_register.png")));
        add(logo);
        
        title= new JLabel("Chào mừng bạn đến với nhà hàng");
        title.setFont(new Font("sansserif",1,18));
        title.setForeground(new Color(245,245,245));
        add(title);
        
        subtitle= new JLabel("Royal TheDreamers");
        subtitle.setFont(new Font("sansserif",1,28));
        subtitle.setForeground(new Color(245,245,245));
        add(subtitle);
        
        description = new JLabel("Để sử dụng dịch vụ tại đây vui lòng");
        description.setForeground(new Color(245,245,245));
        add(description);
        
        description1 = new JLabel("đăng nhập với tài khoản cá nhân của bạn");
        description1.setForeground(new Color(245,245,245));
        add(description1);
        
        button = new ButtonOutLine();
        button.setBackground(new Color(255,255,255));
        button.setForeground(new Color(255,255,255));
        button.setText("<<  Đăng nhập");
        //Add Event cho Button "Đăng nhập"
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                event.actionPerformed(e);
            }
        });
        add(button,"w 60%, h 40");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void addEvent(ActionListener event){
        this.event=event;
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#C06C84"), 0, getHeight(), Color.decode("#6C5B7B"));
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    //Repaint Panel Cover khi thay đổi giữa màn hình Đăng nhập/Đăng ký
    public void registerLeft(double v){
        v=Double.parseDouble(df.format(v));
        login(false);
        layout.setComponentConstraints(logo, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(title, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(subtitle, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -"+v+"% 0 0");
    }
    //Repaint Panel Cover khi thay đổi giữa màn hình Đăng nhập/Đăng ký
    public void registerRight(double v){
        v=Double.parseDouble(df.format(v));
        login(false);
        layout.setComponentConstraints(logo, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(title, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(subtitle, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -"+v+"% 0 0");
    }
     //Repaint Panel Cover khi thay đổi giữa màn hình Đăng nhập/Đăng ký
    public void loginLeft(double v){
        v=Double.parseDouble(df.format(v));
        login(true);
        layout.setComponentConstraints(logo, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(title, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(subtitle, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(description, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(description1, "pad 0 "+v+"% 0 "+v+"%");
    }
     //Repaint Panel Cover khi thay đổi giữa màn hình Đăng nhập/Đăng ký
    public void loginRight(double v){
        v=Double.parseDouble(df.format(v));
        login(true);
        layout.setComponentConstraints(logo, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(title, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(subtitle, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(description, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(description1, "pad 0 "+v+"% 0 "+v+"%");
    }
    private void login(boolean login){
        if(this.isLogin!=login){
            //Set Data cho Panel cover khi ở màn hình đăng nhập
            if(login){
                logo.setIcon(new ImageIcon(getClass().getResource("/Icons/logo_login.png")));
                title.setText("Bạn chưa có tài khoản tại");
                description.setText("Đừng lo, tạo mới một tài khoản");
                description1.setText("và bắt đầu trải nghiệm của bạn với nhà hàng chúng tôi");
                button.setText("Đăng ký  >>");
            }else{
                //Set Data cho Panel cover khi ở màn hình đăng ký
                logo.setIcon(new ImageIcon(getClass().getResource("/Icons/logo_register.png")));
                title.setText("Chào mừng bạn đến với nhà hàng");
                description.setText("Để sử dụng dịch vụ tại đây vui lòng");
                description1.setText("đăng nhập với tài khoản cá nhân của bạn");
                button.setText("<<  Đăng nhập");
            }
            this.isLogin=login;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
