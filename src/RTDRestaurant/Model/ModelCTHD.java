
package RTDRestaurant.Model;


public class ModelCTHD {

    public int getID_HD() {
        return ID_HD;
    }

    public int getID_MonAn() {
        return ID_MonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public ModelCTHD() {
    }

    public ModelCTHD(int ID_HD, int ID_MonAn, String tenMonAn, int soluong, int thanhTien) {
        this.ID_HD = ID_HD;
        this.ID_MonAn = ID_MonAn;
        this.tenMonAn = tenMonAn;
        this.soluong = soluong;
        this.thanhTien = thanhTien;
    }
    
    private int ID_HD;
    private int ID_MonAn;
    private String tenMonAn;
    private int soluong;
    private int thanhTien;
    
}
