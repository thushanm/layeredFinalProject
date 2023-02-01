package lk.ijse.dmi.dwo.custom.impl;

import lk.ijse.dmi.dwo.custom.CrudUtil;
import lk.ijse.dmi.dwo.custom.OrderDAO;
import lk.ijse.dmi.dto.OrderDTO;
import lk.ijse.dmi.entity.Order;
import lk.ijse.dmi.utill.CreateNewId;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {


    @Override
    public boolean save(Order orderDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO orders VALUE(?,?,?)",
                orderDTO.getOrderID(), orderDTO.getTime(), orderDTO.getDate());
    }

    @Override
    public boolean update(Order orderDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Order orderDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM orderDTOS WHERE orderID=? ", orderDTO.getOrderID());

    }

    @Override
    public Order serach(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT * FROM order ");
        ArrayList<Order> orderDTOS = new ArrayList<>();
        while (rst.next()) {
            orderDTOS.add(new Order(rst.getString(1), rst.getTime(2).toLocalTime(), rst.getDate(3).toLocalDate()));
        }
        return orderDTOS;
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT orderID FROM Orders ORDER BY orderID DESC LIMIT 1");
        if (rst.next()) {
            return CreateNewId.generateId("OR", rst.getString(1));
        } else {
            return CreateNewId.generateId("OR", null);
        }
    }
}