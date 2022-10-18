package models;


import javax.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String model;


    private String color;
    @Column(name = "brand")
    private String brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto() {
    }

    public Auto(String brand, String model, String color) {
        this.model = model;
        this.color = color;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return color + " " + brand + " " + model;
    }
    public static class AutoBuilder {
        private String model;
        private String color;
        private String brand;
        public AutoBuilder() {
        }

        public AutoBuilder setBrand(String brand) {
           this.brand = brand;
            return this;
        }

        public AutoBuilder setColor(String color) {
           this.color = color;
            return this;
        }


        public AutoBuilder setModel(String model) {
            this.model = model;
            return this;
        }
        public Auto build(){
            return new Auto(brand,color,model);
        }

        @Override
        public String toString() {
            return "AutoBuilder{" +
                    "model='" + model + '\'' +
                    ", color='" + color + '\'' +
                    ", brand='" + brand + '\'' +
                    '}';
        }
    }

}

