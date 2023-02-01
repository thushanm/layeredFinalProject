package lk.ijse.dmi.dwo.custom.impl;

import lk.ijse.dmi.dwo.custom.CrudDAO;
import lk.ijse.dmi.dwo.custom.CrudUtil;
import lk.ijse.dmi.dto.CustomerDTO;
import lk.ijse.dmi.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CrudDAO<Customer,String> {
    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO customer VALUES(?,?,?,?)",
                customer.getCid(),customer.getName(),customer.getAddress(),customer.getTel_no());

    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE customer SET Name=?, address=?,tel_no=? WHERE cId=?", customer.getCid(),customer.getAddress(),customer.getTel_no());
    }

    @Override
    public boolean delete(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM customer WHERE cId=?",customer.getCid());
    }


    @Override
    public Customer serach(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuary("SELECT * FROM customer");
        ArrayList<Customer> customers = new ArrayList<>();
        while (rst.next()){
            customers.add(new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
        }
        return customers;
    }


}
