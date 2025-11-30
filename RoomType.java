public enum RoomType {
    STANDARD(1000),
    DELUXE(2000),
    SUITE(4000);

    private final double price;

    RoomType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

