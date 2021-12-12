package Menu;

public enum CakeType {
    SIMPLE(5), CHOCOLATE(10), BISCUITS(15);

    private final int price;
    CakeType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
