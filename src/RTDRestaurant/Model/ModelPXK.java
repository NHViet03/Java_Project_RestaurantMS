
package RTDRestaurant.Model;


//Thông tin phiếu xuất kho
public class ModelPXK {

    public int getIdXK() {
        return idXK;
    }

    public int getIdNV() {
        return idNV;
    }

    public String getNgayXK() {
        return ngayXK;
    }

    public ModelPXK() {
    }

    public ModelPXK(int idXK, int idNV, String ngayXK) {
        this.idXK = idXK;
        this.idNV = idNV;
        this.ngayXK = ngayXK;
    }

    
    
    private int idXK; //Mã phiếu xuất
    private int idNV;  //Mã nhân viên lập phiếu xuất
    private String ngayXK; //Ngày lập phiếu xuất
}
