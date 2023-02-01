package lk.ijse.dmi.dwo.custom;

import lk.ijse.dmi.dto.GrnDTO;
import lk.ijse.dmi.entity.Grn;

import java.sql.SQLException;

public interface GrnDAO extends CrudDAO<Grn,String>{
    public String generateNextOrderId() throws SQLException, ClassNotFoundException;
}
