package lk.ijse.dmi.dwo.custom;

import lk.ijse.dmi.dwo.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
private DAOFactory(){

}
public static DAOFactory getDaoFactory(){
    if (daoFactory==null){
        daoFactory=new DAOFactory();
    }
    return daoFactory;

}
public enum DAOType{
    CUSTOMER,GRN,GRNDEATILS,ITEM,ORDER,ORDERDETEAILS,QUERY,SUPPLIER,USER
}
public SuperDAO getDAO(DAOType type){
    switch (type){
        case GRN:
return new GrnDAOImpl();
        case ITEM:
            return new ItemDAOImpl();
        case USER:
            return new UserDAOImpl();
        case ORDER:
            return new OrderDAOImpl();
        case QUERY:
            return new QueryDAOImpl();
        case CUSTOMER:
            return new CustomerDAOImpl();
        case SUPPLIER:
            return new SupplierDAOImpl();
        case GRNDEATILS:
            return new GrnDeatilsDAOImpl();
        case ORDERDETEAILS:
            return new OrderDeataisDAOImpl();
        default:
            return null;
    }
}
}
