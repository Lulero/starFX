package fr.starfx.core.time;

import fr.starfx.core.property.HasMappedObservableValues;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;

import java.util.Comparator;

public interface HasScheduledTime extends HasGlobalTime, HasMappedObservableValues {

    String SCHEDULED_TIME_PROPERTY_NAME = "Scheduled Time";
    ObjectProperty<Double> scheduledTimeProperty();
    default Double getScheduledTime() { return scheduledTimeProperty().get(); }
    default void setScheduledTime(Double time) { scheduledTimeProperty().setValue(time); }
    default void unSchedule() { setScheduledTime(null); }
    default boolean isScheduled() { return getScheduledTime() != null; }

    // Remaining Time
    // --------------

    String REMAINING_TIME_PROPERTY_NAME = "Remaining Time";

    static Double getRemainingTime(HasScheduledTime hasScheduledTimeObject) {
        if (!hasScheduledTimeObject.isScheduled()) return null;
        final double scheduledTime = hasScheduledTimeObject.getScheduledTime();
        final double currentTime = hasScheduledTimeObject.getGlobalTime().getCurrentTime();
        final double remainingTime = scheduledTime - currentTime;
        return remainingTime < 0 ? 0 : remainingTime;
    }

    default ReadOnlyObjectProperty<Double> remainingTimeProperty() {
        return getReadOnlyObjectProperty(
                REMAINING_TIME_PROPERTY_NAME,
                () -> HasScheduledTime.getRemainingTime(this),
                scheduledTimeProperty(), getGlobalTime().currentTimeProperty());
    }
    default Double getRemainingTime() { return remainingTimeProperty().get(); }

    // Comparator and Extractor
    // ------------------------

    static Comparator<HasScheduledTime> comparator() {
        return Comparator.comparingDouble(HasScheduledTime::getScheduledTime);
    }

    static Observable[] extractor(HasScheduledTime hasScheduledTimeObject) {
        final Observable[] result = new Observable[1];
        result[0] = hasScheduledTimeObject.scheduledTimeProperty();
        return result;
    }

}
