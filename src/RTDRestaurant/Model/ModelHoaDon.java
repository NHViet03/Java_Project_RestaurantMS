package RTDRestaurant.Model;

public class ModelHoaDon {

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public int getIdKH() {
        return idKH;
    }

    public int getIdBan() {
        return idBan;
    }

    public String getNgayHD() {
        return ngayHD;
    }

    public int getTienMonAn() {
        return tienMonAn;
    }

    public String getCode_voucher() {
        return code_voucher;
    }

    public int getTienGiam() {
        return tienGiam;
    }

    public int getTongtien() {
        return tongtien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public ModelHoaDon() {
    }

    public ModelHoaDon(int idHoaDon, int idKH, int idBan, String ngayHD, int tienMonAn, int tienGiam, int tongtien){
        this.idHoaDon = idHoaDon;
        this.idKH = idKH;
        this.idBan = idBan;
        this.ngayHD = ngayHD;
        this.tienMonAn = tienMonAn;
        this.tienGiam = tienGiam;
        this.tongtien = tongtien;
    }
    
    public ModelHoaDon(int idHoaDon, int idKH, int idBan, String ngayHD, int tienMonAn, String code_voucher, int tienGiam, int tongtien, String trangthai) {
        this.idHoaDon = idHoaDon;
        this.idKH = idKH;
        this.idBan = idBan;
        this.ngayHD = ngayHD;
        this.tienMonAn = tienMonAn;
        this.code_voucher = code_voucher;
        this.tienGiam = tienGiam;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }
    
    
    
    private int idHoaDon;
    private int idKH;
    private int idBan;
    private String ngayHD;
    private int tienMonAn;
    private String code_voucher;
    private int tienGiam;
    private int tongtien;
    private String trangthai;
}
