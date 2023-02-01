package lk.ijse.dmi.dwo.custom.impl;

import lk.ijse.dmi.dwo.custom.CrudUtil;
import lk.ijse.dmi.dwo.custom.OrderDeatailsDAO;
import lk.ijse.dmi.dto.OrderDeatisDTO;
import lk.ijse.dmi.entity.OrderDeatils;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDeataisDAOImpl implements OrderDeatailsDAO {


    @Override
    public boolean save(OrderDeatils orderDeatisDTO) throws SQLException, ClassNotFoundException {
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
    public boolean update(OrderDeatils orderDeatisDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(OrderDeatils orderDeatisDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDeatils serach(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<OrderDeatils> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }



    @Override
    public boolean saveAll(ArrayList<OrderDeatisDTO> list) throws SQLException, ClassNotFoundException {
        ItemDAOImpl itemDAO =new ItemDAOImpl();
        for (OrderDeatils orderDeatisDTO : list) {

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
