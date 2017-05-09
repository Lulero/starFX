package fr.starfx.sandbox;

import javafx.beans.property.*;

public abstract class Archetype {

    protected final ReadOnlyStringWrapper internalName
            = new ReadOnlyStringWrapper(this, "name");
    public final ReadOnlyStringProperty name = internalName.getReadOnlyProperty();

    protected final ReadOnlyDoubleWrapper internalOdds
            = new ReadOnlyDoubleWrapper(this, "Odds", 1.0);
    public final ReadOnlyDoubleProperty odds = internalOdds.getReadOnlyProperty();

}
