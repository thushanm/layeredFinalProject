package lk.ijse.dmi.bo.custom.impl;

import lk.ijse.dmi.bo.custom.SuplierBO;
import lk.ijse.dmi.dwo.custom.CrudDAO;
import lk.ijse.dmi.dwo.custom.DAOFactory;
import lk.ijse.dmi.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBoimpl implements SuplierBO {
    CrudDAO suplierDAO = (CrudDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.SUPPLIER);

    public ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException {
        return suplierDAO.getAll();
    }

    public boolean saveSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return suplierDAO.save(new SupplierDTO(supplierDTO.getId(),supplierDTO.getName(),supplierDTO.getAddress(),supplierDTO.getNumber()));
    }

    public boolean updateSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return suplierDAO.update(new SupplierDTO(supplierDTO.getId(),supplierDTO.getName(),supplierDTO.getAddress(),supplierDTO.getNumber()));
    }


    public boolean deleteSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return suplierDAO.delete(new SupplierDTO(supplierDTO.getId(),supplierDTO.getName(),supplierDTO.getAddress(),supplierDTO.getNumber()));
    }

}
