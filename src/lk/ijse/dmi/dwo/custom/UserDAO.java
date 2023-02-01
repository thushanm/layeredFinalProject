package lk.ijse.dmi.dwo.custom;

import lk.ijse.dmi.dto.UserDTO;
import lk.ijse.dmi.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User,String>{

 User checkUserPwd(String pwd) throws SQLException, ClassNotFoundException;
  User checkUserName(String name) throws SQLException, ClassNotFoundException;
}
