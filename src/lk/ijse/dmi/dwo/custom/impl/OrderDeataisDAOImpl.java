package lk.ijse.dmi.dwo.custom.impl;

import lk.ijse.dmi.dwo.custom.CrudUtil;
import lk.ijse.dmi.dwo.custom.OrderDeatailsDAO;
import lk.ijse.dmi.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDeataisDAOImpl implements OrderDeatailsDAO {


    @Override
    public boolean save(OrderDetails orderDeatisDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO orderdetails VALUES (?,?,?,?,?,?,?)",
                orderDeatisDTO.getDescription(),
                orderDeatisDTO.getDiscount(),
                orderDeatisDTO.getQty(),
                orderDeatisDTO.getPrice(),
                orderDeatisDTO.getOdId(),
                orderDeatisDTO.getOitId(),
                orderDeatisDTO.getCoId());
    }

        @Override
    public boolean update(OrderDetails orderDeatisDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(OrderDetails orderDeatisDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetails serach(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }



    @Override
    public boolean saveAll(ArrayList<OrderDetails> list) throws SQLException, ClassNotFoundException {
        ItemDAOImpl itemDAO =new ItemDAOImpl();
        for (OrderDetails orderDeatisDTO : list) {

            if(!save(orderDeatisDTO)){
                return false;
            }else{
                boolean b = itemDAO.removeQty(orderDeatisDTO.getOitId(), orderDeatisDTO.getQty());
                if(!b){
                    return false;
                }
            }
        }
        return true;
    }

}
