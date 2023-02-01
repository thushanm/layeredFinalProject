package lk.ijse.dmi.dwo.custom;

import lk.ijse.dmi.dto.OrderDeatisDTO;
import lk.ijse.dmi.entity.OrderDeatils;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDeatailsDAO extends CrudDAO<OrderDeatils,String> {
    public boolean saveAll(ArrayList<OrderDeatisDTO> list) throws SQLException, ClassNotFoundException;
}
