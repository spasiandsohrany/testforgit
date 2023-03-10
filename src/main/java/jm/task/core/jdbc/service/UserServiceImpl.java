package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    //private final UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    private final UserDao userDaoHibernate = new UserDaoHibernateImpl();

    public UserServiceImpl() {

    }

    public void createUsersTable() throws SQLException {
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(1);
    }

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        return userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
    }
}
