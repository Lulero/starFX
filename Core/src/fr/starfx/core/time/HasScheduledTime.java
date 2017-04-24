package fr.starfx.core.time;

import fr.starfx.core.property.HasMappedProperties;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;

public interface HasScheduledTime extends HasGlobalTime, HasMappedProperties {

    DoubleProperty scheduledTimeProperty();
    default double getScheduledTime() { return scheduledTimeProperty().get(); }
    default void setScheduledTime(double time) { scheduledTimeProperty().set(time); }

    // Remaining Time Utility
    // ----------------------

    String REMAINING_TIME_PROPERTY_NAME = "Remaining Time";

    static double getRemainingTime(HasScheduledTime hasScheduledTimeObject) {
        final double scheduledTime = hasScheduledTimeObject.getScheduledTime();
        final double currentTime = hasScheduledTimeObject.getGlobalTime().getCurrentTime();
        final double remainingTime = scheduledTime - currentTime;
        return scheduledTime < 0 ? 0 : scheduledTime;
    }

    default ReadOnlyDoubleProperty remainingTimeProperty() {
        ReadOnlyDoubleWrapper wrapper = (ReadOnlyDoubleWrapper) getPropertyMap().get(REMAINING_TIME_PROPERTY_NAME);
        if (wrapper == null) {
            wrapper = new ReadOnlyDoubleWrapper(this, REMAINING_TIME_PROPERTY_NAME);
            wrapper.bind(Bindings.createDoubleBinding(
                    () -> HasScheduledTime.getRemainingTime(this),
                    scheduledTimeProperty(), getGlobalTime().currentTimeProperty()
            ));
            getPropertyMap().put(REMAINING_TIME_PROPERTY_NAME, wrapper);
        }
        return wrapper.getReadOnlyProperty();
    }
    default double getRemainingTime() { return remainingTimeProperty().get(); }

}
