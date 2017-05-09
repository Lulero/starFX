package fr.starfx.sandbox.common;


public class NamedObject {

    private final String name;

    public NamedObject(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "'" + name + "'";
    }
}
