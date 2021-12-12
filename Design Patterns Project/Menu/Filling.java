package Menu;

public enum Filling{
    BUTTERCREAM(10), SWISS_MERINGUE(30), ITALIAN_MERINGUE(25), CREAM_CHEESE(23), WHIPPED_CREAM(9), GANACHE(32), FONDANT(50);

    private final int price;
    Filling(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
