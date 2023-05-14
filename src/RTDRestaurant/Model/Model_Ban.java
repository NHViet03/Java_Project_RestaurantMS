
package RTDRestaurant.Model;

//Class chứa thông tin về bàn gồm :ID Bàn, Tên Bàn, Loại bàn
public class Model_Ban {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Model_Ban() {
    }
    
    public Model_Ban(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    
    public Model_Ban(int ID, String name, String status) {
        this.ID = ID;
        this.name = name;
        this.status = status;
    }
    
    private int ID; //Mã bàn
    private String name; //Tên bàn
    private String status; //Loại bàn
    
}
