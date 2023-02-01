package lk.ijse.dmi.bo.custom.impl;

import lk.ijse.dmi.bo.custom.ItemBO;
import lk.ijse.dmi.dwo.custom.CrudDAO;
import lk.ijse.dmi.dwo.custom.DAOFactory;
import lk.ijse.dmi.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOimpl implements ItemBO {
    CrudDAO itemDAO = (CrudDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ITEM);
    CrudDAO  suplierDAO = (CrudDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.SUPPLIER);

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new ItemDTO(itemDTO.getItId(),itemDTO.getItsId(),itemDTO.getDescription(),itemDTO.getQty(),itemDTO.getDiscount(),itemDTO.getUnitPrice()));
    }

    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new ItemDTO(itemDTO.getItId(),itemDTO.getItsId(),itemDTO.getDescription(),itemDTO.getQty(),itemDTO.getDiscount(),itemDTO.getUnitPrice()));
    }
}
