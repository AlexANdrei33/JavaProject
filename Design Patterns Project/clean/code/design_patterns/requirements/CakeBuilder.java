package clean.code.design_patterns.requirements;

import Menu.*;
import java.util.ArrayList;

public class CakeBuilder {
    private final boolean birthday;
    private final CakeType cakeType;
    private final ArrayList<Decorations> decorations = new ArrayList<>();
    private Filling filling;
    private Filling frosting;
    private Form form;
    private String message;
    private boolean candles = false;
    private int numberOfCandles;
    private int messagePrice = 0;
    private int candlesPrice = 0;

    public CakeBuilder(boolean birthday, CakeType cakeType) {
        this.birthday = birthday;
        this.cakeType = cakeType;
    }

    public CakeBuilder setDecorations(Decorations decoration) {
        decorations.add(decoration);
        return this;
    }

    public CakeBuilder setFilling(Filling filling) {
        this.filling = filling;
        return this;
    }

    public CakeBuilder setFrosting(Filling frosting) {
        this.frosting = frosting;
        return this;
    }

    public CakeBuilder setForm(Form form) {
        this.form = form;
        return this;
    }

    public CakeBuilder setMessage(String message) {
        if (this.birthday) {
            this.message = message;
            this.messagePrice += 5;
        }
        return this;
    }

    public CakeBuilder setCandles(boolean candles) {
        if (this.birthday) {
            this.candles = candles;
        }
        return this;
    }

    public CakeBuilder setNumberOfCandles(int numberOfCandles) {
        if(this.birthday && this.candles) {
            this.numberOfCandles = numberOfCandles;
            this.candlesPrice += 2 * numberOfCandles;
        }
        return this;
    }

    public SimpleCake build() {
        if(this.birthday) {
            return new BirthdayCake(cakeType, decorations, filling, frosting,
                form, message, candles, numberOfCandles, messagePrice, candlesPrice);
        }

        return new SimpleCake(cakeType, decorations, filling, frosting,
                        form);
    }
}
