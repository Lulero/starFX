package fr.starfx.sandbox.sheet.vital;

import fr.starfx.sandbox.world.SimpleWordObjectComponent;
import fr.starfx.sandbox.world.World;
import fr.starfx.sandbox.world.WorldObject;
import javafx.beans.property.*;

public class SimpleVitalSheet<W extends World, O extends WorldObject<W>>
        extends SimpleWordObjectComponent<W, O> implements VitalSheet<W, O> {

    private final ReadOnlyDoubleWrapper lifeWrapper
            = new ReadOnlyDoubleWrapper(this, "Life");
    private final ReadOnlyDoubleWrapper energyWrapper
            = new ReadOnlyDoubleWrapper(this, "Energy");
    private final ReadOnlyLongWrapper targetTimeWrapper
            = new ReadOnlyLongWrapper(this, "Target Time");

    private ReadOnlyVitalSheet<W, O> readOnlyVitalSheet = null;

    public SimpleVitalSheet(O owner) { super(owner); }

    @Override public DoubleProperty lifeProperty() { return lifeWrapper; }
    @Override public DoubleProperty energyProperty() { return energyWrapper; }
    @Override public LongProperty targetTimeProperty() { return targetTimeWrapper; }

    @Override
    public ReadOnlyVitalSheet<W, O> asReadOnly() {
        if (readOnlyVitalSheet == null) {
            readOnlyVitalSheet = new ReadOnlyImpl();
        }
        return readOnlyVitalSheet;
    }

    private class ReadOnlyImpl implements ReadOnlyVitalSheet<W, O> {

        @Override public O owner() { return SimpleVitalSheet.this.owner(); }

        @Override public ReadOnlyDoubleProperty lifeProperty() { return lifeWrapper.getReadOnlyProperty(); }
        @Override public ReadOnlyDoubleProperty energyProperty() { return energyWrapper.getReadOnlyProperty(); }
        @Override public ReadOnlyLongProperty targetTimeProperty() { return targetTimeWrapper.getReadOnlyProperty(); }

    }
}
