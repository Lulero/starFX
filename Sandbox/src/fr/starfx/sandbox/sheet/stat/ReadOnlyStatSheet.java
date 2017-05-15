package fr.starfx.sandbox.sheet.stat;

import fr.starfx.sandbox.world.World;
import fr.starfx.sandbox.world.WorldObject;
import fr.starfx.sandbox.world.WorldObjectComponent;
import javafx.beans.property.ReadOnlyDoubleProperty;

public interface ReadOnlyStatSheet<W extends World, O extends WorldObject<W>> extends WorldObjectComponent<W, O> {

    ReadOnlyDoubleProperty attackProperty();
    ReadOnlyDoubleProperty defenseProperty();
    ReadOnlyDoubleProperty speedProperty();
    ReadOnlyDoubleProperty specialProperty();

    default double getAttach() { return attackProperty().get(); }
    default double getDefense() { return defenseProperty().get(); }
    default double getSpeed() { return speedProperty().get(); }
    default double getSpecial() { return specialProperty().get(); }

}
