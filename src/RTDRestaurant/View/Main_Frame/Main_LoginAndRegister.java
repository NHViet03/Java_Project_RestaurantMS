
package RTDRestaurant.View.Main_Frame;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Controller.Service.ServiceMail;
import RTDRestaurant.Controller.Service.ServiceUser;
import RTDRestaurant.Model.ModelLogin;
import RTDRestaurant.Model.ModelMessage;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.View.Component.LoginAndRegister_Component.Message;
import RTDRestaurant.View.Component.LoginAndRegister_Component.PanelCover;
import RTDRestaurant.View.Component.LoginAndRegister_Component.PanelLoading;
import RTDRestaurant.View.Component.LoginAndRegister_Component.PanelLoginAndRegister;
import RTDRestaurant.View.Component.LoginAndRegister_Component.PanelVerifyCode;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class Main_LoginAndRegister extends javax.swing.JFrame {
    
    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister loginAndRegister;
    private PanelLoading loading;
    private PanelVerifyCode verifyCode;
    private boolean isLogin;
    private final double addSize=30;
    private final double coverSize=40;
    private final double loginSize=60;
    private final DecimalFormat df= new DecimalFormat("##0.###");
    private ServiceUser service;
    public Main_LoginAndRegister() {
        initComponents();
        init();
        setTitle("Royal TheDreamers Restaurant");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/restaurant (1).png")));
    }

    private void init(){
        service= new ServiceUser();
        layout= new MigLayout("fill, inset 0");
        cover=new PanelCover();
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               register();
            }
        };
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               login();
            }
        };
        loginAndRegister = new PanelLoginAndRegister(eventRegister,eventLogin);
        loading= new PanelLoading();
        verifyCode= new PanelVerifyCode();
        TimingTarget target = new TimingTargetAdapter(){
            
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size=coverSize;
                if(fraction<=0.5f){
                    size+=fraction*addSize;
                }else{
                    size+=addSize- fraction*addSize;
                }
                if(isLogin){
                    fractionCover=1-fraction;
                    fractionLogin=fraction;
                    if(fraction>=0.5f){
                        cover.registerRight(fractionCover*100);
                    }else{
                        cover.loginRight(fractionLogin*100);
                    }
                }else{
                    fractionCover=fraction;
                    fractionLogin=1-fraction;
                    if(fraction<=0.5f){
                        cover.registerLeft(fraction*100);
                    }else{
                        cover.loginLeft((1f-fraction)*100);
                    }
                }
                if(fraction>=0.5f){
                    loginAndRegister.showRegister(isLogin);
                    
                }
                fractionCover=Double.parseDouble(df.format(fractionCover));
                fractionLogin=Double.parseDouble(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width "+size+"%, pos "+fractionCover+"al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width "+loginSize+"%, pos "+fractionLogin+"al 0 n 100%");
                bg.revalidate();
            }
            
            @Override
            public void end() {
                isLogin=!isLogin;
            }
            
        
        };
        Animator animator = new Animator(800,target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0); // for smooth animation
        bg.setLayout(layout);
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.add(loading,"pos 0 0 100% 100%");
        bg.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);
        bg.add(verifyCode,"pos 0 0 100% 100%");
        bg.add(cover,"width "+coverSize+"%, pos 0al 0 n 100%");
        bg.add(loginAndRegister,"width "+loginSize+"%, pos 1al 0 n 100%"); //lal as 100%
        cover.addEvent(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!animator.isRunning()){
                    animator.start();
                }else{
                    
                }
            }
        });
        verifyCode.addEventButtonOK(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try {
                    ModelNguoiDung user = loginAndRegister.getUser();
                    String name=loginAndRegister.getName();
                    if(service.verifyCodeWithUser(user.getUserID(),verifyCode.getInputCode())){
                        service.doneVerify(user.getUserID(),name);
                        showMessage(Message.MessageType.SUCCESS, "Đăng ký thành công");
                        verifyCode.setVisible(false);
                    }else{
                        showMessage(Message.MessageType.ERROR, "Mã xác minh không chính xác");
                    }
                    
                }catch (SQLException e) {
                    showMessage(Message.MessageType.ERROR, "Xảy ra lỗi hệ thống");
                    e.printStackTrace();
                }
            }
        });
    }
    private void register(){
        ModelNguoiDung user=loginAndRegister.getUser();
        try {
            if(service.checkDuplicateEmail(user.getEmail())){
                showMessage(Message.MessageType.ERROR,"Email đã tồn tại");
            }else{
                service.insertUser(user);
                sendMail(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(Message.MessageType.ERROR, "Lỗi đăng ký");
            
        }
    }
    private void login(){
        ModelLogin data=loginAndRegister.getDataLogin();
        try {
            ModelNguoiDung user=service.login(data);
            if(user!=null){
                this.dispose();
                switch (user.getRole()) {
                    case "Khach Hang" -> {
                        Main_Customer_Frame.main(user);
                    }
                    case "Nhan Vien Kho" -> {
                        Main_WarehouseStaff_Frame.main(user);
                    }
                    case "Nhan Vien" -> {
                        Main_Staff_Frame.main(user);
                    }
                    case "Quan Ly" -> {
                        Main_Admin_Frame.main(user);
                    }
                    default -> {
                    }
                }
                
            }else{
                showMessage(Message.MessageType.ERROR, "Email hoặc mật khẩu không chính xác");
            }
        }catch (SQLException e) {
            showMessage(Message.MessageType.ERROR, "Lỗi đăng nhập");
        }
    }
    private void sendMail(ModelNguoiDung user){
        new Thread(new Runnable() {
            @Override
            public void run() {
                loading.setVisible(true);
                ModelMessage ms = new ServiceMail().sendMain(user.getEmail(), user.getVerifyCode());
                if (ms.isSuccess()) {
                    loading.setVisible(false);
                    verifyCode.setVisible(true);
                } else {
                    loading.setVisible(false);
                    showMessage(Message.MessageType.ERROR, ms.getMessage());
                }
            }
        }).start();
    }
    private void showMessage(Message.MessageType messageType,String message){
        Message ms=new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void begin() {
                if(!ms.isShow()){
                    bg.add(ms,"pos 0.5al -30",0); //Insert to bg first index 0
                    ms.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if(ms.isShow()){
                    f=40*(1f-fraction);
                }else{
                    f=fraction*40;
                }
                layout.setComponentConstraints(ms, "pos 0.5al "+(int)(f-30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if(ms.isShow()){
                   bg.remove(ms);
                   bg.repaint();
                   bg.revalidate();
                }else{
                    ms.setShow(true);
                }
            }
            
        };
        Animator animator =new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    animator.start();
                }catch(InterruptedException e){
                    System.err.println(e);
                }
            }
        }).start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        try {
            DatabaseConnection.getInstance().connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_LoginAndRegister().setVisible(true);
            }
        });
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        try {
            DatabaseConnection.getInstance().connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_LoginAndRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
