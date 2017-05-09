package fr.starfx.sandbox;

import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyStringProperty;

public class WorldObject {

    public final ReadOnlyLongProperty currentTime;
    public final ReadOnlyLongProperty birthDate;
    public final ReadOnlyStringProperty name;

    public WorldObject(ReadOnlyLongProperty currentTime, String name) {
        this.currentTime = currentTime;
        this.birthDate = Utils.readOnlyLongProperty(this, "Birth Date", currentTime.get());
        this.name = Utils.readOnlyStringProperty(this, "Name", name);
    }

}
