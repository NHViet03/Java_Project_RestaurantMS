
package RTDRestaurant.Model;

//Thông tin chi tiết phiếu nhập kho
public class ModelCTNK {

    public int getIdNK() {
        return idNK;
    }

    public int getIdNL() {
        return idNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public String getDvt() {
        return dvt;
    }

    public int getsL() {
        return sL;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public ModelCTNK() {
    }

    public ModelCTNK(int idNK, int idNL, String tenNL, String dvt, int sL, int thanhTien) {
        this.idNK = idNK;
        this.idNL = idNL;
        this.tenNL = tenNL;
        this.dvt = dvt;
        this.sL = sL;
        this.thanhTien = thanhTien;
    }

    
    private int idNK;  //Mã phiếu nhập
    private int idNL; //Mã nguyên liệu
    private String tenNL; //Tên nguyên liệu 
    private String dvt; //Đơn vị tính 
    private int sL;     //Số lượng
    private int thanhTien;  //Thành tiền
}
