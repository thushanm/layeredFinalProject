package lk.ijse.dmi.entity;

public class GrnDetails {
    private String description;
    private int qty;
    private double utilPrice;

    public GrnDetails() {
    }

    private String grndid;

    public GrnDetails(String description, int qty, double utilPrice, String grndid, String grnitid) {
        this.description = description;
        this.qty = qty;
        this.utilPrice = utilPrice;
        this.grndid = grndid;
        this.grnitid = grnitid;
    }

    private String grnitid;

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

    public double getUtilPrice() {
        return utilPrice;
    }

    public void setUtilPrice(double utilPrice) {
        this.utilPrice = utilPrice;
    }

    public String getGrndid() {
        return grndid;
    }

    public void setGrndid(String grndid) {
        this.grndid = grndid;
    }

    public String getGrnitid() {
        return grnitid;
    }

    public void setGrnitid(String grnitid) {
        this.grnitid = grnitid;
    }
}
