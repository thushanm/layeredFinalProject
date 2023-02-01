package lk.ijse.dmi.dwo.custom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T,ID> extends SuperDAO{
    boolean save(T t ) throws SQLException, ClassNotFoundException;
    boolean update(T t ) throws SQLException, ClassNotFoundException;
    boolean delete(T t ) throws SQLException, ClassNotFoundException;
  T serach(ID id )throws SQLException, ClassNotFoundException;
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

}
