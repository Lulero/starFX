package fr.starfx.sandbox.world;

public class SimpleWordObjectComponent<W extends World, O extends WorldObject<W>> implements WorldObjectComponent<W, O> {

    private final O owner;

    public SimpleWordObjectComponent(O owner) {
        this.owner = owner;
    }

    @Override public O owner() { return owner; }

}
