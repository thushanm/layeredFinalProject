package lk.ijse.dmi.bo.custom.impl;

import lk.ijse.dmi.bo.custom.CustomerBO;
import lk.ijse.dmi.dwo.custom.CrudDAO;
import lk.ijse.dmi.dwo.custom.DAOFactory;
import lk.ijse.dmi.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOimpl implements CustomerBO {
  CrudDAO crudDAO = (CrudDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.CUSTOMER);
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {

        return crudDAO.getAll();
    }

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return crudDAO.save(new CustomerDTO(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getTelNo()));
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return crudDAO.update(new CustomerDTO(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getTelNo()));
    }

    public boolean deleteCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return crudDAO.delete(new CustomerDTO(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getTelNo()));
    }
}
