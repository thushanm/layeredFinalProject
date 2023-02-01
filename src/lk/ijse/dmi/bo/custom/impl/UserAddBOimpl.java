package lk.ijse.dmi.bo.custom.impl;

import lk.ijse.dmi.bo.custom.UserAddBO;
import lk.ijse.dmi.dwo.custom.CrudDAO;
import lk.ijse.dmi.dwo.custom.DAOFactory;
import lk.ijse.dmi.dto.UserDTO;

import java.sql.SQLException;

public class UserAddBOimpl implements UserAddBO {
    CrudDAO useDAO = (CrudDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.USER);

    public boolean saveUser(UserDTO userDTO) throws SQLException, ClassNotFoundException {
        return useDAO. save(new UserDTO(userDTO.getId(),userDTO.getName(),userDTO.getPwd(),userDTO.getRole()));
    }
}
