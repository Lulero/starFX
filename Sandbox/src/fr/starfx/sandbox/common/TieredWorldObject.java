package fr.starfx.sandbox.common;

import javafx.beans.property.ReadOnlyLongProperty;

public class TieredWorldObject extends WorldObject {

    private final Tier tier;

    public TieredWorldObject(String name, ReadOnlyLongProperty currentTimeProperty) {
        super(name, currentTimeProperty);
        this.tier = new Tier(this);
    }

    public Tier getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getTier();
    }
}
