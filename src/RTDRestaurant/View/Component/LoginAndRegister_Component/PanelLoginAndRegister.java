package RTDRestaurant.View.Component.LoginAndRegister_Component;

import RTDRestaurant.Model.ModelLogin;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.View.Swing.Button;
import RTDRestaurant.View.Swing.MyPasswordField;
import RTDRestaurant.View.Swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

//Panel Đăng nhập/Đăng kys
public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    //Lấy tài khoản đăng ký
    public ModelNguoiDung getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    //Lấy thông tin đăng nhập
    public ModelLogin getDataLogin() {
        return dataLogin;
    }

    private ModelNguoiDung user; //Model Tài khoản người dùng
    private String name; //Tên Khách Hàng
    private ModelLogin dataLogin; //Model thông tin đăng nhập
    private Icon hide;
    private Icon show;
    private char def;

    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        hide = new ImageIcon(getClass().getResource("/Icons/hide.png"));
        show = new ImageIcon(getClass().getResource("/Icons/view.png"));
        initLogin(eventLogin);
        initRegister(eventRegister);
        register.setVisible(true);
        login.setVisible(false);    
    }

    //Khởi tạo màn hình đăng ký
    private void initRegister(ActionListener eventRegister) {
        //Set Layout
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));

        //Label
        JLabel label = new JLabel("TẠO TÀI KHOẢN");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(Color.decode("#6C5B7B"));
        register.add(label);
        //TextField Tên Khách Hàng
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/Icons/user (2).png")));
        txtUser.setHint("Tên Khách Hàng ...");
        register.add(txtUser, "w 60%");
        //TextField Email
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/Icons/mail.png")));
        txtEmail.setHint("Email ...");
        register.add(txtEmail, "w 60%");
        //TextField Mật khẩu
        MyPasswordField txtPassword = new MyPasswordField();
        def = txtPassword.getEchoChar();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/Icons/pass.png")));
        txtPassword.setHint("Mật khẩu ...");
        txtPassword.setSuffixIcon(show);
        register.add(txtPassword, "w 60%");
        txtPassword.addMouseListener(new MouseAdapter() {
         
            public void mouseClicked(MouseEvent e) {
                if (txtPassword.getSuffixIcon().equals(hide)) {
                    txtPassword.setSuffixIcon(show);
                    txtPassword.setEchoChar((char) 0);

                } else {
                    txtPassword.setSuffixIcon(hide);
                    txtPassword.setEchoChar(def);
                }
            }

        });
        //Button Đăng ký
        Button cmd = new Button();
        cmd.setBackground(Color.decode("#6C5B7B"));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("ĐĂNG KÝ");
        //Add Event cho Button "Đăng ký"
        cmd.addActionListener(eventRegister);
        register.add(cmd, "w 40%, h 40");
        //Add Event cho Button "Đăng ký"
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());
                user = new ModelNguoiDung(0, email, password, "Khach Hang");
            }
        });
    }

    //Khởi tạo màn hình Đăng nhập
    private void initLogin(ActionListener eventLogin) {
        //Set Layout
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("ĐĂNG NHẬP");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(Color.decode("#6C5B7B"));
        login.add(label);
        //TextField Email
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/Icons/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");
        //TextField Mật khẩu
        MyPasswordField txtPassword = new MyPasswordField();
        def = txtPassword.getEchoChar();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/Icons/pass.png")));
        txtPassword.setHint("Mật khẩu");
        txtPassword.setSuffixIcon(show);
        login.add(txtPassword, "w 60%");
        txtPassword.addMouseListener(new MouseAdapter() {
         
            public void mouseClicked(MouseEvent e) {
                if (txtPassword.getSuffixIcon().equals(hide)) {
                    txtPassword.setSuffixIcon(show);
                    txtPassword.setEchoChar((char) 0);

                } else {
                    txtPassword.setSuffixIcon(hide);
                    txtPassword.setEchoChar(def);
                }
            }

        });
        //Button "Quên mật khẩu"
        JButton cmdForget = new JButton("Quên mật khẩu của bạn ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        //Button "ĐĂNG NHẬP"
        Button cmd = new Button();
        cmd.setBackground(Color.decode("#6C5B7B"));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("ĐĂNG NHẬP");
        login.add(cmd, "w 40%, h 40");
        //Add Event cho Button "ĐANWGN NHẬP"
        cmd.addActionListener(eventLogin);
        //Add Event cho Button "ĐANWGN NHẬP"
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());
                dataLogin = new ModelLogin(email, password);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card2");

        register.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card3");
    }// </editor-fold>//GEN-END:initComponents
    //Hiển thị màn hình Đăng nhập/Đăng ký

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
