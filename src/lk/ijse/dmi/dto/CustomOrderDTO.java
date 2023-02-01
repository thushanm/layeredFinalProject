package lk.ijse.dmi.dto;

import javafx.scene.control.Button;

import java.time.LocalDate;
import java.time.LocalTime;

public class CustomOrderDTO {
    private String OderId;
    private LocalTime time;
    private LocalDate date;
    private String description;
    private int discount;
    private int qty;

    public CustomOrderDTO(String oderId, LocalTime time, LocalDate date, String description, int discount, int qty, double unitPrice, String orderItemId, String customerId) {
        OderId = oderId;
        this.time = time;
        this.date = date;
        this.description = description;
        this.discount = discount;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.orderItemId = orderItemId;
        this.customerId = customerId;
    }

    private double unitPrice;
    private String orderItemId;
    private String customerId;
    private double amount;
    private Button delete;


    public String getOderId() {
        return OderId;
    }

    public void setOderId(String oderId) {
        OderId = oderId;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
