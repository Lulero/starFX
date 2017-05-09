package fr.starfx.core.time.actor;

import fr.starfx.core.time.TimeObject;

public interface TimeActor extends TimeObject {

    long getCreationTime();
    default long computeAge() { return timeProperty().get() - getCreationTime(); }

}
