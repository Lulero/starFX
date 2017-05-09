package fr.starfx.sandbox.demon;

import fr.starfx.sandbox.common.TieredWorldObject;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Demon extends TieredWorldObject {

    private final Faction faction;
    private final Archetype archetype;

    private final ReadOnlyBooleanWrapper soulFormWrapper
            = new ReadOnlyBooleanWrapper(this, "Soul Form", true);
    private final ReadOnlyBooleanProperty soulForm = soulFormWrapper.getReadOnlyProperty();

    private final ObservableList<Long> internalSoulDates = FXCollections.observableArrayList();
    private final ObservableList<Long> soulDates
            = FXCollections.unmodifiableObservableList(internalSoulDates);

    public Demon(
            ReadOnlyLongProperty currentTime,
            String name,
            Faction faction,
            Archetype archetype) {
        super(name, currentTime);
        this.faction = faction;
        this.archetype = archetype;
    }

    public Faction getFaction() {
        return faction;
    }

    public Archetype getArchetype() {
        return archetype;
    }

    public boolean isSoulForm() {
        return soulForm.get();
    }

    public ReadOnlyBooleanProperty soulFormProperty() {
        return soulForm;
    }

    public ObservableList<Long> getSoulDates() {
        return soulDates;
    }

    public void summon() {
        if (soulForm.get()) {
            internalSoulDates.add(currentTimeProperty().get());
            soulFormWrapper.set(false);
        }
    }

    public void unsummon() {
        if (!soulForm.get()) {
            internalSoulDates.add(currentTimeProperty().get());
            soulFormWrapper.set(true);
        }
    }

    @Override
    public String toString() {
        return getFaction() + " " +
                getArchetype() + " " +
                (soulForm.get() ? "Soul " : "Demon ") +
                super.toString();
    }
}
