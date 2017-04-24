package fr.starfx.core.time;

import javafx.beans.property.DoubleProperty;

public interface Schedulable {

    DoubleProperty scheduledTimeProperty();
    default double getScheduledTime() { return scheduledTimeProperty().get(); }
    default void setScheduledTime(double time) { scheduledTimeProperty().set(time); }

    default double getRemainingTime(double currentTime) {
        final double scheduledTime = getScheduledTime();
        if (scheduledTime > currentTime) return 0;
        return currentTime - scheduledTime;
    }

}
