package fr.starfx.core.time;

import fr.starfx.core.property.PositiveLongProperty;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public interface TimeGlobal extends TimeObject {

    ZonedDateTime getOrigin();

    PositiveLongProperty currentTimeProperty();

    // Overrides
    // ---------

    @Override
    default TimeGlobal getTimeGlobal() { return this; }

    // Conversion Utilities
    // --------------------

    default ZonedDateTime toZonedDateTime(long timeAsMillis) {
        return getOrigin().plus(timeAsMillis, ChronoUnit.MILLIS);
    }

    default ZonedDateTime getCurrentZonedDateTime() {
        return toZonedDateTime(currentTimeProperty().get());
    }

}
