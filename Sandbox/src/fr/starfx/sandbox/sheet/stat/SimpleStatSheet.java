package fr.starfx.sandbox.sheet.stat;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;

public class SimpleStatSheet implements StatSheet {

    private final ReadOnlyDoubleWrapper attackWrapper
            = new ReadOnlyDoubleWrapper(this, "Attack");
    private final ReadOnlyDoubleWrapper defenseWrapper
            = new ReadOnlyDoubleWrapper(this, "Defense");
    private final ReadOnlyDoubleWrapper speedWrapper
            = new ReadOnlyDoubleWrapper(this, "Speed");
    private final ReadOnlyDoubleWrapper specialWrapper
            = new ReadOnlyDoubleWrapper(this, "Special");

    private final ReadOnlyStatSheet readOnlyStatSheet;

    public SimpleStatSheet() { readOnlyStatSheet = new ReadOnlyImpl(); }

    @Override public DoubleProperty attackProperty() { return attackWrapper; }
    @Override public DoubleProperty defenseProperty() { return defenseWrapper; }
    @Override public DoubleProperty speedProperty() { return speedWrapper; }
    @Override public DoubleProperty specialProperty() { return specialWrapper; }

    @Override public ReadOnlyStatSheet asReadOnly() { return readOnlyStatSheet; }

    private class ReadOnlyImpl implements ReadOnlyStatSheet {

        @Override public ReadOnlyDoubleProperty attackProperty() { return attackWrapper.getReadOnlyProperty(); }
        @Override public ReadOnlyDoubleProperty defenseProperty() { return defenseWrapper.getReadOnlyProperty(); }
        @Override public ReadOnlyDoubleProperty speedProperty() { return speedWrapper.getReadOnlyProperty(); }
        @Override public ReadOnlyDoubleProperty specialProperty() { return specialWrapper.getReadOnlyProperty(); }

    }
}
