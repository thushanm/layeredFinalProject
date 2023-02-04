package lk.ijse.dmi.bo.custom.impl;

import lk.ijse.dmi.bo.custom.CustomerBO;
import lk.ijse.dmi.dwo.custom.CrudDAO;
import lk.ijse.dmi.dwo.custom.CustomerDAO;
import lk.ijse.dmi.dwo.custom.DAOFactory;
import lk.ijse.dmi.dto.CustomerDTO;
import lk.ijse.dmi.dwo.custom.impl.CustomerDAOImpl;
import lk.ijse.dmi.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CustomerBOimpl implements CustomerBO {
  CustomerDAO crudDAO = (CustomerDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.CUSTOMER);
//THUSITHA
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {

        return new ArrayList<CustomerDTO>(crudDAO.getAll().stream().map(c -> new CustomerDTO(
                c.getCid(),
                c.getName(),
                c.getAddress(),
                c.getTel_no()
        )).collect(Collectors.toList()));
    }
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return crudDAO.save(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getTelNo()));
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return crudDAO.update(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getTelNo()));
    }

    public boolean deleteCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return crudDAO.delete(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getTelNo()));
    }
}
