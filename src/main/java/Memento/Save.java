package Memento;

public class Save {
    private final int id;
    private final String model;
    private final String color;
    private final String brand;

    public Save(int id, String model, String color, String brand) {
        this.id = id;
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


    public String getColor() {
        return color;
    }


    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Save{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
