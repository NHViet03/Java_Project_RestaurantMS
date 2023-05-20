package RTDRestaurant.Controller.Service;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Model.ModelCTHD;
import RTDRestaurant.Model.ModelCTNK;
import RTDRestaurant.Model.ModelNguyenLieu;
import RTDRestaurant.Model.ModelNhanVien;
import RTDRestaurant.Model.ModelPNK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ServiceStaff {

    private final Connection con;

    //Connect tới DataBase       
    public ServiceStaff() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    //Lấy thông tin nhân viên từ ID người dùng
    public ModelNhanVien getStaff(int userID) throws SQLException {
        ModelNhanVien data = null;
        String sql = "SELECT ID_NV, TenNV, to_char(NgayVL, 'dd-mm-yyyy') AS Ngay, SDT, Chucvu, ID_NQL FROM NhanVien WHERE ID_ND=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, userID);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id_NV = r.getInt("ID_NV");
            String tenNV = r.getString("TenNV");
            String ngayVL = r.getString("Ngay");
            String sdt = r.getString("SDT");
            String chucvu = r.getString("Chucvu");
            int id_NQL = r.getInt("ID_NQL");
            data = new ModelNhanVien(id_NV, tenNV, ngayVL, sdt, chucvu, id_NQL);
        }
        r.close();
        p.close();
        return data;
    }

    //Lấy toàn bộ danh sách nguyên liệu
    public ArrayList<ModelNguyenLieu> MenuNL() throws SQLException {
        ArrayList<ModelNguyenLieu> list = new ArrayList<>();
        String sql = "SELECT ID_NL,TenNL,Dongia,Donvitinh FROM NguyenLieu";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt(1);  //Mã nguyên liệu
            String tenNL = r.getString(2); //Tên nguyên liệu
            int donGia = r.getInt(3); //Đơn giá nhập nguyên liệu
            String dvt = r.getString(4); //Đơn vị tính của nguyên liệu
            ModelNguyenLieu data = new ModelNguyenLieu(id, tenNL, donGia, dvt);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy thông tin của nguyên liệu theo ID
    public ModelNguyenLieu getNLbyID(int idNL) throws SQLException {
        ModelNguyenLieu data = null;
        String sql = "SELECT ID_NL,TenNL,Dongia,Donvitinh FROM NguyenLieu WHERE ID_NL=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, idNL);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt(1);  //Mã nguyên liệu
            String tenNL = r.getString(2); //Tên nguyên liệu
            int donGia = r.getInt(3); //Đơn giá nhập nguyên liệu
            String dvt = r.getString(4); //Đơn vị tính của nguyên liệu
            data = new ModelNguyenLieu(id, tenNL, donGia, dvt);
        }
        r.close();
        p.close();
        return data;
    }

    //Lấy ID của Nguyên Liệu tiếp theo được thêm
    public int getNextID_NL() throws SQLException {
        int nextID = 0;
        String sql = "SELECT MAX(ID_NL) as ID FROM NguyenLieu";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            nextID = r.getInt("ID") + 1;
        }
        r.close();
        p.close();
        return nextID;
    }

    //Thêm một nguyên liệu mới
    public void InsertNL(ModelNguyenLieu data) throws SQLException {
        String sql = "INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(?,?,?,?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, data.getId());
        p.setString(2, data.getTenNL());
        p.setInt(3, data.getDonGia());
        p.setString(4, data.getDvt());
        p.execute();
        p.close();
    }

    //Sửa một nguyên liệu
    public void UpdateNL(ModelNguyenLieu data) throws SQLException {
        String sql = "UPDATE NguyenLieu SET TenNL = ?, Dongia = ?, Donvitinh = ? WHERE ID_NL = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, data.getTenNL());
        p.setInt(2, data.getDonGia());
        p.setString(3, data.getDvt());
        p.setInt(4, data.getId());
        p.execute();
        p.close();
    }

    //Lấy toàn bộ danh sách Phiếu nhập kho
    public ArrayList<ModelPNK> MenuPNK() throws SQLException {
        ArrayList<ModelPNK> list = new ArrayList<>();
        String sql = "SELECT ID_NK,ID_NV,to_char(NgayNK,'dd-mm-yyyy') AS Ngay,Tongtien FROM PhieuNK";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int idNK = r.getInt(1);
            int idNV = r.getInt(2);
            String ngayNK = r.getString(3);
            int tongTien = r.getInt(4);
            ModelPNK data = new ModelPNK(idNK, idNV, ngayNK, tongTien);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }
    
    //Lấy thông tin của Phiếu nhập kho theo ID
    public ModelPNK getPNKbyID(int id) throws SQLException {
        ModelPNK data = null;
        String sql = "SELECT ID_NK,ID_NV,to_char(NgayNK,'dd-mm-yyyy') AS Ngay,Tongtien FROM PhieuNK WHERE ID_NK=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int idNK = r.getInt(1);
            int idNV = r.getInt(2);
            String ngayNK = r.getString(3);
            int tongTien = r.getInt(4);
            data = new ModelPNK(idNK, idNV, ngayNK, tongTien);
        }
        r.close();
        p.close();
        return data;
    }

    //Lấy tổng tiền nhập trong ngày hiện tại
    public int getTongtienNK() throws SQLException {
        int tongtien = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        String sql = "SELECT SUM(Tongtien) FROM PhieuNK WHERE NgayNK=to_date(?, 'dd-mm-yyyy')";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, simpleDateFormat.format(new Date()));
        ResultSet r = p.executeQuery();
        while (r.next()) {
            tongtien = r.getInt(1);
        }
        r.close();
        p.close();
        return tongtien;
    }

    //Lấy danh sách chi tiết nhập kho theo mã nhập kho
    public ArrayList<ModelCTNK> getCTNK(int idnk) throws SQLException {
        ArrayList<ModelCTNK> list = new ArrayList<>();
        String sql = "SELECT ID_NK,CTNK.ID_NL, TenNL,Donvitinh,SoLuong,Thanhtien FROM CTNK "
                + "JOIN NguyenLieu ON NguyenLieu.ID_NL=CTNK.ID_NL WHERE ID_NK=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, idnk);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int ID_NK=r.getInt(1);
            int ID_NL=r.getInt(2);
            String tenNL=r.getString(3);
            String dvt=r.getString(4);
            int soluong=r.getInt(5);
            int thanhTien=r.getInt(6);
            ModelCTNK data=new ModelCTNK(ID_NK, ID_NL, tenNL, dvt,soluong , thanhTien);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }
}
