package fr.starfx.sandbox.sheet.stat;

import javafx.beans.property.DoubleProperty;

public interface StatSheet extends ReadOnlyStatSheet {

    @Override DoubleProperty attackProperty();
    @Override DoubleProperty defenseProperty();
    @Override DoubleProperty speedProperty();
    @Override DoubleProperty specialProperty();

    default void setAttack(double value) { attackProperty().set(value); }
    default void setDefense(double value) { defenseProperty().set(value); }
    default void setSpeed(double value) { speedProperty().set(value); }
    default void setSpecial(double value) { specialProperty().setValue(value); }

    ReadOnlyStatSheet asReadOnly();

}
