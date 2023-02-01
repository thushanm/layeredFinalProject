package lk.ijse.dmi.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dmi.bo.custom.BOFactory;
import lk.ijse.dmi.bo.custom.UpdateOrderBO;
import lk.ijse.dmi.dwo.custom.CrudDAO;
import lk.ijse.dmi.dwo.custom.DAOFactory;
import lk.ijse.dmi.dwo.custom.ItemDAO;
import lk.ijse.dmi.dwo.custom.OrderDAO;
import lk.ijse.dmi.dwo.custom.impl.CustomerDAOImpl;
import lk.ijse.dmi.dto.*;
import lk.ijse.dmi.utill.Regex;
import lk.ijse.dmi.utill.TextFields;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PosController {

UpdateOrderBO updateOrderBOimpl = (UpdateOrderBO) BOFactory.getBoFactory().getBo(BOFactory.boType.POS);
    CrudDAO customerDAO = new CustomerDAOImpl();
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ORDER);
    public AnchorPane posAnchor;
    public TableView tblMainPos;
    public TableColumn tblItemId;
    public TableColumn tblCustomer;
    public TableColumn tblQty;
    public TableColumn tblDiscount;
    public TableColumn tblUPrice;
    public TableColumn tblAmount;
    public TableColumn tblDelete;
    public Label lblCurantAmount;
    public Label lblCurantDiscount;
    public Label lblTotal;
    public Button btnPay;
    public JFXComboBox <ItemDTO>cmbItId;
    public JFXComboBox<CustomerDTO>cmbCustomerId;
    public JFXTextField txtOderId;
    public JFXTextField txtQtyUpdate;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtDescription;
    public JFXTextField txtItemId;
    public JFXTextField txtDiscount;
    public JFXTextField txtCash;
    double total;
    double discount;
    ObservableList<OrderDeatisDTO> obOrder = FXCollections.observableArrayList();


    public void initialize(){
        txtQtyUpdate.setText("1");
loadDataCmb();

}
    public void loadDataCmb() {

        try {
            ArrayList<ItemDTO> allItemOrderDTO = itemDAO.getAll();
            for (ItemDTO a : allItemOrderDTO) {
                cmbItId.getItems().addAll(a);
            }
            ArrayList<CustomerDTO> allCustomerDTO = customerDAO.getAll();
            for (CustomerDTO c: allCustomerDTO){
                cmbCustomerId.getItems().addAll(c);
            }
           tblMainPos.setItems(obOrder);
           tblMainPos.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public void cmbItemClick(ActionEvent actionEvent) {
String b = "1";
        ItemDTO value = (ItemDTO) cmbItId.getValue();
        if (value != null) {
            try {
                txtItemId.setText(value.getItId());

                txtQtyUpdate.setText(b);
                txtOderId.setText(orderDAO.generateNextOrderId());
                txtDescription.setText(value.getDescription());
                txtUnitPrice.setText(String.valueOf(value.getUnitPrice()));
                txtDiscount.setText(value.getDiscount()+"");

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }


    }



    public void btnPay(ActionEvent actionEvent) throws SQLException {
        Connection connection=null;
        if(txtCash.getText()==null){
        return ;
        }
        if(Regex.setTextColor(TextFields.INTEGER,txtCash)){

        }else {
            new Alert(Alert.AlertType.WARNING,"Please Enter Only Money Count").show();
return;
        }
        double cash=Double.parseDouble(txtCash.getText());
        if(cash<addTotal()){
            new Alert(Alert.AlertType.WARNING,(addTotal()-cash)+" not enough").show();
            return;
        }



    }
    public  boolean order(String id, LocalDate date,LocalTime time, List<OrderDeatisDTO> orderDeatisDTOS){
        try {

            return updateOrderBOimpl.order(new OrderDTO(id,time,date,orderDeatisDTOS));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

return false;
    }

    public void printBill(String orderId) {
        try {
            double netAmount=0.0;
            double discount=0.0;
            double totalAmount=0.0;
            double balance=0.0;
               double    cash=0.0;
            int discountString=0;
            if(txtCash.getText()!=null){
                cash=Double.parseDouble(txtCash.getText());
            }
            for (OrderDeatisDTO o : obOrder) {
                netAmount +=o.getAmount();
                discount +=o.getAmount()*o.getDiscount()/100;
            }
            totalAmount=netAmount-discount;

            balance=cash-totalAmount;
            HashMap<String,Object> map=new HashMap<>();
            map.put("orderId",orderId);
            map.put("subTotal",netAmount);
            map.put("discount",discount);
            map.put("netAmount",totalAmount);
            map.put("cash",cash);
            map.put("balance",balance);
            map.put("discountString","0%");

            final JasperDesign load = JRXmlLoader.load(this.getClass().getResourceAsStream("/lk/ijse/dmi/report/bill25.jrxml"));
            final JasperReport compileReport = JasperCompileManager.compileReport(load);
            final JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, map, new JRBeanCollectionDataSource(obOrder));
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException e) {
            e.printStackTrace();
        }


    }


    public void btnLoadTable(ActionEvent actionEvent) {
        boolean isHad=true;
        if (Regex.setTextColor(TextFields.INTEGER,txtQtyUpdate)){

        }
        else{
            new Alert(Alert.AlertType.WARNING,"Please Enter Only Quantity").show();
            return;
        }if (Regex.setTextColor(TextFields.INTEGER,txtDiscount)){

        }
        else{
            new Alert(Alert.AlertType.WARNING,"Please Enter Only Discount").show();
            return;
        }
        for (OrderDeatisDTO o : obOrder) {
            if(o.getOrderItemId().equals(txtItemId.getText())){
                int qty=Integer.parseInt(txtQtyUpdate.getText());
                int dis=Integer.parseInt(txtDiscount.getText());
                o.setQty(o.getQty()+qty);
                o.setDiscount(dis);
                isHad=false;
            }
            Button btn=new Button("Delete");
            btn.setCursor(Cursor.HAND);
            btn.setStyle("-fx-border-color: red");
            o.setDelete(btn);
            o.getDelete().setOnAction(event -> {
                obOrder.remove(o);
            });

        }
        int qtyUpdate=Integer.parseInt(txtQtyUpdate.getText());
        if(qtyUpdate>=0){
            qtyUpdate=1;
        }
        if(isHad) {
            OrderDeatisDTO orderLoad = new OrderDeatisDTO(
                    txtDescription.getText(),
                    Integer.parseInt(txtDiscount.getText()),
                    qtyUpdate,
                    Double.parseDouble(txtUnitPrice.getText()),
                    txtOderId.getText(),
                    txtItemId.getText());
            Button btn=new Button("Delete");
            btn.setCursor(Cursor.HAND);
            btn.setStyle("-fx-border-color: red");
            orderLoad.setDelete(btn);
            orderLoad.getDelete().setOnAction(event -> {
                obOrder.remove(orderLoad);
            });
            obOrder.add(orderLoad);
        }
    addTotal();

        ArrayList<OrderDeatisDTO> it = new ArrayList<>();
        for (OrderDeatisDTO I : it){
            OrderDeatisDTO list1 = new OrderDeatisDTO();
            list1.setAmount(((I.getQty()*I.getUnitPrice())-I.getDiscount()));
obOrder.add(list1);
        }

     tblItemId.setCellValueFactory(new PropertyValueFactory<>("orderItemId"));
      tblCustomer.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
      tblDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
     tblUPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tblDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));



        initialize();
    }

    public double addTotal() {
        total=0.0;
        discount=0.0;
        double finalAmount=0.0;
        for (OrderDeatisDTO or : obOrder) {
            total +=or.getQty()* or.getUnitPrice();
            or.setAmount(or.getQty()*or.getUnitPrice());
            discount += or.getAmount() * or.getDiscount()/100;
        }
        finalAmount =total-discount;

        lblCurantAmount.setText(total+"0");
        lblCurantDiscount.setText(discount+"0");
        lblTotal.setText(finalAmount+"0");
        return finalAmount;
    }

    public void cmbCustomer(ActionEvent actionEvent) {
        txtQtyUpdate.requestFocus();
    }
}
