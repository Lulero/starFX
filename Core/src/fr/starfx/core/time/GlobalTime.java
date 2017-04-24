package fr.starfx.core.time;

import javafx.beans.property.LongProperty;

import java.time.ZonedDateTime;


public interface GlobalTime extends HasCreationTime {

    ZonedDateTime getOrigin();

    String CURRENT_TIME_PROPERTY_NAME = "Current Time";
    LongProperty currentTimeProperty();
    default long getCurrentTime() { return currentTimeProperty().get(); }
    default void setCurrentTime(long time) { currentTimeProperty().set(time); }

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

    // TODO conversion to LocalDateTime, ZonedDateTime, JavaFX Duration and whatever else needed

}
