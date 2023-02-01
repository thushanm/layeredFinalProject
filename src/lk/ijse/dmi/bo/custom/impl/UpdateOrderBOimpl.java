package lk.ijse.dmi.bo.custom.impl;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import lk.ijse.dmi.bo.custom.UpdateOrderBO;
import lk.ijse.dmi.controller.DashbordController;
import lk.ijse.dmi.controller.PosController;
import lk.ijse.dmi.db.DBConnection;
import lk.ijse.dmi.dwo.custom.*;
import lk.ijse.dmi.dto.OrderDTO;
import lk.ijse.dmi.dto.OrderDeatisDTO;
import lk.ijse.dmi.entity.Order;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class UpdateOrderBOimpl implements UpdateOrderBO {
    PosController posController = new PosController();
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ORDER);
    OrderDeatailsDAO orderDeatalsDAO = (OrderDeatailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.GRNDEATILS);



    public boolean order(OrderDTO dto) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            String orderId = orderDAO.generateNextOrderId();
            boolean save = orderDAO.save(new Order(
                    orderId,
                    LocalTime.now(),
                    LocalDate.now()
            ));
            if (save) {
                ArrayList<OrderDeatisDTO> list = new ArrayList<>();
                for (OrderDeatisDTO o : dto.getOrderDeatisDTOS()) {
                    o.setOrderId(orderId);

                    list.add(o);
                }
                if (orderDeatalsDAO.saveAll(list)) {
                    connection.commit();
                    posController.printBill(orderId);
                   posController.lblCurantAmount.setText("");
                    posController.lblCurantDiscount.setText("");
                    posController.lblTotal.setText("");
                    posController.txtCash.clear();

                    new Alert(Alert.AlertType.INFORMATION, "change  :" + ( posController.addTotal()) + "").show();
                    DashbordController.dashbordController.dashbordAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("../view/pos.fxml")));
                }
            }
            connection.rollback();
            connection.setAutoCommit(true);
return save;
        }
    }

