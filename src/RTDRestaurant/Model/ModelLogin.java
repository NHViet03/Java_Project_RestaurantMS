
package RTDRestaurant.Model;

// Model Thông tin đăng nhập (Email, mật khẩu)
public class ModelLogin {

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

    public ModelLogin() {
    }

    public ModelLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    private String email; //email
    private String password; // Mật khẩu
    
}
