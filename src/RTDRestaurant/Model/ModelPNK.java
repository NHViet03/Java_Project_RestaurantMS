package RTDRestaurant.Model;

//Thông tin phiếu nhập kho
public class ModelPNK {

    public int getIdNK() {
        return idNK;
    }

    public int getIdNV() {
        return idNV;
    }

    public String getNgayNK() {
        return ngayNK;
    }

    public int getTongTien() {
        return tongTien;
    }

    public ModelPNK() {
    }

    public ModelPNK(int idNK, int idNV, String ngayNK) {
        this.idNK = idNK;
        this.idNV = idNV;
        this.ngayNK = ngayNK;
    }

    public ModelPNK(int idNK, int idNV, String ngayNK, int tongTien) {
        this.idNK = idNK;
        this.idNV = idNV;
        this.ngayNK = ngayNK;
        this.tongTien = tongTien;
    }

    private int idNK; //Mã phiếu nhập
    private int idNV;  //Mã nhân viên lập phiếu nhập
    private String ngayNK; //Ngày lập phiếu nhập
    private int tongTien; //Tổng tiền nhập
}
