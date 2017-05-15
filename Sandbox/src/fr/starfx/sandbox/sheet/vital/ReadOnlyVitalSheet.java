package fr.starfx.sandbox.sheet.vital;

import fr.starfx.sandbox.world.World;
import fr.starfx.sandbox.world.WorldObject;
import fr.starfx.sandbox.world.WorldObjectComponent;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyLongProperty;

public interface ReadOnlyVitalSheet<W extends World, O extends WorldObject<W>> extends WorldObjectComponent<W, O> {

    ReadOnlyDoubleProperty lifeProperty();
    ReadOnlyDoubleProperty energyProperty();
    ReadOnlyLongProperty targetTimeProperty();

    default double getLife() { return lifeProperty().get(); }
    default double getEnergy() { return energyProperty().get(); }
    default long getTargetTime() { return targetTimeProperty().get(); }

    default long getDelay() { return getTargetTime() - owner().world().getCurrentTime(); }

}
