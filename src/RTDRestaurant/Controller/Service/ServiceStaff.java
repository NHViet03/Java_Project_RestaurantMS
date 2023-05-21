package RTDRestaurant.Controller.Service;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Model.ModelCTNK;
import RTDRestaurant.Model.ModelCTXK;
import RTDRestaurant.Model.ModelKho;
import RTDRestaurant.Model.ModelNguyenLieu;
import RTDRestaurant.Model.ModelNhanVien;
import RTDRestaurant.Model.ModelPNK;
import RTDRestaurant.Model.ModelPXK;
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
        String sql = "SELECT ID_NL,TenNL,Dongia,Donvitinh FROM NguyenLieu ORDER BY ID_NL";
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
        String sql = "SELECT ID_NK,ID_NV,to_char(NgayNK,'dd-mm-yyyy') AS Ngay,Tongtien FROM PhieuNK ORDER BY ID_NK";
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
                + "JOIN NguyenLieu ON NguyenLieu.ID_NL=CTNK.ID_NL WHERE ID_NK=? ORDER BY ID_NK";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, idnk);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int ID_NK = r.getInt(1);
            int ID_NL = r.getInt(2);
            String tenNL = r.getString(3);
            String dvt = r.getString(4);
            int soluong = r.getInt(5);
            int thanhTien = r.getInt(6);
            ModelCTNK data = new ModelCTNK(ID_NK, ID_NL, tenNL, dvt, soluong, thanhTien);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy toàn bộ danh sách Phiếu xuất kho
    public ArrayList<ModelPXK> MenuPXK() throws SQLException {
        ArrayList<ModelPXK> list = new ArrayList<>();
        String sql = "SELECT ID_XK,ID_NV,to_char(NgayXK,'dd-mm-yyyy') AS Ngay FROM PhieuXK ORDER BY ID_XK";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int idXK = r.getInt(1);
            int idNV = r.getInt(2);
            String ngayXK = r.getString(3);
            ModelPXK data = new ModelPXK(idXK, idNV, ngayXK);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy thông tin của Phiếu xuất kho theo ID
    public ModelPXK getPXKbyID(int id) throws SQLException {
        ModelPXK data = null;
        String sql = "SELECT ID_XK,ID_NV,to_char(NgayXK,'dd-mm-yyyy') AS Ngay FROM PhieuXK WHERE ID_XK=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int idXK = r.getInt(1);
            int idNV = r.getInt(2);
            String ngayXK = r.getString(3);
            data = new ModelPXK(idXK, idNV, ngayXK);
        }
        r.close();
        p.close();
        return data;
    }

    //Lấy số lượng phiếu xuất kho trong ngày hiện tại
    public int getSLPXK() throws SQLException {
        int sl = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        String sql = "SELECT COUNT(*) FROM PhieuXK WHERE NgayXK=to_date(?, 'dd-mm-yyyy')";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, simpleDateFormat.format(new Date()));
        ResultSet r = p.executeQuery();
        while (r.next()) {
            sl = r.getInt(1);
        }
        r.close();
        p.close();
        return sl;
    }

    //Lấy danh sách chi tiết Xuất kho theo ID_XK
    public ArrayList<ModelCTXK> getCTXK(int idxk) throws SQLException {
        ArrayList<ModelCTXK> list = new ArrayList<>();
        String sql = "SELECT ID_XK,CTXK.ID_NL, TenNL,Donvitinh,SoLuong FROM CTXK "
                + "JOIN NguyenLieu ON NguyenLieu.ID_NL=CTXK.ID_NL WHERE ID_XK=? ORDER BY ID_XK";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, idxk);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int ID_NK = r.getInt(1);
            int ID_NL = r.getInt(2);
            String tenNL = r.getString(3);
            String dvt = r.getString(4);
            int soluong = r.getInt(5);
            ModelCTXK data = new ModelCTXK(ID_NK, ID_NL, tenNL, dvt, soluong);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy toàn bộ danh sách nguyên liệu trong kho
    public ArrayList<ModelKho> MenuKhoNL() throws SQLException {
        ArrayList<ModelKho> list = new ArrayList<>();
        String sql = "SELECT Kho.ID_NL,TenNL,Donvitinh,SLTon FROM Kho "
                + "JOIN NguyenLieu ON NguyenLieu.ID_NL=Kho.ID_NL ORDER BY Kho.ID_NL";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt(1);  //Mã nguyên liệu
            String tenNL = r.getString(2); //Tên nguyên liệu
            String dvt = r.getString(3); //Đơn vị tính của nguyên liệu
            int slTon = r.getInt(4);
            ModelKho data = new ModelKho(id, tenNL, dvt, slTon);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy số lượng nguyên liệu còn trong kho  (Số lượng tồn >0)
    public int getSLNL_TonKho() throws SQLException {
        int sl = 0;
        String sql = "SELECT COUNT(*) FROM Kho WHERE SLTon>0";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            sl = r.getInt(1);
        }
        return sl;
    }

    //Lấy ID của Phiếu nhập kho tiếp theo được thêm
    public int getNextID_NK() throws SQLException {
        int nextID = 0;
        String sql = "SELECT MAX(ID_NK) as ID FROM PhieuNK";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            nextID = r.getInt("ID") + 1;
        }
        r.close();
        p.close();
        return nextID;
    }

    //Lấy ID của Phiếu xuất kho tiếp theo được thêm
    public int getNextID_XK() throws SQLException {
        int nextID = 0;
        String sql = "SELECT MAX(ID_XK) as ID FROM PhieuXK";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            nextID = r.getInt("ID") + 1;
        }
        r.close();
        p.close();
        return nextID;
    }

    //Thêm phiếu nhập kho và chi tiết Nhập kho
    public void InsertPNK_CTNK(ModelPNK pnk, ArrayList<ModelKho> list) throws SQLException {
        //Thêm phiếu nhập kho
        String sql = "INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (?,?,to_date(?, 'dd-mm-yyyy'))";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, pnk.getIdNK());
        p.setInt(2, pnk.getIdNV());
        p.setString(3, pnk.getNgayNK());
        p.execute();
        //Thêm chi tiết nhập kho
        String sql_ct;
        for (ModelKho data : list) {
            if(data.getSlTon()>0){
                sql_ct = "INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (?,?,?)";
                PreparedStatement p_ct = con.prepareStatement(sql_ct);
                p_ct.setInt(1, pnk.getIdNK());
                p_ct.setInt(2, data.getIdNL());
                p_ct.setInt(3, data.getSlTon());
                p_ct.execute();
                p_ct.close();
            }
        }
        p.close();
    }
    
    //Thêm phiếu xuất kho và chi tiết Xuất kho
    public void InsertPXK_CTXK(ModelPXK pxk, ArrayList<ModelKho> list) throws SQLException {
        //Thêm phiếu nhập kho
        String sql = "INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (?,?,to_date(?, 'dd-mm-yyyy'))";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, pxk.getIdXK());
        p.setInt(2, pxk.getIdNV());
        p.setString(3, pxk.getNgayXK());
        p.execute();
        //Thêm chi tiết nhập kho
        String sql_ct;
        for (ModelKho data : list) {
            if(data.getSlTon()>0){
                sql_ct = "INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (?,?,?)";
                PreparedStatement p_ct = con.prepareStatement(sql_ct);
                p_ct.setInt(1, pxk.getIdXK());
                p_ct.setInt(2, data.getIdNL());
                p_ct.setInt(3, data.getSlTon());
                p_ct.execute();
                p_ct.close();
            }
        }
        p.close();
    }
}