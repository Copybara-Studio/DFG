package my.sfc;

public class Variable {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Variable{" + "name=" + name + '}';
    }
}
