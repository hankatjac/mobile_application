package masoud.ca.demo.java8;

public class Car {

    private int price;
    private String color;

    public Car(int price, String color) {
        this.price = price;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
