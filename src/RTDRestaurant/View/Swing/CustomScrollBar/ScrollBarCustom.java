package RTDRestaurant.View.Swing.CustomScrollBar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setForeground(Color.decode("#A7BFE8"));
        setUnitIncrement(20);
        setOpaque(false);
    }
}