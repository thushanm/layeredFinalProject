package lk.ijse.dmi.bo.custom;

import lk.ijse.dmi.dto.OrderDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface UpdateOrderBO extends SuperBO{
    boolean order(OrderDTO dto) throws SQLException, ClassNotFoundException, IOException;


        }
