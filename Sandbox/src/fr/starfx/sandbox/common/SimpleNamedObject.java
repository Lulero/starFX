package fr.starfx.sandbox.common;

public class SimpleNamedObject implements NamedObject {

    private final String name;

    public SimpleNamedObject(String name) {
        this.name = name;
    }

    @Override public String name() {
        return name;
    }

}
