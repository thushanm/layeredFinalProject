package lk.ijse.dmi.dwo.custom.impl;

import lk.ijse.dmi.dwo.custom.CrudUtil;
import lk.ijse.dmi.dwo.custom.QuaryDAO;
import lk.ijse.dmi.dto.CustomOrderDTO;
import lk.ijse.dmi.dto.GrnCustomDTO;
import lk.ijse.dmi.entity.Custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class QueryDAOImpl implements QuaryDAO {

    public ArrayList<Custom> grnIdQuary(String gid) throws SQLException, ClassNotFoundException {
        ArrayList<Custom> allData = new ArrayList<>();
       ResultSet rst =  CrudUtil.executeQuary("SELECT g.grnid,g.date,g.time,gd.discription,gd.qty,gd.utilPrice,gd.grndId,gd.grnitId FROM grn as g INNER JOIN grndetails as gd ON g.grnid=gd.grndid=?;",gid);
while (rst.next()){
    allData.add(new Custom((rst.getString("grnid")),LocalDate.parse(rst.getString("date")),LocalTime.parse(rst.getString("time")),rst.getString("discription"),rst.getInt("qty"),rst.getInt("utilPrice"),rst.getString("grnitId")));
}
return allData;
    }

    @Override
    public void getOrderId(String oid) throws SQLException, ClassNotFoundException {
        ArrayList<CustomOrderDTO> allDataOrder = new ArrayList<>();
        ResultSet rst1 = CrudUtil.executeQuary("SELECT o.orderID,o.time,o.date,d.description,d.discunt,d.qty,d.price,d.odId,d.oitId,d.coId FROM orders as o INNER JOIN orderDetails as d ON o.orderID=d.odId=?;");
while (rst1.next()){
    allDataOrder.add(new CustomOrderDTO(rst1.getString("orderID"),LocalTime.parse(rst1.getString("time")),LocalDate.parse(rst1.getString("date")),rst1.getString("description"),rst1.getInt("discunt"),rst1.getInt("qty"),rst1.getDouble("price"),rst1.getString("oitId"),rst1.getString("coId")));
}
    }

}
