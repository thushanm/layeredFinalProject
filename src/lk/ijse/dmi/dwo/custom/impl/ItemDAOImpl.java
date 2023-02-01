package lk.ijse.dmi.dwo.custom.impl;

import lk.ijse.dmi.dwo.custom.CrudUtil;
import lk.ijse.dmi.dwo.custom.ItemDAO;
import lk.ijse.dmi.dto.ItemDTO;
import lk.ijse.dmi.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item itemDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Item itemDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE item SET description=?, qty=?,uPrice=? WHERE itId=?", itemDTO.getDescription(), itemDTO.getQty(), itemDTO.getuPrice(), itemDTO.getDiscount(), itemDTO.getItId());

    }

    @Override
    public boolean delete(Item itemDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO item VALUES(?,?,?,?,?,?)", itemDTO.getItId(), itemDTO.getItSId(), itemDTO.getDescription(), itemDTO.getQty(), itemDTO.getDiscount(), itemDTO.getuPrice());
    }
    @Override
    public Item serach(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT * FROM item WHERE itId=?",id);

        while (rst.next()) {
            return new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getInt(5), rst.getDouble(6));

        }

        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT * FROM item");
        ArrayList<Item> itemDTOS = new ArrayList<>();
        while (rst.next()) {
            itemDTOS.add(new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getInt(5), rst.getDouble(6)));
        }
        return itemDTOS;
    }


    @Override
    public boolean saveAll(ArrayList<Item> list) throws SQLException, ClassNotFoundException {
        for (Item p : list) {
            if (!save(p)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addQty(String id, int qty) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE  item SET qty=qty+? WHERE itId=?",qty,id);
    }

    @Override
    public boolean removeQty(String id, int qty) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE  item SET qty=qty-? WHERE itId=?",qty,id);
    }

}
