package lk.ijse.dmi.dto;

import lk.ijse.dmi.entity.Grn;
import lk.ijse.dmi.entity.GrnDetails;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GrnDTO {
    private String grnId;
    private LocalDate date;
    private LocalTime time;

    public GrnDTO(String grnId, LocalDate date, LocalTime time, List<GrnDetailsDTO> grnDetailsDTOList, ArrayList<GrnDetails> grnDetails) {
        this.grnId = grnId;
        this.date = date;
        this.time = time;
        this.grnDetailsDTOList = grnDetailsDTOList;
        this.grnDetails = grnDetails;
    }

    List<GrnDetailsDTO> grnDetailsDTOList;
    private ArrayList<GrnDetails> grnDetails;


    public GrnDTO(String grnId, LocalDate date, LocalTime time, List<GrnDetailsDTO> grnDetailsDTOList) {
        this.grnId = grnId;
        this.date = date;
        this.time = time;
        this.grnDetailsDTOList = grnDetailsDTOList;
    }




    public GrnDTO() {
    }


    public GrnDTO(String grnId, LocalDate date, LocalTime time) {
        this.grnId = grnId;
        this.date = date;
        this.time = time;



    }
    public List<GrnDetailsDTO> getGrnDetailsDTOS(){
        return grnDetailsDTOList;
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


    public ArrayList<GrnDetails> getGrnDetails() {
        return grnDetails;
    }

    public void setGrnDetails(ArrayList<GrnDetails> grnDetails) {
        this.grnDetails = grnDetails;
    }
}
