package models;

import enums.Role;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private int age;
    @Column(name = "bank_account")
    private BigDecimal bankAccount;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<House> houses;

    public User() {
    }

    public User(String name, int age, BigDecimal bankAccount) {
        this.name = name;
        this.age = age;
        this.bankAccount = bankAccount;
        autos = new ArrayList<>();
        houses = new ArrayList<>();

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String name, int age, BigDecimal bankAccount,String login, String password, Role role) {
        this.name = name;
        this.age = age;
        this.bankAccount = bankAccount;
        autos = new ArrayList<>();
        houses = new ArrayList<>();
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
    }

    public void addHouse(House house) {
        house.setUser(this);
        houses.add(house);
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public void removeHouse(House house) {
        houses.remove(house);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public BigDecimal getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BigDecimal bankAccount) {
        this.bankAccount = bankAccount;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bankAccount=" + bankAccount +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", autos=" + autos +
                ", houses=" + houses +
                '}';
    }

    public static class UserBuilder {
        private String name;
        private int age;
        private BigDecimal bankAccount;

        private String login;
        private String password;
        private Role role;

        public UserBuilder() {
        }

        public UserBuilder setLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setRole(Role role) {
            this.role = role;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setBankAccount(BigDecimal account) {
            this.bankAccount = account;
            return this;
        }

        public User build() {
            return new User(name, age, bankAccount,login,password,role);
        }
    }

    public User(int id, String name, int age, BigDecimal bankAccount) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bankAccount = bankAccount;
    }
}
