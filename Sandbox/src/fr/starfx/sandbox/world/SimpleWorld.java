package fr.starfx.sandbox.world;

import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;

public class SimpleWorld implements World {

    private final ReadOnlyLongWrapper currentTimeWrapper
            = new ReadOnlyLongWrapper(this, "Current Time", 0);
    private final ReadOnlyLongProperty currentTime = currentTimeWrapper.getReadOnlyProperty();

    @Override public ReadOnlyLongProperty currentTimeProperty() { return currentTime; }

}
