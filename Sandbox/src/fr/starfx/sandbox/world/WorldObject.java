package fr.starfx.sandbox.world;

import fr.starfx.sandbox.common.NamedObject;

public interface WorldObject<T extends World> extends NamedObject {

    T world();

}
