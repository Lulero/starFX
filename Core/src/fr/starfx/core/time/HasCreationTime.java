package fr.starfx.core.time;

import fr.starfx.core.property.HasMappedObservableValues;
import javafx.beans.property.ReadOnlyLongProperty;

import java.util.Comparator;

public interface HasCreationTime extends HasGlobalTime, HasMappedObservableValues {

    long getCreationTime();

    // Age
    // ---

    String AGE_PROPERTY_NAME = "Age";

    static long getAge(HasCreationTime hasCreationTimeObject) {
        final long currentTime = hasCreationTimeObject.getGlobalTime().getCurrentTime();
        final long creationTime = hasCreationTimeObject.getCreationTime();
        return  currentTime - creationTime;
    }

    default ReadOnlyLongProperty ageProperty() {
        return getReadOnlyLongProperty(
                AGE_PROPERTY_NAME,
                () -> getAge(this),
                getGlobalTime().currentTimeProperty()
        );
    }
    default long getAge() { return ageProperty().get(); }

    // Comparator
    // ----------

    static Comparator<HasCreationTime> comparator() {
        return Comparator.comparingLong(HasCreationTime::getCreationTime);
    }

}
