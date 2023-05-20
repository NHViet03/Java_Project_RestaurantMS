
package RTDRestaurant.Model;


public class ModelNhanVien {

    public int getId_NV() {
        return id_NV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getNgayVL() {
        return ngayVL;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getChucvu() {
        return chucvu;
    }

    public int getId_NQL() {
        return id_NQL;
    }

    public ModelNhanVien() {
    }

    public ModelNhanVien(int id_NV, String tenNV, String ngayVL, String sdt, String chucvu, int id_NQL) {
        this.id_NV = id_NV;
        this.tenNV = tenNV;
        this.ngayVL = ngayVL;
        this.sdt = sdt;
        this.chucvu = chucvu;
        this.id_NQL = id_NQL;
    }
    
    
    private int id_NV;
    private String tenNV;
    private String ngayVL;
    private String sdt;
    private String chucvu;
    private int id_NQL;
    
}
