package Fabric;

import dao.UserDao;
import dao.UserDaoHibernate;
import dao.UserDaoJDBC;
import enums.TypeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricDAO {
    public static UserDao getUserDAO(TypeDAO typeDAO){
        UserDao userDao = null;
        switch (typeDAO) {
            case HIBERNATE -> userDao = new UserDaoHibernate();
            case SQL -> userDao = new UserDaoJDBC();
        }
                    return userDao;
                }
        }
