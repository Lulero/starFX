package fr.starfx.sandbox.fight;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Fight {

    public final ObservableList<FightingSide> sides = FXCollections.observableArrayList();

    public void initialize() {
        sides.forEach(p -> p.initialize(this));
    }

}
