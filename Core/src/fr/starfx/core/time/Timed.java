package fr.starfx.core.time;

import javafx.beans.property.ReadOnlyDoubleProperty;

public interface Timed {

    ReadOnlyDoubleProperty creationTimeProperty();
    default double getCreationTime() { return creationTimeProperty().get(); }

    default double getAge(double currentTime) { return currentTime - getCreationTime(); }

}
