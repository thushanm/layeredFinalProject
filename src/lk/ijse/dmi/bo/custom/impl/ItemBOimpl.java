package lk.ijse.dmi.bo.custom.impl;

import lk.ijse.dmi.bo.custom.ItemBO;
import lk.ijse.dmi.dwo.custom.CrudDAO;
import lk.ijse.dmi.dwo.custom.DAOFactory;
import lk.ijse.dmi.dto.ItemDTO;
import lk.ijse.dmi.dwo.custom.ItemDAO;
import lk.ijse.dmi.dwo.custom.impl.ItemDAOImpl;
import lk.ijse.dmi.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ItemBOimpl implements ItemBO {
   ItemDAO itemDAO = (ItemDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ITEM);


    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return new ArrayList<ItemDTO>(itemDAO.getAll().stream().map(i -> new ItemDTO(
                i.getItId(),
                i.getItSId(),
                i.getDescription(),
                i.getQty(),
                i.getDiscount(),
                i.getuPrice()
        )).collect(Collectors.toList()));
    }

    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(itemDTO.getItId(),itemDTO.getItsId(),itemDTO.getDescription(),itemDTO.getQty(),itemDTO.getDiscount(),itemDTO.getUnitPrice()));
    }

    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(itemDTO.getItId(),itemDTO.getItsId(),itemDTO.getDescription(),itemDTO.getQty(),itemDTO.getDiscount(),itemDTO.getUnitPrice()));
    }
}
