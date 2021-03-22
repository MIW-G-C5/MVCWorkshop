package javadb;

import model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO extends AbstractDAO {

    public CustomerDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void storeCustomer(Customer customer) {
        String sql = "Insert into Klant(voorletters, voorvoegsels, achternaam, telefoon) values(?,?,?,?) ;";
        try {
            setupPreparedStatementWithKey(sql);
            preparedStatement.setString(1, customer.getInitials());
            preparedStatement.setString(2, customer.getPrefix());
            preparedStatement.setString(3, customer.getSurName());
            preparedStatement.setString(4, customer.getMobilePhone());
            int key = executeInsertStatementWithKey();
            customer.setCustomerId(key);
        } catch (SQLException e) {
            System.out.println("SQL error " + e.getMessage());
        }
    }

    public void updateCustomer(Customer customer) {
        String sql = "Update Klant Set voorletters = ?, voorvoegsels = ?, achternaam = ?, telefoon = ? where klantnr = ?;";
        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, customer.getInitials());
            preparedStatement.setString(2, customer.getPrefix());
            preparedStatement.setString(3, customer.getSurName());
            preparedStatement.setString(4, customer.getMobilePhone());
            preparedStatement.setInt(5, customer.getCustomerId());
            executeManipulateStatement();
        } catch (SQLException e) {
            System.out.println("SQL error " + e.getMessage());
        }
    }

    public Customer getCustomerById(int custId) {

        String sql = "Select * From Klant Where klantnr = ?";
        Customer result = null;
        try {
            setupPreparedStatement(sql);
            preparedStatement.setInt(1, custId);
            ResultSet rs = executeSelectStatement();
            if (rs.next()) {
                String initials = rs.getString("voorletters");
                String prefix = rs.getString("voorvoegsels");
                String surName = rs.getString("achternaam");
                String mobile = rs.getString("telefoon");
                result = new Customer(initials, prefix, surName, mobile);
                result.setCustomerId(custId);
            } else {
                System.out.println("Klant met dit klantnummer bestaat niet");
            }

        }
        catch (SQLException e){
            System.out.println("SQL error " + e.getMessage());
        }
        return result;
    }

    public List<Customer> getAllCustomers() {

        String sql = "Select * From Klant";
        List<Customer> result = new ArrayList<>();
        try {
            setupPreparedStatement(sql);
            ResultSet rs = executeSelectStatement();
            Customer customer;
            while (rs.next()) {
                String initials = rs.getString("voorletters");
                String prefix = rs.getString("voorvoegsels");
                String surName = rs.getString("achternaam");
                String mobile = rs.getString("telefoon");
                customer = new Customer(initials, prefix, surName, mobile);
                customer.setCustomerId(rs.getInt("klantnr")); 
                result.add(customer);
            }
        } catch (SQLException e){
                System.out.println("SQL error " + e.getMessage());
            }
        return  result;
    }

}
