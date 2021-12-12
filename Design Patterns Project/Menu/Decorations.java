package Menu;

public enum Decorations {
    FRUITS(15), JELLY_BEANS(12), MOLDABLE_FONDANT(20), POWDERED_SUGAR(3), NUTS(7), COOKIES(13), CHOCOLATE_CURLS(17),
    SPUN_SUGAR(25), SPRINKLES(5);

    private final int price;
    Decorations(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
