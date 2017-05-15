package fr.starfx.sandbox;

import fr.starfx.sandbox.common.NamedObject;

public class WorldObject extends NamedObject {

    private final World world;
    private final long birthDate;

    public WorldObject(World world, String name) {
        super(name);
        this.world = world;
        this.birthDate = world.getCurrentTime();
    }

    public World world() {
        return world;
    }

    public long birthDate() {
        return birthDate;
    }
}
