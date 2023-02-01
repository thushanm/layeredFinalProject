package lk.ijse.dmi.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;
import lk.ijse.dmi.bo.custom.BOFactory;
import lk.ijse.dmi.bo.custom.UpadteQtyBO;
import lk.ijse.dmi.dwo.custom.DAOFactory;
import lk.ijse.dmi.dwo.custom.GrnDAO;
import lk.ijse.dmi.dwo.custom.ItemDAO;
import lk.ijse.dmi.dto.*;
import lk.ijse.dmi.utill.Regex;
import lk.ijse.dmi.utill.TextFields;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GrnController {
    UpadteQtyBO upadteQtyBOimpl = (UpadteQtyBO) BOFactory.getBoFactory().getBo(BOFactory.boType.GRN);
    GrnDAO grnDAO = (GrnDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.GRN);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ITEM);
    public AnchorPane grnAnchor;
    public TableView<GrnDetailsDTO> tblMainGrn;
    public TableColumn tblPoId;
    public TableColumn tblDescription;
    public TableColumn<GrnDetailsDTO, Integer> tblQty;
    public TableColumn tblUnitPrice;
    public TableColumn tblAmount;

    public JFXTextField txtUnitPrice;
    public JFXTextField txtDescription;
    public JFXTextField txtItemId;
    public JFXComboBox<ItemDTO> cmbItId;
    public JFXTextField txtgrnId;
    public JFXTextField txtQty;
    double total;


 ObservableList<GrnDetailsDTO> obGrnList = FXCollections.observableArrayList();


    public void initialize() {
        System.out.println(LocalTime.now());
        tblQty.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tblQty.setOnEditCommit(event -> {
            System.out.println("is ok");
        });

        loadDataCmb();


    }


    public void loadDataCmb() {

        try {
            ArrayList<ItemDTO> allpoOrder = itemDAO.getAll();
            for (ItemDTO a : allpoOrder) {
                cmbItId.getItems().addAll(a);
            }
            tblMainGrn.setItems(obGrnList);
            tblMainGrn.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public void btnAdd(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = grnDAO.generateNextOrderId();
        List<GrnDetailsDTO> grnDetailsDTOS = null;
        boolean s = saveGrn(id,LocalDate.now(),LocalTime.now(),LocalTime.now(),grnDetailsDTOS);

        tblMainGrn.setItems(obGrnList);
        tblMainGrn.refresh();
        txtDescription.clear();
        txtQty.clear();
        txtUnitPrice.clear();
        txtItemId.clear();
        txtItemId.clear();
    }
    public boolean saveGrn(String id, LocalDate date, LocalTime time, LocalTime now, List<GrnDetailsDTO> grnDetailsDTOS){
        try {
            return upadteQtyBOimpl.saveGrn(new GrnDTO(id,date,time,grnDetailsDTOS));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public void cmbClick(ActionEvent actionEvent) {
        ItemDTO value = cmbItId.getValue();
        if (value != null) {
            try {
                txtItemId.setText(value.getItId());
                txtQty.setText(value.getQty() + "");
                txtgrnId.setText(grnDAO.generateNextOrderId());
                txtDescription.setText(value.getDescription());
                txtUnitPrice.setText(String.valueOf(value.getUnitPrice()));


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }


    }


    public void btnAddTable(ActionEvent actionEvent) {
        if(Regex.setTextColor(TextFields.INTEGER,txtQty)){

        }
        else {
            new Alert(Alert.AlertType.WARNING,"Please Enter Only Quantity").show();
            return;
        }
       GrnDetailsDTO genTable = new GrnDetailsDTO(txtDescription.getText(),Integer.parseInt(txtQty.getText()),Double.parseDouble(txtUnitPrice.getText()),txtItemId.getText(),txtItemId.getText());
       if(genTable.getQty()<=0){
           genTable.setQty(1);
        }
       genTable.setAmount(genTable.getQty()*genTable.getUnitPrice());

        obGrnList.add(genTable);




        tblPoId.setCellValueFactory(new PropertyValueFactory<>("ItId"));
        tblDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        initialize();




    }
}














