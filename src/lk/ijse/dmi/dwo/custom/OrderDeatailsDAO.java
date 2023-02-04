package lk.ijse.dmi.dwo.custom;

import lk.ijse.dmi.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDeatailsDAO extends CrudDAO<OrderDetails,String> {
    public boolean saveAll(ArrayList<OrderDetails> list) throws SQLException, ClassNotFoundException;
}
