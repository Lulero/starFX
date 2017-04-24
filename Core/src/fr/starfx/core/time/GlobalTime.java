package fr.starfx.core.time;

import javafx.beans.property.LongProperty;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;


public interface GlobalTime extends TimeObject {

    ZonedDateTime getOrigin();

    String CURRENT_TIME_PROPERTY_NAME = "Current Time";
    LongProperty currentTimeProperty();
    default long getCurrentTime() { return currentTimeProperty().get(); }
    default void setCurrentTime(long timeAsMillis) { currentTimeProperty().set(timeAsMillis); }

    default void incrementCurrentTimeBy(long duration) {
        setCurrentTime(getCurrentTime() + duration);
    }

    // Overrides
    // ---------

    @Override
    default long getCreationTime() { return 0; }

    @Override
    default GlobalTime getGlobalTime() { return this; }

    // Conversion Utilities
    // --------------------

    default ZonedDateTime toZonedDateTime(long timeAsMillis) {
        return getOrigin().plus(timeAsMillis, ChronoUnit.MILLIS);
    }

    default ZonedDateTime getCurrentZonedDateTime() {
        return toZonedDateTime(getCurrentTime());
    }

    default long toEpochSeconds(long timeAsMillis) {
        return toZonedDateTime(timeAsMillis).toEpochSecond();
    }

    default long getCurrentEpochSeconds() {
        return getCurrentZonedDateTime().toEpochSecond();
    }

}
