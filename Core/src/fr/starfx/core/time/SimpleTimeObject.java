package fr.starfx.core.time;

import fr.starfx.core.property.SimpleValuedObject;

public class SimpleTimeObject extends SimpleValuedObject implements TimeObject {

    private final GlobalTime globalTime;
    private final long creationTime;

    public SimpleTimeObject(GlobalTime globalTime) {
        this.globalTime = globalTime;
        creationTime = globalTime.getCurrentTime();
    }

    @Override
    public GlobalTime getGlobalTime() {
        return globalTime;
    }

    @Override
    public long getCreationTime() {
        return creationTime;
    }

}
