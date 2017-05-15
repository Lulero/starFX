package fr.starfx.sandbox.world;

public interface WorldObjectComponent<W extends World, O extends WorldObject<W>> {

    O owner();

}
