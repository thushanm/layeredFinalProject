package lk.ijse.dmi.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private String orderID;
    private LocalTime time;
    private LocalDate date;


    public Order() {
    }


    public Order(String orderID, LocalTime time, LocalDate date) {
        this.orderID = orderID;
        this.time = time;
        this.date = date;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
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
}
