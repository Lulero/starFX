package fr.starfx.core.time;

import fr.starfx.core.property.ValuedObject;
import javafx.beans.property.ReadOnlyLongProperty;

import java.util.Comparator;

public interface TimeObject extends HasGlobalTime, ValuedObject {

    long getCreationTime();

    // Age
    // ---

    String AGE_PROPERTY_NAME = "Age";

    static long getAge(TimeObject timeObjectObject) {
        final long currentTime = timeObjectObject.getGlobalTime().getCurrentTime();
        final long creationTime = timeObjectObject.getCreationTime();
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

    static Comparator<TimeObject> comparator() {
        return Comparator.comparingLong(TimeObject::getCreationTime);
    }

}
