
package RTDRestaurant.Model;

//Thông tin chi tiết phiếu xuất kho
public class ModelCTXK {

    public int getIdXK() {
        return idXK;
    }

    public int getIdNL() {
        return idNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public String getDvt() {
        return dvt;
    }

    public int getsL() {
        return sL;
    }

    public ModelCTXK() {
    }

    public ModelCTXK(int idXK, int idNL, String tenNL, String dvt, int sL) {
        this.idXK = idXK;
        this.idNL = idNL;
        this.tenNL = tenNL;
        this.dvt = dvt;
        this.sL = sL;
    }

   
    private int idXK;  //Mã phiếu nhập
    private int idNL; //Mã nguyên liệu
    private String tenNL; //Tên nguyên liệu 
    private String dvt; //Đơn vị tính 
    private int sL;     //Số lượng
    
}
