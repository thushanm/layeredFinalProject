package lk.ijse.dmi.entity;

public class OrderDetails {
    private String description;
    private int discount;
    private int qty;
    private double price;
    private String odId;
    private String oitId;
    private String coId;


    public OrderDetails() {
    }


    public OrderDetails(String description, int discount, int qty, double price, String odId, String oitId, String coId) {
        this.description = description;
        this.discount = discount;
        this.qty = qty;
        this.price = price;
        this.odId = odId;
        this.oitId = oitId;
        this.coId = coId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOdId() {
        return odId;
    }

    public void setOdId(String odId) {
        this.odId = odId;
    }

    public String getOitId() {
        return oitId;
    }

    public void setOitId(String oitId) {
        this.oitId = oitId;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }
}
