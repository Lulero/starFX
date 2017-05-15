package fr.starfx.sandbox.sheet.stat;

import fr.starfx.sandbox.world.SimpleWordObjectComponent;
import fr.starfx.sandbox.world.World;
import fr.starfx.sandbox.world.WorldObject;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;

public class SimpleStatSheet<W extends World, O extends WorldObject<W>>
        extends SimpleWordObjectComponent<W, O> implements StatSheet<W, O> {

    private final ReadOnlyDoubleWrapper attackWrapper
            = new ReadOnlyDoubleWrapper(this, "Attack");
    private final ReadOnlyDoubleWrapper defenseWrapper
            = new ReadOnlyDoubleWrapper(this, "Defense");
    private final ReadOnlyDoubleWrapper speedWrapper
            = new ReadOnlyDoubleWrapper(this, "Speed");
    private final ReadOnlyDoubleWrapper specialWrapper
            = new ReadOnlyDoubleWrapper(this, "Special");

    private ReadOnlyStatSheet<W, O> readOnlyStatSheet = null;

    public SimpleStatSheet(O owner) { super(owner); }

    @Override public DoubleProperty attackProperty() { return attackWrapper; }
    @Override public DoubleProperty defenseProperty() { return defenseWrapper; }
    @Override public DoubleProperty speedProperty() { return speedWrapper; }
    @Override public DoubleProperty specialProperty() { return specialWrapper; }

    @Override public ReadOnlyStatSheet<W, O> asReadOnly() {
        if (readOnlyStatSheet == null) {
            readOnlyStatSheet = new ReadOnlyImpl();
        }
        return readOnlyStatSheet;
    }

    private class ReadOnlyImpl implements ReadOnlyStatSheet<W, O> {

        @Override public O owner() { return SimpleStatSheet.this.owner(); }

        @Override public ReadOnlyDoubleProperty attackProperty() { return attackWrapper.getReadOnlyProperty(); }
        @Override public ReadOnlyDoubleProperty defenseProperty() { return defenseWrapper.getReadOnlyProperty(); }
        @Override public ReadOnlyDoubleProperty speedProperty() { return speedWrapper.getReadOnlyProperty(); }
        @Override public ReadOnlyDoubleProperty specialProperty() { return specialWrapper.getReadOnlyProperty(); }

    }

}
