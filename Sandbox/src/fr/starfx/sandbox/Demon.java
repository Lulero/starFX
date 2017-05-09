package fr.starfx.sandbox;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Demon extends TieredWorldObject {

    public final ObjectProperty<Archetype> archetype = new SimpleObjectProperty<>(this, "Archetype");

    private final ReadOnlyBooleanWrapper soulFormWrapper
            = new ReadOnlyBooleanWrapper(this, "Soul Form", true);
    public final ReadOnlyBooleanProperty soulForm = soulFormWrapper.getReadOnlyProperty();

    private final ObservableList<Long> internalSoulDates = FXCollections.observableArrayList();
    public final ObservableList<Long> soulDates
            = FXCollections.unmodifiableObservableList(internalSoulDates);

    public Demon(ReadOnlyLongProperty currentTime, String name) {
        super(currentTime, name);
    }

    public void summon() {
        if (soulForm.get()) {
            internalSoulDates.add(currentTime.get());
            soulFormWrapper.set(false);
        }
    }

    public void unsummon() {
        if (!soulForm.get()) {
            internalSoulDates.add(currentTime.get());
            soulFormWrapper.set(true);
        }
    }

    @Override
    public String toString() {
        return (soulForm.get() ? "Soul " : "Demon ") + super.toString();
    }
}
