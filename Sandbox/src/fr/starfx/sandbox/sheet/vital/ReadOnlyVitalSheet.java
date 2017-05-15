package fr.starfx.sandbox.sheet.vital;

import fr.starfx.sandbox.world.TargetTimeObject;
import fr.starfx.sandbox.world.World;
import fr.starfx.sandbox.world.WorldObject;
import fr.starfx.sandbox.world.WorldObjectComponent;
import javafx.beans.property.ReadOnlyDoubleProperty;

public interface ReadOnlyVitalSheet<W extends World, O extends WorldObject<W>>
        extends WorldObjectComponent<W, O> , TargetTimeObject<W> {

    ReadOnlyDoubleProperty lifeProperty();
    ReadOnlyDoubleProperty energyProperty();

    default double getLife() { return lifeProperty().get(); }
    default double getEnergy() { return energyProperty().get(); }

    default long getDelay() { return getTargetTime() - world().getCurrentTime(); }

    @Override default W world() { return owner().world(); }

}
