import java.math.BigDecimal;
import java.sql.*;

import Fabric.FabricDAO;
import Observer.Observer;
import Observer.UserObserved;
import dao.UserDao;
import dao.UserDaoJDBC;
import enums.TypeDAO;
import models.Auto;
//import models.AutoSeller;
import models.House;
import models.Subscriber;
import models.User;
import models.User.UserBuilder;
//import services.AutoSellerService;
import services.UserService;

import java.sql.SQLException;

public class main {
    public static void main(String[] args){
        UserService userService = new UserService(TypeDAO.HIBERNATE);
        User.UserBuilder userBuilder = new UserBuilder();
        Auto.AutoBuilder autoBuilder = new Auto.AutoBuilder();
        House.HouseBuilder houseBuilder = new House.HouseBuilder();
        User user6 = userBuilder
                .setName("John")
                .setAge(18)
                .setBankAccount(new BigDecimal("3425647434623657"))
                .build();
        System.out.println(user6);
        userService.saveUser(user6);
        System.out.println(user6);
        Auto ferrari = autoBuilder.setBrand("Ferrari")
                .setModel("F1")
                .setColor("Red")
                .build();
        ferrari.setUser(user6);
        user6.addAuto(ferrari);
        Auto ford = autoBuilder
                .setBrand("Ford")
                .setModel("Focus")
                .setColor("Blue")
                .build();
        House house = houseBuilder
                .setAddress("Winston st 34")
                .setArea(36)
                .build();
        house.setUser(user6);
        user6.addHouse(house);
        ford.setUser(user6);
        user6.addAuto(ford);
        userService.updateUser(user6);
        user6.setName("Sasha");
        userService.updateUser(user6);
        userService.deleteUser(user6);
        User user7 = userBuilder
                .setName("John")
                .setAge(56)
                .setBankAccount(new BigDecimal("6625647434623657"))
                .build();
        System.out.println(user7);
        userService.saveUser(user7);
        System.out.println(user7);
        Auto ferrari2 = autoBuilder.setBrand("Ferrari")
                .setModel("F2")
                .setColor("Pink")
                .build();
        ferrari.setUser(user7);
        user7.addAuto(ferrari2);
        Auto ford2 = autoBuilder
                .setBrand("Ford")
                .setModel("Fiesta")
                .setColor("Yellow")
                .build();
        House house2 = houseBuilder
                .setAddress("Blueberry st 45")
                .setArea(36)
                .build();
        house.setUser(user7);
        user7.addHouse(house2);
        ford.setUser(user7);
        user7.addAuto(ford2);
        userService.updateUser(user7);
        user7.setName("Uriy");
        userService.updateUser(user7);
        Observer subscriber1 = new Subscriber("James Smith");
        Observer subscriber2 = new Subscriber("Lukas Gamer");
        userService.addObserver(subscriber1);
        userService.addObserver(subscriber2);
        User user2 = new User("Dima",35, new BigDecimal("4556554427485623"));
        House house3 = new House("Winston st 34",36);
        house2.setUser(user2);
        user2.addHouse(house3);
        Auto maserati = new Auto("Maserati","Pro1", "orange");
        maserati.setUser(user2);
        user2.addAuto(maserati);
        Auto nissan = new Auto("Nissan","GTR", "yellow");
        nissan.setUser(user2);
        user2.addAuto(nissan);
        userService.saveUser(user2);
        userService.updateUser(user2);
        userService.deleteUser(user7);

        UserService userServiceSql = new UserService(TypeDAO.SQL);

        /*User user = new User("Masha",26, new BigDecimal("405844274856231"));
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari","F1", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford","Focus", "black");
        House house = new House("Winston st 34",36);
        house.setUser(user);
        user.addHouse(house);
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
        user.setName("Sasha");
        userService.updateUser(user);
        userService.deleteUser(user);
        User user2 = new User("Dima",35, new BigDecimal("4556554427485623"));
        userService.saveUser(user2);
        House house2 = new House("Winston st 34",36);
        house2.setUser(user2);
        user2.addHouse(house2);
        Auto maserati = new Auto("Maserati","Pro1", "orange");
        maserati.setUser(user2);
        user2.addAuto(maserati);
        Auto nissan = new Auto("Nissan","GTR", "yellow");
        nissan.setUser(user);
        user2.addAuto(nissan);
        userService.updateUser(user2);
        User user3 = new User("Viktoria",28, new BigDecimal("276544274856678"));
        userService.saveUser(user3);
        Auto porsche = new Auto("Porsche","Panamera", "red");
        porsche.setUser(user3);
        user3.addAuto(porsche);
        Auto lexus = new Auto("Lexus","LFA", "pink");
        lexus.setUser(user3);
        user3.addAuto(lexus);
        userService.updateUser(user3);
        AutoSeller seller = new AutoSeller("Brad", "Nissan", 150);
        autoSellerService.saveUser(seller);
        AutoSeller seller2 = new AutoSeller("Vick", "Mazda", 120);
        autoSellerService.saveUser(seller2);
        seller2.setQuantity(180);
        autoSellerService.updateUser(seller2);
        System.out.println(userService.findUser(2)+"\n"+ userService.findUser(2).getAutos());
        System.out.println(autoSellerService.findAll());
UserService userService1 = new UserService(TypeDAO.SQL);
       userService1.saveUser(user);

        System.out.println(userService.findAll());*/
        try
        {
            String url = "jdbc:mysql://localhost:3306/hiberpractice?serverTimezone=Europe/Kiev";
            String username = "root";
            String password = "password";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                userServiceSql.getConnection(conn);
                User lisa = userBuilder
                        .setName("Lisa")
                        .setAge(41)
                        .setBankAccount(new BigDecimal("0825647434623657"))
                        .build();
                userServiceSql.saveUser(lisa);
                System.out.println("Connection to Store DB successful!");


            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            ex.printStackTrace();
        }


    }
}
