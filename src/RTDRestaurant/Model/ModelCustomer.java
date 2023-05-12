package RTDRestaurant.Model;

public class ModelCustomer {

    public int getID_KH() {
        return ID_KH;
    }

    public void setID_KH(int ID_KH) {
        this.ID_KH = ID_KH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(String dateJoin) {
        this.dateJoin = dateJoin;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public ModelCustomer() {
    }

    public ModelCustomer(int ID_KH, String name, String dateJoin, String sales, String points) {
        this.ID_KH = ID_KH;
        this.name = name;
        this.dateJoin = dateJoin;
        this.sales = sales;
        this.points = points;
    }

    

    private int ID_KH;
    private String name;
    private String dateJoin;
    private String sales;
    private String points;

}
