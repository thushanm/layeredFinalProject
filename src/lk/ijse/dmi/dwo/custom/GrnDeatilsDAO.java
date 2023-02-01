package lk.ijse.dmi.dwo.custom;

import lk.ijse.dmi.dto.GrnDetailsDTO;
import lk.ijse.dmi.entity.GrnDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GrnDeatilsDAO extends CrudDAO<GrnDetails,String>{
    public boolean saveAll(ArrayList<GrnDetailsDTO> list) throws SQLException, ClassNotFoundException;
}
