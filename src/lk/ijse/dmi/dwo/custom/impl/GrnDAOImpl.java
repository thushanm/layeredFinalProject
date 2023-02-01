package lk.ijse.dmi.dwo.custom.impl;

import lk.ijse.dmi.dwo.custom.CrudUtil;
import lk.ijse.dmi.dwo.custom.GrnDAO;
import lk.ijse.dmi.dto.GrnDTO;
import lk.ijse.dmi.entity.Grn;
import lk.ijse.dmi.utill.CreateNewId;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrnDAOImpl implements GrnDAO {


    @Override
    public boolean save(Grn grnDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO grn VALUES(?,?,?)",
                grnDTO.getGrnId(), grnDTO.getDate(), grnDTO.getTime());
    }

    @Override
    public boolean update(Grn grnDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Grn grnDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Grn serach(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Grn> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT * FROM grn");
        ArrayList<Grn> grnDTO = new ArrayList<>();
        while (rst.next()){
            grnDTO.add(new Grn(rst.getString(1), rst.getDate(2).toLocalDate(),rst.getTime(3).toLocalTime()));
        }
        return grnDTO;
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT grnId FROM grn ORDER BY grnId DESC LIMIT 1");
        if (rst.next()) {
            return CreateNewId.generateId("GR", rst.getString(1));
        } else {
            return CreateNewId.generateId("GR", null);
        }
    }


}
