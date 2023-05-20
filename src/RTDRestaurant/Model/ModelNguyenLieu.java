
package RTDRestaurant.Model;


//Thông tin về Nguyên Liệu
public class ModelNguyenLieu {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    
    

    public ModelNguyenLieu() {
    }

    public ModelNguyenLieu(int id, String tenNL, int donGia, String dvt) {
        this.id = id;
        this.tenNL = tenNL;
        this.donGia = donGia;
        this.dvt = dvt;
    }
    
    private int id; //Mã nguyên liệu
    private String tenNL; //Tên nguyên liệu
    private int donGia; //Đơn giá nhập nguyên liệu
    private String dvt; //Đơn vị tính của nguyên liệu
    
}
