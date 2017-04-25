package fr.starfx.core.time;

import fr.starfx.core.property.ValuedObject;
import javafx.beans.Observable;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyObjectProperty;

import java.util.Comparator;

public interface HasEndTime extends HasGlobalTime, ValuedObject {

    String END_TIME_PROPERTY_NAME = "End Time";
    LongProperty endTimeProperty();
    default long getEndTime() { return endTimeProperty().get(); }
    default void setEndTime(long time) { endTimeProperty().set(time); }

    // Remaining Time
    // --------------

    String REMAINING_TIME_PROPERTY_NAME = "Remaining Time";

    static Long getRemainingTime(HasEndTime hasEndTimeObject) {
        final long endTime = hasEndTimeObject.getEndTime();
        final long currentTime = hasEndTimeObject.getGlobalTime().getCurrentTime();
        final long remainingTime = endTime - currentTime;
        return remainingTime < 0 ? 0 : remainingTime;
    }

    default ReadOnlyObjectProperty<Long> remainingTimeProperty() {
        return getReadOnlyObjectProperty(
                REMAINING_TIME_PROPERTY_NAME,
                () -> HasEndTime.getRemainingTime(this),
                endTimeProperty(), getGlobalTime().currentTimeProperty());
    }
    default Long getRemainingTime() { return remainingTimeProperty().get(); }

    // Comparator and Extractor
    // ------------------------

    static Comparator<HasEndTime> comparator() {
        return Comparator.comparingLong(HasEndTime::getEndTime);
    }

    static Observable[] extractor(HasEndTime hasEndTimeObject) {
        final Observable[] result = new Observable[1];
        result[0] = hasEndTimeObject.endTimeProperty();
        return result;
    }

}
