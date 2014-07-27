package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INT676
 */
public class Customer {

    private int customerId;
    private String name;
    private int creditLimit;
    private String email;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer findById() {
        return Customer.findById(this.customerId);
    }

    public static Customer findById(int id) {
        Customer customer = null;
        try (final Connection con = ConnectionBuilder.getConnection()) {
            final String sqlCmd = "SELECT customer_id, name, credit_limit, email FROM customer where customer_id = ?";
            final PreparedStatement stm = con.prepareStatement(sqlCmd);
            stm.setInt(1, id);
            final ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                mapFieldToObject(rs, customer);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return customer;
    }

    public static List<Customer> findByName(String cond) {
        List<Customer> customers = null;
        Customer customer;
        try (final Connection con = ConnectionBuilder.getConnection()) {
            final String sqlCmd = "SELECT customer_id, name, credit_limit, email FROM customer where name LIKE ?";
            final PreparedStatement stm = con.prepareStatement(sqlCmd);
            stm.setString(1, cond + "%");
            final ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                customer = new Customer();
                mapFieldToObject(rs, customer);
                if (customers == null) {
                    customers = new ArrayList<>();
                }
                customers.add(customer);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return customers;
    }

    public int insertNewCustomer() {
        try (final Connection con = ConnectionBuilder.getConnection()) {
            final String sqlCmd = "INSERT INTO customer (customer_id, name, credit_limit, email, zip, discount_code) "
                    + "VALUES (?, ?, ?, ?, '95117', 'M')";
            final PreparedStatement stm = con.prepareStatement(sqlCmd);
            stm.setInt(1, customerId);
            stm.setString(2, name);
            stm.setInt(3, creditLimit);
            stm.setString(4, email);
            return stm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return -1;
    }

    private static void mapFieldToObject(ResultSet rs, Customer customer) throws SQLException {
        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setCreditLimit(rs.getInt("credit_limit"));
        customer.setName(rs.getString("name"));
        customer.setEmail(rs.getString("email"));
    }
}
