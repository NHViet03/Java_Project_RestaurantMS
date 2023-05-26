package RTDRestaurant.Model;

import javax.swing.Icon;

//Thông tin về món ăn
public class ModelMonAn {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }
    

    public ModelMonAn() {
    }

    public ModelMonAn(Icon icon, int id, String title, int value, String type) {
        this.icon = icon;
        this.id = id;
        this.title = title;
        this.value = value;
        this.type = type;
    }

    public ModelMonAn(Icon icon, int id, String title, int value, String type,String state) {
        this.icon = icon;
        this.id = id;
        this.title = title;
        this.value = value;
        this.type = type;
        this.state=state;
    }
    
    private Icon icon;  //Hình ảnh
    private int id;
    private String title; //Tên món ăn 
    private int value; //Đơn giá
    String type;       //Loại món ăn trong 12 loại
    String state;      //Trạng thái của món ăn (Đang/Ngừng Kinh Doanh)

}
