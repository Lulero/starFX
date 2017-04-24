package fr.starfx.core.time;

import javafx.beans.property.DoubleProperty;


public interface GlobalTime extends HasCreationTime {

    String CURRENT_TIME_PROPERTY_NAME = "Current Time";
    DoubleProperty currentTimeProperty();
    default double getCurrentTime() { return currentTimeProperty().get(); }
    default void setCurrentTime(double time) { currentTimeProperty().set(time); }

    default void incrementCurrentTimeBy(double duration) {
        setCurrentTime(getCurrentTime() + duration);
    }

    // Overrides
    // ---------

    @Override
    default double getCreationTime() { return 0; }

    @Override
    default GlobalTime getGlobalTime() { return this; }

    // Conversion Utilities
    // --------------------

    // TODO conversion to LocalDateTime, ZonedDateTime, JavaFX Duration and whatever else needed

}
