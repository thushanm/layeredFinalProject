package lk.ijse.dmi.dwo.custom.impl;

import lk.ijse.dmi.dwo.custom.CrudUtil;
import lk.ijse.dmi.dwo.custom.UserDAO;
import lk.ijse.dmi.dto.UserDTO;
import lk.ijse.dmi.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {


    @Override
    public User checkUserPwd(String pwd) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT * FROM user WHERE password =?", pwd);

        if (rst.next()) {

            return new User(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;

    }

    @Override
    public User checkUserName(String name) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT * FROM user WHERE name =?", name);
        if (rst.next()) {
            System.out.println("name");
            return new User(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;

    }

    @Override
    public boolean save(User userDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO user VALUES (?,?,?,?)", userDTO.getUserID(), userDTO.getName(), userDTO.getPassword(), userDTO.getRole());
    }

    @Override
    public boolean update(User userDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(User userDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public User serach(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}

