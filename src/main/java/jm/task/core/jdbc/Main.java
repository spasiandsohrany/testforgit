package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Nikita", "Kazakov", (byte) 22);
        userService.saveUser("Nikita", "Pirogov", (byte) 22);
        userService.saveUser("Nikita", "Pirogov", (byte) 24);
        userService.removeUserById(1);
        System.out.println(userService.getAllUsers());
        //userService.cleanUsersTable();
    }
}
