package fr.starfx.sandbox.data;

import fr.starfx.sandbox.common.NamedObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataBase extends NamedObject {

    private final ObservableList<Faction> factionList = FXCollections.observableArrayList();

    private final ObservableList<Archetype> archetypeList = FXCollections.observableArrayList();

    public DataBase(String name) {
        super(name);
    }

    public ObservableList<Faction> getFactionList() {
        return factionList;
    }

    public ObservableList<Archetype> getArchetypeList() {
        return archetypeList;
    }
}
