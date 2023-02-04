package lk.ijse.dmi.dwo.custom.impl;

import lk.ijse.dmi.dto.GrnDetailsDTO;
import lk.ijse.dmi.dwo.custom.CrudUtil;
import lk.ijse.dmi.dwo.custom.GrnDeatilsDAO;
import lk.ijse.dmi.entity.GrnDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrnDeatilsDAOImpl implements GrnDeatilsDAO {


    @Override
    public boolean save(GrnDetails grnDetailsDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO grnDetails VALUES(?,?,?,?,?)",
                grnDetailsDTO.getDescription(),grnDetailsDTO.getQty(),grnDetailsDTO.getUtilPrice(),grnDetailsDTO.getGrndid(),grnDetailsDTO.getGrnitid());
    }

    @Override
    public boolean update(GrnDetails grnDetailsDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(GrnDetails grnDetailsDTO) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public GrnDetails serach(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<GrnDetails> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT * FROM grnDetails");
        ArrayList<GrnDetails> grnDetails = new ArrayList<>();
        while (rst.next()){
            grnDetails.add(new GrnDetails(rst.getString(1), rst.getInt(2),rst.getDouble(3), rst.getString(4), rst.getString(5)));
        }
        return grnDetails;
    }


    @Override
    public boolean saveAll(ArrayList<GrnDetails> list) throws SQLException, ClassNotFoundException {
        ItemDAOImpl itemDAO =new ItemDAOImpl();
        for (GrnDetails g : list) {
            boolean b = save(g);
            if(!b){
                return false;
            }else{
                boolean b1 = itemDAO.addQty(g.getGrndid(), g.getQty());
                if(!b1){
                    return false;
                }
            }
        }
        return true;
    }

}
