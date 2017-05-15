package fr.starfx.sandbox.world;

import javafx.beans.property.ReadOnlyLongProperty;

public interface TargetTimeObject<W extends World> extends WorldObject<W> {

    ReadOnlyLongProperty targetTimeProperty();

    default long getTargetTime() { return targetTimeProperty().get(); }

}
