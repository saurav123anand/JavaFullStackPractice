package interfaceEnumTask;

public class Furniture {
    private String color;
    private double price;
    private double discountedPrice;
    private FurnitureType furnitureType;

    public Furniture(String color, double price, FurnitureType furnitureType) {
        this.color = color;
        this.price = price;
        this.furnitureType = furnitureType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public FurnitureType getFurnitureType() {
        return furnitureType;
    }

    public void setFurnitureType(FurnitureType furnitureType) {
        this.furnitureType = furnitureType;
    }
}
