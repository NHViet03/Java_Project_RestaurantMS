package RTDRestaurant.View.Swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

//Custom Icon cho JLabel
public class ImageFood extends JComponent {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }


    private Icon icon;

    public ImageFood() {
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        //Draw Image
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        Rectangle size=getAutoSize(icon);
        g2.drawImage(toImage(icon), size.x, size.y,size.width,size.height,null);
        super.paintComponent(g); 
    }
    
    //Fix kích thước ảnh
    private Rectangle getAutoSize(Icon image){
        int w=300;
        int h=150;
        int iw=image.getIconWidth();
        int ih=image.getIconHeight();
        double xScale=(double)w/iw;
        double yScale=(double)h/ih;
        double scale=Math.max(xScale, yScale);
        int width=(int)(iw*scale);
        int height=(int)(ih*scale);
        int x=(w-width)/2;
        int y=(h-height)/2;
        return new Rectangle(new Point(x,y),new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
}