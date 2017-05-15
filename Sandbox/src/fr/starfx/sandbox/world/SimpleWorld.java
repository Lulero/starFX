package fr.starfx.sandbox.world;

import fr.starfx.sandbox.common.SimpleNamedObject;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;

public class SimpleWorld extends SimpleNamedObject implements World {

    private final ReadOnlyLongWrapper currentTimeWrapper
            = new ReadOnlyLongWrapper(this, "Current Time", 0);
    private final ReadOnlyLongProperty currentTime = currentTimeWrapper.getReadOnlyProperty();

    public SimpleWorld(String name) {
        super(name);
    }

    @Override public ReadOnlyLongProperty currentTimeProperty() { return currentTime; }

}
