package fr.starfx.core.time;

import fr.starfx.core.property.HasMappedObservableValues;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;

import java.util.Comparator;

public interface HasCreationTime extends HasGlobalTime, HasMappedObservableValues {

    double getCreationTime();

    // Age
    // ---

    String AGE_PROPERTY_NAME = "Age";

    static double getAge(HasCreationTime hasCreationTimeObject) {
        final double currentTime = hasCreationTimeObject.getGlobalTime().getCurrentTime();
        final double creationTime = hasCreationTimeObject.getCreationTime();
        return  currentTime - creationTime;
    }

    default ReadOnlyDoubleProperty ageProperty() {
        ReadOnlyDoubleWrapper wrapper = (ReadOnlyDoubleWrapper) getObservableValueMap().get(AGE_PROPERTY_NAME);
        if (wrapper == null) {
            wrapper = new ReadOnlyDoubleWrapper(this, AGE_PROPERTY_NAME);
            wrapper.bind(Bindings.createDoubleBinding(
                    () -> HasCreationTime.getAge(this),
                    getGlobalTime().currentTimeProperty()
            ));
            getObservableValueMap().put(AGE_PROPERTY_NAME, wrapper);
        }
        return wrapper.getReadOnlyProperty();
    }
    default double getAge() { return ageProperty().get(); }

    // Comparator
    // ----------

    static Comparator<HasCreationTime> comparator() {
        return Comparator.comparingDouble(HasCreationTime::getCreationTime);
    }

}