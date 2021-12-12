package clean.code.design_patterns.requirements;

import Menu.CakeType;
import Menu.Decorations;
import Menu.Filling;
import Menu.Form;
import java.util.ArrayList;

public class BirthdayCake extends SimpleCake{
    private final String message;
    private final boolean candles;
    private final int numberOfCandles;
    private final int messagePrice;
    private final int candlesPrice;

    public BirthdayCake(CakeType type, ArrayList<Decorations> decorations,
        Filling filling, Filling frosting, Form form, String message, boolean candles,
        int numberOfCandles, int messagePrice, int candlesPrice) {
        super(type, decorations, filling, frosting, form);
        this.message = message;
        this.candles = candles;
        this.numberOfCandles = numberOfCandles;
        this.messagePrice = messagePrice;
        this.candlesPrice = candlesPrice;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCandles() {
        return candles;
    }

    public int getNumberOfCandles() {
        return numberOfCandles;
    }

    public int getMessagePrice() {
        return messagePrice;
    }

    public int getCandlesPrice() {
        return candlesPrice;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "BirthdayCake{" +
            "type= " + super.getType() +
            ", decorations= " + super.getDecorations() +
            ", filling= " + super.getFilling() +
            ", frosting= " + super.getFrosting() +
            ", form= " + super.getForm() +
            "message= '" + message + '\'' +
            ", candles= " + candles +
            ", numberOfCandles= " + numberOfCandles +
            ", messagePrice= " + messagePrice +
            ", candlesPrice= " + candlesPrice +
            '}';
    }
}
