package fr.starfx.core.time;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.LongBinding;

public interface TimeEntity extends TimeObject {

    long getCreationTime();

    // Age
    // ---

    default long getAge() {
        return currentTimeProperty().get() - getCreationTime();
    }

    LongBinding ageBinding();

    static LongBinding createAgeBinding(TimeEntity timeEntity) {
        return Bindings.createLongBinding(
                timeEntity::getAge,
                timeEntity.currentTimeProperty()
        );
    }

}
