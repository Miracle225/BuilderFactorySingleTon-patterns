package dao;

import models.Auto;
import models.House;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.sql.Connection;
import java.util.List;

public interface UserDao {

    public User findById(int id);
    public void save(User user);
    public void update(User user);
    public void delete(User user);
    public Auto findAutoById(int id);
    public House findHouseById(int id);
    public List<User> findAll();
   public Connection getConnection(Connection conn);

}
