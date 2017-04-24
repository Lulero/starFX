package fr.starfx.core.time;

import javafx.beans.property.DoubleProperty;


public interface GlobalTime {

    double getOrigin();

    DoubleProperty currentTimeProperty();
    default double getCurrentTime() { return currentTimeProperty().get(); }
    default void setCurrentTime(double time) { currentTimeProperty().set(time); }

    // Utilities
    // ---------

    default void incrementCurrentTime(double duration) {
        setCurrentTime(getCurrentTime() + duration);
    }

}
