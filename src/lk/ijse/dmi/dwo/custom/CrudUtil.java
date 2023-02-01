package lk.ijse.dmi.dwo.custom;

import lk.ijse.dmi.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {
 private static PreparedStatement getPreparedStatement(String sql,Object... args) throws SQLException, ClassNotFoundException {
     DBConnection connection = DBConnection.getInstance();
     PreparedStatement pstm = connection.getConnection().prepareStatement(sql);
     for (int i = 0; i < args.length; i++) {
         pstm.setObject(i + 1, args[i]);
     }
     return pstm;
 }
 public static boolean executeUpdate(String sql,Object... args) throws SQLException, ClassNotFoundException {
     PreparedStatement pstm = getPreparedStatement(sql, args);
     return pstm.executeUpdate()>0;
 } public static ResultSet executeQuary(String sql, Object... args) throws SQLException, ClassNotFoundException {
     PreparedStatement pstm = getPreparedStatement(sql, args);
     return pstm.executeQuery();
 }


}
