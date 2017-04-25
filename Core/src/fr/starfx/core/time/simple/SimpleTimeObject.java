package fr.starfx.core.time.simple;

import fr.starfx.core.time.TimeGlobal;
import fr.starfx.core.time.TimeObject;

public class SimpleTimeObject implements TimeObject {

    private final TimeGlobal timeGlobal;

    public SimpleTimeObject(TimeGlobal timeGlobal) {
        this.timeGlobal = timeGlobal;
    }

    @Override
    public TimeGlobal getTimeGlobal() {
        return timeGlobal;
    }

}
