package clean.code.design_patterns.requirements;

public interface Visitor {
    public void visit(SimpleCake simpleCake);
    public void visit(BirthdayCake birthdayCake);
}
