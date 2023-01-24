package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class UserDaoJDBCImpl extends Util implements UserDao {
    Connection connection = getConnection();
    private Statement st;
    private PreparedStatement ps;

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Users (" +
                " id BIGINT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                " name varchar(50) NOT NULL," +
                " lastName varchar(50) NOT NULL," +
                " age TINYINT(3) NOT NULL)" +
                " ENGINE=InnoDB DEFAULT CHARSET=latin1";
        try {
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String dut = "drop table IF EXISTS Users";
        try {
            ps = connection.prepareStatement(dut);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String su = "INSERT INTO USERS (name, lastName, age)" +
                "VALUES ('" + name + "', '" + lastName + "'," + age + ")";
        try {
            ps = connection.prepareStatement(su);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String rubi = "DELETE FROM USERS WHERE id =" + id;
        try {
            ps = connection.prepareStatement(rubi);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        String gau = "select * from Users";
        ps = connection.prepareStatement(gau);
        ResultSet rs = ps.executeQuery();
        ArrayList<User> res = new ArrayList<>();
        while (rs.next()) {
            Long id = rs.getLong(1);
            String name = rs.getString(2);
            String lastName = rs.getString(3);
            Byte age = rs.getByte(4);
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            res.add(user);
        }
        return res;
    }

    public void cleanUsersTable() {
        String cut = "DELETE FROM USERS";
        try {
            ps = connection.prepareStatement(cut);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
