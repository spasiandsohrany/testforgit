package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Util.getSessionFactory();
        //Util util = new Util();
        //Util.getConnection();
        //UserDao userDao = new UserDaoJDBCImpl();
        //System.out.println(userDao.getAllUsers());
        /*userDao.dropUsersTable();
        userDao.createUsersTable();
        userDao.saveUser("In", "Ib", (byte) 21);
        //userDao.cleanUsersTable();*/
    }
}
