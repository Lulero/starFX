package fr.starfx.sandbox.world;

import javafx.beans.property.ReadOnlyLongProperty;

public interface World {

    ReadOnlyLongProperty currentTimeProperty();

    default long getCurrentTime() { return currentTimeProperty().get(); }

}
