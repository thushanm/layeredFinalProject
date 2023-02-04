package lk.ijse.dmi.entity;

public class Item {
    private String itId;
    private String itSId;
    private String description;
    private int qty;
    private int discount;
    private double uPrice;


    public Item() {
    }


    public Item(String itId, String itSId, String description, int qty, int discount, double uPrice) {
        this.itId = itId;
        this.itSId = itSId;
        this.description = description;
        this.qty = qty;
        this.discount = discount;
        this.uPrice = uPrice;
    }

    public String getItId() {
        return itId;
    }

    public void setItId(String itId) {
        this.itId = itId;
    }

    public String getItSId() {
        return itSId;
    }

    public void setItSId(String itSId) {
        this.itSId = itSId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getuPrice() {
        return uPrice;
    }

    public void setuPrice(double uPrice) {
        this.uPrice = uPrice;
    }
}
