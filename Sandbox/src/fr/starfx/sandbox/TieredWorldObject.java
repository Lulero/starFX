package fr.starfx.sandbox;

import javafx.beans.property.*;

public class TieredWorldObject extends WorldObject {

    public final DoubleProperty experience = new SimpleDoubleProperty(this, "Experience", 0);
    public final IntegerProperty level = new SimpleIntegerProperty(this, "Level");

    public final DoubleProperty essence = new SimpleDoubleProperty(this, "Essence", 0);
    public final IntegerProperty tier = new SimpleIntegerProperty(this, "Tier", 0);

    public TieredWorldObject(ReadOnlyLongProperty currentTime, String name) {
        super(currentTime, name);
    }

    private String computeTierSuffix() {
        return level.get() + " <" + tier.get() + "*>";
    }

    @Override
    public String toString() {
        return name.get() + " " + computeTierSuffix();
    }

}
