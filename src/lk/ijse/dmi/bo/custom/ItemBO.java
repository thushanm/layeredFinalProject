package lk.ijse.dmi.bo.custom;

import lk.ijse.dmi.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO  extends SuperBO{
    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
    boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
}
