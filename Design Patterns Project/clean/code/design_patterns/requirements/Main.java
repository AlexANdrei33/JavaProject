package clean.code.design_patterns.requirements;


import Menu.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<SimpleCake> cakes = new ArrayList<>();
        SimpleCake cake1 =
            new CakeBuilder(false, CakeType.CHOCOLATE).setForm(Form.CONICAL)
                .setFilling(Filling.CREAM_CHEESE)
                .setFrosting(Filling.FONDANT)
                .setDecorations(Decorations.FRUITS)
                .build();
        SimpleCake cake2 =
            new CakeBuilder(false, CakeType.BISCUITS).setForm(Form.LAYER_CAKE)
                .setFilling(Filling.GANACHE)
                .setFrosting(Filling.ITALIAN_MERINGUE)
                .setDecorations(Decorations.NUTS)
                .setDecorations(Decorations.COOKIES)
                .build();
        SimpleCake cake3 =
            new CakeBuilder(false, CakeType.SIMPLE).setForm(Form.BUNDT)
                .setFilling(Filling.BUTTERCREAM)
                .setFrosting(Filling.FONDANT)
                .setDecorations(Decorations.POWDERED_SUGAR)
                .build();
        SimpleCake birthdayCake1 =
            new CakeBuilder(true, CakeType.CHOCOLATE).setForm(Form.SHEET_CAKE)
                .setFilling(Filling.SWISS_MERINGUE)
                .setFrosting(Filling.GANACHE)
                .setDecorations(Decorations.MOLDABLE_FONDANT)
                .setDecorations(Decorations.JELLY_BEANS)
                .setCandles(true)
                .setNumberOfCandles(21)
                .setMessage("LMA")
                .build();
        SimpleCake birthdayCake2 =
            new CakeBuilder(true, CakeType.SIMPLE).setForm(Form.POPS)
                .setFilling(Filling.ITALIAN_MERINGUE)
                .setFrosting(Filling.GANACHE)
                .setDecorations(Decorations.CHOCOLATE_CURLS)
                .setMessage("hepi barsdai tu iu")
                .build();
        SimpleCake birthdayCake3 =
            new CakeBuilder(true, CakeType.BISCUITS).setForm(Form.CONICAL)
                .setFilling(Filling.CREAM_CHEESE)
                .setFrosting(Filling.SWISS_MERINGUE)
                .setDecorations(Decorations.NUTS)
                .setDecorations(Decorations.JELLY_BEANS)
                .setCandles(true)
                .setNumberOfCandles(69)
                .build();
        cakes.add(cake1);
        cakes.add(cake2);
        cakes.add(cake3);
        cakes.add(birthdayCake1);
        cakes.add(birthdayCake2);
        cakes.add(birthdayCake3);

        Visitor v = new PriceVisitor();
        for (SimpleCake c: cakes) {
            System.out.println(c);
            c.accept(v);
        }
    }
}
