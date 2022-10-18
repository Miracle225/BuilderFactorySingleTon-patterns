package models;



import javax.persistence.*;

@Entity
@Table(name = "house")

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String address;

    @Column
    private float area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public House() {
    }

    public House(String address, float area) {
        this.address = address;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", area=" + area +
                '}';
    }

    public static class HouseBuilder {
        private String address;
        private float area;

        public HouseBuilder() {
        }

        public HouseBuilder setAddress(String address){
            this.address= address;
            return this;
        }
        public HouseBuilder setArea(float area){
            this.area=area;
            return this;
        }
        public House build(){
            return new House(address,area);
        }


    }
}

