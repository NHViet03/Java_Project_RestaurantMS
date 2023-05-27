package RTDRestaurant.Controller.Service;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Model.ModelCTHD;
import RTDRestaurant.Model.ModelMonAn;
import RTDRestaurant.Model.ModelKhachHang;
import RTDRestaurant.Model.ModelHoaDon;
import RTDRestaurant.Model.ModelVoucher;
import RTDRestaurant.Model.ModelBan;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

public class ServiceCustomer {

    private final Connection con;

    //Connect tới DataBase       
    public ServiceCustomer() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    //Lấy toàn bộ danh sách Món ăn theo loại Món Ăn đang kinh doanh
    public ArrayList<ModelMonAn> MenuFood(String type) throws SQLException {
        ArrayList<ModelMonAn> list = new ArrayList<>();
        String sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=? AND TrangThai='Dang kinh doanh'";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, type);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt("ID_MonAn");
            String name = r.getString("TenMon");
            int value = r.getInt("DonGia");
            ModelMonAn data;
            if (id < 90) {
                data = new ModelMonAn(new ImageIcon(getClass().getResource("/Icons/Food/" + type + "/" + id + ".jpg")), id, name, value, type);
            } else {
                data = new ModelMonAn(new ImageIcon(getClass().getResource("/Icons/Food/Unknown/unknown.jpg")), id, name, value, type);
            }
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy danh sách Món ăn theo loại món ăn và thứ tự Tên/Giá tăng dần/Giá giảm dần đang kinh doanh
    public ArrayList<ModelMonAn> MenuFoodOrder(String type, String orderBy) throws SQLException {
        ArrayList<ModelMonAn> list = new ArrayList<>();

        String sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=? AND TrangThai='Dang kinh doanh'";
        switch (orderBy) {
            case "Tên A->Z" -> {
                sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=? AND TrangThai='Dang kinh doanh' ORDER BY TenMon";
            }
            case "Giá tăng dần" -> {
                sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=? AND TrangThai='Dang kinh doanh' ORDER BY DonGia";
            }
            case "Giá giảm dần" -> {
                sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=? AND TrangThai='Dang kinh doanh' ORDER BY DonGia DESC";
            }
        }
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, type);

        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt("ID_MonAn");
            String name = r.getString("TenMon");
            int value = r.getInt("DonGia");
            ModelMonAn data;
            if (id < 90) {
                data = new ModelMonAn(new ImageIcon(getClass().getResource("/Icons/Food/" + type + "/" + id + ".jpg")), id, name, value, type);
            } else {
                data = new ModelMonAn(new ImageIcon(getClass().getResource("/Icons/Food/Unknown/unknown.jpg")), id, name, value, type);
            }
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy toàn bộ danh sách bàn theo tầng
    public ArrayList<ModelBan> MenuTable(String floor) throws SQLException {
        ArrayList<ModelBan> list = new ArrayList<>();
        String sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, floor);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt("ID_Ban");
            String name = r.getString("TenBan");
            String status = r.getString("Trangthai");
            ModelBan data = new ModelBan(id, name, status);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }
    //Lấy danh sách bàn theo trạng thái bàn Tất cả/Còn trống/Đã đặt trước/Đang dùng bữa

    public ArrayList<ModelBan> MenuTableState(String floor, String state) throws SQLException {
        ArrayList<ModelBan> list = new ArrayList<>();
        String sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=?";
        switch (state) {
            case "Tất cả" ->
                sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=?";
            case "Còn trống" ->
                sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=? AND Trangthai='Con trong'";
            case "Đã đặt trước" ->
                sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=? AND Trangthai='Da dat truoc'";
            case "Đang dùng bữa" ->
                sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=? AND Trangthai='Dang dung bua'";
        }
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, floor);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt("ID_Ban");
            String name = r.getString("TenBan");
            String status = r.getString("Trangthai");
            ModelBan data = new ModelBan(id, name, status);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy thông tin khách hàng từ ID người dùng
    public ModelKhachHang getCustomer(int userID) throws SQLException {
        ModelKhachHang data = null;
        String sql = "SELECT ID_KH, TenKH, to_char(Ngaythamgia, 'dd-mm-yyyy') AS NgayTG, Doanhso,Diemtichluy FROM KhachHang WHERE ID_ND=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, userID);
        ResultSet r = p.executeQuery();
        while (r.next()) {

            int id = r.getInt("ID_KH");
            String name = r.getString("TenKH");
            String date = r.getString("NgayTG");
            int sales = r.getInt("Doanhso");
            int points = r.getInt("Diemtichluy");
            data = new ModelKhachHang(id, name, date, sales, points);
        }
        r.close();
        p.close();
        return data;
    }

    // Đổi tên Khách hàng 
    public void reNameCustomer(ModelKhachHang data) throws SQLException {
        String sql = "UPDATE KhachHang SET TenKH=? WHERE ID_KH=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, data.getName());
        p.setInt(2, data.getID_KH());
        p.execute();
        p.close();
    }

    //Lấy toàn bộ danh sách Voucher
    public ArrayList<ModelVoucher> MenuVoucher() throws SQLException {
        ArrayList<ModelVoucher> list = new ArrayList<>();
        String sql = "SELECT * FROM Voucher";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            String code = r.getString("Code_Voucher");
            String desc = r.getString("Mota");
            int percent = r.getInt("Phantram");
            String typeMenu = r.getString("LoaiMA");
            int quantity = r.getInt("SoLuong");
            int point = r.getInt("Diem");
            ModelVoucher data = new ModelVoucher(code, desc, percent, typeMenu, quantity, point);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy danh sách Voucher theo mốc xu
    public ArrayList<ModelVoucher> MenuVoucherbyPoint(String bypoint) throws SQLException {
        ArrayList<ModelVoucher> list = new ArrayList<>();
        String sql = "SELECT * FROM Voucher";
        if (null != bypoint) {
            switch (bypoint) {
                case "Tất cả" ->
                    sql = "SELECT * FROM Voucher";
                case "Dưới 300 xu" ->
                    sql = "SELECT * FROM Voucher WHERE Diem <300";
                case "Từ 300 đến 500 xu" ->
                    sql = "SELECT * FROM Voucher WHERE Diem BETWEEN 300 AND 501";
                case "Trên 500 xu" ->
                    sql = "SELECT * FROM Voucher WHERE Diem >500";
                default -> {
                }
            }
        }
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            String code = r.getString("Code_Voucher");
            String desc = r.getString("Mota");
            int percent = r.getInt("Phantram");
            String typeMenu = r.getString("LoaiMA");
            int quantity = r.getInt("SoLuong");
            int point = r.getInt("Diem");
            ModelVoucher data = new ModelVoucher(code, desc, percent, typeMenu, quantity, point);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    /*
        Khi khách hàng đặt bàn thì tự động thêm mới một hóa đơn với ID_Ban và ID_KH từ tham số 
        Tiền món ăn và Tiền giảm mặc định là 0
        Trạng thái Hóa đơn mặc định là Chưa thanh toán
     */
    public void InsertHoaDon(ModelBan table, ModelKhachHang customer) throws SQLException {
        //Tìm ID_HD tiếp theo
        int idHD=0;
        PreparedStatement p_ID=con.prepareStatement("SELECT MAX(ID_HoaDon) +1 FROM HoaDon");
        ResultSet r_id=p_ID.executeQuery();
        if(r_id.next()){
            idHD=r_id.getInt(1);
        }
       
        //Thêm Hoá Đơn mới
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        String sql = "INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai)"
                + " VALUES (?,?,?,to_date(?, 'dd-mm-yyyy'),0,0,'Chua thanh toan')";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, idHD);
        p.setInt(2, customer.getID_KH());
        p.setInt(3, table.getID());
        p.setString(4, simpleDateFormat.format(new Date()));
        p_ID.close();
        r_id.close();
        p.execute();
        p.close();

    }

    //Lấy thông tin HoaDon mà Khách hàng vừa đặt, Hóa Đơn có trạng thái 'Chưa thanh toán'
    public ModelHoaDon FindHoaDon(ModelKhachHang customer) throws SQLException {
        ModelHoaDon hoadon = null;
        String sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-yyyy') AS Ngay,TienMonAn,Code_Voucher,TienGiam,Tongtien,Trangthai FROM HoaDon "
                + "WHERE ID_KH=? AND Trangthai='Chua thanh toan'";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, customer.getID_KH());
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int idHoaDon = r.getInt(1);
            int idKH = r.getInt(2);
            int idBan = r.getInt(3);
            String ngayHD = r.getString(4);
            int tienMonAn = r.getInt(5);
            String code_voucher = r.getString(6);
            int tienGiam = r.getInt(7);
            int tongtien = r.getInt(8);
            String trangthai = r.getString(9);
            hoadon = new ModelHoaDon(idHoaDon, idKH, idBan, ngayHD, tienMonAn, code_voucher, tienGiam, tongtien, trangthai);
        }
        r.close();
        p.close();
        return hoadon;
    }

    //Thêm món ăn mới khách hàng vừa đặt vào CTHD
    public void InsertCTHD(int ID_HoaDon, int ID_MonAn, int soluong) throws SQLException {
        //Kiểm tra món ăn đã có trong CTHD hay chưa, nếu đã có cập nhật số lượng, nếu chưa thì thêm CTHD mới
        String sql = "SELECT 1 FROM CTHD WHERE ID_HoaDon=? AND ID_MonAn=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, ID_HoaDon);
        p.setInt(2, ID_MonAn);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            // Nếu tồn tại 
            String sql_update = "UPDATE CTHD SET SoLuong=SoLuong+? WHERE ID_HoaDon=? AND ID_MonAn=?";
            PreparedStatement p1 = con.prepareStatement(sql_update);
            p1.setInt(1, soluong);
            p1.setInt(2, ID_HoaDon);
            p1.setInt(3, ID_MonAn);
            p1.execute();
            p1.close();
        } else {
            //Nếu không tồn tại
            String sql_insert = "INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (?,?,?)";
            PreparedStatement p1 = con.prepareStatement(sql_insert);
            p1.setInt(1, ID_HoaDon);
            p1.setInt(2, ID_MonAn);
            p1.setInt(3, soluong);
            p1.execute();
            p1.close();
        }
        p.close();
        r.close();
    }

    // Lấy danh sách CTHD từ ID_HoaDon
    public ArrayList<ModelCTHD> getCTHD(int ID_HoaDon) throws SQLException {
        ArrayList<ModelCTHD> list = new ArrayList<>();
        String sql = "SELECT ID_HoaDon,CTHD.ID_MonAn, TenMon,SoLuong,Thanhtien FROM CTHD "
                + "JOIN MonAn ON MonAn.ID_MonAn=CTHD.ID_MonAn WHERE ID_HoaDon=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, ID_HoaDon);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int ID_HD = r.getInt(1);
            int ID_MonAn = r.getInt(2);
            String tenMonAn = r.getString(3);
            int soluong = r.getInt(4);
            int thanhTien = r.getInt(5);
            ModelCTHD data = new ModelCTHD(ID_HD, ID_MonAn, tenMonAn, soluong, thanhTien);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy toàn bộ danh sách hóa đơn của một khách hàng
    public ArrayList<ModelHoaDon> getListHD(int ID_KH) throws SQLException {
        ArrayList<ModelHoaDon> list = new ArrayList<>();
        String sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-yyyy') AS Ngay,TienMonAn,Code_Voucher,TienGiam,Tongtien,Trangthai FROM HoaDon "
                + "WHERE ID_KH=? ORDER BY ID_HoaDon";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, ID_KH);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int idHoaDon = r.getInt(1);
            int idKH = r.getInt(2);
            int idBan = r.getInt(3);
            String ngayHD = r.getString(4);
            int tienMonAn = r.getInt(5);
            String code_voucher = r.getString(6);
            int tienGiam = r.getInt(7);
            int tongtien = r.getInt(8);
            String trangthai = r.getString(9);
            ModelHoaDon hoadon = new ModelHoaDon(idHoaDon, idKH, idBan, ngayHD, tienMonAn, code_voucher, tienGiam, tongtien, trangthai);
            list.add(hoadon);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy toàn bộ danh sách hóa đơn của một khách hàng theo mốc Tổng tiền Hóa Đơn
    public ArrayList<ModelHoaDon> getListHDOrder(int ID_KH, String order) throws SQLException {
        ArrayList<ModelHoaDon> list = new ArrayList<>();
        String sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-yyyy') AS Ngay,TienMonAn,Code_Voucher,TienGiam,Tongtien,Trangthai FROM HoaDon "
                + "WHERE ID_KH=? ORDER BY ID_HoaDon";
        switch (order) {
            case "Tất cả":
                sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-yyyy') AS Ngay,TienMonAn,Code_Voucher,TienGiam,Tongtien,Trangthai FROM HoaDon "
                        + "WHERE ID_KH=? ORDER BY ID_HoaDon";
                break;
            case "Dưới 1.000.000đ":
                sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-yyyy') AS Ngay,TienMonAn,Code_Voucher,TienGiam,Tongtien,Trangthai FROM HoaDon "
                        + "WHERE ID_KH=? AND Tongtien <1000000 ORDER BY ID_HoaDon";
                break;
            case "Từ 1 đến 5.000.000đ":
                sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-yyyy') AS Ngay,TienMonAn,Code_Voucher,TienGiam,Tongtien,Trangthai FROM HoaDon "
                        + "WHERE ID_KH=? AND Tongtien BETWEEN 1000000 AND 5000001 ORDER BY ID_HoaDon";
                break;
            case "Trên 5.000.000đ":
                sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-yyyy') AS Ngay,TienMonAn,Code_Voucher,TienGiam,Tongtien,Trangthai FROM HoaDon "
                        + "WHERE ID_KH=? AND Tongtien >5000000 ORDER BY ID_HoaDon";
                break;
            default:
                break;
        }
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, ID_KH);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int idHoaDon = r.getInt(1);
            int idKH = r.getInt(2);
            int idBan = r.getInt(3);
            String ngayHD = r.getString(4);
            int tienMonAn = r.getInt(5);
            String code_voucher = r.getString(6);
            int tienGiam = r.getInt(7);
            int tongtien = r.getInt(8);
            String trangthai = r.getString(9);
            ModelHoaDon hoadon = new ModelHoaDon(idHoaDon, idKH, idBan, ngayHD, tienMonAn, code_voucher, tienGiam, tongtien, trangthai);
            list.add(hoadon);
        }
        r.close();
        p.close();
        return list;
    }

    //Sau khi khách hàng đổi Voucher ở phần Điểm tích lũy, áp dụng trực tiếp lên hóa đơn mà khách hàng đang sử dụng
    //Thực hiện Trigger giảm Điểm tích lũy của Khách hàng và tính Tiền Giảm giá
    public void exchangeVoucher(int ID_HoaDon, String Code_Voucher) throws SQLException {
        String sql = "UPDATE HoaDon SET Code_Voucher=? WHERE ID_HoaDon=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, Code_Voucher);
        p.setInt(2, ID_HoaDon);
        p.execute();
        p.close();
    }
}
