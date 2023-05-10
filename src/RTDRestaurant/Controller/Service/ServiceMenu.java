package RTDRestaurant.Controller.Service;

import RTDRestaurant.Controller.Connection.DatabaseConnection;
import RTDRestaurant.Model.ModelCard;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
public class ServiceMenu {
    
    private final Connection con;
    
    //Connect tới DataBase       
    public ServiceMenu() {
        con=DatabaseConnection.getInstance().getConnection();
    }
    //Lấy danh sách Món ăn theo loại Món Ăn
    public ArrayList<ModelCard> MenuFood(String type) throws SQLException{
        ArrayList<ModelCard> list = new ArrayList<>();
        String sql = "SELECT ID_MonAn,TenMon,DonGia FROM MonAn WHERE Loai=?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setString(1, type);
        ResultSet r= p.executeQuery();
        while(r.next()){
            DecimalFormat df = new DecimalFormat("##,###,###");
            int id=r.getInt("ID_MonAn");
            String name=r.getString("TenMon");
            int value=r.getInt("DonGia");
            
            ModelCard data=new ModelCard(new ImageIcon(getClass().getResource("/Icons/Food/"+type+"/"+id+".jpg")),name,df.format(value)+"đ");
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }
}
