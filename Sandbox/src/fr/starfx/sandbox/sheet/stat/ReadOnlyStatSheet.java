package fr.starfx.sandbox.sheet.stat;

import javafx.beans.property.ReadOnlyDoubleProperty;

public interface ReadOnlyStatSheet {

    ReadOnlyDoubleProperty attackProperty();
    ReadOnlyDoubleProperty defenseProperty();
    ReadOnlyDoubleProperty speedProperty();
    ReadOnlyDoubleProperty specialProperty();

    default double getAttach() { return attackProperty().get(); }
    default double getDefense() { return defenseProperty().get(); }
    default double getSpeed() { return speedProperty().get(); }
    default double getSpecial() { return specialProperty().get(); }

}
