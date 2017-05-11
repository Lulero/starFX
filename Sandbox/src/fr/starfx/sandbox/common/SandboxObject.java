package fr.starfx.sandbox.common;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

public class SandboxObject {

    private final ReadOnlyStringWrapper toStringWrapper
            = new ReadOnlyStringWrapper(this, "To String");
    private final ReadOnlyStringProperty toStringProperty = toStringWrapper.getReadOnlyProperty();

    public SandboxObject() {
        initializeToString();
    }

    protected ReadOnlyStringWrapper toStringWrapper() {
        return toStringWrapper();
    }

    protected void initializeToString() {
        toStringWrapper.set(super.toString());
    }

    public ReadOnlyStringProperty toStringProperty() {
        return toStringProperty;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return toStringProperty().get();
    }

}
