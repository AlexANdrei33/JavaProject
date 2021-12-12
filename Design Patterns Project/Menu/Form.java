package Menu;

public enum Form {
    BUNDT(5), POPS(20), CONICAL(14), CUPCAKE(16), LAYER_CAKE(6), SHEET_CAKE(12), SWISS_ROLLS(4);

    private final int price;
    Form(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
