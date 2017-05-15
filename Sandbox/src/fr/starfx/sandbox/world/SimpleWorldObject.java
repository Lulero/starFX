package fr.starfx.sandbox.world;

import fr.starfx.sandbox.common.SimpleNamedObject;

public class SimpleWorldObject<T extends World> extends SimpleNamedObject implements WorldObject<T> {

    private final T world;

    public SimpleWorldObject(T world, String name) {
        super(name);
        this.world = world;
    }

    public T world() {
        return world;
    }

}
