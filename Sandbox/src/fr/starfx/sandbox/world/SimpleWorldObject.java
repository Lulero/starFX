package fr.starfx.sandbox.world;


public class SimpleWorldObject<T extends World> implements WorldObject<T> {

    private final T world;

    public SimpleWorldObject(T world) {
        this.world = world;
    }

    public T world() {
        return world;
    }

}
