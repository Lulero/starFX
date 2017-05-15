package fr.starfx.sandbox.sheet.vital;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;

public interface VitalSheet extends ReadOnlyVitalSheet {

    @Override DoubleProperty lifeProperty();
    @Override DoubleProperty energyProperty();
    @Override LongProperty targetTimeProperty();

    default void setLife(double life) { lifeProperty().set(life); }
    default void setEnergy(double energy) { energyProperty().set(energy); }
    default void setTargetTime(long targetTime) { targetTimeProperty().set(targetTime); }

    default void modLife(double delta) { setLife(getLife() + delta); }
    default void modEnergy(double delta) { setEnergy(getEnergy() + delta); }
    default void modTargetTime(long delta) { setTargetTime(getTargetTime() + delta); }

    default void setDelay(long delay) {
        setTargetTime(world().getCurrentTime() + delay);
    }

    ReadOnlyVitalSheet asReadOnly();
}
