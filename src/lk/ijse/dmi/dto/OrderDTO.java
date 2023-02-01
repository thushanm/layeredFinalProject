package lk.ijse.dmi.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class OrderDTO {
    private String OderId;
    private LocalTime time;
    private LocalDate date;
    private List<OrderDeatisDTO> orderDeatisDTOS;

    public OrderDTO() {
    }


    public OrderDTO(String oderId, LocalTime time, LocalDate date,List<OrderDeatisDTO> orderDeatisDTOS) {
        OderId = oderId;
        this.time = time;
        this.date = date;
        this.orderDeatisDTOS = orderDeatisDTOS;
    }public OrderDTO(String oderId, LocalTime time, LocalDate date) {
        OderId = oderId;
        this.time = time;
        this.date = date;

    }

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

    public List<OrderDeatisDTO> getOrderDeatisDTOS() {
        return orderDeatisDTOS;
    }

    public void setOrderDeatisDTOS(List<OrderDeatisDTO> orderDeatisDTOS) {
        this.orderDeatisDTOS = orderDeatisDTOS;
    }
}
