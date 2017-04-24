package fr.starfx.core.time;

import fr.starfx.core.property.ValuedObject;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;

import java.util.Comparator;

public interface HasScheduledTime extends HasGlobalTime, ValuedObject {

    String SCHEDULED_TIME_PROPERTY_NAME = "Scheduled Time";
    ObjectProperty<Long> scheduledTimeProperty();
    default Long getScheduledTime() { return scheduledTimeProperty().get(); }
    default void setScheduledTime(Long time) { scheduledTimeProperty().setValue(time); }
    default void unSchedule() { setScheduledTime(null); }
    default boolean isScheduled() { return getScheduledTime() != null; }

    // Remaining Time
    // --------------

    String REMAINING_TIME_PROPERTY_NAME = "Remaining Time";

    static Long getRemainingTime(HasScheduledTime hasScheduledTimeObject) {
        if (!hasScheduledTimeObject.isScheduled()) return null;
        final long scheduledTime = hasScheduledTimeObject.getScheduledTime();
        final long currentTime = hasScheduledTimeObject.getGlobalTime().getCurrentTime();
        final long remainingTime = scheduledTime - currentTime;
        return remainingTime < 0 ? 0 : remainingTime;
    }

    default ReadOnlyObjectProperty<Long> remainingTimeProperty() {
        return getReadOnlyObjectProperty(
                REMAINING_TIME_PROPERTY_NAME,
                () -> HasScheduledTime.getRemainingTime(this),
                scheduledTimeProperty(), getGlobalTime().currentTimeProperty());
    }
    default Long getRemainingTime() { return remainingTimeProperty().get(); }

    // Comparator and Extractor
    // ------------------------

    static Comparator<HasScheduledTime> comparator() {
        return Comparator.comparingLong(HasScheduledTime::getScheduledTime);
    }

    static Observable[] extractor(HasScheduledTime hasScheduledTimeObject) {
        final Observable[] result = new Observable[1];
        result[0] = hasScheduledTimeObject.scheduledTimeProperty();
        return result;
    }

}
