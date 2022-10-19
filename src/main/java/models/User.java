package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
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

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Auto> autos;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<House> houses;

   public User() {
   }

   public User(String name, int age,BigDecimal bankAccount) {
      this.name = name;
      this.age = age;
      this.bankAccount = bankAccount;
      autos = new ArrayList<>();
      houses = new ArrayList<>();

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
              ", autos=" + autos +
              ", houses=" + houses +
              '}';
   }
   public static class UserBuilder {
      private String name;
      private int age;
      private BigDecimal bankAccount;
      public UserBuilder() {
      }

      public UserBuilder setName(String name){
         this.name = name;
         return this;
      }
      public UserBuilder setAge(int age){
         this.age = age;
         return this;
      }
      public UserBuilder setBankAccount(BigDecimal account){
         this.bankAccount = account;
         return this;
      }
      public User build(){
         return new User(name,age,bankAccount);
      }
}

   public User(int id, String name, int age, BigDecimal bankAccount) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.bankAccount = bankAccount;
   }
}
