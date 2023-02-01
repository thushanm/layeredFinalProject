package lk.ijse.dmi.dwo.custom.impl;

import lk.ijse.dmi.dwo.custom.CrudDAO;
import lk.ijse.dmi.dwo.custom.CrudUtil;
import lk.ijse.dmi.dto.SupplierDTO;
import lk.ijse.dmi.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements CrudDAO<Supplier,String> {

    @Override
    public boolean save(Supplier supplierDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO supplier VALUES(?,?,?,?)",
                supplierDTO.getsId(), supplierDTO.getName(), supplierDTO.getAddress(), supplierDTO.getTel_no());

    }
    @Override
    public boolean update(Supplier supplierDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE supplier SET Name=?, address=?,tel_no=? WHERE sId=?", supplierDTO.getName(), supplierDTO.getAddress(), supplierDTO.getTel_no(), supplierDTO.getsId());

    }

    @Override
    public boolean delete(Supplier supplierDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM supplier WHERE sId=?", supplierDTO.getsId());
    }

    @Override
    public Supplier serach(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT * FROM supplier");
        ArrayList<Supplier> supplierDTOS = new ArrayList<>();
        while (rst.next()){
            supplierDTOS.add(new Supplier(rst.getString(1),rst.getString(2), rst.getString(3),rst.getInt(4)));
        }
        return supplierDTOS;
    }


}

