package RTDRestaurant.Controller.Service;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Model.ModelNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            int id_NV=r.getInt(1);
            String tenNV=r.getString(2);
            String ngayVL=r.getString(3);
            String sdt=r.getString(4);
            String chucvu=r.getString(5);
            int id_NQL=r.getInt(6);
            String tinhTrang =r.getString(7);
            ModelNhanVien data=new ModelNhanVien(id_NV, tenNV, ngayVL, sdt, chucvu, id_NQL,tinhTrang);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }
    
    //Lấy thông tin nhân viên từ ID
    public ModelNhanVien getNV(int idNV) throws SQLException {
        ModelNhanVien data=null;
        String sql = "SELECT ID_NV,TenNV,to_char(NgayVL,'dd-mm-yyyy')as Ngay,SDT,ChucVu,ID_NQL,TinhTrang FROM NhanVien WHERE ID_NV=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, idNV);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id_NV=r.getInt(1);
            String tenNV=r.getString(2);
            String ngayVL=r.getString(3);
            String sdt=r.getString(4);
            String chucvu=r.getString(5);
            int id_NQL=r.getInt(6);
            String tinhTrang=r.getString(7);
            data=new ModelNhanVien(id_NV, tenNV, ngayVL, sdt, chucvu, id_NQL,tinhTrang);
        }
        p.close();
        r.close();
        return data;
    }
    //Lấy Mã nhân viên tiếp theo được thêm
    public int getNextID_NV() throws SQLException{
        int id=0;
        String sql="SELECT MIN(ID_NV) +1 FROM NhanVien WHERE ID_NV + 1 NOT IN (SELECT ID_NV FROM NhanVien)";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        if(r.next()){
            id=r.getInt(1);
        }
        return id;
    }
    //Thêm mới một nhân viên
    public void insertNV(ModelNhanVien data) throws SQLException{
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
    public void FireStaff(int idNV) throws SQLException{
        String sql = "UPDATE NhanVien SET TinhTrang ='Da nghi viec' WHERE ID_NV=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, idNV);
        p.execute();
        p.close();
    }
    //Cập nhật thông tin của một nhân viên
    public void UpdateNV(ModelNhanVien data) throws SQLException{
        String sql = "UPDATE NhanVien SET TenNV=?,SDT=?,Chucvu=? WHERE ID_NV=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, data.getTenNV());
        p.setString(2, data.getSdt());
        p.setString(3, data.getChucvu());
        p.setInt(4, data.getId_NV());
        p.execute();
        p.close();
    }
}
