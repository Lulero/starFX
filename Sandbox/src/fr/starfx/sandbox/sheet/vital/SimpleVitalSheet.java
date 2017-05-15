package fr.starfx.sandbox.sheet.vital;

import fr.starfx.sandbox.world.World;
import fr.starfx.sandbox.world.SimpleWorldObject;
import javafx.beans.property.*;

public class SimpleVitalSheet extends SimpleWorldObject implements VitalSheet {

    private final ReadOnlyDoubleWrapper lifeWrapper
            = new ReadOnlyDoubleWrapper(this, "Life");
    private final ReadOnlyDoubleWrapper energyWrapper
            = new ReadOnlyDoubleWrapper(this, "Energy");
    private final ReadOnlyLongWrapper targetTimeWrapper
            = new ReadOnlyLongWrapper(this, "Target Time");

    private final ReadOnlyVitalSheet readOnlyVitalSheet;

    public SimpleVitalSheet(World world, String name) {
        super(world, name);
        readOnlyVitalSheet = new ReadOnlyImpl();
    }

    @Override public DoubleProperty lifeProperty() { return lifeWrapper; }
    @Override public DoubleProperty energyProperty() { return energyWrapper; }
    @Override public LongProperty targetTimeProperty() { return targetTimeWrapper; }

    @Override public ReadOnlyVitalSheet asReadOnly() { return readOnlyVitalSheet; }

    private class ReadOnlyImpl implements ReadOnlyVitalSheet {

        @Override public String name() { return SimpleVitalSheet.this.name(); }
        @Override public World world() { return SimpleVitalSheet.this.world(); }

        @Override public ReadOnlyDoubleProperty lifeProperty() { return lifeWrapper.getReadOnlyProperty(); }
        @Override public ReadOnlyDoubleProperty energyProperty() { return energyWrapper.getReadOnlyProperty(); }
        @Override public ReadOnlyLongProperty targetTimeProperty() { return targetTimeWrapper.getReadOnlyProperty(); }

    }
}
