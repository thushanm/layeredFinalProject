package lk.ijse.dmi.bo.custom.impl;

import lk.ijse.dmi.bo.custom.UserBO;
import lk.ijse.dmi.dwo.custom.DAOFactory;
import lk.ijse.dmi.dwo.custom.UserDAO;
import lk.ijse.dmi.dwo.custom.impl.UserDAOImpl;

import java.sql.SQLException;

public class UserBOimpl implements UserBO {
UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.USER);
    public Object checkUserName(String text) throws SQLException, ClassNotFoundException {

        return userDAO.checkUserName(text);
    }

    public Object checkUserPwd(String text) throws SQLException, ClassNotFoundException {
        return userDAO.checkUserPwd(text);
    }
}
