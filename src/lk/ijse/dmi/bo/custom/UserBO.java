package lk.ijse.dmi.bo.custom;

import java.sql.SQLException;

public interface UserBO extends SuperBO{
    Object checkUserName(String text) throws SQLException, ClassNotFoundException;
    Object checkUserPwd(String text) throws SQLException, ClassNotFoundException;

}
