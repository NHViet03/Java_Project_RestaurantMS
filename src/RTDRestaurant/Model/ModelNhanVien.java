
package RTDRestaurant.Model;


public class ModelNhanVien {

    public int getId_NV() {
        return id_NV;
    }

    public void setId_NV(int id_NV) {
        this.id_NV = id_NV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgayVL() {
        return ngayVL;
    }

    public void setNgayVL(String ngayVL) {
        this.ngayVL = ngayVL;
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

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public int getId_NQL() {
        return id_NQL;
    }

    public void setId_NQL(int id_NQL) {
        this.id_NQL = id_NQL;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
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

    public ModelNhanVien(int id_NV, String tenNV, String ngayVL, String sdt, String chucvu, int id_NQL, String tinhTrang) {
        this.id_NV = id_NV;
        this.tenNV = tenNV;
        this.ngayVL = ngayVL;
        this.sdt = sdt;
        this.chucvu = chucvu;
        this.id_NQL = id_NQL;
        this.tinhTrang = tinhTrang;
    }
    
    
    private int id_NV;
    private String tenNV;
    private String ngayVL;
    private String sdt;
    private String chucvu;
    private int id_NQL;
    private String tinhTrang;
    
}
