package lk.ijse.dmi.bo.custom;

import lk.ijse.dmi.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private void boFactory(){
    }
public static BOFactory getBoFactory(){
        if (boFactory==null){
            boFactory=new BOFactory();

        }

       return boFactory;
    }
    public enum boType{
        CUSTOMER,GRN,ITEM,LOGIN,POS,SUPPLIER,USER
    }
    public SuperBO getBo(boType type){
        switch (type){
            case SUPPLIER:
                return  new SupplierBoimpl();
            case CUSTOMER:
                return new CustomerBOimpl();
            case USER:
                return new UserAddBOimpl();
            case LOGIN:
                return new UserBOimpl();
            case POS:
                return new UpdateOrderBOimpl();
            case ITEM:
                return new ItemBOimpl();
            case GRN:
                return new UpadteQtyBOimpl();
            default:
                return null;
        }
    }
}
