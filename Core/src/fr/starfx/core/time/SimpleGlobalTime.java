package fr.starfx.core.time;

import fr.starfx.core.property.SimpleValuedObject;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

import java.time.ZonedDateTime;

public class SimpleGlobalTime extends SimpleValuedObject implements GlobalTime {

    private final ZonedDateTime origin;

    private LongProperty currentTime = new SimpleLongProperty(
            this,
            CURRENT_TIME_PROPERTY_NAME,
            getCreationTime()
    );

    public SimpleGlobalTime(ZonedDateTime origin) {
        this.origin = origin;
    }

    public SimpleGlobalTime() {
        this(ZonedDateTime.now());
    }

    @Override
    public ZonedDateTime getOrigin() {
        return origin;
    }

    @Override
    public LongProperty currentTimeProperty() {
        return currentTime;
    }

}
