package RTDRestaurant.Controller.Service;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Model.ModelCard;
import RTDRestaurant.Model.ModelCustomer;
import RTDRestaurant.Model.ModelUser;
import RTDRestaurant.Model.ModelVoucher;
import RTDRestaurant.Model.Model_CardTable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ServiceCustomer {

    private final Connection con;

    //Connect tới DataBase       
    public ServiceCustomer() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    //Lấy toàn bộ danh sách Món ăn theo loại Món Ăn
    public ArrayList<ModelCard> MenuFood(String type) throws SQLException {
        ArrayList<ModelCard> list = new ArrayList<>();
        String sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, type);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            DecimalFormat df = new DecimalFormat("##,###,###");
            int id = r.getInt("ID_MonAn");
            String name = r.getString("TenMon");
            int value = r.getInt("DonGia");

            ModelCard data = new ModelCard(new ImageIcon(getClass().getResource("/Icons/Food/" + type + "/" + id + ".jpg")), name, df.format(value) + "đ");
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy danh sách Món ăn theo loại món ăn và thứ tự Tên/Giá tăng dần/Giá giảm dần
    public ArrayList<ModelCard> MenuFoodOrder(String type, String orderBy) throws SQLException {
        ArrayList<ModelCard> list = new ArrayList<>();

        String sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=?";
        switch (orderBy) {
            case "Tên A->Z" -> {
                sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=? ORDER BY TenMon";
            }
            case "Giá tăng dần" -> {
                sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=? ORDER BY DonGia";
            }
            case "Giá giảm dần" -> {
                sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=? ORDER BY DonGia DESC";
            }
        }
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, type);

        ResultSet r = p.executeQuery();
        while (r.next()) {
            DecimalFormat df = new DecimalFormat("##,###,###");
            int id = r.getInt("ID_MonAn");
            String name = r.getString("TenMon");
            int value = r.getInt("DonGia");

            ModelCard data = new ModelCard(new ImageIcon(getClass().getResource("/Icons/Food/" + type + "/" + id + ".jpg")), name, df.format(value) + "đ");
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Lấy toàn bộ danh sách bàn theo tầng
    public ArrayList<Model_CardTable> MenuTable(String floor) throws SQLException {
        ArrayList<Model_CardTable> list = new ArrayList<>();
        String sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, floor);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt("ID_Ban");
            String name = r.getString("TenBan");
            String status = r.getString("Trangthai");
            Model_CardTable data = new Model_CardTable(id, name, status);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }
    //Lấy danh sách bàn theo trạng thái bàn Tất cả/Còn trống/Đã đặt trước/Đang dùng bữa

    public ArrayList<Model_CardTable> MenuTableState(String floor,String state) throws SQLException {
        ArrayList<Model_CardTable> list = new ArrayList<>();
        String sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=?";
        switch (state) {
            case "Tất cả" -> sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=?";
            case "Còn trống" -> sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=? AND Trangthai='Con trong'";
            case "Đã đặt trước" -> sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=? AND Trangthai='Da dat truoc'";
            case "Đang dùng bữa" -> sql = "SELECT ID_Ban,TenBan,Trangthai FROM Ban WHERE Vitri=? AND Trangthai='Dang dung bua'";
        }
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, floor);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt("ID_Ban");
            String name = r.getString("TenBan");
            String status = r.getString("Trangthai");
            Model_CardTable data = new Model_CardTable(id, name, status);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }
    //Lấy thông tin khách hàng từ ID người dùng
    public ModelCustomer getCustomer(int userID) throws SQLException{
        ModelCustomer data=null;
        String sql = "SELECT ID_KH, TenKH, to_char(Ngaythamgia, 'dd-mm-yyyy') AS NgayTG, Doanhso,Diemtichluy FROM KhachHang WHERE ID_ND=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, userID);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            DecimalFormat df = new DecimalFormat("###,###,###");
            int id = r.getInt("ID_KH");
            String name = r.getString("TenKH");
            String date = r.getString("NgayTG");
            String sales = df.format(r.getInt("Doanhso"));
            String points = df.format(r.getInt("Diemtichluy"));
            data=new ModelCustomer(id, name, date, sales, points);
        }
        r.close();
        p.close();
        return data;
    }
    // Đổi tên Khách hàng 
    public void reNameCustomer (ModelCustomer data) throws SQLException{
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
            String code= r.getString("Code_Voucher");
            String desc = r.getString("Mota");
            int percent = r.getInt("Phantram");
            String typeMenu=r.getString("LoaiMA");
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
        if(bypoint=="Tất cả"){
            sql = "SELECT * FROM Voucher";
        }else if(bypoint=="Dưới 300 xu"){
            sql = "SELECT * FROM Voucher WHERE Diem <300";
        }else if(bypoint=="Từ 300 đến 500 xu"){
            sql = "SELECT * FROM Voucher WHERE Diem BETWEEN 300 AND 501";
        }
        else if(bypoint=="Trên 500 xu"){
            sql = "SELECT * FROM Voucher WHERE Diem >500";
        }
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            String code= r.getString("Code_Voucher");
            String desc = r.getString("Mota");
            int percent = r.getInt("Phantram");
            String typeMenu=r.getString("LoaiMA");
            int quantity = r.getInt("SoLuong");
            int point = r.getInt("Diem");
            ModelVoucher data = new ModelVoucher(code, desc, percent, typeMenu, quantity, point);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }
}
