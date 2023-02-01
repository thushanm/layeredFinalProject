package lk.ijse.dmi.bo.custom;

import lk.ijse.dmi.dto.UserDTO;

import java.sql.SQLException;

public interface UserAddBO extends SuperBO {
    boolean saveUser(UserDTO userDTO) throws SQLException, ClassNotFoundException;
}
