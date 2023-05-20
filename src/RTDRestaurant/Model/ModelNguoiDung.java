
package RTDRestaurant.Model;

// Model Người dùng của hệ thống 
public class ModelNguoiDung {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    public ModelNguoiDung() {
    }

    public ModelNguoiDung(int userID,String email, String password, String verifyCode,String role) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
        this.role=role;
    }
    
    public ModelNguoiDung(int userID, String email, String password,String role) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.role=role;
    }
    int userID;  //ID tài khoản
    String email;  // Email
    String password; //Mật khẩu
    String verifyCode; //Mã xác minh
    String role; //Vai trò : Khách Hàng, Nhân Viên,Nhân viên Kho,Quản lý
}
