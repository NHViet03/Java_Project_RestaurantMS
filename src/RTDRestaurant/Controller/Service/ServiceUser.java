
package RTDRestaurant.Controller.Service;


import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Model.ModelLogin;
import RTDRestaurant.Model.ModelNguoiDung;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

// Controller Đăng ký/Đăng nhập vào hệ thống
public class ServiceUser {
    
    private final Connection con;
    
    //Connect tới DataBase       
    public ServiceUser() {
        con=DatabaseConnection.getInstance().getConnection();
    }
    
    /*
        Kiểm tra thông tin đăng nhập
        Trả về : null <- Nếu Thông tin đăng nhập sai
                 ModelNguoiDung <- Nếu thông tin đăng nhập đúng
    */
    public ModelNguoiDung login(ModelLogin login) throws SQLException{
        ModelNguoiDung user=null;
        String sql = "SELECT * FROM NguoiDung WHERE Email=? AND Matkhau=? AND Trangthai='Verified' FETCH FIRST 1 ROWS ONLY";
        PreparedStatement p=con.prepareStatement(sql);
        p.setString(1, login.getEmail());
        p.setString(2, login.getPassword());
        ResultSet r= p.executeQuery();
        if(r.next()){
            int UserID=r.getInt("ID_ND");
            String email=r.getString("Email");
            String password=r.getString("Matkhau");
            String role=r.getString("Vaitro");
            user=new ModelNguoiDung(UserID,email,password,role);
        }
        r.close();
        p.close();
        return user;
    }
    /*
        Phần đăng ký chỉ dành cho khách hàng, sau khi đăng ký thành công:
        Thêm thông tin Người dùng gồm email, mật khẩu, verifycode với
          Vai trò mặc định là 'Khach Hang' xuống bảng NguoiDung.
    */
    public void insertUser(ModelNguoiDung user)throws SQLException{
        //Lấy ID của User tiếp theo 
        PreparedStatement p1=con.prepareStatement("SELECT MAX(ID_ND) as ID_ND FROM NguoiDung");
        ResultSet r= p1.executeQuery();
        r.next();
        int userID=r.getInt("ID_ND")+1;
        
        //Thêm Người Dùng
        String sql_ND = "INSERT INTO NguoiDung (ID_ND,Email, MatKhau, VerifyCode,Vaitro) VALUES (?,?, ?, ?,'Khach Hang')";
        PreparedStatement p=con.prepareStatement(sql_ND);
        String code=generateVerifiyCode();
        p.setInt(1, userID);
        p.setString(2, user.getEmail());
        p.setString(3, user.getPassword());
        p.setString(4, code);
        p.execute();
        
        r.close();
        p.close();
        p1.close();
        
        user.setUserID(userID);
        user.setVerifyCode(code);
        user.setRole("Khách Hàng");
    }
    
    //Tạo random Mã xác minh
    public String generateVerifiyCode()throws SQLException{
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }
    
    //Kiểm tra Mã trùng 
    private boolean checkDuplicateCode(String code) throws SQLException{
        boolean duplicate=false;
        String sql="SELECT * FROM NguoiDung WHERE VerifyCode=? FETCH FIRST 1 ROWS ONLY";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, code);
        ResultSet r=p.executeQuery();
        if(r.next()){
            duplicate=true;
        }
        r.close();
        p.close();
        return duplicate;
    }
    
    /*
        Kiểm tra Email đã tồn tại trong hệ thống hay chưa
        Trả về : True <- Nếu tồn tại
                 False <- Nếu chưa tồn tại
    */
    public boolean checkDuplicateEmail(String email) throws SQLException{
        boolean duplicate=false;
        String sql="SELECT * FROM NguoiDung WHERE Email=? AND Trangthai='Verified' FETCH FIRST 1 ROWS ONLY";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, email);
        ResultSet r=p.executeQuery();
        if(r.next()){
            duplicate=true;
        }
        r.close();
        p.close();
        return duplicate;
    }
    /*
        Sau khi Hoàn tất xác minh tài khoản:
        1.Cập nhật VerifyCode= '' và Trangthai của Người dùng thành Verified
        2. Thêm mới một khách hàng vào bảng KhachHang với các thông tin:
        - Tên KH : lấy từ phần đăng ký
        - Ngày tham gia: ngày hiện tại đăng ký
        - Doanh số, điểm tích lũy mặc định là 0
        - ID_ND lấy từ Người dùng vừa tạo
        
    */
    public void doneVerify(int userID,String name) throws SQLException{
        //Cập nhật NguoiDung
        String sql_ND="UPDATE NguoiDung SET VerifyCode='', Trangthai='Verified' WHERE ID_ND=?";
        PreparedStatement p1 = con.prepareStatement(sql_ND);
        p1.setInt(1, userID);
        p1.execute();
        //Lấy id của Khách Hàng tiếp theo
        int id=0;
        String sql_ID="SELECT MAX(ID_KH) as ID FROM KhachHang";
        PreparedStatement p_id = con.prepareStatement(sql_ID);
        ResultSet r=p_id.executeQuery();
        if(r.next()){
            id=r.getInt("ID")+1;
        }
        
        //Thêm KH mới
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        String sql_KH="INSERT INTO KhachHang (ID_KH,TenKH, Ngaythamgia,ID_ND) VALUES (?,?,to_date(?, 'dd-mm-yyyy'),?)";
        PreparedStatement p2=con.prepareStatement(sql_KH);
        p2.setInt(1, id);
        p2.setString(2, name);
        p2.setString(3, simpleDateFormat.format(new Date()));
        p2.setInt(4, userID);
        p2.execute();
        
        p1.close();
        p_id.close();
        p2.close();
    }
    
    /* 
       Kiểm trả Verify Code của người dùng nhập vào với 
       Verify Code của người dùng đó được lưu trên DB
       Trả về : True <- Nếu Mã xác minh đúng
                False <- Nếu nhập sai
    */
    public boolean verifyCodeWithUser(int userID,String code) throws SQLException{
        boolean verify=false;
        String sql="SELECT COUNT(ID_ND) as CountID FROM NguoiDung WHERE ID_ND=? AND VerifyCode=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setInt(1, userID);
        p.setString(2,code);
        ResultSet r=p.executeQuery();
        if(r.next()){
            if(r.getInt("CountID")>0){
                verify=true;
            }
        }
        r.close();
        p.close();
        return verify;
    }
    //Thay đổi mật khẩu tài khoản
    public void changePassword(int userID,String newPass) throws SQLException{
        String sql="UPDATE NguoiDung SET MatKhau = ? WHERE ID_ND = ?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setString(1, newPass);
        p.setInt(2, userID);
        p.execute();
        p.close();
    }
}
