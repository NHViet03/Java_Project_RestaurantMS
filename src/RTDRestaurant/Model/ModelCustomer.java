package RTDRestaurant.Model;

public class ModelCustomer {

    public int getID_KH() {
        return ID_KH;
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

    public int getSales() {
        return sales;
    }

    public int getPoints() {
        return points;
    }

    public ModelCustomer() {
    }

    public ModelCustomer(int ID_KH, String name, String dateJoin, int sales, int points) {
        this.ID_KH = ID_KH;
        this.name = name;
        this.dateJoin = dateJoin;
        this.sales = sales;
        this.points = points;
    }

    private int ID_KH;
    private String name;
    private String dateJoin;
    private int sales;
    private int points;

}
