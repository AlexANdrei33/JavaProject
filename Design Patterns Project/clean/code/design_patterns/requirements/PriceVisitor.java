package clean.code.design_patterns.requirements;

import Menu.Decorations;

public class PriceVisitor implements Visitor{
    @Override
    public void visit(SimpleCake s) {
        int price = s.getType().getPrice()
                    + s.getFilling().getPrice()
                    + s.getFrosting().getPrice()
                    + s.getForm().getPrice();
        for (Decorations d: s.getDecorations()) {
            price += d.getPrice();
        }
        System.out.println("Price of the cake is: " + price);
    }

    @Override
    public void visit(BirthdayCake b) {
        int price = b.getType().getPrice()
                    + b.getFilling().getPrice()
                    + b.getFrosting().getPrice()
                    + b.getForm().getPrice()
                    + b.getMessagePrice()
                    + b.getCandlesPrice();
        for (Decorations d: b.getDecorations()) {
            price += d.getPrice();
        }
        System.out.println("Price of the cake is: " + price);
    }
}
