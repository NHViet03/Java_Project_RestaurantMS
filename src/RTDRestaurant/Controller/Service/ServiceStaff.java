
package RTDRestaurant.Controller.Service;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Model.ModelStaff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ServiceStaff {
    private final Connection con;

    //Connect tới DataBase       
    public ServiceStaff() {
        con = DatabaseConnection.getInstance().getConnection();
    }
    //Lấy thông tin nhân viên từ ID người dùng
    public ModelStaff getStaff(int userID) throws SQLException {
        ModelStaff data = null;
        String sql = "SELECT ID_NV, TenNV, to_char(NgayVL, 'dd-mm-yyyy') AS Ngay, SDT, Chucvu, ID_NQL FROM NhanVien WHERE ID_ND=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, userID);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id_NV=r.getInt("ID_NV");
            String tenNV=r.getString("TenNV");
            String ngayVL=r.getString("Ngay");
            String sdt=r.getString("SDT");
            String chucvu=r.getString("Chucvu");
            int id_NQL=r.getInt("ID_NQL");
            data=new ModelStaff(id_NV, tenNV, ngayVL, sdt, chucvu, id_NQL);
        }
        r.close();
        p.close();
        return data;
    }
}
