
package RTDRestaurant.Model;

//Thông tin về mã giảm giá 
public class ModelVoucher {

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ModelVoucher() {
    }

    public ModelVoucher(String code, String description, int percent, String typeMenu, int quantity, int point) {
        this.code = code;
        this.description = description;
        this.percent = percent;
        this.typeMenu = typeMenu;
        this.quantity = quantity;
        this.point = point;
    }
    
    String code; //Mã
    String description; //Mô tả
    int percent; //Phần trăm giảm
    String typeMenu; //Loại menu áp dụng 
    int quantity;  //Số lượng
    int point;     //Số điểm để đổi
    
}
