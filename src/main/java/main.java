import java.math.BigDecimal;
import java.sql.*;

import Fabric.FabricDAO;
import Memento.File;
import Observer.Observer;
import Observer.UserObserved;
import dao.AutoDao;
import dao.UserDao;
import dao.UserDaoJDBC;
import enums.Role;
import enums.TypeDAO;
import models.Auto;
import models.House;
import models.Subscriber;
import models.User;
import models.User.UserBuilder;
import services.AutoService;
import services.UserService;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        UserService userService = new UserService(TypeDAO.HIBERNATE);
        User.UserBuilder userBuilder = new UserBuilder();
        Auto.AutoBuilder autoBuilder = new Auto.AutoBuilder();
        House.HouseBuilder houseBuilder = new House.HouseBuilder();
        AutoService autoService = new AutoService();
        //*----------------------------------------------------------------------*
        //Test Memento
        /*
       Auto ferrari = autoBuilder.setBrand("Ferrari")
                .setModel("F1")
                .setColor("Red")
                .build();
        File file = new File();
        file.saveAuto(ferrari.save());
        System.out.println(ferrari.toString());
        ferrari=autoBuilder.setColor("Yellow")
                .build();
        System.out.println(ferrari.toString());
        file.saveAuto(ferrari.save());
        System.out.println(file.toString());
        ferrari=autoBuilder.setBrand("Ford")
                        .setModel("Fiesta")
                                .build();
        System.out.println(ferrari.toString());
        file.saveAuto(ferrari.save());
        System.out.println(file.toString());
        ferrari.CancelAction(file.CancelAction());
        ferrari.CancelAction(file.CancelAction());
        System.out.println(ferrari.toString());
        System.out.println(file.toString());
        ferrari=autoBuilder.setBrand("Lamborgini")
                .setModel("Aventador")
                .build();
        file.saveAuto(ferrari.save());
        System.out.println(ferrari.toString());
        ferrari.CancelAction(file.CancelAction());
        System.out.println(ferrari.toString());
        System.out.println(file.toString());
        */
        //*----------------------------------------------------------------------*

        //*----------------------------------------------------------------------*
        //Test Proxy
        /*
        User user6 = userBuilder
                .setName("John")
                .setAge(18)
                .setBankAccount(new BigDecimal("3425647434623657"))
                .setLogin("ishchenko44@gmail.com")
                .setPassword("qwerty123456")
                .setRole(Role.USER)
                .build();
        userService.saveUser(user6, user6.getRole());
        System.out.println(userService.findAll());
        User user7 = userBuilder
                .setName("John")
                .setAge(18)
                .setBankAccount(new BigDecimal("3425647434623657"))
                .setLogin("ishchenko44@gmail.com")
                .setPassword("qwerty123456")
                .setRole(Role.ADMIN)
                .build();
        userService.saveUser(user7, user7.getRole());
        System.out.println(userService.findAll());
        User user8 = userBuilder
                .setName("John")
                .setAge(18)
                .setBankAccount(new BigDecimal("3425547434623657"))
                .setLogin("ishchenko44@gmail.com")
                .setPassword("qwerty123456")
                .setRole(Role.USER)
                .build();
        userService.saveUser(user8, user8.getRole());
        System.out.println(userService.findAll());
        User user9 = userBuilder
                .setName("John")
                .setAge(18)
                .setBankAccount(new BigDecimal("3425647434623657"))
                .setLogin("ishchenko44@gmail.com")
                .setPassword("qwerty123456")
                .setRole(Role.ADMIN)
                .build();
        userService.saveUser(user9, user9.getRole());
        System.out.println(userService.findAll());
        */
        //*----------------------------------------------------------------------*

        //*----------------------------------------------------------------------*
        //Test Observer
        /*User user6 = userBuilder
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
*/
        //*----------------------------------------------------------------------*

        //*----------------------------------------------------------------------*
        //Test Factory
        /*
        UserService userServiceSql = new UserService(TypeDAO.SQL);
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
                        .setLogin("ishchenko44@gmail.com")
                        .setPassword("qwerty123456")
                        .setRole(Role.USER)
                        .build();
                userServiceSql.saveUser(lisa,lisa.getRole());
                System.out.println("Connection to Store DB successful!");


            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            ex.printStackTrace();
        }

*/
        //*----------------------------------------------------------------------*

    }
}
