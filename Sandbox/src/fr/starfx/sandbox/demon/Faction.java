package fr.starfx.sandbox.demon;

import fr.starfx.sandbox.common.NamedObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Faction extends NamedObject {

    private final ObservableList<Archetype> archetypeList = FXCollections.observableArrayList();

    public Faction(String name) {
        super(name);
    }

    public ObservableList<Archetype> getArchetypeList() {
        return archetypeList;
    }

}
