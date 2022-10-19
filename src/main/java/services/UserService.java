package services;

import Fabric.FabricDAO;
import Observer.Observer;
import dao.UserDao;
import dao.UserDaoHibernate;
import enums.TypeDAO;
import models.Auto;
import models.House;
import models.User;
import Observer.UserObserved;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDao userDao;
UserObserved userObserved = new UserObserved();
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
        userObserved.addUser(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(User user) {

        userDao.delete(user);
        userObserved.removeUser(user);
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
    public void addObserver(Observer observer){
       userObserved.addObserver(observer);
    }
    public void removeObserver(Observer observer){
        userObserved.removeObserver(observer);
    }

}
