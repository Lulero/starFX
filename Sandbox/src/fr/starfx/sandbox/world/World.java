package fr.starfx.sandbox.world;

import fr.starfx.sandbox.common.NamedObject;
import javafx.beans.property.ReadOnlyLongProperty;

public interface World extends NamedObject {

    ReadOnlyLongProperty currentTimeProperty();

    default long getCurrentTime() { return currentTimeProperty().get(); }

}
