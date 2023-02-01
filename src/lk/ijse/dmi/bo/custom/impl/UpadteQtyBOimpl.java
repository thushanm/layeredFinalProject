package lk.ijse.dmi.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.dmi.bo.custom.UpadteQtyBO;
import lk.ijse.dmi.db.DBConnection;
import lk.ijse.dmi.dwo.custom.*;
import lk.ijse.dmi.dto.GrnDTO;
import lk.ijse.dmi.dto.GrnDetailsDTO;
import lk.ijse.dmi.entity.Grn;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class UpadteQtyBOimpl implements UpadteQtyBO {
    GrnDAO grnDAO = (GrnDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.GRN);
    GrnDeatilsDAO grnDeatilsDAO = (GrnDeatilsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.GRNDEATILS);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ITEM);

@Override
    public boolean saveGrn(GrnDTO dto) throws SQLException, ClassNotFoundException {

        Connection connection = null;
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            String id = grnDAO.generateNextOrderId();
            boolean saveGrn = grnDAO.save(new Grn(
                    id,
                    LocalDate.now(),
                    LocalTime.now()

            ));
            if (saveGrn) {
                ArrayList<GrnDetailsDTO> grnDetailDTOS = new ArrayList<>();
                for (GrnDetailsDTO g : dto.getGrnDetailsDTOS()) {
                    g.setGrnId(id);
                    grnDetailDTOS.add(g);
                }
                boolean saveAll = grnDeatilsDAO.saveAll(grnDetailDTOS);
                if (saveAll) {
                    connection.commit();

                    new Alert(Alert.AlertType.INFORMATION, "completed").show();
                }
            }
            connection.rollback();
            connection.setAutoCommit(true);

    return saveGrn;
}


    }

