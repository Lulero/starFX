package fr.starfx.sandbox;

import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;

public class World {

    private final ReadOnlyLongWrapper currentTimeWrapper
            = new ReadOnlyLongWrapper(this, "Current Time", 0);
    private final ReadOnlyLongProperty currentTime = currentTimeWrapper.getReadOnlyProperty();

    public long getCurrentTime() {
        return currentTime.get();
    }

    public ReadOnlyLongProperty currentTimeProperty() {
        return currentTime;
    }

}
