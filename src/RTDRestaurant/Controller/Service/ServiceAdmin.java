package RTDRestaurant.Controller.Service;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Model.ModelBan;
import RTDRestaurant.Model.ModelHoaDon;
import RTDRestaurant.Model.ModelMonAn;
import RTDRestaurant.Model.ModelNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

public class ServiceAdmin {

    private final Connection con;

    //Connect tới DataBase       
    public ServiceAdmin() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    //Lấy toàn bộ danh sách nhân viên
    public ArrayList<ModelNhanVien> getListNV() throws SQLException {
        ArrayList<ModelNhanVien> list = new ArrayList();
        String sql = "SELECT ID_NV,TenNV,to_char(NgayVL,'dd-mm-yyyy')as Ngay,SDT,ChucVu,ID_NQL,TinhTrang FROM NhanVien";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id_NV = r.getInt(1);
            String tenNV = r.getString(2);
            String ngayVL = r.getString(3);
            String sdt = r.getString(4);
            String chucvu = r.getString(5);
            int id_NQL = r.getInt(6);
            String tinhTrang = r.getString(7);
            ModelNhanVien data = new ModelNhanVien(id_NV, tenNV, ngayVL, sdt, chucvu, id_NQL, tinhTrang);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }

    //Lấy thông tin nhân viên từ ID
    public ModelNhanVien getNV(int idNV) throws SQLException {
        ModelNhanVien data = null;
        String sql = "SELECT ID_NV,TenNV,to_char(NgayVL,'dd-mm-yyyy')as Ngay,SDT,ChucVu,ID_NQL,TinhTrang FROM NhanVien WHERE ID_NV=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, idNV);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id_NV = r.getInt(1);
            String tenNV = r.getString(2);
            String ngayVL = r.getString(3);
            String sdt = r.getString(4);
            String chucvu = r.getString(5);
            int id_NQL = r.getInt(6);
            String tinhTrang = r.getString(7);
            data = new ModelNhanVien(id_NV, tenNV, ngayVL, sdt, chucvu, id_NQL, tinhTrang);
        }
        p.close();
        r.close();
        return data;
    }

    //Lấy Mã nhân viên tiếp theo được thêm
    public int getNextID_NV() throws SQLException {
        int id = 0;
        String sql = "SELECT MIN(ID_NV) +1 FROM NhanVien WHERE ID_NV + 1 NOT IN (SELECT ID_NV FROM NhanVien)";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            id = r.getInt(1);
        }
        return id;
    }

    //Thêm mới một nhân viên
    public void insertNV(ModelNhanVien data) throws SQLException {
        String sql = "INSERT INTO NhanVien(ID_NV,TenNV,NgayVL,SDT,Chucvu,ID_NQL,TinhTrang) VALUES (?,?,to_date(?,'dd-mm-yyyy'),?,?,?,'Dang lam viec')";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, data.getId_NV());
        p.setString(2, data.getTenNV());
        p.setString(3, data.getNgayVL());
        p.setString(4, data.getSdt());
        p.setString(5, data.getChucvu());
        p.setInt(6, data.getId_NQL());
        p.execute();
        p.close();
    }

    //Sa thải một nhân viên, cập nhận tình trạng thành 'Da nghi viec'
    public void FireStaff(int idNV) throws SQLException {
        String sql = "UPDATE NhanVien SET TinhTrang ='Da nghi viec' WHERE ID_NV=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, idNV);
        p.execute();
        p.close();
    }

    //Cập nhật thông tin của một nhân viên
    public void UpdateNV(ModelNhanVien data) throws SQLException {
        String sql = "UPDATE NhanVien SET TenNV=?,SDT=?,Chucvu=? WHERE ID_NV=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, data.getTenNV());
        p.setString(2, data.getSdt());
        p.setString(3, data.getChucvu());
        p.setInt(4, data.getId_NV());
        p.execute();
        p.close();
    }

    //Lấy toàn bộ danh sách hóa đơn
    public ArrayList<ModelHoaDon> getListHD() throws SQLException {
        ArrayList<ModelHoaDon> list = new ArrayList();
        String sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int idHoaDon = r.getInt(1);
            int idKH = r.getInt(2);
            int idBan = r.getInt(3);
            String ngayHD = r.getString(4);
            int tienMonAn = r.getInt(5);
            int tienGiam = r.getInt(6);
            int tongtien = r.getInt(7);
            ModelHoaDon data = new ModelHoaDon(idHoaDon, idKH, idBan, ngayHD, tienMonAn, tienGiam, tongtien);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }

    //Lấy toàn bộ danh sách hóa đơn trong ngày/tháng/năm
    public ArrayList<ModelHoaDon> getListHDIn(String txt) throws SQLException {
        ArrayList<ModelHoaDon> list = new ArrayList();
        String sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon";
        if (txt.equals("Tất cả")) {
            sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon";
        } else if (txt.equals("Trong ngày")) {
            sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon "
                    + "WHERE TO_DATE(NgayHD,'dd-mm-YYYY')=TO_DATE(CURRENT_DATE,'dd-mm-YYYY')";
        } else if (txt.equals("Trong tháng")) {
            sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon "
                    + "WHERE EXTRACT(MONTH FROM NgayHD)=EXTRACT(MONTH FROM CURRENT_DATE)";
        } else if (txt.equals("Trong năm")) {
            sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon "
                    + "WHERE EXTRACT(YEAR FROM NgayHD)=EXTRACT(YEAR FROM CURRENT_DATE) AND EXTRACT(YEAR FROM NgayHD)=EXTRACT(YEAR FROM CURRENT_DATE)";
        }
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int idHoaDon = r.getInt(1);
            int idKH = r.getInt(2);
            int idBan = r.getInt(3);
            String ngayHD = r.getString(4);
            int tienMonAn = r.getInt(5);
            int tienGiam = r.getInt(6);
            int tongtien = r.getInt(7);
            ModelHoaDon data = new ModelHoaDon(idHoaDon, idKH, idBan, ngayHD, tienMonAn, tienGiam, tongtien);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }

    //Lấy tổng doanh thu Hóa Đơn trong ngày
    public int getProfitHD() throws SQLException {
        int profit = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        String sql = "SELECT SUM(Tongtien) FROM HoaDon WHERE NgayHD=to_date(?,'dd-mm-YYYY')";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, simpleDateFormat.format(new Date()));
        ResultSet r = p.executeQuery();
        if (r.next()) {
            profit = r.getInt(1);
        }
        p.close();
        r.close();
        return profit;
    }

    //Lấy toàn bộ danh sách Món ăn theo loại Món Ăn
    public ArrayList<ModelMonAn> getMenuFood() throws SQLException {
        ArrayList<ModelMonAn> list = new ArrayList<>();
        String sql = "SELECT ID_MonAn,TenMon,DonGia,Loai,TrangThai FROM MonAn";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt("ID_MonAn");
            String name = r.getString("TenMon");
            int value = r.getInt("DonGia");
            String type = r.getString("Loai");
            String state =r.getString("TrangThai");
            ModelMonAn data;
            if (id < 90) {
                data = new ModelMonAn(new ImageIcon(getClass().getResource("/Icons/Food/" + type + "/" + id + ".jpg")), id, name, value, type,state);
            } else {
                data = new ModelMonAn(new ImageIcon(getClass().getResource("/Icons/Food/Unknown/unknown.jpg")), id, name, value, type,state);
            }
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }
    //Lấy số lượng món ăn đang kinh doanh
    public int getNumberFood_inBusiness() throws SQLException{
        int number=0;
        String sql="SELECT COUNT(*) FROM MonAn WHERE TrangThai='Dang kinh doanh'";
        PreparedStatement p=con.prepareStatement(sql);
        ResultSet r=p.executeQuery();
        if(r.next()){
            number=r.getInt(1);
        }
        return number;
    }
    
}
