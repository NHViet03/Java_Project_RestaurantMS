package RTDRestaurant.Model;

//Thông tin các nguyên liệu có trong kho
public class ModelKho {

    public int getIdNL() {
        return idNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public String getDvt() {
        return dvt;
    }

    public void setSlTon(int slTon) {
        this.slTon = slTon;
    }
    
    
    public int getSlTon() {
        return slTon;
    }

    public ModelKho() {
    }

    public ModelKho(int idNL, String tenNL, String dvt, int slTon) {
        this.idNL = idNL;
        this.tenNL = tenNL;
        this.dvt = dvt;
        this.slTon = slTon;
    }
    
    private int idNL;   //Mã nguyên liệu
    private String tenNL; //Tên nguyên liệu
    private String dvt;   //Đơn vị tính
    private int slTon; //Số lượng tồn
}
