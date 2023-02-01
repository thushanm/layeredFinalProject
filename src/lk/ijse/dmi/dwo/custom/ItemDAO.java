package lk.ijse.dmi.dwo.custom;

import lk.ijse.dmi.dto.ItemDTO;
import lk.ijse.dmi.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item,String>{
    boolean saveAll(ArrayList<Item> list) throws SQLException, ClassNotFoundException;
    boolean addQty(String id, int qty) throws SQLException, ClassNotFoundException;
    boolean removeQty(String id, int qty) throws SQLException, ClassNotFoundException;
}
