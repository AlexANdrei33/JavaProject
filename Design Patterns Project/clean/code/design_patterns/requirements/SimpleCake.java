package clean.code.design_patterns.requirements;

import Menu.*;
import java.util.ArrayList;

public class SimpleCake {
    private final CakeType type;
    private final ArrayList<Decorations> decorations;
    private final Filling filling;
    private final Filling frosting;
    private final Form form;

    public SimpleCake(CakeType type, ArrayList<Decorations> decorations, Filling filling,
        Filling frosting, Form form) {
        this.type = type;
        this.decorations = decorations;
        this.filling = filling;
        this.frosting = frosting;
        this.form = form;
    }

    public CakeType getType() {
        return type;
    }

    public ArrayList<Decorations> getDecorations() {
        return decorations;
    }

    public Filling getFilling() {
        return filling;
    }

    public Filling getFrosting() {
        return frosting;
    }

    public Form getForm() {
        return form;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "SimpleCake{" +
            "type= " + type +
            ", decorations= " + decorations +
            ", filling= " + filling +
            ", frosting= " + frosting +
            ", form= " + form +
            '}';
    }
}
