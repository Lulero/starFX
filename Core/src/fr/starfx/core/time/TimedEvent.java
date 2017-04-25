package fr.starfx.core.time;

import fr.starfx.core.property.ValuedObject;
import javafx.beans.property.ObjectProperty;

public interface TimedEvent extends HasGlobalTime, HasEndTime, ValuedObject {

    String START_TIME_PROPERTY_NAME = "Start Time";
    ObjectProperty<Long> startTimeProperty();
    default long getStartTime() { return endTimeProperty().get(); }
    default void setStartTime(long time) { endTimeProperty().setValue(time); }

}
