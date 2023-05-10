
package RTDRestaurant.View.Form;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Controller.Service.ServiceMenu;
import RTDRestaurant.Model.ModelCard;
import RTDRestaurant.View.Component.Card;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import RTDRestaurant.View.Swing.WrapLayout;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class FoodMenu_Form extends javax.swing.JPanel {

    private final String type;
    private ServiceMenu service;
    private ArrayList<ModelCard> list;
    public FoodMenu_Form(String type) {
        try {
            DatabaseConnection.getInstance().connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.type=type;
        service=new ServiceMenu();
        initComponents();
        init();
    }

    public void init(){
        panel.setLayout(new WrapLayout(WrapLayout.LEADING,20,20));
        txtSearch.setHint("Tìm kiếm món ăn . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        //Thêm data cho Menu
        initMenuFood();
   
        //Set Data cho Tiêu đề Menu     
        switch (type) {
            case "Arias" -> {
                lbTitle.setText("Menu/"+type+" - Bạch Dương");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/aries.png")));
            }
            case "Taurus" -> {
                lbTitle.setText("Menu/"+type+" - Kim Ngưu");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/taurus.png")));
            }
            case "Gemini" -> {
                lbTitle.setText("Menu/"+type+" - Song tử");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/gemini.png")));
            }
            case "Cancer" -> {
                lbTitle.setText("Menu/"+type+" - Cự Giải");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/cancer.png")));
            }
            case "Leo" -> {
                lbTitle.setText("Menu/"+type+" - Sư tử");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/leo.png")));
            }
            case "Virgo" -> {
                lbTitle.setText("Menu/"+type+" - Xử Nữ");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/virgo.png")));
            }
            case "Libra" -> {
                lbTitle.setText("Menu/"+type+" - Thiên Bình");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/libra.png")));
            }
            case "Scorpio" -> {
                lbTitle.setText("Menu/"+type+" - Bọ Cạp");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/scorpio.png")));
            }
            case "Sagittarius" -> {
                lbTitle.setText("Menu/"+type+" - Nhân Mã");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/sagittarius.png")));
            }
            case "Capricorn" -> {
                lbTitle.setText("Menu/"+type+" - Ma Kết");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/capricorn.png")));
            }
            case "Aquarius" -> {
                lbTitle.setText("Menu/"+type+" - Bảo Bình");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/aquarius.png")));
            }
            case "Pisces" -> {
                lbTitle.setText("Menu/"+type+" - Song Ngư");
                lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/pisces.png")));
            }
            default -> {
            }
        }
    }
    public void initMenuFood(){
        try {
            list = service.MenuFood(type);
            for(ModelCard data:list){
               
            panel.add(new Card(data));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        header1 = new RTDRestaurant.View.Component.OrderBar();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        panel.setBackground(new java.awt.Color(215, 221, 232));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/MenuBar/aries.png"))); // NOI18N
        lbTitle.setText("Menu/Arias - Bạch Dương");

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe (1).png"))); // NOI18N

        jComboBox1.setEditable(true);
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(108, 91, 123));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp theo: Tên", "Sắp xếp theo: Giá tăng dần", "Sắp xếp theo: Giá giảm dần", " ", " " }));
        jComboBox1.setToolTipText("Sắp xếp");
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 145, 145), 2));
        jComboBox1.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(header1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Component.OrderBar header1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel panel;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
