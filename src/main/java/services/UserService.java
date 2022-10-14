package services;

import Fabric.FabricDAO;
import dao.UserDao;
import dao.UserDaoHibernate;
import enums.TypeDAO;
import models.Auto;
import models.House;
import models.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDao userDao;
    public UserService() {
    }

    public UserService(TypeDAO typeDAO) {
         userDao = FabricDAO.getUserDAO(typeDAO);
    }

    public User findUser(int id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public Auto findAutoById(int id) {
        return userDao.findAutoById(id);
    }

    public House findHouseById(int id) {
        return userDao.findHouseById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
    public Connection getConnection(Connection conn){
        return userDao.getConnection(conn);
    }
}
