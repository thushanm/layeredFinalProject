package lk.ijse.dmi.bo.custom;

import lk.ijse.dmi.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
      boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
     boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
 boolean deleteCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

}
