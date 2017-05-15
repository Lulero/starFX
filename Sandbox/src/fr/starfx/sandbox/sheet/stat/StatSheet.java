package fr.starfx.sandbox.sheet.stat;

import fr.starfx.sandbox.world.World;
import fr.starfx.sandbox.world.WorldObject;
import javafx.beans.property.DoubleProperty;

public interface StatSheet<W extends World, O extends WorldObject<W>> extends ReadOnlyStatSheet<W, O> {

    @Override DoubleProperty attackProperty();
    @Override DoubleProperty defenseProperty();
    @Override DoubleProperty speedProperty();
    @Override DoubleProperty specialProperty();

    default void setAttack(double value) { attackProperty().set(value); }
    default void setDefense(double value) { defenseProperty().set(value); }
    default void setSpeed(double value) { speedProperty().set(value); }
    default void setSpecial(double value) { specialProperty().setValue(value); }

    ReadOnlyStatSheet<W, O> asReadOnly();

}
