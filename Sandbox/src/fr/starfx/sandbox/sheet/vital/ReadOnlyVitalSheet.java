package fr.starfx.sandbox.sheet.vital;

import fr.starfx.sandbox.world.TargetTimeObject;
import javafx.beans.property.ReadOnlyDoubleProperty;

public interface ReadOnlyVitalSheet extends TargetTimeObject {

    ReadOnlyDoubleProperty lifeProperty();
    ReadOnlyDoubleProperty energyProperty();

    default double getLife() { return lifeProperty().get(); }
    default double getEnergy() { return energyProperty().get(); }

    default long getDelay() {
        return getTargetTime() - world().getCurrentTime();
    }

}
