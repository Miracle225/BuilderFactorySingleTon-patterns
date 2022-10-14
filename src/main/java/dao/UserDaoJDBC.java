package dao;

import models.Auto;
import models.House;
import models.User;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoJDBC implements UserDao {


    private Connection conn = null;

    public UserDaoJDBC() {
    }


    public Connection getConnection(Connection conn) {
        if (this.conn == null) {
            this.conn = conn;
        }
        return conn;
    }

    @Override
    public User findById(int id) {
        try (PreparedStatement searchStatement = conn.prepareStatement("SELECT * FROM USERS WHERE id = ?")) {
            searchStatement.setInt(1, id);
            final boolean searchResult = searchStatement.execute();
            if (searchResult) {
                final ResultSet foundMovie = searchStatement.getResultSet();
                if (foundMovie.next()) {
                    final int age = foundMovie.getInt(2);
                    final BigDecimal bank_account = foundMovie.getBigDecimal(3);
                    final String name = foundMovie.getString(4);
                    return new User(id, name, age, bank_account);
                }
            }
            return null;
        } catch (final SQLException exp) {
            exp.printStackTrace();
        }
        return null;
    }


    @Override
    public void save(User user) {
        try (final PreparedStatement insertItemStatement = conn.prepareStatement("INSERT INTO USERS (id, age, bank_account, name) VALUES (?,?, ?, ?)")) {
            insertItemStatement.setInt(1, user.getId());
            insertItemStatement.setInt(2, user.getAge());
            insertItemStatement.setBigDecimal(3, user.getBankAccount());
            insertItemStatement.setString(4, user.getName());
            insertItemStatement.executeUpdate();
        } catch (final SQLException exp) {
            exp.printStackTrace();
        }
        System.out.println("User saved: " + user);

    }

    @Override
    public void update(User user) {
        try (PreparedStatement updateStatement = conn.prepareStatement("UPDATE USERS SET age = ? , bank_account = ?, name = ? WHERE id = ?")) {
            updateStatement.setInt(1, user.getAge());
            updateStatement.setBigDecimal(2, user.getBankAccount());
            updateStatement.setString(3, user.getName());
            updateStatement.setInt(4, user.getId());
            updateStatement.executeUpdate();
        } catch (final SQLException exp) {
            exp.printStackTrace();
        }
        System.out.println("User updated: " + user);
    }

    @Override
    public void delete(User user) {
        int id = user.getId();
        try (final PreparedStatement deleteItemStatement = conn.prepareStatement("DELETE FROM USERS WHERE id = ?")) {
            deleteItemStatement.setInt(1, id);
            deleteItemStatement.executeUpdate();
        } catch (final SQLException exp) {
            exp.printStackTrace();
        }
        System.out.println("User deleted: " + user);

    }

    @Override
    public Auto findAutoById(int id) {
        try (PreparedStatement searchStatement = conn.prepareStatement("SELECT * FROM AUTOS WHERE id = ?")) {
            searchStatement.setInt(1, id);
            final boolean searchResult = searchStatement.execute();
            if (searchResult) {
                final ResultSet foundMovie = searchStatement.getResultSet();
                if (foundMovie.next()) {
                    final String brand = foundMovie.getString(2);
                    final String color = foundMovie.getString(3);
                    final String model = foundMovie.getString(4);
                    return new Auto(brand, color, model);
                }
            }
            return new Auto();
        } catch (final SQLException exp) {
            exp.printStackTrace();
        }

        System.out.println("This is your AutoID: " + id);
        return null;
    }

    @Override
    public House findHouseById(int id) {
        try (PreparedStatement searchStatement = conn.prepareStatement("SELECT * FROM HOUSE WHERE id = ?")) {
            searchStatement.setInt(1, id);
            final boolean searchResult = searchStatement.execute();
            if (searchResult) {
                final ResultSet foundMovie = searchStatement.getResultSet();
                if (foundMovie.next()) {
                    final String address = foundMovie.getString(2);
                    final float area = foundMovie.getFloat(3);
                    return new House(address, area);
                }
            }
            return new House();
        } catch (final SQLException exp) {
            exp.printStackTrace();
        }
        System.out.println("This is your HouseID: " + id);
        return null;
    }

    @Override
    public List<User> findAll() {
        System.out.println("Finding all users");
        try (final Statement allStatement = conn.createStatement()) {
            final String sql = "SELECT * FROM MOVIES";
            final ResultSet rs = allStatement.executeQuery(sql);
            final List<User> users = new ArrayList<>();
            while (rs.next()) {
                final int id = rs.getInt(1);
                final int age = rs.getInt(2);
                final BigDecimal bank_account = rs.getBigDecimal(3);
                final String name = rs.getString(4);
                users.add(new User(id, name, age, bank_account));
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


