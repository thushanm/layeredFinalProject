package lk.ijse.dmi.dwo.custom;

import lk.ijse.dmi.dto.GrnCustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QuaryDAO extends SuperDAO {
    ArrayList<GrnCustomDTO> grnIdQuary(String gid) throws SQLException, ClassNotFoundException;
    void getOrderId(String oid) throws SQLException, ClassNotFoundException;
}
