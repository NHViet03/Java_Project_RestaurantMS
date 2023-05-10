
package RTDRestaurant.View.Main_Frame;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Controller.Event.EventMenuSelected;
import RTDRestaurant.View.Component.OrderBar;
import RTDRestaurant.View.Component.Menu;
import RTDRestaurant.View.Form.FoodMenu_Form;
import RTDRestaurant.View.Form.Form2;
import RTDRestaurant.View.Form.MainForm;
import java.awt.Toolkit;
import java.sql.SQLException;
import net.miginfocom.swing.MigLayout;


public class Main_Customer_Frame extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private OrderBar header;
    private MainForm main;
    public Main_Customer_Frame() {
        initComponents();
        init();
        setTitle("Royal TheDreamers Restaurant");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/restaurant (1).png")));
    }
    
    public void init(){
        layout = new MigLayout("fill","0[]0[100%, fill]0","0[fill, top]0");
        bg.setLayout(layout);
        menu=new Menu();
        header= new OrderBar();
        main= new MainForm();
        menu.addEvent(new EventMenuSelected(){
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                if(menuIndex==0){
                    switch (subMenuIndex) {
                        case 0 -> main.showForm(new FoodMenu_Form("Aries"));
                        case 1 -> main.showForm(new FoodMenu_Form("Taurus"));
                        case 2 -> main.showForm(new FoodMenu_Form("Gemini"));
                        case 3 -> main.showForm(new FoodMenu_Form("Cancer"));
                        case 4 -> main.showForm(new FoodMenu_Form("Leo"));
                        case 5 -> main.showForm(new FoodMenu_Form("Virgo"));
                        case 6 -> main.showForm(new FoodMenu_Form("Libra"));
                        case 7 -> main.showForm(new FoodMenu_Form("Scorpio"));
                        case 8 -> main.showForm(new FoodMenu_Form("Sagittarius"));
                        case 9 -> main.showForm(new FoodMenu_Form("Capricorn"));
                        case 10 -> main.showForm(new FoodMenu_Form("Aquarius"));
                        case 11 -> main.showForm(new FoodMenu_Form("Pisces"));
                        default -> {
                        }
                    }
                    
                }
            }
        });
        Menu menu1=new Menu();
        menu.initMenuItem();
        bg.add(menu,"w 265!, spany 2"); //Span Y 2cell
        bg.add(main,"w 100%, h 100%");
        //Form mặc định lúc đăng nhập
        main.showForm(new FoodMenu_Form("Aries"));
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1321, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
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

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Customer_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Customer_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Customer_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Customer_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            DatabaseConnection.getInstance().connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Customer_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
