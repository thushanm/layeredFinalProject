package lk.ijse.dmi.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Custom {
    private String grnId;
    private LocalDate date;
    private LocalTime time;
    private String description;
    private int qty;
    private double unitPrice;
    private String itId;
    private double amount;
    public Custom(String grnId, LocalDate date, LocalTime time, String description, int qty, double unitPrice, String itId) {
        this.grnId = grnId;
        this.date = date;
        this.time = time;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.itId = itId;

    }



    public Custom() {
    }

    public String getGrnId() {
        return grnId;
    }

    public void setGrnId(String grnId) {
        this.grnId = grnId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getItId() {
        return itId;
    }

    public void setItId(String itId) {
        this.itId = itId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
