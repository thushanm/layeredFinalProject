package lk.ijse.dmi.bo.custom;

import lk.ijse.dmi.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuplierBO extends SuperBO{
    ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException;

    boolean saveSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;
    boolean updateSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;
    boolean deleteSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;
}
