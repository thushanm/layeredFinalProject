package lk.ijse.dmi.bo.custom;

import lk.ijse.dmi.dto.GrnDTO;

import java.sql.SQLException;

public interface UpadteQtyBO extends SuperBO {
 boolean saveGrn(GrnDTO dto) throws SQLException, ClassNotFoundException ;
}
