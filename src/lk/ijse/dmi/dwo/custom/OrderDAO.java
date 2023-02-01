package lk.ijse.dmi.dwo.custom;

import lk.ijse.dmi.dto.OrderDTO;
import lk.ijse.dmi.entity.Order;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<Order,String> {
    public String generateNextOrderId() throws SQLException, ClassNotFoundException;
}
