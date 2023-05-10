
package RTDRestaurant.Model;

import javax.swing.Icon;


public class ModelCard {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ModelCard() {
    }

    public ModelCard(Icon icon, String title, String value) {
        this.icon = icon;
        this.title = title;
        this.value = value;
    }
    
    private Icon icon;
    private String title;
    private String value;
    
}
