
package RTDRestaurant.View.Form;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;


//Form chính ở giữa màn hình
public class MainForm extends javax.swing.JPanel {
    
    public MainForm() {
        initComponents();
        setOpaque(false);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10,10,10,10));
    }
    //Thay đổi giữa các form subMenu theo Menu được chọn
    public void showForm(Component form){
        removeAll();
        add(form);
        repaint();
        revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 204, 204));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
