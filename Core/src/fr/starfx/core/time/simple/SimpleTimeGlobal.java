package fr.starfx.core.time.simple;

import fr.starfx.core.property.PositiveLongProperty;
import fr.starfx.core.time.TimeGlobal;

import java.time.ZonedDateTime;

public class SimpleTimeGlobal implements TimeGlobal {

    private final ZonedDateTime origin;

    private final PositiveLongProperty currentTime
            = new PositiveLongProperty(this, "Current Time");

    public SimpleTimeGlobal(ZonedDateTime origin) {
        this.origin = origin;
    }

    public SimpleTimeGlobal() {
        this(ZonedDateTime.now());
    }

    @Override
    public ZonedDateTime getOrigin() {
        return origin;
    }

    @Override
    public PositiveLongProperty currentTimeProperty() {
        return currentTime;
    }

}
