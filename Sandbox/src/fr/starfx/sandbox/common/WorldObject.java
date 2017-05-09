package fr.starfx.sandbox.common;

import javafx.beans.property.ReadOnlyLongProperty;

public class WorldObject extends NamedObject {

    private final ReadOnlyLongProperty currentTimeProperty;
    private final long birthDate;

    public WorldObject(String name, ReadOnlyLongProperty currentTimeProperty) {
        super(name);
        this.currentTimeProperty = currentTimeProperty;
        this.birthDate = currentTimeProperty.get();
    }

    public ReadOnlyLongProperty currentTimeProperty() { return currentTimeProperty; }
    public long getBirthDate() { return birthDate; }

}
