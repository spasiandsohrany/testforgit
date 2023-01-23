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
            st = connection.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            try {
                connection.close();
                st.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }*/
    }

    public void dropUsersTable() {
        String dut = "drop table IF EXISTS Users";
        try {
            st = connection.createStatement();
            st.executeUpdate(dut);
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            try {
                connection.close();
                st.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }*/
    }

    public void saveUser(String name, String lastName, byte age) {
        String su = "INSERT INTO USERS (name, lastName, age)" +
                "VALUES ('"+ name +"', '" + lastName + "'," + age + ")";
        try {
            st = connection.createStatement();
            st.executeUpdate(su);
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }*/
    }

    public void removeUserById(long id) {
        String rubi = "DELETE FROM USERS WHERE id =" + id;
        try {
            st = connection.createStatement();
            st.executeUpdate(rubi);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        String gau = "select * from Users";
            ps = connection.prepareStatement(gau);
            ResultSet rs = ps.executeQuery();
            /*st = connection.createStatement();
            ResultSet rs = st.executeQuery(gau);*/
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
        /*catch (SQLException e) {
            e.printStackTrace();
        } *//*finally {
            try {
                connection.close();
                st.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }*/
    }

    public void cleanUsersTable() {
        String cut = "DELETE FROM USERS";
        try {
            st = connection.createStatement();
            st.executeUpdate(cut);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
